Feature: Login functionality

  Scenario: User cannot log in with invalid credentials
    Given the user is on the login page
    When user enters invalid username "wrongUsername" or password "wrongPass"
    And clicks on the login button
    Then the user should see an Error message "Login failed! Please ensure the username and password are valid."
