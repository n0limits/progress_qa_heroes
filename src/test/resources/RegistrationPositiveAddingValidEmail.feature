Feature: Basic logic for Registration (Positive) QP-3
  In order to create a new Customer account
  as a user
  I want to be able to add an email, which will be used in the creation of a new Customer account

  Scenario: Customer adds a mail for registering a new user via the Authentication page
    Given Customer navigates to the Authentication page
    And customer enters a valid email to the registration field
      | email                      |
      | pesho.petruvchev@gmail.com |
    When Customer presses the Create an account button
    Then Customer is redirected to Registration form page
