package CucumberRunner;
//old version cucumber
// import cucumber.api.CucumberOptions;
//import cucumber.api.junit.Cucumber;
import io.cucumber.junit.Cucumber;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;



@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/java/Features"},glue= {"Stepdefs"},tags = "@SmokeTest",publish = true,
//        plugin = { "pretty", "html:target/cucumber-reports" },
        plugin = { "pretty", "json:cucumber-report.json" },
        monochrome = true
)



public class RunCukesTest extends AbstractTestNGCucumberTests {

    @BeforeClass
    @Parameters("url")
    public void setUp1(@Optional("https://www.yahoo.com") String url){
        System.out.println("run before class");
        System.out.println(url);

//        System.setProperty("webdriver.chrome.driver", "/Users/abraartishan/Downloads/chromedriver");
        String path = System.getProperty("user.dir");
        System.out.println("MY PATH IS "+path);
        System.setProperty("webdriver.chrome.driver",path+"/src/test/resource/Drivers/chromedriver");
        WebDriver driver=new ChromeDriver();
        driver.get(url);
        System.out.println(driver.getTitle());
        driver.quit();
    }

//    @BeforeMethod(alwaysRun = true)
//    public void setUp(){
//        System.out.println("BEFORE METHOD");
//    }

//    @Test
//    public void testtt(){
//        System.out.println("test");
//
////        System.setProperty("webdriver.chrome.driver", "/Users/abraartishan/Downloads/chromedriver");
////        WebDriver driver=new ChromeDriver();
////        driver.get("https://www.facebook.com");
////        System.out.println(driver.getTitle());
////        driver.quit();
//    }
}
