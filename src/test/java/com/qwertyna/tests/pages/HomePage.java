package com.qwertyna.tests.pages;

import com.qwertyna.tests.TestUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class HomePage {

    @FindBy(how = How.ID, using = "headerSearch")
    private WebElement searchField;

    @FindBy(how = How.ID, using = "submit-searchmain")
    private WebElement searchBtn;

    @FindBy(how = How.ID, using = "offers_table")
    private WebElement arr;

    @FindBy(how = How.CLASS_NAME, using = "cookiesBarClose")
    private WebElement cookiesBar;

    public HomePage() {
        PageFactory.initElements(TestUtil.driver, this);
    }

    public void inputToSearchField(String input) {
        searchField.sendKeys(input);
    }

    public void clickSearchButton() {
        WebDriverWait wait = new WebDriverWait(TestUtil.driver, 120);
        wait.until(ExpectedConditions.elementToBeClickable(By.id("submit-searchmain")));
        searchBtn.click();
    }


    public void clickFirstItem() {
        WebDriverWait wait = new WebDriverWait(TestUtil.driver, 120);
        wait.until(ExpectedConditions.elementToBeClickable(By.className("detailsLink")));
        List<WebElement> el = arr.findElements(By.className("wrap"));
        el.get(0).findElement(By.className("detailsLink")).click();
    }

    public void aceptCookie() {
        WebDriverWait wait = new WebDriverWait(TestUtil.driver, 120);
        wait.until(ExpectedConditions.elementToBeClickable(By.className("cookiesBarClose")));
        if (cookiesBar.isDisplayed()) {
            cookiesBar.click();
        }


    }
}
