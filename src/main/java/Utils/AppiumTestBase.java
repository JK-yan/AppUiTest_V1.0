package Utils;

import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * Created by jackiezero on 2017/1/3.
 */
public class AppiumTestBase {
    AppiumElement el = new AppiumElement();
    public static void initialization(String platform){
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        switch (platform){
            case "AndroidDriver":
                desiredCapabilities.setCapability("deviceName","Android Emulator");
                desiredCapabilities.setCapability("platformVersion", "4.4");
                desiredCapabilities.setCapability("app", "");
                desiredCapabilities.setCapability("appPackage", "io.appium.android.apis");
                desiredCapabilities.setCapability("appActivity", ".ApiDemos");
                break;
            case "IOSDriver":
                desiredCapabilities.setCapability("deviceName","Android Emulator");
                desiredCapabilities.setCapability("platformVersion", "4.4");
                desiredCapabilities.setCapability("app", "");
                desiredCapabilities.setCapability("appPackage", "io.appium.android.apis");
                desiredCapabilities.setCapability("appActivity", ".ApiDemos");
                break;
            case "WebDriver":
                break;
            default:
                break;
        }
    }
}
