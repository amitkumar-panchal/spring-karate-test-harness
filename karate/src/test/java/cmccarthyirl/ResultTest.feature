Feature: Get Results Tests

  Background:
    Given url baseUrl
    And header Accept = 'application/json'
    And header Content-Type = 'application/json; charset=utf-8'

  Scenario: Get all results
    Given path '/results'
    When method GET
    Then status 200
    And print response