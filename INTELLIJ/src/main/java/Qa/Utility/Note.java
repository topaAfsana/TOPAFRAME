package Qa.Utility;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Note {

////    @BeforeClass
//    public void setUp(){
//        System.out.println("run before class");
//        System.setProperty("webdriver.chrome.driver", "/Users/abraartishan/Downloads/chromedriver");
////        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/src/test/resources/Drivers/chromedriver.exe");
//
//        WebDriver driver=new ChromeDriver();
//        driver.get("https://www.facebook.com");
//        System.out.println(driver.getTitle());
//        driver.quit();
//    }

//    //************************************DRIVER INITIALIZATION BEGIN BEGIN************************************
//    public static WebDriver driver;
//    @Autowired
//    DriverFactory driverProvider;
//    @Autowired
//    public AppConstants appConstants;
//
//    //*********************************DRIVER ENVIRONMENT SETUP BEGIN**********************************
//    @BeforeClass(alwaysRun = true)
//    @Parameters({"platform","browser"})
//    public void setUp(@Optional("mac") String platform,@Optional("chrome") String browser) throws MalformedURLException {
//        System.out.println("**********Run before class***************");
//        driver= driverProvider.initLocalDriver(appConstants.URL,platform,browser); }
//
//    @AfterClass(alwaysRun = true)
//    public void tearDown(){
//        System.out.println("**************Run after class**************");
//        driver.quit();
//    }

//I)MAVEN CODE
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


