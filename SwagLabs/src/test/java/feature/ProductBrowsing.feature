Feature: Product browsing on SauceDemo website

  Scenario: View product details
    Given I am logged into SauceDemo with username "performance_glitch_user" and password "secret_sauce"
    When I click on a specific product
    Then I should see the details of that product

  Scenario: Add product to cart
    Given I am logged in and on the products page
    When I add a product to the cart
    Then the cart icon should update to reflect the added product

  Scenario: Remove product from cart
    Given I have products in my cart
    When I remove a product from the cart
    Then the cart should update to reflect the removed product