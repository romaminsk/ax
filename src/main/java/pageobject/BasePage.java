package pageobject;

import driver.WebDriverManager;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    public BasePage() {
        PageFactory.initElements(WebDriverManager.getDriver(), this);
    }

}
