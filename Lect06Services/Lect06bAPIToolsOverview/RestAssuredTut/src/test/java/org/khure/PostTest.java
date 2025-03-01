package org.khure;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Клас PostTest для демонстрації POST запитів.
 */
public class PostTest {

    /**
     * Тестує POST запит.
     */
    @Test
    public void testPostRequest() {
        // Встановлення базового URI
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";

        // Створення об'єкта запиту
        RequestSpecification request = RestAssured.given();

        // Додавання заголовків
        request.header("Content-Type", "application/json");

        // Вказуємо тіло запиту
        request.body("{\"title\": \"foo\", \"body\": \"bar\", \"userId\": 1}");

        // Відправка POST запиту
        Response response = request.post("/posts");

        // Перевірка коду відповіді
        assertEquals(201, response.getStatusCode());
    }
}
