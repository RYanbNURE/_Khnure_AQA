package hellocucumber.stepdefs;

import hellocucumber.pages.HomePage;
import hellocucumber.pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginDefinitions {

    private HomePage homePage = new HomePage();

    @Given("I logged in as end-user")
    public void i_logged_in_as_end_user() {
        new HomePage().visit();
        new HomePage().clickLoginLink();
        new LoginPage().inputUserName("test_user");
        new LoginPage().inputPassword("123");
        //logic parsing email
    }
}
