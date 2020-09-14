Feature: user login with existing account

  Scenario: user logs in
    Given user is in emag web page
    And user hovers over My Account at the top
    And user clicks on enter in account
    When the user is redirected to the login page of emag
    And user clicks on login with Google
    And user enters "lycifer@gmail.com" address and click continue
    And enter a password and click continue
    Then the user is successfully logged in