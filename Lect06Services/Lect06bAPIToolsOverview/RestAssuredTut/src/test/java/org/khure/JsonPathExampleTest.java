package org.khure;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Клас для демонстрації використання JsonPath для витягу даних із JSON відповідей.
 */
public class JsonPathExampleTest {

    @Test
    public void fetchUserDetails() {
        // Встановлення URI базового ресурсу
        RestAssured.baseURI = "https://api.example.com/users";

        // Виконання запиту та отримання відповіді
        String response = RestAssured.given()
                .when()
                .get("/1")
                .asString();

        // Використання JsonPath для аналізу отриманої відповіді
        JsonPath jsonPath = new JsonPath(response);

        // Отримання міста з адреси
        String city = jsonPath.getString("address.city");
        assertEquals("London", city);

        // Отримання першого телефонного номера
        String firstPhoneNumber = jsonPath.getString("phoneNumbers[0]");
        assertEquals("123-456-7890", firstPhoneNumber);

        System.out.println("Місто: " + city);
        System.out.println("Перший телефонний номер: " + firstPhoneNumber);
    }
}