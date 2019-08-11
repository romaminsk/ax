package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class StartPage extends BasePage {

    public StartPage(WebDriver driver){
    }

    @FindBy(xpath = "//div[1]/input[@role='combobox']")
    private WebElement inputField;


    public WebElement getInputField(){
        return inputField;
    }


}
