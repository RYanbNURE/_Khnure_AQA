package com.example.consumer.controller;

import com.example.consumer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userClient) {
        this.userService = userClient;
    }

    @GetMapping("/user/{id}")
    public String getUser(@PathVariable int id) {
        return userService.getUser(id);
    }
}
