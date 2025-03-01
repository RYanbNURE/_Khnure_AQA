package org.khure;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Клас DeleteTest демонструє видалення ресурсів через DELETE запит за допомогою RestAssured.
 */
public class DeleteTest {

    /**
     * Тестує DELETE запит.
     */
    @Test
    public void testDeleteRequest() {
        // Встановлення базового URI
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";

        // Виконання DELETE запиту і збереження відповіді
        Response response = RestAssured.given()
                .when()
                .delete("/posts/1");

        // Перевірка коду стану відповіді
        assertEquals(200, response.getStatusCode());
    }
}
