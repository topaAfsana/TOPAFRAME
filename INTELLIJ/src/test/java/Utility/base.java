package Utility;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;

public class base {

    @BeforeClass
    public void setUp(){
        System.out.println("run before class");
        System.setProperty("webdriver.chrome.driver", "/Users/abraartishan/Downloads/chromedriver");
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.facebook.com");
        System.out.println(driver.getTitle());
        driver.quit();
    }




    //// mvn test -Dtestng.dtd.http=true
//<systemPropertyVariables>-->
//<!--                    <url>https://www.firefox.com</url>-->
//<!--                </systemPropertyVariables>



//mvn test -Dtestng.dtd.http=true -Dtest.url=https://www.facebook.com
//<parameter name = "url" value="${test.url}"/>
}