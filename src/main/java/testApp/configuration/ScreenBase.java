package testApp.configuration;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import testApp.supports.CommonFunctions;

/**
 * Created by dongan on 10/9/17.
 */
public class ScreenBase {

    public ScreenBase() {
        PageFactory.initElements(new AppiumFieldDecorator(CommonFunctions.getDriver()),this);
    }
}
