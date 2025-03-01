package com.epam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConsumerController {


//    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    public ConsumerController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    private final String producerUrl = "http://localhost:9000/user-data/";

    @GetMapping("/fetch-user-data/{userId}")
    @ResponseBody
    public String fetchUserData(@PathVariable int userId) {
        return restTemplate.getForObject(producerUrl + userId, String.class);
    }
}
