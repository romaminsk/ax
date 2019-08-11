package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import util.CustomLogger;
import util.PropertiesReader;

import java.util.concurrent.TimeUnit;

public class WebDriverManager {

    private static WebDriver driver = null;

    public WebDriverManager() {
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            System.setProperty("webdriver.chrome.driver", PropertiesReader.getProperty("path_to_chromedriver"));
            driver = new ChromeDriver();
            driver.manage().deleteAllCookies();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.get(PropertiesReader.getProperty("path_to_url"));
        }
        return driver;
    }

    public static void closeDriver () {
        try {
            driver.quit();
            driver = null;
        } catch (Exception e) {
            CustomLogger.error("Can not quit browser");
        }
    }

}
