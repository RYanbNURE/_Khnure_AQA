Feature: User Registration

#  Data tables in Cucumber can be used to represent lists or tables of data.
#  Cucumber can automatically convert these tables to Lists, Maps, or custom types.

  Scenario: Register multiple users
    Given the following users are registered
      | name    | email             |
      | Alice   | alice@example.com |
      | Bob     | bob@example.com   |
      | Bob1    | bob1@example.com  |

#    Examples are used with
#  Scenario Outline to run the same scenario multiple times with different data.


  Scenario Outline: User login
    Given <user> enters username and password
    Then the user should be logged in successfully

    Examples:
      | user   |
      | Alice  |
      | Bob    |
      | Jack   |

#    Custom parameter types let you transform expressions directly.

  Scenario Outline:: Order coffee by type
    Given I order a <Size> coffee

    Examples:
      | Size   |
      | Small  |
      | Medium |
      | Large  |

#  You can transform data from data tables into custom objects via DataTableType.


  Scenario: Register a new user
    Given the following user is created:
      | firstName | lastName | email             | age |
      | John      | Doe      | john.doe@mail.com | 30  |


