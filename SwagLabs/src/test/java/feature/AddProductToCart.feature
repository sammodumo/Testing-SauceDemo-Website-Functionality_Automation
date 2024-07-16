Feature: Testing SauceDemo Website Functionality

Scenario: Add Product to Cart

Given I am logged in to SauceDemo
When I add a product to my cart
Then the product should appear in my cart