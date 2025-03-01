package com.example.demo;

import com.example.kafka.KafkaProducer;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.ContainerProperties;
import org.springframework.kafka.listener.KafkaMessageListenerContainer;
import org.springframework.kafka.listener.MessageListener;
import org.springframework.kafka.test.EmbeddedKafkaBroker;
import org.springframework.kafka.test.context.EmbeddedKafka;
import org.springframework.kafka.test.utils.ContainerTestUtils;
import org.springframework.kafka.test.utils.KafkaTestUtils;
import org.springframework.test.context.ActiveProfiles;

import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@EmbeddedKafka(partitions = 1, brokerProperties = {"listeners=PLAINTEXT://localhost:9092", "port=9092"})
@ActiveProfiles("test")
public class KafkaProducerIntegrationTest {

    @Autowired
    private KafkaProducer kafkaProducer;

    @Autowired
    private EmbeddedKafkaBroker embeddedKafkaBroker;

    @Test
    public void testSendMessage() throws Exception {
        String topic = "example-topic";
        String message = "Test message";

        Map<String, Object> consumerProps = KafkaTestUtils.consumerProps("testGroup", "true", embeddedKafkaBroker);
        consumerProps.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
        DefaultKafkaConsumerFactory<String, String> cf = new DefaultKafkaConsumerFactory<>(consumerProps, new StringDeserializer(), new StringDeserializer());

        BlockingQueue<ConsumerRecord<String, String>> records = new LinkedBlockingQueue<>();
        KafkaMessageListenerContainer<String, String> container = createContainer(topic, cf, records);
        container.start();
        ContainerTestUtils.waitForAssignment(container, embeddedKafkaBroker.getPartitionsPerTopic());

        kafkaProducer.sendMessage(topic, message);

        ConsumerRecord<String, String> record = records.poll(5, TimeUnit.SECONDS);
        assertNotNull(record);
        assertEquals(message, record.value());

        container.stop();
    }

    private KafkaMessageListenerContainer<String, String> createContainer(String topic, DefaultKafkaConsumerFactory<String, String> cf, BlockingQueue<ConsumerRecord<String, String>> records) {
        ContainerProperties containerProperties = new ContainerProperties(topic);
        containerProperties.setMessageListener((MessageListener<String, String>) records::add);
        return new KafkaMessageListenerContainer<>(cf, containerProperties);
    }
}