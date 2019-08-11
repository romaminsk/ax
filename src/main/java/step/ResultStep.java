package step;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import util.CustomLogger;

import java.util.List;

public class ResultStep extends BaseStep {

    public ResultStep(WebDriver driver){
        super(driver);
    }

    private static final int RESPONSES_AMOUNT = 8;

    public boolean isResponsesAmountСorrectly(){
        List<WebElement> resultLinks = resultPage.getResultLinks();
        if (resultLinks.size() >= RESPONSES_AMOUNT){
            return true;
        } else {
            CustomLogger.info("Responses amount isn't correctly");
        }
        return false;
    }

    public boolean isVideoScrollingDisplayed(){
        CustomLogger.info("Checking presence of video scrolling");
        return resultPage.getVideoScrolling().isDisplayed();
    }

    public boolean isImageScrollingDisplayed(){
        CustomLogger.info("Checking presence of image scrolling");
        return resultPage.getImageScrolling().isDisplayed();
    }

}
