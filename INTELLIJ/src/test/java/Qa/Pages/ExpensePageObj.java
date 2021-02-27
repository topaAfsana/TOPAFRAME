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
    @FindBy(id = "expense") WebElement expense_button;
    @FindBy(id = "expense") WebElement expense_title;


    //*********PAGE METHODS**************
    public void gotToExpense() {
        driverUtil.clickElement(expense_button);
    }
}
