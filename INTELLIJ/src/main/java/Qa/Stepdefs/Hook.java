package Qa.Stepdefs;

import Qa.Utility.AppConstants;
import Qa.Utility.DriverFactory;
import Qa.Utility.ScreenshotFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

import java.net.MalformedURLException;

public class Hook{
    public static WebDriver driver;

    DriverFactory driverProvider=new DriverFactory();

    public AppConstants appConstants=new AppConstants();

    @Before
    public void setUp() throws MalformedURLException, InterruptedException {
        System.out.println("**********Run before hook***************");
        String platform=Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("platform") ;
        String browser=Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("browser") ;
        driver= driverProvider.initLocalDriver(appConstants.getURL(),platform,browser);
    }

//    @After
//    public void tearDown(Scenario scenario) throws InterruptedException {
//        if(scenario.isFailed()){
//            System.out.println("**************Screenshot method**************");
//            ScreenshotFactory.captureScreenShot(driver,scenario.getName());
//        }
//        System.out.println("**************Run after hook**************");
//        driver.quit();
//    }


    @After
    public void tearDown(Scenario scenario) throws InterruptedException {
        if(scenario.isFailed()){
            System.out.println("**************Screenshot method**************");
          ScreenshotFactory.CaptureAndEmbedScreenshot(driver,scenario);
        }
        System.out.println("**************Run after hook**************");
        driver.quit();
    }


}
