Feature: Login on demoblaze web

  @web
  Scenario: Login with valid username and password
    Given user open demoblaze website
    And user select the log in option
    And user input login username "zeeu94"
    And user input login password "secretmode"
    When user click the log in button
    Then user sees welcome message "Welcome zeeu94"

  @web
  Scenario: Login with invalid username and password
    Given user open demoblaze website
    And user select the log in option
    And user input login username "zeeu001"
    And user input login password "bip"
    When user click the log in button
    Then user sees alert message "User does not exist."