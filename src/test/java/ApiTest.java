import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobject.Ticket;
import util.Helper;
import util.PropertiesReader;

import java.util.Collections;
import java.util.List;

import static io.restassured.RestAssured.given;

public class ApiTest {

    private static final String API = PropertiesReader.getProperty("api.path");

    private static final Response RESPONSE = given().
            get(API).
            then().
            statusCode(200).
            extract().
            response();

    private static List<Ticket> tickets = RESPONSE.jsonPath().getList("$", Ticket.class);

    @Test
    public void checkCurrency() {
        for(Ticket ticket : tickets) {
            String string = ticket.getCurrency();
            Assert.assertTrue(Helper.isCurrencyContainsValues(string));
        }
    }



    @Test
    public void checkRussianCharacters() {
        for(Ticket ticket : tickets) {
            String string = ticket.getTitle();
            Assert.assertTrue(Helper.isTitlesContainsRussianSymbols(string));
        }
    }

    @Test
    public void checkTitlesAmount() {
        for(Ticket ticket : tickets) {
            String string = ticket.getTitle();
            Assert.assertTrue(Helper.getTitlesAmount(Collections.singletonList(string)));
        }
    }

    @Test
    public void checkPriceCorrectness() {
        for(Ticket ticket : tickets) {
            String string = ticket.getPrice();
            Assert.assertTrue(Helper.isPriceIsNumbers(string));
        }
    }

}


