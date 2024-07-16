Feature: Testing SauceDemo Website Functionality

  Scenario: Valid Login
    Given I navigate to the SauceDemo login page
    When I enter valid username and password
    And I click on the login button
    Then I should be logged into the system and click first item