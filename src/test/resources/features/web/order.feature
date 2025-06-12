Feature: Order confirmation

  @web
  Scenario: User successfully submits an order
    Given user has added products to the cart
    When user submits the order
    And user input the "name" "Zee"
    And user input the "country" "Canada"
    And user input the "city" "Toronto"
    And user input the "card" "80008"
    And user input the "month" "12"
    And user input the "year" "2030"
    And user completes the purchase
    Then user sees a confirmation message "Thank you for your purchase!"

  @web
  Scenario: User submits an order without filling the form
    Given user has added products to the cart
    When user submits the order
    And user input the "name" ""
    And user input the "country" ""
    And user input the "city" ""
    And user input the "card" ""
    And user input the "month" ""
    And user input the "year" ""
    And user completes the purchase
    Then user sees alert message "Please fill out Name and Creditcard."