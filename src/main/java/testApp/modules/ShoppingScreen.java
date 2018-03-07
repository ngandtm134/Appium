package testApp.modules;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import testApp.configuration.ScreenBase;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class ShoppingScreen extends ScreenBase {
    AndroidDriver driver;
    @BeforeTest
    public void Setup() throws IOException
    {
        String apkpath ="/Users/dongan/Downloads/vn.tiki.app.tikiandroid.apk";
        File app = new File(apkpath);
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName","Android");
        caps.setCapability("platformVersion","6.0");
        caps.setCapability("deviceName","Nexus 5");
        caps.setCapability("app", app.getAbsolutePath());
        driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"),caps);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }
    @AndroidFindBy(id="block")
    MobileElement btnToiDaHieu;
    @AndroidFindBy(id="vSearch")
    MobileElement txtSearch;
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ViewFlipper/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.view.ViewGroup/android.view.ViewGroup/android.support.v7.widget.RecyclerView/android.widget.FrameLayout[1]/android.widget.RelativeLayout")
    MobileElement lblSanPham1;
    @AndroidFindBy(id="btAddToCart")
    MobileElement btnAddToCart;
    @AndroidFindBy(id="icon")
    MobileElement btnCart;
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.view.ViewGroup/android.support.v7.widget.RecyclerView/android.widget.RelativeLayout[1]")
    MobileElement lblProductInCart;
    public void verifyTextChange(String expectedText) {
        Assert.assertEquals(expectedText, lblProductInCart.getText());
    }

    @AfterClass
    public void teaDown(){
        driver.close();
    }
}
