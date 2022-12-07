Feature: Buying Items in existing account

  Scenario Outline: Adding items to cart and buying items
    Given Web page MyStore is open in Chrome browser
    When I click Sign in button
    And I login using <login> and <password>
    And I go back to main page
    And I go to desired item page
    And I check if discount is equal <discount>
    And I select item size <size>
    And I select number of items <quantity>
    And I add items to cart
    And I go to check out
    And I confirm Address
    And I choose pick up method
    And I pick payment method
    And I click on order with an obligation to pay
    Then I do a screenshot of order

    Examples:
      |login     |password|discount|size|quantity|
      |12@test.pl|test1|-20%|M|5|
