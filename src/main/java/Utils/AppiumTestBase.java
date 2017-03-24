package Utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import org.apache.log4j.Logger;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.LinkedHashMap;

/**
 * Created by jackiezero on 2017/1/3.
 */
public class AppiumTestBase {
    private static Logger logger = Logger.getLogger(AppiumTestBase.class);
    protected AppiumDriver driver;

    /**
     *
     *设置appium启动的基本参数
     *@param  filepath 文件路径
     *@param filename 文件名字
     *根据读取文件中platformName的属性选择不同平台IOS or Android
     *
     */

    public void initialization(String filepath,String filename) throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        LinkedHashMap capability= (LinkedHashMap) YamlUtils.loadGetValue(filepath,filename,"capability");
        for (Iterator it = capability.keySet().iterator(); it.hasNext(); ) {
            Object iterable = it.next();
            desiredCapabilities.setCapability(iterable.toString(),capability.get(iterable).toString());
        }
        switch (capability.get("platformName").toString()){
            case "android":{
                LinkedHashMap androidCapability= (LinkedHashMap) YamlUtils.loadGetValue(filepath,filename,"androidCapability");
                for (Iterator it = androidCapability.keySet().iterator(); it.hasNext(); ) {
                    Object iterable = it.next();
                    desiredCapabilities.setCapability(iterable.toString(),androidCapability.get(iterable).toString());
                }//                driver.findElement("-android uiautomator","");
                driver =  new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);
                break;
            }
            case "ios":{
                LinkedHashMap iosCapability= (LinkedHashMap) YamlUtils.loadGetValue(filepath,filename,"androidCapability");
                for (Iterator it = iosCapability.keySet().iterator(); it.hasNext(); ) {
                    Object iterable = it.next();
                    desiredCapabilities.setCapability(iterable.toString(),iosCapability.get(iterable).toString());
                }
                driver = new IOSDriver<IOSElement>(new URL("http://127.0.0.1:4730/wd/hub"), desiredCapabilities);
                break;
            }
        }
    }
}
