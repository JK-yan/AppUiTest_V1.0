package Utils;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.apache.log4j.Logger;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.LinkedHashMap;

/**
 * Created by Jackie-yan on 2017/1/3.
 **/
public class AppiumTestBase {
    private static Logger logger = Logger.getLogger(AppiumTestBase.class);
    public static AndroidDriver<MobileElement> driver;
    protected void initializationAppiumConfiguration(String filepath,String filename,int port){
        String uri = "http://127.0.0.1:"+port+"/wd/hub";

        try {
            DesiredCapabilities a = setDesiredCapabilities(filepath,filename);
            driver = new AndroidDriver<>(new URL(uri),a);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     *设置appium启动的基本参数
     *@param  filepath 文件路径
     *@param filename 文件名字
     *根据读取文件中platformName的属性选择不同平台IOS or Android
     *
     */
    private static DesiredCapabilities setDesiredCapabilities(String filepath,String filename) throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        LinkedHashMap capability= (LinkedHashMap) YamlUtils.loadGetValue(filepath,filename,"capability");
        for (Object iterable : capability.keySet()) {
            desiredCapabilities.setCapability(iterable.toString(), capability.get(iterable).toString());
        }
        switch (capability.get("platformName").toString()){
            case "android":{
                LinkedHashMap androidCapability= (LinkedHashMap) YamlUtils.loadGetValue(filepath,filename,"androidCapability");
                for (Object iterable : androidCapability.keySet()) {
                    desiredCapabilities.setCapability(iterable.toString(), androidCapability.get(iterable).toString());
                }//                driver.findElement("-android uiautomator",""); 4731 4725 4728 4733 4735
                break;
            }
            case "ios":{
                LinkedHashMap iosCapability= (LinkedHashMap) YamlUtils.loadGetValue(filepath,filename,"androidCapability");
                for (Object iterable : iosCapability.keySet()) {
                    desiredCapabilities.setCapability(iterable.toString(), iosCapability.get(iterable).toString());
                }
                break;
            }
        }
        logger.info("appium初始化参数设置"+desiredCapabilities);
        return desiredCapabilities;
    }
}
