package org.khure;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Клас для демонстрації використання XPath для витягу даних із XML відповідей.
 */
public class XPathExampleTest {

    @Test
    public void fetchBookDetails() {
        // Встановлення базового URI
        RestAssured.baseURI = "https://api.example.com/bookstore";

        // Виконання запиту
        Response response = RestAssured.given()
                .when()
                .get("/books")
                .andReturn();

        // Використання XPath для отримання автора другої книги
        String author = response.xmlPath().getString("//book[2]/author");
        assertEquals("Erik T. Ray", author);

        System.out.println("Автор другої книги: " + author);
    }
}