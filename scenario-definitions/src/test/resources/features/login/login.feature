Feature: User Login
  As a registered user
  I should provide valid username and password
  So that I can login into the system

  Scenario: Login with valid username and password
    When Enter credentials to log in
    When Click on logout

#    Examples:
#      | Username           | Password  |
#      | splendor@gmail.com | splendor1 |
#


#  Scenario Outline: Login with in-valid username and password
#    When Enter username '<Username>'
#    When Enter password '<Password>'
#    When Click on button 'Login'
#    Then Error message should have text equal to 'Incorrect username or password'
#
#    Examples:
#      | Username | Password |
#      | unknown  | unknown  |
#      | admin    | admin    |
#      | invalid  | admin    |

