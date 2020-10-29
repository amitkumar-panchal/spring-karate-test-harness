Feature: Get all Employees

  Background:
    Given url baseUrl

  Scenario: Get all Employees
    Given path '/employees'
    When method GET
    Then status 200

  Scenario: Get single Employee
    Given path '/employee/1'
    When method GET
    Then status 200
    And match response[*].employee_name contains ['Tiger Nixon']