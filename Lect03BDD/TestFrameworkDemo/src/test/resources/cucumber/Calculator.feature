Feature: Calculator
  As a user
  I want to use a calculator
  So that I can add two numbers

  Scenario: Add two numbers
    Given I have a calculator
    When I add 2 and 3
    Then the result should be 5