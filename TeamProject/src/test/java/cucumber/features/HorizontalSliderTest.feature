#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: Can move horizontal slider
  I want to use this template for my feature file

  @tag1
  Scenario: Can move Horizontal slider to chosen positions
    Given I want to move my horizontal slider
    When I set its positions to
    | 1.0 |
    | 3.0 |
    | 2.0 |
    | 4.5 |
    | 5.0 |
    Then I check if it moved to the correct positions

 
    
