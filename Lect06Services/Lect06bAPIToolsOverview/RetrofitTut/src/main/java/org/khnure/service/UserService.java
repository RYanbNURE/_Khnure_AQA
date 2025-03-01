package org.khnure.service;


import org.khnure.api.ApiService;
import org.khnure.model.User;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import okhttp3.OkHttpClient;
//import okhttp3.

/**
 * Сервіс для роботи з API користувачів.
 */
public class UserService {
    private ApiService apiService;

    public UserService() {
        // Налаштування інтерцептора
//        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
//        logging.setLevel(HttpLoggingInterceptor.Level.BODY);  // Рівень журналювання
        OkHttpClient client = new OkHttpClient.Builder()
//                .addInterceptor(logging)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .client(client)
                .baseUrl("https://api.example.com")
                .addConverterFactory(new CustomConverterFactory())  // Використання нашого конвертера
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        apiService = retrofit.create(ApiService.class);
    }

    // Отримання користувача по ID
    public void getUserById(int id) {
        apiService.getUserById(id).enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if (response.isSuccessful()) {
                    User user = response.body();
                    System.out.println("User " + user.getName() + " retrieved successfully.");
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                // Обробка випадку помилки
                t.printStackTrace();
            }
        });
    }

    // Метод для створення нового користувача асинхронно
    public void createUser(User user) {
        apiService.createUser(user).enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if (response.isSuccessful()) {
                    System.out.println("Створено користувача: " + response.body().getName());
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                // Обробка помилок відправки
                System.err.println("Помилка при створенні користувача: " + t.getMessage());
            }
        });
    }
}