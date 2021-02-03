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
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.net.URL;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/java/Features"},glue= {"Stepdefs"},tags = "@SmokeTest",publish = true,
//        plugin = { "pretty", "html:target/cucumber-reports" },
        plugin = { "pretty", "json:target/cucumber-report.json" },
        monochrome = true
)



public class RunCukesTest extends AbstractTestNGCucumberTests {

    public static final String SAUCELAB_USERNAME = "ATSaucelab1";
    public static final String SAUCELAB_ACCESS_KEY = "f043bd3fbdb94a5695942079c8ea1617";
    public static final String SAUCELAB_URL = "https://"+SAUCELAB_USERNAME+":"+SAUCELAB_ACCESS_KEY+"@ondemand.saucelabs.com:443/wd/hub";





    @BeforeClass
    @Parameters({"url","platform"})
    public void setUp1(@Optional("https://www.yahoo.com") String url,@Optional("linux") String platform) throws MalformedURLException {
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
            driver.get(url);
            System.out.println(driver.getTitle());
            driver.quit();
        }
        else if (platform.equalsIgnoreCase("linux")){
            //        System.setProperty("webdriver.chrome.driver", "/Users/abraartishan/Downloads/chromedriver");
            //        System.setProperty("webdriver.chrome.driver",path+"/src/test/resource/Drivers/chromedriver");

            String path = System.getProperty("user.dir");
            System.out.println("MY PATH NOT NEEDED FOR LINUX-test "+path);

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
        else if (platform.equalsIgnoreCase("saucelab")){
//            DesiredCapabilities caps=DesiredCapabilities.chrome();
            DesiredCapabilities caps=DesiredCapabilities.internetExplorer();

            caps.setCapability("platform","Windows 10");
//            caps.setCapability("platform","Linux");

            caps.setCapability("version","latest");
            WebDriver driver=new RemoteWebDriver(new URL(SAUCELAB_URL),caps);
            driver.get(url);
            System.out.println(driver.getTitle());
            driver.quit();
        }


        else if (platform.equalsIgnoreCase("mac")){
            //        System.setProperty("webdriver.chrome.driver", "/Users/abraartishan/Downloads/chromedriver");
            String path = System.getProperty("user.dir");
            System.out.println("MY PATH NOT NEEDED FOR MAC-test "+path);
            System.setProperty("webdriver.chrome.driver",path+"/src/test/resource/Drivers/chromedriver");
            WebDriver driver = new ChromeDriver();
            driver.get(url);
            System.out.println(driver.getTitle());
            driver.quit();
        }


    }

}
