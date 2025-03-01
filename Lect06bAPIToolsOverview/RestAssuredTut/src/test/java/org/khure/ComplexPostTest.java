package org.khure;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.khure.pojo.complex.Address;
import org.khure.pojo.complex.User;

/**
 * Відправляє складний об'єкт User за допомогою POST запиту.
 */
public class ComplexPostTest {

    @Test
    public void postComplexUser() {
        Address address = new Address("1234 Street", "Kyiv");
        User user = new User(1, "Jane Doe", address);

        RestAssured.baseURI = "https://reqres.in/api/users";

        int statusCode = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(user)
                .when()
                .post()
                .getStatusCode();

        assertEquals(201, statusCode);
    }
}
