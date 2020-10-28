Feature: Create Employees

  Background:
    Given url baseUrl

  Scenario: Create Employees
    Given path '/create'
    And request {"name":"apples","salary":"12","age":"6"}
    And header Accept = 'application/json'
    When method POST
    Then status 200