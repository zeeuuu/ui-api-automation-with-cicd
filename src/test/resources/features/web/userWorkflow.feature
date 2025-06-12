Feature: End-to-End Purchase Flow

  @web
  Scenario: User registers, logs in, adds products to cart, and completes order
    Given user open demoblaze website
    And user select the sign up option
    And user input a random username
    And user input password "secretmode"
    When user click the sign up button
    Then user sees alert message "Sign up successful."
    And user is successfully redirected to the homepage
    And user sees welcome message "Welcome zeeu94"
    And user selects category "Monitors"
    And user add product "Apple monitor 24"
    And user selects category "Phones"
    And user add product "Nokia lumia 1520"
    And user navigates to the cart
    And user submits the order
    And user input the "name" "Zee"
    And user input the "country" "Canada"
    And user input the "city" "Toronto"
    And user input the "card" "80008"
    And user input the "month" "12"
    And user input the "year" "2030"
    And user completes the purchase
    Then user sees a confirmation message "Thank you for your purchase!"