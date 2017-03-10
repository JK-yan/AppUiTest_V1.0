package Launcher;

import Utils.AppiumTestBase;
import Utils.AppiumUtils;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

/**
 * Created by admin on 2017/2/9.
 */
public class LauncherServer extends AppiumTestBase {
    String filepath = "E:\\Code\\AppUiTest_V1.0\\src\\main\\resources\\";
    String filename = "base.yaml";



    @Test
     public void run(){
         try {
             initialization(filepath,filename);
         } catch (MalformedURLException e) {
             e.printStackTrace();
         }
         while (AppiumUtils.findElement(driver,"new UiSelector().className(\"android.widget.TextView\").text(\"首页\")")==null){
             AppiumUtils.waitFelement(driver,"new UiSelector().className(\"android.widget.RelativeLayout\").childSelector(new UiSelector().className(\"android.widget.RelativeLayout\"))",10).click();
         }
         AppiumUtils.findElement(driver,"new UiSelector().className(\"android.widget.TextView\").text(\"我的\")").click();
    }
     @AfterTest
    public void tearDown(){
        driver.quit();
    }
}
