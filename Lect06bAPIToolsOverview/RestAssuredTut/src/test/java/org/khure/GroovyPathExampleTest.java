package org.khure;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;
import org.junit.jupiter.api.Test;
import static org.hamcrest.Matchers.*;

/**
 * Клас для демонстрації використання GPath для навігації по вкладеному JSON.
 */
public class GroovyPathExampleTest {

    @Test
    public void testMovieDetailsExtraction() {
        RestAssured.baseURI = "https://api.example.com/movies";

        given()
                .when()
                .get("/inception")
                .then()
                .assertThat()
                .body("movie.title", equalTo("Inception"))
                .body("movie.director", equalTo("Christopher Nolan"))
                .body("movie.ratings.critics", equalTo(9.1f))
                .body("movie.cast.find { it.name == 'Leonardo DiCaprio' }.role", equalTo("Dom Cobb"))
                .body("movie.cast.findAll { it.name =~ /.*Gordon.*/ }.name", hasItem("Joseph Gordon-Levitt"));

//        body("movie.title", equalTo("Inception")): Checks the title of the movie.
//        body("movie.director", equalTo("Christopher Nolan")): Verifies the director name.
//        body("movie.ratings.critics", equalTo(9.1f)): Assesses the critics’ rating.
//        body("movie.cast.find { it.name == 'Leonardo DiCaprio' }.role", equalTo("Dom Cobb")): Finds the role of Leonardo DiCaprio using a find query.
//        body("movie.cast.findAll { it.name =~ /.*Gordon.*/ }.name", hasItem("Joseph Gordon-Levitt")): Uses a regex within findAll to find any cast member whose name includes "Gordon".
//
    }
}