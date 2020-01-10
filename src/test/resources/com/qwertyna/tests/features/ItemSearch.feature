Feature: Item search by specific field
  This test find product by search Query and verifying that
  found first element in sections "regular ads" contains specific field and value

  Scenario Outline: Find item by field
    Given I navigate to url "https://www.olx.ua"
    When I enter "<searchQuery>" to search field
    And I click Search button
    And I select first found item
    Then I verify that found "<searchQuery>" contain field "<field>" and value "<fieldValue>"
    Examples:
      | searchQuery | field       | fieldValue |
      | телевизор   | Вид техники | Телевизоры |

