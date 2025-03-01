package org.khure;

import io.restassured.RestAssured;
import io.restassured.mapper.ObjectMapperType;
import org.junit.jupiter.api.Test;
import org.khure.pojo.User;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Клас для демонстрації отримання Java об'єкта з GET запиту.
 */
public class GetObjectTest {

    /**
     * Отримує JSON і десеріалізує у Java об'єкт.
     */
    @Test
    public void getUser() {
        RestAssured.baseURI = "https://reqres.in/api";

        User user = RestAssured.given()
                .when()
                .get("/users/2")
                .as(User.class, ObjectMapperType.JACKSON_2);

        assertNotNull(user);
        assertNotNull(user.getName());
    }
}