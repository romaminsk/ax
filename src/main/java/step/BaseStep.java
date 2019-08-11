package step;

import org.openqa.selenium.WebDriver;
import pageobject.ResultPage;
import pageobject.StartPage;

public class BaseStep {

    protected StartPage startPage;
    protected ResultPage resultPage;

    public BaseStep(WebDriver driver){
        this.startPage = new StartPage(driver);
        this.resultPage = new ResultPage(driver);
    }

}
