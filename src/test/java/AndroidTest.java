import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

/**
 * Created by admin on 2016/12/29.
 */
public class AndroidTest {
    private static AndroidDriver driver;

    @Before
    public void setUp() throws Exception {
//        File classpathRoot = new File(System.getProperty("user.dir"));
//        File appDir = new File(classpathRoot, "../../../apps/ApiDemos/bin");
//        File app = new File(appDir, "ApiDemos-debug.apk");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName","android");
        capabilities.setCapability("platformVersion", "4.4");
        capabilities.setCapability("platformName", "android");
        capabilities.setCapability("noReset", true);
        capabilities.setCapability("appPackage", "com.fulihui.www.information");
        capabilities.setCapability("appActivity", ".SplashActivity");
        driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        Thread.sleep(5000);
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }
    public static void swipeToUp() {
        int width = driver.manage().window().getSize().width;
        int height = driver.manage().window().getSize().height;
        driver.swipe(width / 2, height * 3 / 4, width / 2, height / 4, 500);
//        TouchAction action = new TouchAction(driver);
//        action.press(width / 2,height * 3 / 4).moveTo(width / 2, height / 4).release();
        // wait for page loading
    }
    public static void swipeDown() {
        int width = driver.manage().window().getSize().width;
        int height = driver.manage().window().getSize().height;
        driver.swipe(width / 2, height / 4, width / 2, height * 3 / 4, 500);
    }
    public static void getAD(){
        while (true){
            try {
                MobileElement element = (MobileElement) driver.findElementById("com.fulihui.www.information:id/ad");
                element.click();
                Thread.sleep(5000);
                driver.pressKeyCode(3);
            }catch (NoSuchElementException e){
                swipeToUp();
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
   @org.junit.Test
    public void apiDemo(){
//        driver.findElementByAndroidUIAutomator("new UiSelector().className(\"android.widget.TextView\").text(\"我的\")");

       try {
//           Thread.sleep(5000);
//           driver.findElementByAndroidUIAutomator("new UiSelector().className(\"android.widget.TextView\").text(\"我的\")");
           swipeDown();
           Thread.sleep(5000);
           swipeDown();
           Thread.sleep(5000);
           swipeDown();
       } catch (InterruptedException e) {
           e.printStackTrace();
       }
       getAD();


    }

}
