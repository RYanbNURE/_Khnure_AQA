package com.example.consumer.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class KafkaConsumer {

    private final List<String> messages = new ArrayList<>();

    @KafkaListener(topics = "test_topic", groupId = "test_group")
    public void listen(String message) {
        messages.add(message);
        System.out.println("Received message: " + message);
    }

    public List<String> getMessages() {
        return messages;
    }
}
