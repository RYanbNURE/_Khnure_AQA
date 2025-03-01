package com.example.steps;

import com.example.pages.GoogleSearchPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Step;
import org.junit.jupiter.api.Assertions;

public class GoogleSearchSteps {

    private GoogleSearchPage googleSearchPage;

    @Given("I am on the Google search page")
    @Step
    public void iAmOnTheGoogleSearchPage() {
        googleSearchPage.open();
    }

    @When("I search for {string}")
    @Step
    public void iSearchFor(String searchTerm) {
        googleSearchPage.enterSearchTerm(searchTerm);
        googleSearchPage.clickSearch();
    }

    @Then("the page title should contain {string}")
    @Step
    public void thePageTitleShouldContain(String expectedTitle) {
        Assertions.assertTrue(googleSearchPage.getTitle().contains(expectedTitle));
    }
}