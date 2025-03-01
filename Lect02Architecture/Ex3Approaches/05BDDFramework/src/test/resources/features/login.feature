Feature: Login Functionality

  Scenario: Successful Login with Valid Credentials
    Given I am on the Login page
    When I enter valid credentials
    Then I should be redirected to the Dashboard page