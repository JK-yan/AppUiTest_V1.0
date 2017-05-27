package Utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 * Created by jackiezero on 2017/1/3.
 */
public class AppiumUtils extends AppiumTestBase {
    private static Logger logger = Logger.getLogger(AppiumUtils.class);

    /**
     * 根据定位参数条件ID,Xpath,AndroidUiautomator选择定位方式
     *
     * @param controlInfo 定位条件
     * @param driver
     * @return elements MobileElement 类型的控件
     * @author Jackie_yan
     */
    public static List findElements(AppiumDriver driver, String controlInfo) {
        List elements;
        if (controlInfo.startsWith("//")) {
            elements = driver.findElementsByXPath(controlInfo);
        } else if (controlInfo.contains(":id/") || controlInfo.contains(":string/")) {
            elements = driver.findElementsById(controlInfo);
        } else {
            elements = driver.findElements("-android uiautomator", controlInfo);
        }
        return elements;
    }

    /**
     * 根据定位参数条件ID,Xpath,AndroidUiautomator选择定位方式,当控件未找到时先确认是否有权限弹框
     * （有，全部点击确认或者允许，在循环定位控件一次，依然定位不到跳出循环）
     *
     * @param driver
     * @param controlInfo 定位条件
     * @return element MobileElement 类型的控件
     * @author Jackie_yan
     */
    public static MobileElement findElement(AppiumDriver driver, String controlInfo) {
        WebElement element;
        if (controlInfo.startsWith("//")) {
            element = driver.findElementByXPath(controlInfo);
            logger.info("......................Find Element By Xpath:" + controlInfo + ".........................");
            return (MobileElement) element;
        } else if (controlInfo.contains(":id/") || controlInfo.contains(":string/")) {
            element = driver.findElementById(controlInfo);
            logger.info("......................Find Element By ID:" + controlInfo + ".........................");
            return (MobileElement) element;
        } else {
            element = driver.findElement("-android uiautomator", controlInfo);
            logger.info("......................Find Element By UiautomatorViewer:" + controlInfo + ".........................");
            return (MobileElement) element;
        }
    }

    /**
     * 等待控件元素响应，并定位到控件，等元素为定位到的时候根据设定时间循环去寻找
     *
     * @param driver
     * @param elementInfo 定位控件方式
     * @author Jackie_yan
     * @ findElement(AppiumDriver driver, String controlInfo){}寻找控件的方法
     **/
    public static MobileElement waitElementFind(AppiumDriver driver, String elementInfo) {
        int i = 0;
        while (i < 10) {
            try {
                MobileElement element = findElement(driver, elementInfo);
                logger.info("......................Succeed find Element" + elementInfo + " in " + i + " seconds.........................");
                return element;
            } catch (NoSuchElementException e) {
                i++;
                waitTimes();
            }
        }
        logger.error("......................can not find Element" + elementInfo + " in " + 10 + " seconds.........................");
        return null;
    }

    /**
     * 强制等待时间
     **/
    private static void waitTimes() {
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * An expectation for checking that an element is present on the DOM of a page and visible.
     * Visibility means that the element is not only displayed but also has a height and width that is
     * greater than 0.
     *
     * @return the WebElement once it is located and visible
     * @author Jackie_yan
     * locator used to find the element
     */
    public static MobileElement androidElementWait(WebDriver driver, By by) {
        try {
            MobileElement element = (MobileElement) (new WebDriverWait(driver, 60)).until(ExpectedConditions.visibilityOfElementLocated(by));
            return element;
        } catch (Exception e) {
            e.getCause();
            logger.error(e);
            return null;
        }
    }


    public boolean isElementExist(AppiumDriver<WebElement> driver, String by, String use) {

//           MobileElement element = (MobileElement) driver.findElements(by,use);
        return driver.findElements(by, use).isEmpty();
    }

    /**
     * This Method for swipe up
     *
     * @param driver
     * @param during
     * @author Jackie_yan
     */
    public static void swipeToUp(AndroidDriver driver, int during) {
        int width = driver.manage().window().getSize().width;
        int height = driver.manage().window().getSize().height;
        driver.swipe(width / 2, height * 3 / 4, width / 2, height / 4, during);
//        TouchAction action = new TouchAction(driver);
//        action.press(width / 2,height * 3 / 4).moveTo(width / 2, height / 4).release();
        // wait for page loading
    }

    /**
     * This Method for swipe down
     *
     * @param driver
     * @param during
     * @author Jackie_yan
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
     * @param driver
     * @param during
     * @author Jackie_yan
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
     * @param driver
     * @param during
     * @author Jackie_yan
     */
    public static void swipeToRight(AndroidDriver driver, int during) {
        int width = driver.manage().window().getSize().width;
        int height = driver.manage().window().getSize().height;
        driver.swipe(width / 4, height / 2, width * 3 / 4, height / 2, during);
        // wait for page loading
    }
}
