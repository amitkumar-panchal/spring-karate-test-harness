Feature: Update Employees

  Background:
    Given url baseUrl

  Scenario: Update Employees
    Given path '/employees'
    When method GET
    Then status 200
