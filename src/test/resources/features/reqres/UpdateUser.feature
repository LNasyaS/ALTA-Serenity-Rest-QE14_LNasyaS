Feature: Update user

#  Positive case
  @Tugas
  Scenario Outline: Update user with valid json and user id
    Given Update user with valid json "<json>" and user id <id>
    When Send request update user
    Then Status code should be 200
    And Response body name should be "<name>" and job should be "<job>"
    And Validate json schema "UpdateUserJsonSchema.json"
    Examples:
      | id | json             | name                      | job                  |
      | 1  | UpdateUser1.json | LNasya Syafitrie Update 1 | QA Engineer Update 1 |
      | 2  | UpdateUser2.json | LNasya Syafitrie Update 2 | QA Engineer Update 2 |
      | 3  | UpdateUser3.json | LNasya Syafitrie Update 3 | QA Engineer Update 3 |

#  Positive case
  @Tugas
  Scenario: Update user without user id path
    Given Update user with json "UpdateUser1.json" without user id
    When Send request update invalid id path
    Then Status code should be 400