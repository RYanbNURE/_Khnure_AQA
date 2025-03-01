Feature: Google Search

  Scenario: Search for Serenity BDD
    Given I am on the Google search page
    When I search for "Serenity BDD"
    Then the page title should contain "Serenity BDD"