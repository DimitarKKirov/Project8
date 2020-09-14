Feature: Create account and login

  Scenario: Create account
    Given user is in emag web page
    And user hovers over My Account at the top
    When user clicks on new account
    And the user is redirected to the login page and prompted to enter "dimitar.kirov@estafet.com" address
    And after hitting continue the user is asked to enter more details
    And that he is agree with the Terms and Conditions and the Privacy Policy
    Then the user can continue