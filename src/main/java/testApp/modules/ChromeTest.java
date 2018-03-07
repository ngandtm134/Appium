package testApp.modules;

import org.openqa.selenium.WebDriver;
import testApp.supports.CommonFunctions;

import java.net.MalformedURLException;

/**
 * Created by dongan on 13/8/17.
 */
public class ChromeTest {
    public static void main(String[] args) throws MalformedURLException {
        WebDriver driver = CommonFunctions.openBrowse("android","6.0","Android");

    }
}
