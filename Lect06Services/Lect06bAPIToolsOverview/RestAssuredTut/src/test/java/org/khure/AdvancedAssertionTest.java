package org.khure;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

/**
 * Клас AdvancedAssertionTest демонструє складні перевірки відповідей за допомогою RestAssured.
 */
public class AdvancedAssertionTest {

    /**
     * Тестує розширені перевірки відповіді JSON.
     */
    @Test
    public void testResponseAssertions() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";

        given()
                .when()
                .get("/posts/1")
                .then()
                .assertThat()
                .statusCode(200)
                .body("userId", equalTo(1))
                .body("title", containsString("sunt aut facere repellat provident occaecati excepturi optio reprehenderit"));
    }
}