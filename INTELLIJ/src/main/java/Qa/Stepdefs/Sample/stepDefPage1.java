package Qa.Stepdefs.Sample;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class stepDefPage1 {

    @Given("User Navigate to Facebook")
    public void user_navigate_to_facebook() {
        System.out.println("4");
    }

    @When("User Log In")
    public void user_log_in() {
        System.out.println("5");
    }

    @Then("User logged in Home page")
    public void user_logged_in_home_page() {
        System.out.println("6");
    }

}
