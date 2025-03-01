package com.example.jbehave;


import org.example.service.Calculator;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import static org.junit.Assert.assertEquals;

public class CalculatorSteps {
    private Calculator calculator;
    private int result;

    @Given("I have a calculator")
    public void givenIHaveACalculator() {
        calculator = new Calculator();
    }

    @When("I add $a and $b")
    public void whenIAdd(int a, int b) {
        result = calculator.add(a, b);
    }

    @Then("the result should be $expected")
    public void thenTheResultShouldBe(int expected) {
        assertEquals(expected, result);
    }
}
