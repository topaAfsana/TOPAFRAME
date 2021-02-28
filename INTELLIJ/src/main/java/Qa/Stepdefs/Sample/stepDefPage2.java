package Qa.Stepdefs.Sample;


import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class stepDefPage2 {

    @Then("User Verify the profile name")
    public void user_verify_the_profile_name() {
        System.out.println("1");
    }

    @When("User Log out")
    public void user_log_out() {
        System.out.println("2");
    }

    @Then("User verify User Logged out")
    public void user_verify_user_logged_out() {
        System.out.println("3");
    }




}
