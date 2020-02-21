@ontest
Feature: Users category section

  Scenario: Validate navigate to category section
    Given Navigate to Login page
    And Enter credentials to log in
    And Navigate to category 'Electronics' under group 'CATEGORIES'