package com.example.consumer.controller;

import com.example.consumer.service.ConsumerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsumerController {
    private final ConsumerService consumerService;

    public ConsumerController(ConsumerService consumerService) {
        this.consumerService = consumerService;
    }

    @GetMapping("/consumer/data")
    public String getData() {
        return consumerService.fetchData();
    }

    @GetMapping("/consumer/user")
    public String getUser() {
        return consumerService.fetchData();
    }
}
