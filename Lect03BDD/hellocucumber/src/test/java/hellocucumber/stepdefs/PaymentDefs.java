package hellocucumber.stepdefs;

import io.cucumber.java.en.When;

public class PaymentDefs {

    @When("I input valid credit card")
    public void i_input_valid_credit_card() {
        System.out.println("1");
    }

    @When("I input invalid credit card")
    public void i_input_invalid_credit_card() {
        System.out.println("1");
    }

}
