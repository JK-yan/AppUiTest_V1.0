package Launcher;

import Utils.AppiumTestBase;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

/**
 * Created by admin on 2017/2/9.
 */
public class LauncherServer extends AppiumTestBase {

    @Test
     public void run(){
         String filepath = "E:\\Code\\AppUiTest_V1.0\\src\\main\\java\\conf";
         String filename = "base.yaml";
         String platform = "AndroidDriver";
         String appName = "erduo.apk";
         try {
             initialization(filepath,filename,platform,appName);
//             SwipeElementDirection left = SwipeElementDirection.valueOf();

         } catch (MalformedURLException e) {
             e.printStackTrace();
         }
     }
}
