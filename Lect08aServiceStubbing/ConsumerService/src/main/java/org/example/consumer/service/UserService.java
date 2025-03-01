package org.example.consumer.service;

import org.example.consumer.model.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserService {

    private final RestTemplate restTemplate;

    @Value("${provider.url}")
    private String providerUrl;

    public UserService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public User getUser(String id) {
        return restTemplate.getForObject(providerUrl + "/users/" + id, User.class);
    }
}