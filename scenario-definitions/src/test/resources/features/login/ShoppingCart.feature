@single
Feature: Users category section
  As a logged in user

  Scenario: Validate navigate to Shopping cart
    Given Navigate to Login page
    When Enter credentials to log in
    When In Home Page click on button 'Shopping cart'
    Then Title should be 'Shopping cart'
    When Shopping cart should have columns
      | Remove      |
      | Product(s)  |
      | Price       |
      | Qty.        |
      | Total       |