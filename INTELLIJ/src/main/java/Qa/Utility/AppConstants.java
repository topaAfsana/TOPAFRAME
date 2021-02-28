package Qa.Utility;


import org.springframework.beans.factory.annotation.Value;

import javax.inject.Named;



@Named
public class AppConstants {

    @Value("${APP.LOCAL_RUN}")
    public String LOCAL_RUN;

    @Value("${APP.DEFAULT_BROWSER}")
    public String DEFAULT_BROWSER;

    @Value("${APP.URL}")
    public String URL;

    @Value("${APP.DEFAULT_USER}")
    public String DEFAULT_USER;

    @Value("${APP.DEFAULT_PASSWORD}")
    public String DEFAULT_PASSWORD;

    @Value("${APP.GRIDHUB_URL}")
    public String GRIDHUB_URL;

    @Value("${APP.GRIDHUB_PORT}")
    public String GRIDHUB_PORT;

    @Value("${APP.DEFAULT_WAIT_IN_SEC}")
    public String DEFAULT_WAIT;

    @Value("${APP.PROP}")
    public String PROP;



    public String myURL="https://topabudgetexplorers.com";

    public String getURL() {
        System.out.println(myURL);
        return myURL;
    }
}
