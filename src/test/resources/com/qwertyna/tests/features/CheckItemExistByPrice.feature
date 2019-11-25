Feature: Check item price on fist 5 pages

Scenario: Check TV item exist by price
Given I navigate to url "https://www.olx.ua"
When I enter "телевизор" to search field
And I click Search button
Then I click next page until offer price < "20000" or page count =5 and verify