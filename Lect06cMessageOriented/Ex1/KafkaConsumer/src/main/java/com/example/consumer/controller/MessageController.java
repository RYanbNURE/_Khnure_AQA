package com.example.consumer.controller;

import com.example.consumer.kafka.KafkaConsumer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/messages")
public class MessageController {

    private final KafkaConsumer kafkaConsumer;

    public MessageController(KafkaConsumer kafkaConsumer) {
        this.kafkaConsumer = kafkaConsumer;
    }

    @GetMapping
    public List<String> getMessages() {
        return kafkaConsumer.getMessages();
    }
}