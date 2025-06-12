Feature: Test automation Rest API

  @api
  Scenario: Create a new user
    Given prepare url for "user"
    When hit api to post create a new user
    Then validate that the status code is 200
    And validate response JSON using JSON Schema "create_new_user.json"

  @api
  Scenario: Get a user with a valid ID
    Given prepare url for "user"
    And hit api to post create a new user
    And validate that the status code is 200
    When hit api to get user by ID
    Then validate that the status code is 200
    And validate response body contains correct user data

  @api
  Scenario: Get a user with a non-existent ID
    Given prepare url for "user"
    When hit api to get user with non-existent ID "08e96e582721592e071c36c0"
    Then validate that the status code is 404
    Then validation response body contains error message "Not Found"

  @api
  Scenario: Update a user withg a valid ID
    Given prepare url for "user"
    And hit api to post create a new user
    And validate that the status code is 200
    When hit api put request update data
    Then validate that the status code is 200
    Then validate response body contains correct user data

  @api
  Scenario: Delete a user with a valid ID
    Given prepare url for "user"
    And hit api to post create a new user
    And validate that the status code is 200
    When hit api delete user
    Then validate that the status code is 200
    And validate response JSON using JSON Schema "delete_user.json"

  @api
  Scenario: Delete user with an invalid ID
    Given prepare url for "user"
    When hit api to delete user with invalid ID "08e96e582721592"
    Then validate that the status code is 400
    Then validation response body contains error message "Bad Request"

  @api
  Scenario:  Get the list of tags
    Given prepare url for "tags"
    When hit api to get list
    Then validate that the status code is 200
    And validate response JSON using JSON Schema "list_of_tags.json"

  @api
  Scenario: Send request to an invalid URL
    Given prepare url for "invalid_url"
    And hit api to get list
    Then validate that the status code is 404
    Then validation response body contains error message "Not Found"