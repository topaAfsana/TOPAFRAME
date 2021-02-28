package Qa.Stepdefs;

import Qa.Utility.AppConstants;
import Qa.Utility.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
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

    @After
    public void tearDown() throws InterruptedException {
        System.out.println("**************Run after hook**************");
        driver.quit();
    }

}
