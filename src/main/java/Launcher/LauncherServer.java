package Launcher;

import Utils.AppiumTestBase;
import Utils.AppiumUtils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.NoSuchElementException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

/**
 * Created by admin on 2017/2/9.
 */
public class LauncherServer extends AppiumTestBase {
    String filepath = "E:\\Code\\AppUiTest_V1.0\\src\\main\\resources\\";
    String filename = "base.yaml";



    @BeforeTest
     public void run(){
         try {
             initialization(filepath,filename);
//             Thread.sleep(4000);
         } catch (MalformedURLException e) {
             e.printStackTrace();
         }

//         AppiumUtils.waitFelement(driver,"new UiSelector().className(\"android.widget.TextView\").text(\"首页\")",10);
//        while (AppiumUtils.findElement(driver,"new UiSelector().className(\"android.widget.TextView\").text(\"首页\")")==null){
//             AppiumUtils.waitFelement(driver,"new UiSelector().className(\"android.widget.RelativeLayout\").childSelector(new UiSelector().className(\"android.widget.RelativeLayout\"))",10).click();
//         }
//         AppiumUtils.findElement(driver,"new UiSelector().className(\"android.widget.TextView\").text(\"我的\")").click();
    }
//    @Test
//    public void login(){
//        AppiumUtils.findElement(driver,"new UiSelector().className(\"android.widget.TextView\").text(\"我的\")").click();
//        AppiumUtils.findElement(driver,"com.fulihui.www.information:id/civ_user_icon").click();
//        AppiumUtils.findElement(driver,"com.fulihui.www.information:id/civ_user_icon").sendKeys("");
//    }
//    @Test
//    public void close(){
//        driver.closeApp();
//    }
public static void getAD(AndroidDriver driver,int a){
    MobileElement element = null;
    while (a<5) {
        try {
        element = (MobileElement) driver.findElementById("com.fulihui.www.information:id/ad");
        } catch (NoSuchElementException e) {
            AppiumUtils.swipeToUp(driver, 500);
            e.printStackTrace();
            continue;
        }
        element.click();
        try {
            Thread.sleep(5000);
            driver.pressKeyCode(4);
            a++;
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
    @Test
    public void start() {
//        driver.launchApp();
        AppiumUtils.waitFelement(driver, "new UiSelector().className(\"android.widget.TextView\").text(\"首页\")", 10).click();
        System.out.println("..............................................");
        System.out.println(driver.getContext());
        System.out.println("..............................................");
        MobileElement element;

        int i = 0;
        int a =0;
        while (i<10) {

            getAD((AndroidDriver) driver,a);
            AppiumUtils.swipeToUp((AndroidDriver) driver,500);
            a = 0;
            i++;
        }
    }
     @AfterTest
    public void tearDown(){
        driver.quit();
    }
}
