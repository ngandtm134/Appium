package testApp.modules;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidKeyCode;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import testApp.configuration.Config;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

/**
 *
 */
public class Mobile {
    public static AndroidDriver driver;
    public static TouchAction touchAction;
    public static int height;
    public static int width;

    public static AndroidDriver getDriver() {
	   return driver;
    }

    public static void launchApp() throws IOException {
	   Config config = new Config();
	   DesiredCapabilities capsi = new DesiredCapabilities();
	   capsi.setCapability("platformName", "Android");
	   capsi.setCapability("platformVersion", "6.0");
	   capsi.setCapability("deviceName", "192.168.56.101:5555");
	   capsi.setCapability("appPackage", "com.example.hybridtestapp");
	   capsi.setCapability("appActivity","com.example.hybridtestapp.MainActivity");
	   try {
		  driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),capsi);
	   } catch (MalformedURLException e) {
		  System.err.println(e);
	   }
	   driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
//	   touchAction = new TouchAction(driver);
//	   height = driver.manage().window().getSize().height;
//	   width = driver.manage().window().getSize().width;
    }

    public static void longPress(AndroidElement el) {
	   touchAction.longPress(el).perform();
    }

    public static AndroidElement scrollToText(String text) {
	   return (AndroidElement) driver.findElementsByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView("
			 + "new UiSelector().text(\"ngan\"));");
    }

    public static void swipe(double startX, double startY, double endX, double endY, int waitAction) {
	   touchAction.press((int) startX * width, (int) startY * height).moveTo((int) endX * width, (int) endY * height).release().perform();
    }

    public static void swipeVertical(double startPercentage, double finalPercentage, double anchorPercentage, int duration) throws Exception {

	   Dimension size = driver.manage().window().getSize();
	   int anchor = (int) (size.width * anchorPercentage);
	   int startPoint = (int) (size.height * startPercentage);
	   int endPoint = (int) (size.height * finalPercentage);
	   new TouchAction(driver).press(anchor, startPoint).waitAction(Duration.ofSeconds(duration)).moveTo(anchor, endPoint).release().perform();
    }
    public static void swipeHorizontal(double startPercentage, double finalPercentage, double anchorPercentage, int duration) throws Exception {
	   Dimension size = driver.manage().window().getSize();
	   int anchor = (int) (size.height * anchorPercentage);
	   int startPoint = (int) (size.width * startPercentage);
	   int endPoint = (int) (size.width * finalPercentage);
	   new TouchAction(driver).press(startPoint, anchor).waitAction(duration).moveTo(endPoint, anchor).release().perform();

	   //In documentation they mention moveTo coordinates are relative to initial ones, but thats not happening. When it does we need to use the function below
	   //new TouchAction(driver).press(startPoint, anchor).waitAction(duration).moveTo(endPoint-startPoint,0).release().perform();
    }

	public AndroidDriver getElement(String how, String locator){

		if(how.equalsIgnoreCase("id")) {
			driver.findElement(By.id(locator));
		}
		else if(how.equalsIgnoreCase("xpath")){

			driver.findElement(By.xpath(locator));
		}
		else if(how.equalsIgnoreCase("className")){
			driver.findElement(By.className(locator));
		}
		else{
			driver.findElementByAccessibilityId(locator);
		}
		return null;
	}
	public static void runAppBackgruond(){
		driver.pressKeyCode(AndroidKeyCode.HOME);
	}
	//open app sau ? mins
	public static void runAppBackGruond(AndroidDriver driver,int second) throws InterruptedException {
		driver.pressKeyCode(AndroidKeyCode.HOME);
		Thread.sleep(second*1000);
		driver.launchApp();
	}
	//switch via another app
	public static void switchApp(String packageName, String activityName){
		driver.startActivity(new Activity(packageName,activityName));
	}
	//screenshot when test failed
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

}
