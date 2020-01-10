package com.qwertyna.tests.steps;

import com.qwertyna.tests.DriverManager;
import com.qwertyna.tests.pages.ItemPage;
import com.qwertyna.tests.pages.SearchPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class Stepdefs {
    private SearchPage homePage = new SearchPage();
    private ItemPage itemPage = new ItemPage();

    @Given("I navigate to url {string}")
    public void iNavigateToUrl(String url) {
        System.out.println("Navigate to " + url);
        DriverManager.getInstance().driver.navigate().to(url);
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
        DriverManager.getInstance().driver.manage().deleteAllCookies();
        homePage.clickFirstItem();
        homePage.aceptCookie();
    }

    @Then("I verify that found item contain field {string} and value {string}")
    public void iVerifyThatFoundItemContainFieldAndValue(String field, String fieldValue) {
        Assert.assertTrue(itemPage.isContainCorrectFieldValue(field, fieldValue));
    }

    @Then("I click next page until offer price < {string} or page count ={int} and verify")
    public void iClickNextPageUntilOfferPriceOrPageCount(String price, int pageCount) {
        Assert.assertTrue("Offer price >= "+ price +" on first "+ pageCount + " pages not exist ",homePage.checkOfferPriceExist(price, pageCount));
    }
}
