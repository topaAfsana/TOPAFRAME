package Qa.CucumberRunner;
//old version cucumber
// import cucumber.api.CucumberOptions;
//import cucumber.api.junit.Cucumber;
//works without AbstractTestngcucumber
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



//@RunWith(Cucumber.class)
@CucumberOptions(
//        features = {"src/test/java/Qa/Features"},glue= {"Qa/Stepdefs"},tags = "@SmokeTest",publish = true,
        features = {"src/test/java/Qa/Features"},glue= {"Qa/Stepdefs"},tags = "@webtest",publish = true,
//        plugin = { "pretty", "html:target/cucumber-reports" },
        plugin = { "pretty", "json:target/cucumber-report.json" },
        monochrome = true
)


@ContextConfiguration(locations = {"classpath:test-bean.xml"})
public class RunCukesTest extends AbstractTestNGSpringContextTests{

    //************************************AbstractTestNGCucumberTests************************************
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


    //************************************SET UP BEGIN************************************
     public static WebDriver driver;
     @Autowired
     DriverFactory driverProvider;

    @BeforeClass(alwaysRun = true)
    @Parameters({"url","platform","browser"})
    public void setUp(@Optional("https://www.yahoo.com") String url, @Optional("mac") String platform,String browser) throws MalformedURLException {
        System.out.println("Run before class");
        driver= driverProvider.initLocalDriver(url,platform,browser); }

    @AfterClass(alwaysRun = true)
    public void tearDown(){
        System.out.println("Run after class");
        driver.quit();
    }


    //************************************PAGE OBJECTS************************************


        protected HomePageObj homePageObj=new HomePageObj(driver);








}
