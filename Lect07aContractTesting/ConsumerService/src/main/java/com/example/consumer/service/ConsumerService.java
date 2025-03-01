package com.example.consumer.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ConsumerService {
    private final RestTemplate restTemplate;
    private final String providerUrl = "http://localhost:8081";

    public ConsumerService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String fetchData() {
        String url = providerUrl + "/provider/data";
        return restTemplate.getForObject(url, String.class);
    }

    public String getUser(int id) {
        return restTemplate.getForObject(providerUrl + "/users/" + id, String.class);
    }
}
