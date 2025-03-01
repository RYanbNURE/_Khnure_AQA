package org.khnure;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.khnure.api.ApiService;
import org.khnure.model.User;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import static org.junit.Assert.*;

/**
 * Тести для сервісу користувачів.
 */
public class UserServiceTest {
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
    public void testGetUserById() throws Exception {
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

        // Запит
        User user = apiService.getUserById(1).execute().body();

        assertNotNull(user);
        assertEquals("John Doe", user.getName());
    }
}