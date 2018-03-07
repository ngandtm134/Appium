package testApp.modules;

import java.io.IOException;
import java.util.Set;

/**
 * Created by dongan on 13/8/17.
 */
public class HybridAppTest {
    public static void main(String[] args) throws IOException{
        Mobile.launchApp();
        Set<String> contexts = Mobile.getDriver().getContextHandles();
        for (String context : contexts) {
            System.out.println(context);
            //it will print NATIVE_APP \n WEBVIEW_com.example.hybridtestapp
        }
//        driver.context((String) contexts.toArray()[1]);
        Mobile.getDriver().context("WEBVIEW_R");
    }
}
