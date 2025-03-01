package com.epam.stepdefinitions;

import io.cucumber.java.DataTableType;
import io.cucumber.java.en.Given;

import java.util.Map;

public class RegistrationSteps {
    @DataTableType
    public UserT convertToUser(Map<String, String> entry) {
        return new UserT(
                entry.get("firstName"),
                entry.get("lastName"),
                entry.get("email"),
                Integer.parseInt(entry.get("age"))
        );
    }

    @Given("the following user is created:")
    public void the_following_user_is_created(UserT userT) {
        System.out.println("Creating user: " + userT);
    }
}

class User {
    String firstName;
    String lastName;
    String email;
    int age;

    public User(String firstName, String lastName, String email, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.age = age;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + " (" + email + "), age " + age;
    }
}