package Qa.Pages;

import Qa.CucumberRunner.RunCukesTest;
import Qa.Utility.driverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


public class HomePageObj{
    //*********PAGE CONFIG**************
    private WebDriver driver;
    public HomePageObj(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);}

    //*********PAGE ELEMENTS**************
    @FindBy(id="tittleheader") WebElement tittleHeader;
    @FindBy(id="expense") WebElement expense_button;
    @FindBy(how=How.XPATH,using=".//*[@id='u_0_n']") WebElement LogInButton;



    //*********PAGE METHODS**************


    public void Go_to_Expense_feature(){
    driverUtil.click(expense_button);
    }
    public void getExpenseAttriubute(){
        String attribute=expense_button.getAttribute("id");
        System.out.println(attribute); }



    public void getTittleHeader(){
    driverUtil.getText(tittleHeader);}
}
