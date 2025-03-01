package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @MockBean
    private UserRepository userRepository;

    @Test
    public void testCreateUser() {
        User user = new User();
        user.setName("Alice");
        user.setEmail("alice@example.com");

        when(userRepository.save(any(User.class))).thenReturn(user);

        User createdUser = userService.createUser("Alice", "alice@example.com");
        assertEquals("Alice", createdUser.getName());
        assertEquals("alice@example.com", createdUser.getEmail());
    }

    @Test
    public void testGetUserByEmail() {
        User user = new User();
        user.setName("Bob");
        user.setEmail("bob@example.com");

        when(userRepository.findByEmail("bob@example.com")).thenReturn(Optional.of(user));

        Optional<User> foundUser = userService.getUserByEmail("bob@example.com");
        assertTrue(foundUser.isPresent());
        assertEquals("Bob", foundUser.get().getName());
    }

    @Test
    public void testGetUserById() {
        User user = new User();
        user.setId(1L);
        user.setName("Charlie");
        user.setEmail("charlie@example.com");

        when(userRepository.findById(1L)).thenReturn(Optional.of(user));

        Optional<User> foundUser = userService.getUserById(1L);
        assertTrue(foundUser.isPresent());
        assertEquals("Charlie", foundUser.get().getName());
        assertEquals("charlie@example.com", foundUser.get().getEmail());
    }

    @Test
    public void testGetUserByIdNotFound() {
        when(userRepository.findById(99L)).thenReturn(Optional.empty());

        Optional<User> foundUser = userService.getUserById(99L);
        assertFalse(foundUser.isPresent());
    }
}