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
    @FindBy(how=How.ID,using="expense']") WebElement expenseAttribute;
    @FindBy(id="tittleheader") WebElement tittleHeader;
    @FindBy(how=How.XPATH,using=".//*[@id='u_0_n']") WebElement LogInButton;



    //*********PAGE METHODS**************
    public void getExpenseAttriubute(){
        System.out.println(driver.getPageSource());
        String attribute=expenseAttribute.getAttribute("id");
        System.out.println(attribute); }

    public void getTittleHeader(){
    driverUtil.getText(tittleHeader);}
}
