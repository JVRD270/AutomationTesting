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
Feature: Title of your feature
  I want to use this template for my feature file

  @tag1
  Scenario Outline: Add and Delete elements
    Given I want to add <add> elements and delete <delete>
    When I click "Add Element" <add> times
    Then there will be <add> elements
    When I click "Delete" <delete> times
    Then there will be <result> elements left
    
     Examples: 
      | add  | delete | result  |
      | 5 |     5 | 0 |
      | 10 |     7 | 3    |

