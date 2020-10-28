Feature: Hello World

  Background:
    Given url baseUrl

  Scenario: Get all Employees
    Given path '/employees'
    When method GET
    Then status 200
    And print response

  Scenario: Get single Employee
    Given path '/employee/1'
    When method GET
    Then status 200
    And match response[*].employee_name contains ["Tiger Nixon"]

  Scenario: Get single Employee
    Given path '/employee/1'
    When method GET
    Then status 200
    And match response[*].employee_name contains ["Tiger Nixon"]