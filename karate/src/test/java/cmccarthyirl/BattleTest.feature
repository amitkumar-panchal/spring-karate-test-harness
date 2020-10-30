Feature: Battle Tests

  Background:
    Given url baseUrl
    And header Accept = 'application/json'
    And header Content-Type = 'application/json; charset=utf-8'

  Scenario: Battle Endpoint Scenario
    Given path '/battle'
    And param yourHeroId = 1
    And param chosenHeroId = 2
    And request {}
    And header Accept = 'application/json'
    When method POST
    Then status 200
    And print response