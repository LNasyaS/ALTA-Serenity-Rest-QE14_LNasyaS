Feature: Get single user

#  Positive case
  @Tugas
  Scenario Outline: Get user with valid id
    Given Get user with valid user <id>
    When Send request get user
    Then Status code should be 200
    And Response body name should be <id> and "<email>"
    And Validate json schema "SingleUserJsonSchema.json"
    Examples:
      | id | email                  |
      | 1  | george.bluth@reqres.in |
      | 2  | janet.weaver@reqres.in |

#  Negative cases
  @Tugas
  Scenario Outline: Get user with invalid id
    Given Get user with invalid "<id>"
    When Send request get user
    Then Status code should be 404
    Examples:
      | id     |
      | 23     |
      | zzzxxx |
      | !@#$%^ |