package org.khure;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;
import org.khure.pojo.User;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Клас для демонстрації відправлення Java об'єкта через POST запит.
 */
public class PostObjectTest {

    /**
     * Серіалізує Java об'єкт у JSON і відправляє через POST.
     */
    @Test
    public void postUser() {
        User user = new User(1, "John Doe", "john@example.com");

        // Встановлення базового URI
        RestAssured.baseURI = "https://reqres.in/api";

        // Відправляємо об'єкт через POST і перевіряємо статус коду
        int statusCode = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(user)
                .when()
                .post("/users")
                .getStatusCode();

        assertEquals(201, statusCode);
    }
}
