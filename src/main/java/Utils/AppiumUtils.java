package Utils;

import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by jackiezero on 2017/1/3.
 */
public class AppiumUtils extends AppiumTestBase{

public static MobileElement AndroidElementWait(WebDriver driver, By by){
    /**
     * An expectation for checking that an element is present on the DOM of a page and visible.
     * Visibility means that the element is not only displayed but also has a height and width that is
     * greater than 0.
     *
     * @param locator used to find the element
     * @return the WebElement once it is located and visible
     */
    MobileElement element = (MobileElement)(new WebDriverWait(driver,60)).until(ExpectedConditions.visibilityOfElementLocated(by));


    return element;
}

}
