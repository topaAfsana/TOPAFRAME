package Qa.Utility;


import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ScreenshotFactory {

        public static String currentDateTime() {
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");

            //SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy:hh_mm");
            Calendar cal = Calendar.getInstance();

            String dateTime = dateFormat.format(cal.getTime());
            //String cal1 = formater.format(cal.getTime());
            return dateTime;
        }

        public  static void captureScreenShot(WebDriver driver, String testcaseName){

            File screenshotFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            String datetime = currentDateTime();
            try {
//                String path = System.getProperty("user.dir");

                String destFile=new File("Screenshots_failed").getAbsolutePath();
                Boolean destFileExist=new File("Screenshots_failed").exists();
                System.out.println(destFile + destFileExist);
                File dest=new File("//Users//abraartishan//Desktop//TOPA_QA//CODE BASE//CUCUMBER_FRAME//INTELLIJ//Screenshots_failed//"+testcaseName+" "+datetime+System.currentTimeMillis()+".png");
                FileHandler.copy(screenshotFile,dest);
            } catch (IOException e) {
                System.out.println("ScreenShot is not captured because "+e.getMessage());
            }

        }


        public static void CaptureAndEmbedScreenshot(WebDriver driver, Scenario scenario){
            final byte[] screenshot=((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot,"image/png",scenario.getName()+"_failed");
        }


    }

