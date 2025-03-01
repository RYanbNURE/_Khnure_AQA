package org.example.demo.controller;

import org.example.demo.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @GetMapping("/users/{id}")
    public User getUser(@PathVariable String id) {
        return new User(30l, "John Doe", "john.doe@example.com");
    }
}
