package org.example.provider.controller;

import org.example.provider.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping("/users/{id}")
    public User getUser(@PathVariable String id) {
        return new User("John Doe", 30, "john.doe@example.com");
    }
}