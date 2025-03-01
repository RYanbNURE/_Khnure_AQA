package org.khure;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Клас AuthenticationTest демонструє використання базової аутентифікації в RestAssured.
 */
public class AuthenticationTest {

    /**
     * Виконує запит з базовою аутентифікацією.
     */
    @Test
    public void testBasicAuthentication() {
        RestAssured.baseURI = "https://postman-echo.com";

        RequestSpecification request = RestAssured.given()
                .auth()
                .basic("username", "password");

        int statusCode = request.when()
                .get("/basic-auth")
                .getStatusCode();

        assertEquals(200, statusCode);
    }
}
