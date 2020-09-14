@Lilly
Feature: Login page

  Scenario: user is logged in with correct credentials
    Given the user is on user Login page
    When user enters the correct username and password
    And clicks on button Вход
    Then user is successfully logged in

