package Qa.Utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

@Component
public class DriverFactory {
     private WebDriver driver;
     @Autowired
     AppConstants appConstants;

    private static final String SAUCELAB_USERNAME = "ATSaucelab1";
    private static final String SAUCELAB_ACCESS_KEY = "f043bd3fbdb94a5695942079c8ea1617";
    private static final String SAUCELAB_URL = "https://"+SAUCELAB_USERNAME+":"+SAUCELAB_ACCESS_KEY+"@ondemand.saucelabs.com:443/wd/hub";

    public  WebDriver initLocalDriver(String url,String platform,String browser) throws MalformedURLException{
        if(platform.equalsIgnoreCase("windows")){
            if(browser.equalsIgnoreCase("chrome")){
                String path = System.getProperty("user.dir");
                System.out.println("MY PATH IS metoo"+path);
//            System.setProperty("webdriver.chrome.driver",path+"/src/test/resource/Drivers/chromedriver.exe");
//            System.setProperty("webdriver.chrome.driver","C:\\chromedriver.exe");
                System.setProperty("webdriver.chrome.driver","C:\\WebDriver\\chromedriver.exe");
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--headless");
                options.addArguments("window-size=1400,1500");
                options.addArguments("--disable-gpu");
                options.addArguments("--no-sandbox");
                options.addArguments("start-maximized");
                options.addArguments("enable-automation");
                options.addArguments("--disable-infobars");
                options.addArguments("--disable-dev-shm-usage");
                driver = new ChromeDriver(options);
                driver.get(url);
                System.out.println(driver.getTitle());
            }
            if(browser.equalsIgnoreCase("firefox")){

            }
            if(browser.equalsIgnoreCase("ie")){

            }
            if(browser.equalsIgnoreCase("safari")){

            }
        }
        else if (platform.equalsIgnoreCase("linux")){


            if(browser.equalsIgnoreCase("chrome")){
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
                driver = new ChromeDriver(options);


                driver.get(url);
                System.out.println(driver.getTitle());
            }
            if(browser.equalsIgnoreCase("firefox")){

            }
            if(browser.equalsIgnoreCase("ie")){

            }
            if(browser.equalsIgnoreCase("safari")){

            }
        }
        else if (platform.equalsIgnoreCase("saucelab")){
//            DesiredCapabilities caps=DesiredCapabilities.chrome();
            DesiredCapabilities caps=DesiredCapabilities.internetExplorer();

            caps.setCapability("platform","Windows 10");
//            caps.setCapability("platform","Linux");

            caps.setCapability("version","latest");
            driver=new RemoteWebDriver(new URL(SAUCELAB_URL),caps);
            driver.get(url);
            System.out.println(driver.getTitle());
        }


        else if (platform.equalsIgnoreCase("mac")){


            if(browser.equalsIgnoreCase("chrome")){
                String path = System.getProperty("user.dir");
                System.setProperty("webdriver.chrome.driver",path+"/src/main/resources/Drivers/chromedriver");
                driver = new ChromeDriver();
                driver.get(url);
            }
            if(browser.equalsIgnoreCase("firefox")){

            }
            if(browser.equalsIgnoreCase("ie")){

            }
            if(browser.equalsIgnoreCase("safari")){

            }

        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        return driver;

    }
}
