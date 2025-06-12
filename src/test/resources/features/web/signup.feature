Feature: Sign up on demoblaze web

  @web
  Scenario: Sign up with a new account
    Given user open demoblaze website
    And user select the sign up option
    And user input a random username
    And user input password "secretmode"
    When user click the sign up button
    Then user sees alert message "Sign up successful."

  @web
  Scenario: Sign up with an existing account
    Given user open demoblaze website
    And user select the sign up option
    And user input username "test"
    And user input password "123"
    When user click the sign up button
    Then user sees alert message "This user already exist."