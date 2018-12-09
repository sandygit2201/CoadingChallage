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

Feature: Title of your feature
	I want to use this template for my feature file

Background: Background runs for each scenario
Given Run before each scenario

Scenario: Title of your scenario
Given The price of banana is 40c
When I checkout 1 banana
Then The total price should be 40c

Scenario: Title of your scenario
Given The price of banana is 40c
When I checkout 1 banana
Then The total price should be 40c

