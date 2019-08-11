package util;

import driver.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ScreenshotListener extends TestListenerAdapter {

    private Calendar calendar = Calendar.getInstance();
    private SimpleDateFormat formatter = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");

    @Override
    public void onTestFailure(ITestResult result) {
        String methodName = result.getName();

        if (!result.isSuccess()) {
            try {
                File scrFile = ((TakesScreenshot) WebDriverManager.getDriver()).getScreenshotAs(OutputType.FILE);
                String screenshotName =
                        new File(System.getProperty("user.dir")).getAbsolutePath()
                                + "/target/"
                                + methodName + "_" + formatter.format(calendar.getTime()) + ".jpg";
                File destFile = new File(screenshotName);
                FileUtils.copyFile(scrFile, destFile);
                CustomLogger.info("Screenshot was taken");
            } catch (IOException e) {
                CustomLogger.error("Can not save screenshot: " + e.getMessage());
            }
        }
    }

}
