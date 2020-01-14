package parallel;

import com.qwertyna.tests.pages.ItemPage;
import com.qwertyna.tests.pages.SearchPage;
import com.qwertyna.tests.DriverManager;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class StepsDefs {
    private SearchPage homePage = new SearchPage();
    private ItemPage itemPage = new ItemPage();

    @Given("I navigate to url {string}")
    public void iNavigateToUrl(String url) {
        System.out.println("Navigate to " + url);
        DriverManager.getInstance().getDriver().navigate().to(url);
        homePage.aceptCookie();
    }

    @When("I enter {string} to search field")
    public void iEnterToSearchField(String string) {
        homePage.inputToSearchField(string);
    }

    @And("I click Search button")
    public void iClickSearchButton() {
        homePage.clickSearchButton();
    }

    @And("I select first found item")
    public void iSelectFirstFoundObject() {
        //TODO: Do I need add Asert true "first item exist"
        DriverManager.getInstance().getDriver().manage().deleteAllCookies();
        homePage.clickFirstItem();
        homePage.aceptCookie();
    }

    @Then("I verify that found {string} contain field {string} and value {string}")
    public void iVerifyThatFoundItemContainFieldAndValue(String item, String field, String fieldValue) {
        Assert.assertTrue(item + " is not contain field " + fieldValue + " or " + field,
                itemPage.isContainCorrectFieldValue(field, fieldValue));
    }

    @Then("I click next page until offer price < {string} or page count ={int} and verify")
    public void iClickNextPageUntilOfferPriceOrPageCount(String price, int pageCount) {
        Assert.assertTrue("Not exist offer price >= "+ price +" on first "+ pageCount + " pages",homePage.checkOfferPriceExist(price, pageCount));
    }
}
