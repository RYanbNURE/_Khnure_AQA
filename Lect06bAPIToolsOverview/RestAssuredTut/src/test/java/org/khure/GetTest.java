package org.khure;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Клас GetTest демонструє тестування GET запитів за допомогою RestAssured.
 */
public class GetTest {

    /**
     * Тестує GET запит.
     */
    @Test
    public void testGetRequest() {
        // Встановлення базового URI
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";

        // Виконання GET запиту і збереження відповіді
        Response response = RestAssured.given()
                .when()
                .get("/posts/1");

        // Перевірка статусу відповіді
        assertEquals(200, response.getStatusCode());
        assertEquals(true, response.asString().contains("sunt aut facere repellat provident occaecati excepturi optio reprehenderit"));
    }
}