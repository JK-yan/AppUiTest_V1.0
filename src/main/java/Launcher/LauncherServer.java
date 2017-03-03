package Launcher;

import Utils.AppiumTestBase;
import Utils.AppiumUtils;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

/**
 * Created by admin on 2017/2/9.
 */
public class LauncherServer extends AppiumTestBase {

    @Test
     public void run(){
//         String filepath = "E:\\Code\\AppUiTest_V1.0\\src\\main\\java\\conf";
         String filepath = "E:\\Code\\AppUiTest_V1.0\\src\\main\\resources\\";
         String filename = "base.yaml";
         try {
             initialization(filepath,filename);
//             SwipeElementDirection left = SwipeElementDirection.valueOf();
             AppiumUtils.androidElementWait(driver, By.id("com.android.packageinstaller:id/permission_allow_button")).click();
//             AndroidElement element = driver.findElement
             while ( driver.findElements("-android uiautomator","new UiSelector().className(\"android.widget.TextView\").text(\"首页\")").isEmpty()){
                 AppiumUtils.swipeToLeft((AndroidDriver) driver,1000);

             }
             System.out.println("............................................................................................111111111..");
//             System.out.println("..............................................................................................");
System.out.println("465468798645644444444444444444444444444"+driver.findElements("-android uiautomator","new UiSelector().className(\"android.widget.TextView\").text(\"首页\")").get(0));
             System.out.println(".............................................................................222222222222.................");
             driver.findElement("-android uiautomator","new UiSelector().className(\"android.widget.TextView\").text(\"我的\")").click();
             } catch (MalformedURLException e) {
             e.printStackTrace();
         }
    }
     @AfterTest
    public void tearDown(){
        driver.quit();
    }
}
