package Qa.Stepdefs;
import Qa.CucumberRunner.RunCukesTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;



public class HomePageStep extends RunCukesTest{


    @Given("User Navigate to Budget Explorers Web page Expense Feature")
    public void user_navigate_to_budget_explorers_web_page() {
        System.out.println("TEST STARTED");
        System.out.println("MY STEP "+driver.getTitle());
        homePageObj.getTittleHeader();
//        Log.info("LOG FOR REPORTING");
    }

    @When("User Get Text of Expense Page")
    public void userGetTextOfExpensePage() {
        driver.findElement(By.id("expense")).click();
    }
}
