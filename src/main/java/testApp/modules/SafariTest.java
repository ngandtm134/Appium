package testApp.modules;

import org.openqa.selenium.WebDriver;
import testApp.supports.CommonFunctions;

import java.net.MalformedURLException;

/**
 * Created by dongan on 13/8/17.
 */
public class SafariTest {
    public static void main(String[] args) throws MalformedURLException {
        WebDriver driver= CommonFunctions.openBrowse("ios","10.3.2","iphone");
        driver.get("");
    }
}
