package org.khnure.feignClient;


import feign.Headers;
import feign.Param;
import feign.QueryMap;
import feign.RequestLine;
import org.khnure.model.User;

import java.util.List;
import java.util.Map;

/**
 * Інтерфейс Feign Client для взаємодії з API користувачів.
 */
public interface UserClient {
    @RequestLine("GET /users/{id}")  // Визначення типу запиту і шляху
    User getUserById(@Param("id") int id);  // Метод для отримання користувача по ID

    // Додавання методу для створення користувача
    @RequestLine("POST /users")
    @Headers("Content-Type: application/json")
    User createUser(User user);  // Використання анотації Headers для вказання типу контенту

    @RequestLine("GET /users")
    List<User> findUsers(@QueryMap Map<String, Object> queryMap);  // Використання QueryMap для динамічних параметрів зpocу
}