package com.example.consumer;

import com.example.consumer.kafka.KafkaConsumer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.test.context.EmbeddedKafka;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@DirtiesContext
@EmbeddedKafka(partitions = 1, brokerProperties = {"listeners=PLAINTEXT://localhost:9092", "port=9092"})
@ActiveProfiles("test")
public class KafkaConsumerIntegrationTest {

    @Autowired
    private KafkaConsumer consumer;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

//    @Test
    public void testConsume() throws Exception {
        String message = "Hello, Kafka!";
        kafkaTemplate.send("test_topic", message);

        // Wait for the consumer to process the message
        TimeUnit.SECONDS.sleep(1);

        assertTrue(consumer.getMessages().contains(message));
        assertEquals(1, consumer.getMessages().size());
    }
}