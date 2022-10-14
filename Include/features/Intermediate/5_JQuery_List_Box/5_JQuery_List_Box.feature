#Author: vminhhung@tma.com.vn

Feature: As an PO, i want to view new elements in UI, then i can add/remove it

  @AC1.1
  Scenario: Verify the element visible in UI
    Given Easyselenium page is launched
    When  I navigate to Immediate level then JQuery List Box
    Then  I verify item Isis is visible in UI

  @AC1.2
  Scenario Outline: Select item in left panel then click Add and verify it is moved to right
    Given Easyselenium page is launched
    When  I navigate to Immediate level then JQuery List Box
    And   I select item <item> in the left panel then click Add button
    Then  The item <item> is moved to the right panel

    Examples: 
      | item     |
      | Isis     |
      
   @AC1.3
    Scenario Outline: Select item in right panel then click Remove and verify it is moved to left
    Given Easyselenium page is launched
    When  I navigate to Immediate level then JQuery List Box
    And   I select item <item> in the left panel then click Add button
    And   I select item <item> in the right panel then click Remove button
    Then  The item <item> is moved to the left panel

    Examples: 
      | item     |
      | Isis     |