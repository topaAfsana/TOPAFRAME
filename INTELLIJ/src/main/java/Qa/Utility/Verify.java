package Qa.Utility;

import org.testng.Assert;

public class Verify {
    public static void It_matches(String assertMessage,String expected,String actual){
        System.out.println(assertMessage);
        Assert.assertEquals(expected,actual);
    }
}
