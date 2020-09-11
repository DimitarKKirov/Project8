@Lilly
Feature: homepage

  Scenario: navigating to login page and log in
    Given user is on https://shop.lillydrogerie.bg/
    When user click on Вход button
    Then the user is redirected to the login page of Lilly website

