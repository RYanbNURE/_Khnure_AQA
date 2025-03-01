package com.example.provider.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProviderController {
    @GetMapping("/provider/data")
    public String getData() {
        return "Hello from Provider!";
    }

}
