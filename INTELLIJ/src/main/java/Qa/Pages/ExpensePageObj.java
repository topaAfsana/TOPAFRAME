package Qa.Pages;

import Qa.Utility.driverUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ExpensePageObj {
    private WebDriver driver;

    public ExpensePageObj(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //*********PAGE ELEMENTS**************

    @FindBy(id = "headerTextId") WebElement expensePageTitle;
    @FindBy(id = "myProfileId") WebElement userField;
    @FindBy(id = "myPassId") WebElement passField;
    @FindBy(id = "logInBtn") WebElement logInBtn;
    @FindBy(id = "showprofTableId") WebElement listsTableBtn;
    @FindBy(xpath = "//th[@id=\"profBasedTh\"]") WebElement listsTableHeader;





    //*********PAGE METHODS**************
    public void Log_In_With(String user, String password) {
        driverUtil.enterIn(userField, user);
        driverUtil.enterIn(passField, password);
        driverUtil.click(logInBtn);
    }
    public void  Open_Lists_Table(){
        driverUtil.click(listsTableBtn);
    }
    public String  Get_Lists_Table_Header(){
       return  driverUtil.getText(listsTableHeader);
    }



}
