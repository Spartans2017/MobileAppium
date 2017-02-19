package test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
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
        methods.assertEnabled("addition button should be enabled", Elements.addButton, true);
        methods.assertEnabled("subtraction button should be enabled", Elements.subButton, true);
        methods.assertText("title should equal 'Calculator'", Elements.title, "Calculator");
    }

    @Test
    public void additionOperation(){
        methods.click(Elements.addButton);
        methods.assertText("should equals to 'ADD'", Elements.addButton, "ADD");
    }

    @Test
    public void subtractionOperation(){
        methods.click(Elements.subButton);
        methods.assertText("should equals to 'SUB'", Elements.subButton, "SUB");
    }

    @Test
    public void multipleOperationsSameButton(){

        int number = 1;
        for (int i = 0; i < 2; i++) {
            methods.click(Elements.addButton);
            methods.assertText("'new number =" + number + "' value should be displayed in the output text field", Elements.output, "new number =" + number);
            number++;
        }
    }

    @Test
    public void multipleOperationsRandom(){
        methods.click(Elements.subButton);
        methods.assertText("'new number =-1' value should be displayed in the output text field", Elements.output, "new number =-1");
        methods.click(Elements.addButton);
        methods.assertText("'new number =0' value should be displayed in the output text field", Elements.output, "new number =0");
        methods.click(Elements.subButton);
        methods.assertText("'new number =-1' value should be displayed in the output text field", Elements.output, "new number =-1");
        methods.click(Elements.addButton);
        methods.assertText("'new number =0' value should be displayed in the output text field", Elements.output, "new number =0");
        methods.click(Elements.addButton);
        methods.assertText("'new number =1' value should be displayed in the output text field", Elements.output, "new number =1");
    }
}
