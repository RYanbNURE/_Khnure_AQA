package com.example.service;

import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.assertThat;

// Тести для сервісу користувачів
public class UserServiceTest {

    private final com.example.service.UserService userService = new com.example.service.UserService();

    @Test
    public void testIsAdult() {
        assertThat(userService.isAdult(18)).isTrue();
        assertThat(userService.isAdult(17)).isFalse();
    }

    @Test
    public void testGreetUser() {
        String greeting = userService.greetUser("Олексій");
        assertThat(greeting).isEqualTo("Привіт, Олексій!");
    }
}