package test;

import io.appium.java_client.android.AndroidDriver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

/**
 * Helper test.methods
 */

class methods {

    private static AndroidDriver driver;

    static void init(DesiredCapabilities capabilities) throws Exception {
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

    }

    private static WebElement element(By by) {
        return driver.findElement(by);
    }

    static void click(By by) {
        element(by).click();
    }

    static void cleanup() {
        driver.quit();
    }

    private static Object getAtt(By by, String attribute) {

        return element(by).getAttribute(attribute);

    }

    private static String getText(By by) {

        return element(by).getText();
    }

    private static Boolean isEnabled(By by) {
        return element(by).isEnabled();

    }

    static void assertAttribute(String description, By by, String attribute, String expected) {
        Object actualAttribute = getAtt(by, attribute);
        Assert.assertEquals(description, expected, actualAttribute);
    }

    static void assertText(String description, By by, String expected) {
        String actualText = getText(by);
        Assert.assertEquals(description, expected, actualText);
    }

    static void assertEnabled(String description, By by, Boolean expected) {
        Boolean actual = isEnabled(by);
        Assert.assertEquals(description, expected, actual);
    }
}
