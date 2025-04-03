@LoginFeature
Feature: Login Feature
  
  @test @positive
  Scenario: Verify logged in user is able to add task
    Given the user is on the login page
    When the user enters valid credentials
    And clicks the login button
    Then the user should be redirected to the dashboard
    When the user switches to Employee Mode
    And clicks on Add Task
    Then the task should be added successfully
    
    
  @test @negative
  Scenario: Verify that user is unable to submit until required parameters are filled
    Given the user is on the login page
    When the user enters valid credentials
    And clicks the login button
    Then the user should be redirected to the dashboard
    When the user switches to Employee Mode
    And clicks on Add Task
    Then the task should be added successfully