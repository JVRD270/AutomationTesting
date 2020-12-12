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
  Scenario Outline: Check information from table
    Given I want to assert the amount user <userId> owes me
    When I navigate to my data page
    Then I want to get the amount so I can assert it equals <expectedAmount>

    Examples: 
      | userId  | expectedAmount |
      | 1 |   "$50.00" |
      | 2 |   "$51.00" |
      | 3 |   "$100.00" |
      | 4 |   "$50.00" |
