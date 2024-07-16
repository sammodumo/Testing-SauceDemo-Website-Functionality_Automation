Feature: Testing SauceDemo Website Functionality

Scenario: Invalid login

Given I am on the SauceDemo login page
When I enter invalid username and invalid password"
And I click on the Login button
Then I should see an error message "Epic sad face: Username and password do not match any user in this service"