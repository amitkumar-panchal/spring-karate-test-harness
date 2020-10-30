Feature: Create Hero Tests

  Background:
    Given url baseUrl
    And header Accept = 'application/json'
    And header Content-Type = 'application/json; charset=utf-8'

  Scenario: Create Hero Endpoint Scenario
    Given path '/battle'
    And request {"id": 7,"name": "SDET","age": 100,"weapon": "Programming","specialPower": "Can see the Matrix"}
    When method PUT
    Then status 200
    And print response
