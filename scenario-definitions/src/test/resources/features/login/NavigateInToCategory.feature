@single
Feature: Users category section

  Scenario: Validate navigate to category section
    Given Navigate to Login page
    And Enter credentials to log in
    When Navigate to option 'ELECTRONICS' under group 'Camera, photo'
    When Select product 'Camcorder'
    Then Product name should have text equal to 'Camcorder'
