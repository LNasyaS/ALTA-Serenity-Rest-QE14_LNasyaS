Feature: Delete user

#  Positive case
  @Latihan
  Scenario: Delete user with valid user id
    Given Delete user with valid user 2
    When Send request delete user
    Then Status code should be 204

#  Negative case
  @Tugas
  Scenario Outline: Delete user with invalid user id
    Given Delete user with invalid user "<id>"
    When Send request delete user
    Then Status code should be 400
    Examples:
      | id     |
      | zzzxxx |
      | !@#$%  |