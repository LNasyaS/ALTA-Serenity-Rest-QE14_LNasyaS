Feature: Create user

#  Positive case
  @Tugas
  Scenario: Post create user with valid json
    Given Create user with valid json "CreateUser.json"
    When Send request create new user
    Then Status code should be 201
    And Response body name should be "LNasya Syafitrie" and job should be "QA Engineer"
    And Validate json schema "CreateUserJsonSchema.json"

#  Negative case
  @Tugas
  Scenario Outline: Post create user with invalid json
    Given Create user with valid json "<json>"
    When Send request create new user
    Then Status code should be 400
    Examples:
      | json                       |
      | CreateUserWithoutJob.json  |
      | CreateUserWithoutName.json |
