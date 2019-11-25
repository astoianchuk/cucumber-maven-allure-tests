package com.qwertyna.tests.steps;

import com.qwertyna.tests.TestUtil;
import com.qwertyna.tests.pages.HomePage;
import com.qwertyna.tests.pages.ItemPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class Stepdefs {
    private HomePage homePage = new HomePage();
    private ItemPage itemPage = new ItemPage();

    @Given("I navigate to url {string}")
    public void i_navigate_to_url(String string) {
        System.out.println("Navigate to https://www.olx.ua page");
        TestUtil.driver.navigate().to("https://www.olx.ua");
        homePage.aceptCookie();
    }

    @When("I enter {string} to search field")
    public void i_enter_to_search_field(String string) {
        homePage.inputToSearchField(string);
    }

    @And("I click Search button")
    public void iClickSearchButton() {
        homePage.clickSearchButton();
    }

    @And("I select first found item")
    public void iSelectFirstFoundObject() {
        TestUtil.driver.manage().deleteAllCookies();
        homePage.clickFirstItem();
        homePage.aceptCookie();
    }

    @Then("I verify that found item contain field {string} and value {string}")
    public void i_verify_that_item_s_contain_field_and_value(String field, String fieldValue) {
        Assert.assertTrue(itemPage.isContainCorrectFieldValue(field, fieldValue));
    }


    @Then("I click next page until offer price < {string} or page count ={int}")
    public void iClickNextPageUntilOfferPriceOrPageCount(String price, int pageCount) {
        Assert.assertTrue(homePage.checkOfferPriceExist(price, pageCount));
    }

    @Then("I verify that on the first {int} pages of the usual announcements at least one TV with a price> {string}")
    public void iVerifyThatOnTheFirstPagesOfTheUsualAnnouncementslThereIsAtLeastTVWithAPrice(int pageCount, String price) {
        Assert.assertTrue(homePage.checkOfferPriceExist(price, pageCount));
    }
}
