package com.epam.stepdefinitions;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import static org.junit.Assert.assertNotEquals;

public class UserImportSteps {
    private List<UserT> userTS = new ArrayList<>();

    @Given("I have a CSV file named {string}")
    public void i_have_a_csv_file_named(String fileName) {
        // This is where you may read the CSV file
    }

    @When("I import the users from the CSV file")
    public void i_import_the_users_from_the_csv_file() throws Exception {
        Reader reader = Files.newBufferedReader(Paths.get("src/test/resources/" + "users.csv"));
        CSVParser parser = new CSVParser(reader, CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());

        for (CSVRecord record : parser) {
            UserT userT = new UserT(
                    record.get("Name"),
                    record.get("Email"),
                    record.get("Age"));
            userTS.add(userT);
            // Assuming you have some method to import user into a database
            // importUser(user);
        }
        parser.close();
        reader.close();
    }

    @Then("all users should be successfully imported into the database")
    public void all_users_should_be_successfully_imported_into_the_database() {
        // Here you might confirm that the users are indeed in the database,
        // possibly querying the database or checking the number of users imported
        assertNotEquals(0, userTS.size());
    }
}

class UserT {
    private String name;
    private String email;
    private int age;

    public UserT(String name, String email, int age) {
        this.name = name;
        this.email = email;
        this.age = age;
    }
}
