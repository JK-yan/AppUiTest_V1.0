package Utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by jackiezero on 2017/1/3.
 */
public class AppiumTestBase {
    public   static AppiumDriver driver;
//    AppiumUtils el = new AppiumUtils();
/**
 * @ initialization初始化APPIUM
 * @ 获取设备平台
 * @ app路径
 * @ appPackage
 * @ appActivity（启动）
 * */
    public static void initialization(String filepath,String filename,String platform,String appName) throws MalformedURLException {
        File classRootPath=new File(System.getProperty("user.dir"));
        File appDir=new File(classRootPath,"Driver");
        File app =new File(appDir,appName);
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        switch (platform){
            case "AndroidDriver":
                desiredCapabilities.setCapability("deviceName",YamlUtils.LoadgetValue(filepath,filename,"androidCapability","deviceName"));
                desiredCapabilities.setCapability("platformVersion", YamlUtils.LoadgetValue(filepath,filename,"androidCapability","platformVersion"));
//                desiredCapabilities.setCapability("app", app.getAbsoluteFile());
                desiredCapabilities.setCapability("appPackage", YamlUtils.LoadgetValue(filepath,filename,"androidCapability","appPackage"));
                desiredCapabilities.setCapability("appActivity", YamlUtils.LoadgetValue(filepath,filename,"androidCapability","appActivity"));
//                desiredCapabilities.setCapability("clearSystemFiles", true);
                driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);

                break;
            case "IOSDriver":
                desiredCapabilities.setCapability("deviceName","Android Emulator");
                desiredCapabilities.setCapability("platformVersion", "4.4");
                desiredCapabilities.setCapability("app", "");
                desiredCapabilities.setCapability("appPackage", "com.fulihui.www.information");
                desiredCapabilities.setCapability("appActivity", ".SplashActivity");
                driver = new IOSDriver<IOSElement>(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);
                break;
            case "WebDriver":
                break;
            default:
                break;
        }
    }
}
