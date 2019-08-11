package step;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import util.CustomLogger;

public class StartStep extends BaseStep {

    public StartStep(WebDriver driver){
        super(driver);
    }


    public void setRequest(String request){
        WebElement inputField = startPage.getInputField();
        CustomLogger.info("Setting request");
        inputField.sendKeys(request);
    }

}
