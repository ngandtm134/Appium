package testApp.modules;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * Created by dongan on 13/8/17.
 */
public class iOSNativeAppTest {
    public static final String USERNAME = "ngando";
    public static final String ACCESS_KEY = "1f95a6e6-c62c-4d84-9888-5828f732e6e4";
    public static final String URL = "https://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:443/ wd/hub";
    public static void main(String[] args) throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("platformVersion", "10.3");
        caps.setCapability("deviceName", "iPhone 5s");
        caps.setCapability("app", "settings");
        caps.setCapability("appActivity", ".activity.LoginActivity");
        AndroidDriver driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), caps);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
}

