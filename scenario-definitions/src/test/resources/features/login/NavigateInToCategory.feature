Feature: Users category section
  As a logged in user
  I should navigate to category
  So I can validate functionality of navigation

  Scenario: Validate navigate to category section
    Given Navigate to Login page
    When Enter credentials to log in
    When Navigate to option 'ELECTRONICS' under group 'Camera, photo'
    When Select product 'Camcorder'
    Then Product name should have text equal to 'Camcorder'
