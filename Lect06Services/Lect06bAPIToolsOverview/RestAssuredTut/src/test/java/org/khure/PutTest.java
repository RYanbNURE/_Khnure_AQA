package org.khure;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Клас PutTest для демонстрації PUT запитів.
 */
public class PutTest {

    /**
     * Тестує PUT запит.
     */
    @Test
    public void testPutRequest() {
        // Встановлення базового URI
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";

        // Створення об'єкта запиту
        RequestSpecification request = RestAssured.given();

        // Додавання заголовків
        request.header("Content-Type", "application/json");

        // Вказуємо тіло запиту
        request.body("{\"id\": 1, \"title\": \"foo\", \"body\": \"bar\", \"userId\": 1}");

        // Відправка PUT запиту
        Response response = request.put("/posts/1");

        // Перевірка коду відповіді
        assertEquals(200, response.getStatusCode());
    }
}
