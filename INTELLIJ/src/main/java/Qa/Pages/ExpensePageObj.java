package Qa.Pages;

import Qa.Utility.DriverUtil;
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
        DriverUtil.enterIn(userField, user);
        DriverUtil.enterIn(passField, password);
        DriverUtil.click(logInBtn);
    }
    public void  Open_Lists_Table(){
        DriverUtil.click(listsTableBtn);
    }
    public String  Get_Lists_Table_Header(){
       return  DriverUtil.getText(listsTableHeader);
    }



}
