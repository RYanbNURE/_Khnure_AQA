package org.khure;

import io.restassured.RestAssured;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;
import org.khure.pojo.complex.User;

/**
 * Отримує складний JSON відповідь і перетворює його на Java об'єкт.
 */
public class ComplexGetTest {

    @Test
    public void getComplexUser() {
        RestAssured.baseURI = "https://reqres.in/api/users/2";

        User user = RestAssured.given()
                .when()
                .get()
                .as(User.class);

        assertNotNull(user);
        assertNotNull(user.getAddress().getCity());
    }
}