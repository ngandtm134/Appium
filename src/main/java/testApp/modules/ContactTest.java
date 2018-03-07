package testApp.modules;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class ContactTest {
    AndroidDriver driver;
    Dimension size;
    @BeforeTest
    public void setUp() throws IOException {
       DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "6.0");
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Simulator");
        caps.setCapability("appPackage", "com.android.contacts");
        caps.setCapability("appActivity", ".activities.PeopleActivity");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),caps);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }
    @Test
    public void scrollTest()
    {
       // scroll untill find text:ngan
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView("
                + "new UiSelector().text(\"ngan\"));");

    }
    @Test
    public void runAppBackGruond() throws InterruptedException {
        Mobile.runAppBackGruond(driver,5);
    }
    @Test
    public void switchCalculator(){
        Mobile.switchApp("com.android.calculator2",".Calculator");
    }
    @Test
    public void captureScreenShotTest() throws IOException, InterruptedException {
        Thread.sleep(3000);
        Mobile.captureScreenShot(driver);
    }
    public static void captureScreenShot(AndroidDriver driver) throws IOException {
        File screenShot= driver.getScreenshotAs(OutputType.FILE);
        File location=new File("screenshots");
        String screenShotName=location.getAbsolutePath()+File.separator+"testCalculator.png";
        FileUtils.copyFile(screenShot,new File(screenShotName));
    }
    @AfterMethod
    public void captureScreenShotTest(ITestResult result) throws IOException, InterruptedException {

        if (!result.isSuccess()) {
            Mobile.captureScreenShot(driver);
        }
    }
        @AfterTest
        public void tearDown(){

            driver.closeApp();
        }
}