package com.epam.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;

import java.util.List;
import java.util.Map;

public class UserSteps {
    @Given("the following users are registered")
    public void the_following_users_are_registered(DataTable dataTable) {
        List<Map<String, String>> users = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> user : users) {
            System.out.println("Registering: " + user.get("name") + " with email " + user.get("email"));
        }
    }

    @Given("{string} enters username and password")
    public void user_enters_username_and_password(String user) {
        System.out.println(user + " enters credentials");
    }

    @Then("the user should be logged in successfully")
    public void user_logged_in_successfully() {
        System.out.println("User logged in successfully");
    }
}