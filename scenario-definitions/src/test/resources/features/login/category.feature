Feature: Users category section
  As a logged in user
  I should navigate to category
  So I can validate functionality of category

  Scenario: Validate navigate to category section
    Given Navigate to Login page
    And Enter credentials to log in
    When Navigate to group 'ELECTRONICS'
    When select category 'Camera, photo'
    When Select product 'Camcorder'
    Then Product name should have text equal to 'Camcorder'