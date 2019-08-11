package util;

import driver.WebDriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtils {

    public static void sleep(int timeout) {
        CustomLogger.info("Sleeping");
        try {
            Thread.sleep(timeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void waitForElementVisible(final WebElement element) {
        waitForElementVisible(element , 20);
    }

    public static void waitForElementVisible(final WebElement element, int waitingTime) {
        CustomLogger.info("Waiting visibility of an element");
        new WebDriverWait(WebDriverManager.getDriver(), waitingTime)
                .until(ExpectedConditions.visibilityOf(element));
    }

    public static void waitForElementClickable(final WebElement element) {
        waitForElementClickable(element,20);
    }

    public static void waitForElementClickable(final WebElement element, int waitingTime) {
        CustomLogger.info("Waiting clickable of an element");
        new WebDriverWait(WebDriverManager.getDriver(), waitingTime)
                .until(ExpectedConditions.elementToBeClickable(element));
    }

}
