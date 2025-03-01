package org.khnure.service;


import feign.Feign;
import feign.gson.GsonDecoder;
import org.khnure.feignClient.UserClient;
import org.khnure.model.User;

import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;


/**
 * Сервіс для взаємодії з користувачами через Feign Client.
 */
public class UserService {
    private UserClient userClient;

    public UserService() {
        userClient = Feign.builder()
                .encoder(new CustomEncoder()) // Використання власного енкодера
                .decoder(new GsonDecoder())  // Встановлення декодера для JSON
                .errorDecoder(new CustomErrorDecoder())  // Встановлення власного декодера помилок
                .requestInterceptor(new HeaderInterceptor())  // Використання інтерцептора
                .target(UserClient.class, "https://api.example.com");
    }

    // Метод для отримання користувача по ID
    public User getUserById(int id) {
        return userClient.getUserById(id);
    }

    public List<User> findUsersBasedOnCriteria(Map<String, Object> criteria) {
        return userClient.findUsers(criteria);
    }

//    public CompletableFuture<User> getUserByIdAsync(int id) {
//        return userClient.getUserByIdAsync(id);
//    }
}