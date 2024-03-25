Feature: Get list user

#  Positive case
  @Latihan
  Scenario Outline: Get list users with valid parameter page
    Given Get list user with parameter page <page>
    When Send request get list users
    Then Status code should be 200
    And Response body page should be <page>
    And Validate json schema "ListUsersJsonSchema.json"
    Examples:
      | page |
      | 1    |
      | 2    |

#   Negative cases
  @Tugas
  Scenario Outline: Get list users with invalid parameter page
    Given Get list user with parameter page "<page>"
    When Send request get list users
    Then Status code should be 404
    Examples:
      | page   |
      | zzzxxx |
      | !@#$%^ |