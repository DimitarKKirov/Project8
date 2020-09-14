Feature: search for books, choose some books,put in basket,edit the basket,add to favourites

  Scenario:
    Given user is on bard.bg
    When user enter search keyword in the search field
    And pres the search button
    Then the user is redirected to the result page
    And the user chooses books to add to user basket
    Then Clicks on catalogue
    And chooses a genre
    And user removes some books from the basket
    Then the user adds some books to favourites