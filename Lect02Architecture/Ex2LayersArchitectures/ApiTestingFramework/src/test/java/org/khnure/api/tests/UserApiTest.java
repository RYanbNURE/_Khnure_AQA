package org.khnure.api.tests;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.khnure.api.models.User;
import org.khnure.api.utils.RestAssuredConfig;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class UserApiTest {
    @BeforeAll
    public static void setup() {
        RestAssuredConfig.getRequestSpecification();
    }

    @Test
    public void testGetUserById() {
        given()
                .pathParam("id", 1)
                .when()
                .get("/users/{id}")
                .then()
                .statusCode(200)
                .body("id", equalTo(1))
                .body("username", equalTo("Bret"));
    }

    @Test
    public void testCreateUser() {
        User newUser = new User();
        newUser.setName("John Doe");
        newUser.setUsername("johndoe");
        newUser.setEmail("johndoe@example.com");

        given()
                .body(newUser)
                .when()
                .post("/users")
                .then()
                .statusCode(201)
                .body("name", equalTo("John Doe"))
                .body("username", equalTo("johndoe"))
                .body("email", equalTo("johndoe@example.com"));
    }
}
