package com.epam.stepdefinitions;

import com.epam.pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class LoginSteps {

    private final WebDriver driver = new ChromeDriver();
    private final LoginPage loginPage = new LoginPage(driver);

    @Given("^I am on the Login page$")
    public void i_am_on_the_login_page() {
        driver.get("https://example.com/login");
    }

    @When("^I enter valid credentials$")
    public void i_enter_valid_credentials() {
        loginPage.enterUsername("user");
        loginPage.enterPassword("password");
        loginPage.clickLogin();
    }

    @Then("^I should be redirected to the Dashboard page$")
    public void i_should_be_redirected_to_the_dashboard_page() {
        // Assertions go here
        driver.quit();
    }
}