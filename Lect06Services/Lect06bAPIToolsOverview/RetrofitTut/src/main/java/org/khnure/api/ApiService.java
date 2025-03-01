package org.khnure.api;


import org.khnure.model.User;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Інтерфейс API для демонстрації використання Retrofit.
 */
public interface ApiService {
    // Метод для отримання даних користувача
    @GET("/users/{id}")
    Call<User> getUserById(@Path("id") int id); // Параметр 'id' задається динамічно

    @POST("/users")
    Call<User> createUser(@Body User user); // Використовуює тіло з запитом для відправки даних користувача
}
