package com.example.demo;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@Testcontainers
public class UserServiceIntegrationTest {

    @Container
    public static PostgreSQLContainer<?> postgresContainer = new PostgreSQLContainer<>("postgres:15")
            .withDatabaseName("testdb")
            .withUsername("testuser")
            .withPassword("testpass");

    @DynamicPropertySource
    static void setProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", postgresContainer::getJdbcUrl);
        registry.add("spring.datasource.username", postgresContainer::getUsername);
        registry.add("spring.datasource.password", postgresContainer::getPassword);
    }

    @BeforeEach
    void setUp() {
        userRepository.deleteAll();
    }


    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testCreateAndGetAllUsers() {
        User user = new User("John Doe", "john@example.com");

        User savedUser = userService.createUser(user);
        assertNotNull(savedUser.getId());

        List<User> allUsers = userService.getAllUsers();
        assertEquals(1, allUsers.size());
        assertEquals("John Doe", allUsers.get(0).getName());
    }

    @Test
    void testSaveAndRetrieveUser() {
        User user = new User();
        user.setName("John Doe");
        user.setEmail("johndoe@example.com");

        userRepository.save(user);

        List<User> users = userRepository.findAll();
        assertThat(users).hasSize(1);
        assertThat(users.get(0).getName()).isEqualTo("John Doe");
    }

}