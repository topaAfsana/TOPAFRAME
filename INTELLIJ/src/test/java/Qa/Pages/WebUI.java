package Qa.Pages;

import Qa.CucumberRunner.RunCukesTest;
import Qa.Pages.ExpensePageObj;
import Qa.Pages.HomePageObj;

public class WebUI extends RunCukesTest {
//FOCUSED DRIVER COMING FROM RUNNER
    //****************************REGISTER PAGES********************************************
    public static HomePageObj HomePage(){ return  new HomePageObj(driver); }
    public static ExpensePageObj ExpensePage(){ return  new ExpensePageObj(driver); }

}
