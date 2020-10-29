Feature: Get all Employees

  Background:
    Given url baseUrl

  Scenario: Get all Employees
    Given path '/hero'
    When method GET
    Then status 200
    And print response

  Scenario: Get single Employee
    Given path '/hero/1'
    When method GET
    Then status 200
    And match response.name == 'Achilles'