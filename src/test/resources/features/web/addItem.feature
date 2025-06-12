Feature: Add item to the cart

  @web
  Scenario: User add product to cart
    Given user is successfully redirected to the homepage
    And user selects category "Monitors"
    And user add product "Apple monitor 24"
    And user selects category "Phones"
    And user add product "Nokia lumia 1520"
    Then user navigates to the cart

