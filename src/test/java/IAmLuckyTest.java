import driver.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import step.ResultStep;
import step.StartStep;
import util.Helper;
import util.JsonDataReader;

import java.util.Map;

public class IAmLuckyTest extends BaseTest {


    protected WebDriver driver;

    private static Map<String, String> searchData;

    private StartStep startStep;
    private ResultStep resultStep;

    @BeforeClass
    public void preparationForTest() {
        driver = WebDriverManager.getDriver();
        searchData = JsonDataReader.getSearchData();
        startStep = new StartStep(driver);
        resultStep = new ResultStep(driver);
    }

    @Test
    public void checkSearchResults(){
        String request = searchData.get("request");
        startStep.setRequest(request);
        Helper.clickEnter();
        Assert.assertTrue(resultStep.isResponsesAmountСorrectly());
        Assert.assertTrue(resultStep.isVideoScrollingDisplayed());
        Assert.assertTrue(resultStep.isImageScrollingDisplayed());
    }

}
