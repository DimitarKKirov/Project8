@Login
Feature: Reach excite.com login page

  Scenario: accessing the user login page
    Given user is on excite.com/email page
    When user click on "Click here to access your email" link button
    Then user is redirected to the login page


    Scenario: user going to registration page
      Given user is on login.excite.com
      When user clicks on "need an account?" button
      Then user is redirected to the registration page in new tab