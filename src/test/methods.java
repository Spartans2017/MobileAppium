package test;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

/**
 * Helper test.methods
 */

public class methods {

    private static AndroidDriver driver;

    public static void init(DesiredCapabilities capabilities) throws Exception {
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

    }

    public static void click(By by) {
        WebElement button = driver.findElement(by);
        button.click();
    }
}
