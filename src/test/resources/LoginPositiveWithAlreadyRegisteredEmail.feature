Feature: Basic logic for Login with valid email (Positive)
  In order to be able to use the full list of functionalities of the site
  as an already registered user
  I want to be able to log in to the site with a valid email and password

  Scenario: Successful login

    Given Customer is on Authentication page
    And enters a valid email address and password in Login section
    When presses Login button
    Then user is successfully logged in