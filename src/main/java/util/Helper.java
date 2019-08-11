package util;

import driver.WebDriverManager;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public final class Helper {

    private static WebDriver driver = WebDriverManager.getDriver();
    private static Actions actions = new Actions(driver);



    public static void clickEnter() {
        CustomLogger.info("Clicking enter button");
        actions.sendKeys(Keys.ENTER).build().perform();
    }

    public static void refreshPage(){
        CustomLogger.info("Refreshing page");
        driver.navigate().refresh();
    }

}
