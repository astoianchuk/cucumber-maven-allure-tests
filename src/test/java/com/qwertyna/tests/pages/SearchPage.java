package com.qwertyna.tests.pages;

import com.qwertyna.tests.utils.DriverManager;
import com.qwertyna.tests.utils.WebDriverHelper;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class SearchPage {

    private By detailsLinkLocator = By.className("detailsLink");
    private By wrapLocator = By.className("wrap");
    private By nextBtnLocator = By.xpath("//*[@id=\"body-container\"]/div[3]/div/div[5]/span[17]/a");
    private By priceLocator = By.className("price");
    private By pagePreloaderLocator = By.className("listOverlay");

    @FindBy(how = How.ID, using = "headerSearch")
    private WebElement searchField;

    @FindBy(how = How.ID, using = "submit-searchmain")
    private WebElement searchBtn;

    @FindBy(how = How.ID, using = "offers_table")
    private WebElement regularOfers;

    private List<WebElement> regularListItems;

    @FindBy(how = How.CLASS_NAME, using = "cookiesBarClose")
    private WebElement cookiesBar;

    public SearchPage() {
        PageFactory.initElements(DriverManager.getInstance().driver, this);
    }

    public void inputToSearchField(String input) {
        searchField.sendKeys(input);
    }

    public void clickSearchButton() {
        searchBtn.click();
    }

    public void clickFirstItem() {
        WebElement firstItem = getFirstItemFromSearchResult();
        firstItem.click();
    }

    private WebElement getFirstItemFromSearchResult() {
        regularListItems = regularOfers.findElements(wrapLocator);
        return regularListItems.get(0).findElement(detailsLinkLocator);
    }

    public void aceptCookie() {
        if (cookiesBar.isDisplayed()) {
            cookiesBar.click();
        }
    }

    public boolean checkOfferPriceExist(String price, int pageCount) {

        for (int i = 1; i <= pageCount; i++) {
            System.out.println("Check page: " + i);
            regularListItems = null;
            regularListItems = regularOfers.findElements(wrapLocator);
            if (offerPriceExistOnPage(price)) return true;
            if (i != pageCount) clickNextButton();
            WebDriverHelper.waitUntilPageContentLoaded(pagePreloaderLocator, 5);
            System.out.println("Complete check page: " + i);
        }
        return false;
    }

    private void clickNextButton() {
        WebDriver driver = DriverManager.getInstance().driver;
        WebDriverHelper.waitElementToBeClickable(nextBtnLocator, 120);
        driver.findElement(nextBtnLocator).click();
    }

    private boolean offerPriceExistOnPage(String price) {

        Stream<Integer> foundElements = regularListItems.stream()
                .map(el -> getIntPrice(getPriceElementText(el)))
                //TODO need for Debug next line
                .peek(System.out::println)
                .filter(intPrice -> (intPrice > Integer.parseInt(price)))
                //TODO need for Debug next line
                .peek(System.out::println);

        return foundElements.count() > 0;
    }

    private String getPriceElementText(WebElement el) {
        try {
            return el.findElement(priceLocator).getText();
        } catch (StaleElementReferenceException ignored) {
            System.out.println("ELEMENT NOT FOUND StaleElementReferenceException");
        } catch (NoSuchElementException error) {
            System.out.println("ELEMENT NOT FOUND NoSuchElementException");
        }
        return " ";
    }

    private int getIntPrice(String strPrice) {
        int price = 0;
        String substring = "";
        String strPrice2 = strPrice.replace(" ", "");
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(strPrice2);
        while (matcher.find()) {
            substring = strPrice2.substring(matcher.start(), matcher.end());
        }
        if (substring.length() != 0) {
            price = Integer.parseInt(substring);
        }
        return price;
    }


}
