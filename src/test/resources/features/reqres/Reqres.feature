Feature: Serenity Rest QE 14

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

  @Latihan
  Scenario: Post create user with valid json
    Given Create user with valid json "CreateUser.json"
    When Send request create new user
    Then Status code should be 201
    And Response body name should be "LNasya Syafitrie" and job should be "QA Engineer"

  @Latihan
  Scenario Outline: Update user with valid json and user id
    Given Update user with valid json "<json>" and user id <id>
    When Send request update user
    Then Status code should be 200
    And Response body name should be "<name>" and job should be "<job>"
    Examples:
      | id | json             | name                      | job                  |
      | 1  | UpdateUser1.json | LNasya Syafitrie Update 1 | QA Engineer Update 1 |
      | 2  | UpdateUser2.json | LNasya Syafitrie Update 2 | QA Engineer Update 2 |
      | 3  | UpdateUser3.json | LNasya Syafitrie Update 3 | QA Engineer Update 3 |

  @Latihan
  Scenario: Delete user with valid user id
    Given Delete user with valid user 2
    When Send request delete user
    Then Status code should be 204