package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ResultPage extends BasePage {

    public ResultPage(WebDriver driver){
    }

    @FindBy(xpath = "//h3")
    private List<WebElement> resultLinks;

    @FindBy(xpath = "//g-scrolling-carousel[@class = 'COEoid']")
    private WebElement videoScrolling;

    @FindBy(xpath = "//g-scrolling-carousel[@jsname = 'mILnFc']")
    private WebElement imageScrolling;


    public List<WebElement> getResultLinks(){
        return resultLinks;
    }

    public WebElement getVideoScrolling(){
        return videoScrolling;
    }

    public WebElement getImageScrolling(){
        return imageScrolling;
    }

}
