package org.example.demo;

import org.example.demo.model.User;
import org.example.demo.repository.UserRepository;
import org.example.demo.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@ActiveProfiles("test") // Указываем профиль для H2
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testCreateUser() {
        User user = userService.createUser("Alice", "alice@example.com");
        assertEquals("Alice", user.getName());
        assertEquals("alice@example.com", user.getEmail());
    }

    @Test
    public void testGetUserByEmail() {
        userRepository.save(new User() {{
            setName("Bob");
            setEmail("bob@example.com");
        }});

        var user = userService.getUserByEmail("bob@example.com");
        assertTrue(user.isPresent());
        assertEquals("Bob", user.get().getName());
    }
}

