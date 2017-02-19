package test;

import io.appium.java_client.android.AndroidDriver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;
import java.util.Objects;
import java.util.function.BooleanSupplier;

/**
 * Helper test.methods
 */

public class methods {

    private static AndroidDriver driver;

    public static void init(DesiredCapabilities capabilities) throws Exception {
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

    }

    private static WebElement element(By by) {
        return driver.findElement(by);
    }

    public static void click(By by) {
        element(by).click();
    }

    public static void cleanup() {
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

    public static void assertAttribute(String description, By by, String attribute, String expected) {
        Object actualAttribute = getAtt(by, attribute);
        Assert.assertEquals(description, expected, actualAttribute);
    }

    public static void assertText(String description, By by, String expected) {
        String actualText = getText(by);
        Assert.assertEquals(description, expected, actualText);
    }

    public static void assertEnabled(String description, By by, Boolean expected) {
        Boolean actual = isEnabled(by);
        Assert.assertEquals(description, expected, actual);
    }
}
