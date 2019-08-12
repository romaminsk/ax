package util;

import driver.WebDriverManager;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class Helper {

    private static WebDriver driver = WebDriverManager.getDriver();
    private static Actions actions = new Actions(driver);

    private static List<String> currency = new ArrayList<>(Arrays.asList("USD", "GBP", "EUR", "RUB"));

    public static void clickEnter() {
        CustomLogger.info("Clicking enter button");
        actions.sendKeys(Keys.ENTER).build().perform();
    }

    public static boolean isTitlesContainsRussianSymbols(String string){
        Pattern pattern = Pattern.compile(
                "[" +
                        "а-яА-ЯёЁ" +
                        "\\d" +
                        "\\s" +
                        "\\p{Punct}" +
                        "]" +
                        "*");
        Matcher matcher = pattern.matcher(string);
        if (matcher.matches()){
            return true;
        } else {
            CustomLogger.info("Matching wasn't found");
        }
        return false;
    }

    public static boolean isCurrencyContainsValues(String string){
        for (String str : currency) {
            if (currency.contains(str)) {
                return true;
            } else {
                CustomLogger.info("Currency value isn't found");
            }
        }
            return false;
    }

    public static boolean getTitlesAmount(List<String> list){
        if (list.size()>=0){
            return true;
        } else {
            CustomLogger.info("Titles amount less than 0");
        }
        return false;
    }

    public static boolean isPriceIsNumbers(String string) {
        try {
            Integer.parseInt(string);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

}
