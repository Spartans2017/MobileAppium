package test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

public class MyTest {

    @Before
    public void setUp() throws Exception {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "virtual_device_android");

        methods.init(capabilities);
    }

    @After
    public void tearDown() throws Exception{
        methods.cleanup();
    }

    @Test
    public void layout(){
        methods.assertEnabled("addition button should be enabled", By.id("com.test.calc:id/add_b"), true);
        methods.assertEnabled("subtraction button should be enabled", By.id("com.test.calc:id/sub_b"), true);
        methods.assertAttribute("output should not be clickable", By.id("com.test.calc:id/tv2"), "clickable", "false");
        methods.assertText("title should equal 'Calculator'", By.id("android:id/title"), "Calculator");
    }

    @Test
    public void additionOperation(){
        methods.click(By.id("com.test.calc:id/add_b"));
        methods.assertText("should equals to 'ADD'", By.id("com.test.calc:id/add_b"), "ADD");
    }

    @Test
    public void subtractionOperation(){
        methods.click(By.id("com.test.calc:id/sub_b"));
        methods.assertText("should equals to 'SUB'", By.id("com.test.calc:id/sub_b"), "SUB");
    }

    @Test
    public void multipleOperationsSameButton(){

        methods.click(By.id("com.test.calc:id/add_b"));
        methods.assertText("'new number =1' value should be displayed in the output text field", By.id("com.test.calc:id/tv2"), "new number =1");
        methods.click(By.id("com.test.calc:id/add_b"));
        methods.assertText("'new number =2' value should be displayed in the output text field", By.id("com.test.calc:id/tv2"), "new number =2");
        methods.click(By.id("com.test.calc:id/add_b"));
        methods.assertText("'new number =3' value should be displayed in the output text field", By.id("com.test.calc:id/tv2"), "new number =3");
    }

    @Test
    public void multipleOperationsRandom(){

        methods.click(By.id("com.test.calc:id/sub_b"));
        methods.assertText("'new number =-1' value should be displayed in the output text field", By.id("com.test.calc:id/tv2"), "new number =-1");
        methods.click(By.id("com.test.calc:id/add_b"));
        methods.assertText("'new number =0' value should be displayed in the output text field", By.id("com.test.calc:id/tv2"), "new number =0");
        methods.click(By.id("com.test.calc:id/sub_b"));
        methods.assertText("'new number =-1' value should be displayed in the output text field", By.id("com.test.calc:id/tv2"), "new number =-1");
        methods.click(By.id("com.test.calc:id/add_b"));
        methods.assertText("'new number =0' value should be displayed in the output text field", By.id("com.test.calc:id/tv2"), "new number =0");
        methods.click(By.id("com.test.calc:id/add_b"));
        methods.assertText("'new number =1' value should be displayed in the output text field", By.id("com.test.calc:id/tv2"), "new number =1");
    }
}
