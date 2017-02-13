package Utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by jackiezero on 2017/1/3.
 */
public class AppiumUtils extends AppiumTestBase{

public static MobileElement androidElementWait(WebDriver driver, By by){
    /**
     * An expectation for checking that an element is present on the DOM of a page and visible.
     * Visibility means that the element is not only displayed but also has a height and width that is
     * greater than 0.
     *@author jackiezero
     * @param locator used to find the element
     * @return the WebElement once it is located and visible
     */
    MobileElement element = (MobileElement)(new WebDriverWait(driver,60)).until(ExpectedConditions.visibilityOfElementLocated(by));


    return element;
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
