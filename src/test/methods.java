package test;

import io.appium.java_client.android.AndroidDriver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

/**
 * Helper methods
 */

class methods {

    /**
     * define Android driver
     */
    private static AndroidDriver driver;

    /**
     * initialize the Android driver with the desired capabilities
     */
    static void init(DesiredCapabilities capabilities) throws Exception {
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

    }

    /**
     * Find an element
     */
    private static WebElement element(By by) {
        return driver.findElement(by);
    }

    /**
     * Click element
     */
    static void click(By by) {
        element(by).click();
    }

    /**
     * Cleanup code after test (quits the running driver)
     */
    static void cleanup() {
        driver.quit();
    }

    /**
     * Get specific attribute
     */
    private static Object getAtt(By by, String attribute) {

        return element(by).getAttribute(attribute);

    }

    /**
     * Get text from an element
     */
    private static String getText(By by) {

        return element(by).getText();
    }

    /**
     * return bool value if an element is enabled/disabled
     */
    private static Boolean isEnabled(By by) {
        return element(by).isEnabled();

    }

    /**
     * Assert specific attribute of an element
     */
    static void assertAttribute(String description, By by, String attribute, String expected) {
        Object actualAttribute = getAtt(by, attribute);
        Assert.assertEquals(description, expected, actualAttribute);
    }

    /**
     * Assert text of an element
     */
    static void assertText(String description, By by, String expected) {
        String actualText = getText(by);
        Assert.assertEquals(description, expected, actualText);
    }

    /**
     * Assert if the element is enabled/disabled
     */
    static void assertEnabled(String description, By by, Boolean expected) {
        Boolean actual = isEnabled(by);
        Assert.assertEquals(description, expected, actual);
    }
}
