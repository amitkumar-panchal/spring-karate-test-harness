Feature: Get Heros Tests

  Background:
    Given url baseUrl
    And header Accept = 'application/json'
    And header Content-Type = 'application/json; charset=utf-8'

  Scenario: Get all Heros Endpoint Scenario
    Given path '/hero'
    When method GET
    Then status 200
    And print response

  Scenario: Get single Heros Endpoint Scenario
    Given path '/hero/1'
    When method GET
    Then status 200
    And print response
    And match response.name == 'Achilles'