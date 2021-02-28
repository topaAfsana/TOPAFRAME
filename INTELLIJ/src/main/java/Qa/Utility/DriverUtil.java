package Qa.Utility;

import Qa.Stepdefs.Hook;
import org.openqa.selenium.WebElement;


public class DriverUtil extends Hook {

    public static void OpenWebUI(String url){
    driver.get(url);
}
    public static String getText(WebElement element){
        return element.getText();
    }
    public static void click(WebElement element){element.click(); }
    public static void enterIn(WebElement element,String input){
        element.sendKeys(input);
    }


    public  static String getPageTitle(){
        String page_title=driver.getTitle();
        System.out.println(page_title);
       return page_title;
    }

}
