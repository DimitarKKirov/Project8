Feature: search

  Background:
    Given the user is logged in emag

  Scenario: search for item
    When user enters search criteria
    Then the user can see the results