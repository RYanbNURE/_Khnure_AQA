package org.khure;

import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static io.restassured.path.json.JsonPath.from;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Клас демонструє використання GPath для навігації та вилучення даних з JSON відповідей.
 */
public class GPathJsonExampleTest {

    @Test
    public void testUserExtractionUsingGPath() {
        RestAssured.baseURI = "https://api.example.com";

        // Виконання запиту та отримання відповіді
        String response = given()
                .when()
                .get("/users")
                .then()
                .extract()
                .asString();

        // Використання GPath для випрелення імені другого користувача.
        String secondUserName = from(response).getString("users[1].name");
        assertEquals("Jane Smith", secondUserName);

        // Перевірка електронної пошти першого користувача.
        String firstUserEmail = from(response).getString("users[0].email");
        assertEquals("john.doe@example.com", firstUserEmail);

        System.out.println("Ім'я другого користувача: " + secondUserName);
        System.out.println("Емейл першого користувача: " + firstUserEmail);
    }
}