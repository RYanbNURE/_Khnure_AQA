package org.khnure;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.khnure.feignClient.UserClient;
import org.khnure.model.User;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

// Використання JUnit 5 та Mockito розширень
@ExtendWith(MockitoExtension.class)
public class UserClientTest {
    @Mock
    private UserClient userClient;

    @Test
    public void testGetUserById() {
        // Налаштування мок об'єкта
        User mockUser = new User(1, "Олександр", "olexander@example.com");
        when(userClient.getUserById(1)).thenReturn(mockUser);

        // Виклик методу
        User user = userClient.getUserById(1);

        // Перевірка результату
        assertNotNull(user);
        assertEquals("Олександр", user.getName());
    }
}