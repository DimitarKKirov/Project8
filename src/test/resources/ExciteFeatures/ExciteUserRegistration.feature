@CreateAccount
Feature: user registration page

  Scenario: user registration
    Given user is on registration page
    When user enters the necessary data in all fields
    And user clicks complete registration
    #predpolagam
    Then  the user is redirected to the login page