package org.khnure;

import okhttp3.mockwebserver.MockWebServer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import okhttp3.mockwebserver.MockResponse;
import org.khnure.api.ApiService;
import org.khnure.model.User;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CreateUserTest{

    private MockWebServer server;

    @Before
    public void setUp() throws Exception {
        server = new MockWebServer();
        server.start();
    }

    @After
    public void tearDown() throws Exception {
        server.shutdown();
    }

    @Test
    public void testCreateUser() throws Exception {
        // Налаштування Mock Web Server
        String mockResponse = "{\"id\": 1, \"name\": \"John Doe\", \"email\": \"john@example.com\"}";
        server.enqueue(new MockResponse()
                .setBody(mockResponse)
                .addHeader("Content-Type", "application/json"));

        // Налаштування Retrofit
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(server.url("/"))
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiService apiService = retrofit.create(ApiService.class);


        // Подібно до тесту GetUserById, але використовує метод POST
        server.enqueue(new MockResponse().setResponseCode(201));

        User newUser = new User(99, "Alice Wonderland", "alice@example.com");
        Response<User> response = apiService.createUser(newUser).execute();

        assertEquals(201, response.code());  // Перевірка, чи запит на створення користувача успішний
        assertTrue(response.isSuccessful());
    }
}
