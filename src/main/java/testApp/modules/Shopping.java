package testApp.modules;

import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.Test;

public class Shopping extends ShoppingScreen {
    AndroidDriver driver;

    @Test
    public void testOder(){
    btnToiDaHieu.click();
    txtSearch.click();
    txtSearch.sendKeys("doi gio hu");
    lblSanPham1.click();
    btnAddToCart.click();
    btnCart.click();
    verifyTextChange("Đồi Gió Hú");

    }
}
