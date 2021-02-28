package Qa.Pages;

import Qa.Utility.DriverUtil;

public class OnWebUI extends DriverUtil {

    public static void waitFor(){
        try{ Thread.sleep(5000); } catch (Exception e){ e.getMessage(); } }

//FOCUSED DRIVER COMING FROM RUNNER
    //****************************REGISTER PAGES********************************************
    public  static HomePageObj On_HomePage(){ return  new HomePageObj(driver); }
    public  static ExpensePageObj On_ExpensePage(){ return  new ExpensePageObj(driver); }

}
