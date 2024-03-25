Feature: User login

#  Positive case
  @Tugas
  Scenario: User successfully login with valid json
    Given Login user with valid json "LoginUser.json"
    When Send request post user login
    Then Status code should be 200
    And Validate json schema "LoginValidJsonSchema.json"

#  Negative cases
  @Tugas
  Scenario Outline: User unsuccessfully login with invalid json
    Given Login user with valid json "<json>"
    When Send request post user login
    Then Status code should be 400
    And Validate json schema "LoginInvalidJsonSchema.json"
    Examples:
      | json                          |
      | LoginUserInvalidEmail.json    |
      | LoginUserWithoutPassword.json |
      | LoginUserWithoutEmail.json    |
