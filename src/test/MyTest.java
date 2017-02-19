package test;

import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;


public class MyTest {

    AndroidDriver driver;
    @Before
    public void setUp() throws Exception {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "virtual_device_android");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }

    @After
    public void tearDown() throws Exception{
        driver.quit();
    }

    @Test
    public void layout(){
        WebElement addButton = driver.findElement(By.id("com.test.calc:id/add_b"));
        WebElement subButton = driver.findElement(By.id("com.test.calc:id/sub_b"));
        WebElement title = driver.findElement(By.id("android:id/title"));
        WebElement output = driver.findElement(By.id("com.test.calc:id/tv2"));

        Boolean addButtonEnabled = addButton.isEnabled();
        Boolean subButtonEnabled = subButton.isEnabled();
        String outputNotClickable = output.getAttribute("clickable");
        String titleText = title.getText();
        Assert.assertEquals("addition button should be enabled", true, addButtonEnabled);
        Assert.assertEquals("subtraction button should be enabled", true, subButtonEnabled);
        Assert.assertEquals("output should not be clickable", "false", outputNotClickable);
        Assert.assertEquals("title should equal 'Calculator'", "Calculator", titleText);
    }

    @Test
    public void additionOperation(){
        WebElement button = driver.findElement(By.id("com.test.calc:id/add_b"));
        String buttonText = button.getText();
        Assert.assertEquals("should equals to 'ADD'", "ADD", buttonText);
        button.click();
    }

    @Test
    public void subtractionOperation(){
        WebElement button = driver.findElement(By.id("com.test.calc:id/sub_b"));
        String buttonText = button.getText();
        Assert.assertEquals("should equals to 'SUB'", "SUB", buttonText);
        button.click();
    }

    @Test
    public void multipleOperationsSameButton(){
        WebElement addButton = driver.findElement(By.id("com.test.calc:id/add_b"));
        WebElement output = driver.findElement(By.id("com.test.calc:id/tv2"));

        addButton.click();
        String output1 = output.getText();
        Assert.assertEquals("'new number =1' value should be displayed in the output text field", "new number =1", output1);
        addButton.click();
        String output2 = output.getText();
        Assert.assertEquals("'new number =2' value should be displayed in the output text field", "new number =2", output2);
        addButton.click();
        String output3 = output.getText();
        Assert.assertEquals("'new number =3' value should be displayed in the output text field", "new number =3", output3);
    }

    @Test
    public void multipleOperationsRandom(){
        WebElement addButton = driver.findElement(By.id("com.test.calc:id/add_b"));
        WebElement subButton = driver.findElement(By.id("com.test.calc:id/sub_b"));
        WebElement output = driver.findElement(By.id("com.test.calc:id/tv2"));

        subButton.click();
        String output1 = output.getText();
        Assert.assertEquals("'new number =-1' value should be displayed in the output text field", "new number =-1", output1);
        addButton.click();
        String output2 = output.getText();
        Assert.assertEquals("'new number =0' value should be displayed in the output text field", "new number =0", output2);
        subButton.click();
        String output3 = output.getText();
        Assert.assertEquals("'new number =-1' value should be displayed in the output text field", "new number =-1", output3);
        addButton.click();
        String output4 = output.getText();
        Assert.assertEquals("'new number =0' value should be displayed in the output text field", "new number =0", output4);
        addButton.click();
        String output5 = output.getText();
        Assert.assertEquals("'new number =1' value should be displayed in the output text field", "new number =1", output5);
    }
}
