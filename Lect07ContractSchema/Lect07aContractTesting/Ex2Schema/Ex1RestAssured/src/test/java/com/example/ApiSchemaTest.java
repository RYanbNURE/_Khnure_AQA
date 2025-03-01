package com.example;

import io.restassured.RestAssured;
import io.restassured.module.jsv.JsonSchemaValidator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class ApiSchemaTest {

    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
    }

    @Test
    public void validatePostSchema() {
        given()
                .when()
                .get("/posts/1")
                .then()
                .statusCode(200)
                .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("post-schema.json"))
                .body("userId", equalTo(1))
                .body("id", equalTo(1))
                .body("title", not(emptyString()));
    }

    @Test
    public void validateMultiplePosts() {
        given()
                .when()
                .get("/posts")
                .then()
                .statusCode(200)
                .body("size()", greaterThan(0))
                .body("findAll { it.userId == 1 }.size()", greaterThan(0))
                .body("every { it.title.length() > 0 }", is(true));
    }

    @Test
    public void createNewPost() {
        String newPost = """
            {
                "title": "foo",
                "body": "bar",
                "userId": 1
            }
            """;

        given()
                .contentType("application/json")
                .body(newPost)
                .when()
                .post("/posts")
                .then()
                .statusCode(201)
                .body("id", notNullValue())
                .body("title", equalTo("foo"))
                .body("body", equalTo("bar"))
                .body("userId", equalTo(1));
    }
}