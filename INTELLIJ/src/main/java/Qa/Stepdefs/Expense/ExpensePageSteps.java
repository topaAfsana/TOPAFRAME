package Qa.Stepdefs.Expense;

import Qa.Pages.OnWebUI;
import Qa.Utility.Verify;
import Qa.Utility.driverUtil;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class ExpensePageSteps {



    @When("User Log In with valid User {string} and valid password {string}")
    public void user_log_in_with_valid_user_and_valid_password(String user, String password) {
        OnWebUI.On_ExpensePage().Log_In_With(user,password);
        OnWebUI.waitFor();
    }

    @When("User able to log in and land on Expense page")
    public void user_able_to_log_in_and_land_on_expense_page() {
        String expected="BUDGET EXPLORER-EXPENSE CHECK";
        String actual= driverUtil.getPageTitle();
        Verify.It_matches("Page title matched ",expected,actual);
        OnWebUI.waitFor();
    }

    @When("User Create a new List {string}")
    public void user_create_a_new_list(String string) {

    }

    @Then("Verify new list is created successfully")
    public void verify_new_list_is_created_successfully() {

    }

    @Then("new table is displayed in the list table")
    public void new_table_is_displayed_in_the_list_table() {

    }


    @When("User open list table")
    public void user_open_list_table() {
        OnWebUI.On_ExpensePage().Open_Lists_Table();
        OnWebUI.waitFor();

    }

    @Then("Verify it gets all the list available for the User")
    public void verify_it_gets_all_the_list_available_for_the_user() {
        String expected_table_header="Tables";
        String actual_table_header=OnWebUI.On_ExpensePage().Get_Lists_Table_Header();
        Verify.It_matches("Table opened and Title mached",expected_table_header,actual_table_header);
        OnWebUI.waitFor();

    }


}
