package runServer;

import Utils.AppiumTestBase;
import Utils.AppiumUtils;
import conf.StartAppiumServer;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.apache.log4j.Logger;

/**
 * @author Jackie-yan on 2017/4/26.
 **/
public class MyStepdefs extends AppiumTestBase {
//    private AndroidDriver driver;
private static Logger logger = Logger.getLogger(MyStepdefs.class);
    @Given("^StartAppiumServer$")
    public void startAppiumserver() {
        // Write code here that turns the phrase above into concrete actions
        new StartAppiumServer();
    }

    @Given("^wait element find：(.*)$")
    public void waitElementFind(String arg0) {
        System.out.println(arg0);
        // Write code here that turns the phrase above into concrete actions
        if (AppiumUtils.waitElementFind(driver, arg0) == null) {
            logger.error("未能定位到控件");
        }
        logger.info("成功定位到控件");
    }

    @When("^find element by：(.*)$")
    public void findElementBy(String arg0) {
        // Write code here that turns the phrase above into concrete actions
        AppiumUtils.findElement(driver,arg0).click();
    }
}
