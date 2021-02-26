package Qa.Pages;

import Qa.CucumberRunner.RunCukesTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


public class HomePageObj {
WebDriver driver;
    public HomePageObj(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        }


//    public  WebElement locateElement(WebDriver driver,String locator){
//        WebElement element=driver.findElement(By.id(""+locator+""));
//        return element;
//    }


//    public WebElement titleheader=locateElement(driver,"tittleheader");
//    public WebElement attriubute=locateElement("expense");






    @FindBy(how=How.ID,using="expense']")
    public static WebElement expenseAttribute;

    @FindBy(id="tittleheader")
    public static WebElement tittleHeader;

    @FindBy(how=How.XPATH,using=".//*[@id='u_0_n']")
    WebElement LogInButton;





    public void getExpenseAttriubute(){
        System.out.println(driver.getPageSource());
        String attribute=expenseAttribute.getAttribute("id");
        System.out.println(attribute);
    }


    public void getTittleHeader(){
//       WebElement titleheader= driver.findElement(By.id("tittleheader"));

System.out.println(tittleHeader.getText());    }
}
