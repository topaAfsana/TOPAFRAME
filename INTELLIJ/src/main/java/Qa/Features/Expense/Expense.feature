Feature: User is able to perform Expoense functionality


  @RegressionTest
  Scenario: User able to create new expense list
    Given User is on BudgetExplorer Home Page
    And   User got to Expense page
    When User Log In with valid User "Topa" and valid password "tishan"
    And User able to log in and land on Expense page


  @RegressionTest @WIP
  Scenario: User able to view all the Expense List
    Given User is on BudgetExplorer Home Page
    And   User got to Expense page
    When User Log In with valid User "Topa" and valid password "tishan"
    And User able to log in and land on Expense page
    When User open list table
#    Then Verify it gets all the list available for the User








#    When User Create a new List ""
#    Then Verify new list is created successfully
#    And new table is displayed in the list table


  @RegressionTest
  Scenario: User able to add item into Expense List

  @RegressionTest
  Scenario: User able to Update Expense List

  @RegressionTest
  Scenario: User able to delete Expense List

