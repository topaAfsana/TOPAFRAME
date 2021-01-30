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
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;



@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/java/Features"},glue= {"Stepdefs"},tags = "@SmokeTest",publish = true,
//        plugin = { "pretty", "html:target/cucumber-reports" },
        plugin = { "pretty", "json:target/cucumber-report.json" },
        monochrome = true
)



public class RunCukesTest extends AbstractTestNGCucumberTests {

    @BeforeClass
    @Parameters({"url","platform"})
    public void setUp1(@Optional("https://www.yahoo.com") String url,@Optional("linux") String platform){
        System.out.println("run before class");
        System.out.println(url);


        if(platform.equalsIgnoreCase("windows")){
            String path = System.getProperty("user.dir");
            System.out.println("MY PATH IS metoo"+path);
//            System.setProperty("webdriver.chrome.driver",path+"/src/test/resource/Drivers/chromedriver.exe");
            System.setProperty("webdriver.chrome.driver","C:\\chromedriver.exe");

            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless");
            options.addArguments("window-size=1400,1500");
            options.addArguments("--disable-gpu");
            options.addArguments("--no-sandbox");
            options.addArguments("start-maximized");
            options.addArguments("enable-automation");
            options.addArguments("--disable-infobars");
            options.addArguments("--disable-dev-shm-usage");
            WebDriver driver = new ChromeDriver(options);
//            WebDriver driver=new ChromeDriver();
            driver.get(url);
            System.out.println(driver.getTitle());
            driver.quit();
        }
        else if (platform.equalsIgnoreCase("linux")){
            //        System.setProperty("webdriver.chrome.driver", "/Users/abraartishan/Downloads/chromedriver");
            String path = System.getProperty("user.dir");
            System.out.println("MY PATH NOT NEEDED FOR LINUX-Ammu "+path);
//            System.setProperty("webdriver.chrome.driver",path+"/src/test/resource/Drivers/chromedriver");

            System.setProperty("webdriver.chrome.driver","/usr/bin/chromedriver");
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless");
            options.addArguments("window-size=1400,1500");
            options.addArguments("--disable-gpu");
            options.addArguments("--no-sandbox");
            options.addArguments("start-maximized");
            options.addArguments("enable-automation");
            options.addArguments("--disable-infobars");
            options.addArguments("--disable-dev-shm-usage");
            WebDriver driver = new ChromeDriver(options);



            driver.get(url);
            System.out.println(driver.getTitle());
            driver.quit();
        }




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
