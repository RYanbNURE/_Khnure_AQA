Feature: My test title

  Background:
    Given I logged in as end-user

  Scenario: Confirmation Email
    When I buy a product
    And I input valid credit card
    Then I should see confirmation email

  Scenario: Invalid card message
    When I buy a product
    And I input invalid credit card
    Then I should see invalid credit card message