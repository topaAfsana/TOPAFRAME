package Utility;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;

public class base {

    @BeforeClass
    public void setUp(){
        System.out.println("run before class");
        System.setProperty("webdriver.chrome.driver", "/Users/abraartishan/Downloads/chromedriver");
//        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/src/test/resources/Drivers/chromedriver.exe");

        WebDriver driver=new ChromeDriver();
        driver.get("https://www.facebook.com");
        System.out.println(driver.getTitle());
        driver.quit();
    }



//I)
//     mvn test -Dtestng.dtd.http=true
//<systemPropertyVariables>-->
//<!--                    <url>https://www.firefox.com</url>-->
//<!--                </systemPropertyVariables>
//
//
//II)
//mvn test -Dtestng.dtd.http=true -Dtest.url=https://www.facebook.com
//<parameter name = "url" value="${test.url}"/>
//
//III)
//    mvn clean test -Dtestng.dtd.http=true -Dtest.url=https://www.facebook.com -Dtest.platform=linux
//                    <parameter name = "platform" value="${test.platform}"/>

//    clean test -Dtestng.dtd.http=true -Dtest.url=$URL -Dtest.platform=$PLATFORM



}


