Feature: User register

#  Positive case
  @Tugas
  Scenario: User successfully register with valid data
    Given User register with valid json "RegisterUser.json"
    When Send request post user register
    Then Status code should be 200
    And Validate json schema "RegisterValidJsonSchema.json"

#  Negative cases
  @Tugas
  Scenario Outline: User unsuccessfully register with invalid data
    Given User register with valid json "<json>"
    When Send request post user register
    Then Status code should be 400
    And Validate json schema "RegisterInvalidJsonSchema.json"
    Examples:
      | json                         |
      | RegisterInvalidEmail.json    |
      | RegisterWithoutEmail.json    |
      | RegisterWithoutPassword.json |