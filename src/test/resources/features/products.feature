Feature: Shopping cart functionality

  @regression @master
  Scenario: User adds multiple products to the cart
    Given As a user I want to launch to the application
    Then the user adds the following products to the cart:
      | MacBook                 |
      | iPhone                  |
      | Samsung Galaxy Tab 10.1 |

  @regression @master
  Scenario: Add and remove multiple products
    Given As a user I want to launch to the application
    When the user adds the following products to the cart:
      | MacBook                 |
      | iPhone                  |
      | Samsung Galaxy Tab 10.1 |
    And the user removes the following products from the cart:
      | iPhone |
    Then the cart should contain the following products:
      | MacBook                 |
      | Samsung Galaxy Tab 10.1 |