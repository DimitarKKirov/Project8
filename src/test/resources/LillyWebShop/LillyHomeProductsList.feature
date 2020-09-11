@Lilly
Feature: shopping
        #Продукти за дома
  Scenario: user goes to Home Products from the left menu
    Given the user is logged in
    And on the home page
    When the user clicks Home products from the left had menu
    Then the user is redirected to the shop list with the corresponding items


  Scenario: Adding items to the shopping cart and opening the shopping cart
    Given user is in Home products shopping list
    And add items to the basket
    And the total price is calculated correctly for the items in the basket
    When the user clicks the basket
    Then the user is redirected to the shopping cart


    Scenario: user