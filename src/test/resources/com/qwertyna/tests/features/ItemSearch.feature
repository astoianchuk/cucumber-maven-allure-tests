Feature: Item search by specific field(s)
  #1. на сайте olx ввести в поиске "телевизор",
  # открыть первый из списка (обычные обьявления)
  # и проверить что Вид техники - "Телевизроры"


#  Scenario Outline: Find item by field
  Scenario: Find item by field
    Given I navigate to url "https://www.olx.ua"
    When I enter "телевизор" to search field
    And I click Search button
    And I select first found item
    Then I verify that found item contain field "Вид техники" and value "Телевизроры"


#    Examples:
#| field       | value        |testData  |
#| Вид техники | Телевизроры  | телевизор         |
#| C243225 | teams/releaseClassicTeams        |
#| C243226 | sites/ReleaseModernTeamPrivate   |
#| C243227 | sites/ReleaseModernTeamPublic    |
#| C243228 | sites/ReleaseModernCommunication |
#| C243229 | releaseClassicTeamSubsite        |
#| C243230 | releaseModernTeamSubsite         |

  #2. на сайте olx ввести в поиске "телевизор",
  # проверить что на первых 5-ти страницах списка (обычные обьявления)
  # есть хотя бы 1 телевизор с ценой > 20000