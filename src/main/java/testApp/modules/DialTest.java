package testApp.modules;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by DinhNguyen on 9/17/17.
 */
public class DialTest {
    AndroidDriver driver;
    @BeforeMethod

    public void Setup() throws MalformedURLException
    {
	   DesiredCapabilities caps = new DesiredCapabilities();
	   caps.setCapability("platformName","Android");
	   caps.setCapability("platformVersion","7.0");
	   caps.setCapability("deviceName","Nexus 5");

	   caps.setCapability("appPackage","com.android.dialer");
	   caps.setCapability("appActivity","com.android.dialer.DialtactsActivity");
	   // driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"),caps);
	  driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),caps);
    }
    @Test
    public void testDial()
    {
        driver.findElementByAccessibilityId("floating_action_button").click();
    }


}


