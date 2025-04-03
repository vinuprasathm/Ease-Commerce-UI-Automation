@LoginFeature
Feature: Login Feature
  
  @test
  Scenario: Login with valid credentials
    Given User is on the login page
    When User enters valid username and password
    And Clicks the login button
    Then User should be redirected to the dashboard