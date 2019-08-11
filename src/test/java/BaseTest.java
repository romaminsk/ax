import driver.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;

public class BaseTest {

    protected WebDriver driver;

    @BeforeClass
    public void preparationForTest() {
        driver = WebDriverManager.getDriver();
    }

    @AfterSuite
    public void tearDown() {
        WebDriverManager.closeDriver();
    }

}
