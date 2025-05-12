Feature: E-commerce Shopping Flow
  As a user
  I want to complete a purchase
  So that I can buy products online

  @smoke
  Scenario: Complete purchase flow with valid credentials
    Given I am on the login page
    When I login with valid credentials
    And I add "ZARA COAT 3" to cart
    And I navigate to cart page
    Then I should see the "ZARA COAT 3" in cart
    And the total amount should be correct
    When I proceed to checkout
    And I fill in the mandatory information
    And I place the order
    Then I should see the order confirmation message

  @smoke
  Scenario: Complete purchase flow with multiple products
    Given I am on the login page
    When I login with valid credentials
    And I add the following products to cart:
      | ZARA COAT 3        |
      | ADIDAS ORIGINAL    |
#      | IPHONE 13 PRO      |
    And I navigate to cart page
    Then I should see all the following products in cart:
      | ZARA COAT 3        |
      | ADIDAS ORIGINAL    |
#      | IPHONE 13 PRO      |
    And the total amount should be correct
    When I proceed to checkout
    And I fill in the mandatory information
    And I place the order
    Then I should see the order confirmation message