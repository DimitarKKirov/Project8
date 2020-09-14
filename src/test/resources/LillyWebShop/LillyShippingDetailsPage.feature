Feature: ordering items

  Scenario:
    Given user have items in the basket
    And user is in the basket
    And and clicks buy
    When user fill the necessary Data
    And pres submit button
    Then the user is redirected to the payment page

