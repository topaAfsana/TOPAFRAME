package Qa.CucumberRunner;
//old version cucumber
// import cucumber.api.CucumberOptions;
//import cucumber.api.junit.Cucumber;
//@RunWith(Cucumber.class)
//works without AbstractTestngcucumber
import Qa.Utility.AppConstants;
import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;
//***************************
import Qa.Pages.HomePageObj;
import Qa.Utility.DriverFactory;
import io.cucumber.testng.*;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.*;
import java.net.MalformedURLException;




@CucumberOptions(
//        features = {"src/test/java/Qa/Features"},glue= {"Qa/Stepdefs"},tags = "@SmokeTest",publish = true,
        features = {"src/test/java/Qa/Features"},glue= {"Qa/Stepdefs"},tags = "@WIP",publish = true,
//        plugin = { "pretty", "html:target/cucumber-reports" },
        plugin = { "pretty", "json:target/cucumber-report.json" },
        monochrome = true
)


@ContextConfiguration(locations = {"classpath:test-bean.xml"})
public class RunCukesTest extends AbstractTestNGSpringContextTests{

    //************************************INITIALIZE TESTNG CUCUMBER RUNNER-AbstractTestNGCucumberTests************************************
    private TestNGCucumberRunner testNGCucumberRunner;
    @BeforeClass(alwaysRun = true)
    public void setUpClass() {
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
    }
    @Test(groups = "cucumber", description = "Runs Cucumber Scenarios", dataProvider = "scenarios")
    public void runScenario(PickleWrapper pickleWrapper, FeatureWrapper featureWrapper) { testNGCucumberRunner.runScenario(pickleWrapper.getPickle()); }
    @DataProvider
    public Object[][] scenarios() { if (testNGCucumberRunner == null) { return new Object[0][0]; }return testNGCucumberRunner.provideScenarios(); }
    @AfterClass(alwaysRun = true)
    public void tearDownClass() { if (testNGCucumberRunner == null) {return; }testNGCucumberRunner.finish();}


    //************************************DRIVER INITIALIZATION BEGIN BEGIN************************************
     public static WebDriver driver;
     @Autowired
     DriverFactory driverProvider;
     @Autowired
     public AppConstants appConstants;

     //*********************************DRIVER ENVIRONMENT SETUP BEGIN**********************************
    @BeforeClass(alwaysRun = true)
    @Parameters({"platform","browser"})
    public void setUp(@Optional("mac") String platform,@Optional("chrome") String browser) throws MalformedURLException {
        System.out.println("Run before class");
        appConstants.getURL();
        driver= driverProvider.initLocalDriver(appConstants.URL,platform,browser); }

    @AfterClass(alwaysRun = true)
    public void tearDown(){
        System.out.println("Run after class");
        driver.quit();
    }










}
