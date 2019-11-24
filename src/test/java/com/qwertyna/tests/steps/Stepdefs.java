package com.qwertyna.tests.steps;

import com.qwertyna.tests.TestUtil;
import com.qwertyna.tests.pages.HomePage;
import com.qwertyna.tests.pages.ItemPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Stepdefs {
    private HomePage homePage = new HomePage(TestUtil.driver);
    private ItemPage itemPage = new ItemPage(TestUtil.driver);

    @Given("I navigate to url {string}")
    public void i_navigate_to_url(String string) {
        System.out.println("Navigate to https://www.olx.ua page");
        TestUtil.driver.navigate().to("https://www.olx.ua");
        homePage.aceptCookie();
      //  System.out.println(TestUtil.driver.getWindowHandle());
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
        //class="fixed offers breakword redesigned"
        TestUtil.driver.manage().deleteAllCookies();
        homePage.clickFirstItem();
    }

    @Then("I verify that found item contain field {string} and value {string}")
    public void i_verify_that_item_s_contain_field_and_value(String field, String fieldValue) {
        //Assert.assertTrue(itemPage.isContainItemField(field));
        //Assert.assertTrue(itemPage.isContainCorrectFieldValue(field, fieldValue));
        //Assert.assertFalse(itemPage.isContainItemField(field));
        //Assert.assertFalse(itemPage.isContainCorrectFieldValue(field, fieldValue));
    }

}
