Feature: Check item price on fist 5 pages

Scenario: Check TV price
Given I navigate to url "https://www.olx.ua"
When I enter "телевизор" to search field
And I click Search button
Then I click next page until offer price < "20000" or page count =5
#Then I verify that on the first 5 pages of the usual announcements at least one TV with a price> "200000"