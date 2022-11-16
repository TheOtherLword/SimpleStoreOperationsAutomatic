Feature: Managing addresses in existing account

  Scenario Outline: Adding and deleting addresses in https://mystore-testlab.coderslab.pl
    Given Web page https://mystore-testlab.coderslab.pl is open in Chrome browser
    When I click Sign in button
    And I login using login ... and password ...
    And I click Addresses button
    And I click Create new address
    And I fill in alias, address, city, postal code,country, phone in input boxes
#    And I click country list box and select a country
    And I add address by clicking Save button
    Then I see Address successfully added! message
    And I verify created address
    And I remove address by clicking on Delete button
    And I see Address successfully deleted! message


  Examples:
  |login|password|alias|address|city|postal code|phone|country|
  |12@test.pl|test1|testing|Test Street|Testopolis|12-123|123456789|United Kingdom|

# email 12@test.pl password test1