package com.epam.stepdefinitions;

import io.cucumber.java.ParameterType;
import io.cucumber.java.en.Given;

public class CoffeeSteps {
    @ParameterType("Small|Medium|Large")
    public CoffeeSize coffeeSize(String size) {
        return CoffeeSize.valueOf(size.toUpperCase());
    }

    @Given("I order a {coffeeSize} coffee")
    public void i_order_a_coffee(CoffeeSize size) {
        System.out.println("Ordering a " + size);
    }
}

enum CoffeeSize {
    SMALL, MEDIUM, LARGE
}