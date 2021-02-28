package Qa.Stepdefs.Home;
import Qa.Pages.OnWebUI;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;



public class HomePageStep{

    @Given("User is on BudgetExplorer Home Page")
    public void user_is_on_budget_explorer_home_page() {
    OnWebUI.On_HomePage();
    }

    @Given("User got to Expense page")
    public void user_got_to_expense_page() {
        OnWebUI.On_HomePage().getExpenseAttriubute();
        OnWebUI.On_HomePage().Go_to_Expense_feature();
        OnWebUI.waitFor();



    }

    @Given("User Navigate to Budget Explorers Web page Qa.Features.Expense Feature and get Title header")
    public void user_navigate_to_budget_explorers_web_page() {
        OnWebUI.On_HomePage().getTittleHeader(); }

    @When("User go to Qa.Features.Expense Page")
    public void userGetTextOfExpensePage() {
        OnWebUI.On_ExpensePage();   }
}
