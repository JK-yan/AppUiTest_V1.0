package Utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.Time;
import java.util.List;

/**
 * Created by jackiezero on 2017/1/3.
 */
public class AppiumUtils extends AppiumTestBase{
    private static Logger logger = Logger.getLogger(AppiumUtils.class);
    /**
    * 根据定位参数条件选择定位方式
     *@return element MobileElement 类型的控件
    *
     * @param driver
     * @param controlInfo 定位条件
     * @param time
     */
    public static MobileElement findElement(AppiumDriver driver, String controlInfo, Time time){
        WebElement element ;
        if (controlInfo.startsWith("//")){
            element = driver.findElementByXPath(controlInfo);
        }else if (controlInfo.contains(":id/") || controlInfo.contains(":string/")){
            element = driver.findElementById(controlInfo);
        }else {
            element = driver.findElement("-android uiautomator",controlInfo);
        }

        return (MobileElement) element;
    }
    /**
     * 根据定位参数条件选择定位方式
     *@param controlInfo 定位条件
     *@param driver
     *@return elements MobileElement 类型的控件
     *
     */
    public List findElements(AppiumDriver driver,String controlInfo){
        List elements ;
        if (controlInfo.startsWith("//")){
            elements = driver.findElementsByXPath(controlInfo);
        }else if (controlInfo.contains(":id/") || controlInfo.contains(":string/")){
            elements = driver.findElementsById(controlInfo);
        }else {
            elements = driver.findElements("-android uiautomator",controlInfo);
        }

        return  elements;
    }
    public static waitFelement(AppiumDriver driver,String elementInfo, Time time){
        findElement(driver,elementInfo,time);
    return findElement(driver,elementInfo,time);
    }
    /**
     * An expectation for checking that an element is present on the DOM of a page and visible.
     * Visibility means that the element is not only displayed but also has a height and width that is
     * greater than 0.
     *@author jackiezero
     * locator used to find the element
     * @return the WebElement once it is located and visible
     */
    public static MobileElement androidElementWait(WebDriver driver, By by){
    try {
        MobileElement  element = (MobileElement) (new WebDriverWait(driver, 60)).until(ExpectedConditions.visibilityOfElementLocated(by));
        return element;
    }catch (Exception e){
        e.getCause();
        logger.error(e);
        return null;
    }
}


    public boolean isElementExist(AppiumDriver<WebElement> driver , String by , String use) {

//           MobileElement element = (MobileElement) driver.findElements(by,use);
        return driver.findElements(by,use).isEmpty();
    }

    /**
     * This Method for swipe up
     *
     * @author Young
     * @param driver
     * @param during
     */
    public static void swipeToUp(AndroidDriver driver, int during) {
        int width = driver.manage().window().getSize().width;
        int height = driver.manage().window().getSize().height;
        driver.swipe(width / 2, height * 3 / 4, width / 2, height / 4, during);
        // wait for page loading
    }

    /**
     * This Method for swipe down
     *
     * @author Young
     * @param driver
     * @param during
     */
    public static void swipeToDown(AndroidDriver driver, int during) {
        int width = driver.manage().window().getSize().width;
        int height = driver.manage().window().getSize().height;
        driver.swipe(width / 2, height / 4, width / 2, height * 3 / 4, during);
        // wait for page loading
    }

    /**
     * This Method for swipe Left
     *
     * @author Young
     * @param driver
     * @param during
     */
    public static void swipeToLeft(AndroidDriver driver, int during) {
        int width = driver.manage().window().getSize().width;
        int height = driver.manage().window().getSize().height;
        driver.swipe(width * 3 / 4, height / 2, width / 4, height / 2, during);
        // wait for page loading
    }

    /**
     * This Method for swipe Right
     *
     * @author Young
     * @param driver
     * @param during
     */
    public static void swipeToRight(AndroidDriver driver, int during) {
        int width = driver.manage().window().getSize().width;
        int height = driver.manage().window().getSize().height;
        driver.swipe(width / 4, height / 2, width * 3 / 4, height / 2, during);
        // wait for page loading
    }
}
