Feature: Delete Employee

  Background:
    Given url baseUrl

  Scenario: Delete Employee
    Given path '/delete/1'
    When method GET
    Then status 200
