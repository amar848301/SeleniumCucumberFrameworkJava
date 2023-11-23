Feature: Create order of different products

  @tag1
  Scenario: Create an order till dispatch
    Given Login into account with given details
    | email              | password    |
    | customer@gmail.com | Customer@123 |
    When add a single product in cart
    | productName                               |
    | Field Roast Chao Cheese Creamy Original |
    Then proceed to checkout