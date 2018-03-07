package testApp.supports;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import testApp.configuration.Config;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * Created by dongan on 20/8/17.
 */
public class CommonFunctions {
    public static AndroidDriver driver;
    public static WebDriver openBrowse(String platformName, String platformVersion,String deviceName) throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName","Android");
        caps.setCapability("platformVersion","4.3");
        caps.setCapability("deviceName","Android");
        if (platformName.equalsIgnoreCase("ios"))
            caps.setCapability("browserName","safari");
        else caps.setCapability("browserName","chrome");
        try {
            RemoteWebDriver driver = new RemoteWebDriver(new URL("http://0.0.0.0:4723/wd/hub"), caps);
        } catch (MalformedURLException e){
            e.printStackTrace();
            System.err.println("Could not start Appium sever");
        }
        return driver;

    }
//    public static AndroidDriver launchApp(String platformVersion,String deviceName,String appPath){
//        DesiredCapabilities caps = new DesiredCapabilities();
//        caps.setCapability("deviceName", deviceName);
//        caps.setCapability("platformVersion",platformVersion);
//        caps.setCapability("deviceName","Android");
//        caps.setCapability("app",new File(appPath));
//        AndroidDriver driver = null;
//        try {
//            driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), caps);
//        } catch (MalformedURLException e){
//            e.printStackTrace();
//            System.err.println("Could not start Appium sever");
//        }
//        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
//        return driver;
//    }

    public static AndroidDriver getDriver() {
        return driver;
    }

    public static void launchApp() throws IOException {
        Config config = new Config();
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", config.getParam("deviceName"));
        caps.setCapability("platformVersion", config.getParam("platformVersion"));
        caps.setCapability("appActivity", config.getParam("appActivity"));
        caps.setCapability("appPackage", config.getParam("appPackage"));
        try {
            driver = new AndroidDriver<AndroidElement>(new URL(config.getParam("appiumHost")), caps);
        } catch (MalformedURLException e) {
            e.printStackTrace();
            System.err.println("Could not start Appium sever");
        }
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

}
