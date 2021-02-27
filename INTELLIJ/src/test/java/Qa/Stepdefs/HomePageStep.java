package Qa.Stepdefs;
import Qa.Utility.AppConstants;
import Qa.Pages.WebUI;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;



public class HomePageStep{

AppConstants appConstants=new AppConstants();

    @Given("User Navigate to Budget Explorers Web page Expense Feature and get Title header")
    public void user_navigate_to_budget_explorers_web_page() {
        WebUI.HomePage().getTittleHeader(); }

    @When("User go to Expense Page")
    public void userGetTextOfExpensePage() {
        WebUI.ExpensePage().gotToExpense();    }
}
