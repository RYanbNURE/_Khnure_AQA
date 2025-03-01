package org.khnure;


import feign.Feign;
import feign.gson.GsonDecoder;
import org.junit.jupiter.api.Test;
import org.khnure.feignClient.UserClient;
import org.khnure.model.User;
import org.khnure.service.UserService;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.concurrent.CompletableFuture;

import static org.mockito.BDDMockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class UserServiceTest {

    @Mock
    private UserClient userClient;

    @InjectMocks
    private UserService userService;

    public UserServiceTest() {
        MockitoAnnotations.initMocks(this);
        userService = new UserService(); // Установка залежностей
    }

    @Test
    public void testGetUserByIdAsync() {
        // Налаштування асинхронного відповіді
        User expectedUser = new User(2, "Марія", "maria@example.com");
        CompletableFuture<User> completableFuture = CompletableFuture.completedFuture(expectedUser);
//        given(userClient.getUserByIdAsync(2)).willReturn(completableFuture);

        // Асинхронний запит
//        CompletableFuture<User> result = userService.getUserByIdAsync(2);

        // Перевірка результату
//        assertNotNull(result);
//        assertEquals("Марія", result.get().getName());
    }
}