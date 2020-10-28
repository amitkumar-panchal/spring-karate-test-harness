Feature: Hello World

  Background:
    Given url baseUrl

  Scenario: Get all Employees
    Given path '/employees'
    When method GET
    Then status 200
    And print response