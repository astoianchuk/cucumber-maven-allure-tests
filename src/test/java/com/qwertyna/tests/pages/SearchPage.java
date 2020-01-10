package com.qwertyna.tests.pages;

import com.qwertyna.tests.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class SearchPage {

    private By searchButtonElement = By.id("submit-searchmain");
    private By detailsLinkElement = By.className("detailsLink");
    private By wrapElement = By.className("wrap");
    private By closeCookieButtonElement = By.className("cookiesBarClose");
    private By nextBtnElement = By.xpath("//*[@id=\"body-container\"]/div[3]/div/div[5]/span[17]/a");
    private By priceElement = By.className("price");

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
        WebDriverWait wait = new WebDriverWait(DriverManager.getInstance().driver, 120);
        wait.until(ExpectedConditions.elementToBeClickable(searchButtonElement));
        searchBtn.click();
    }

    public void clickFirstItem() {
        WebElement firstItem = getFirstItemFromSearchResult();
        firstItem.click();
    }

    private WebElement getFirstItemFromSearchResult() {
        WebDriverWait wait = new WebDriverWait(DriverManager.getInstance().driver, 120);
        wait.until(ExpectedConditions.elementToBeClickable(detailsLinkElement));
        regularListItems = regularOfers.findElements(wrapElement);
        return regularListItems.get(0).findElement(detailsLinkElement);
    }

    public void aceptCookie() {
        WebDriverWait wait = new WebDriverWait(DriverManager.getInstance().driver, 120);
        wait.until(ExpectedConditions.elementToBeClickable(closeCookieButtonElement));
        if (cookiesBar.isDisplayed()) {
            cookiesBar.click();
        }
    }

    public boolean checkOfferPriceExist(String price, int pageCount) {

        for (int i = 1; i <= pageCount; i++) {
            System.out.println("Check page: " + i);
            if (offerPriceExistOnPage(price)) return true;
            if (i != pageCount) clickNextButton();
            System.out.println("Complete check page: " + i);
        }
        return false;
    }

    private void clickNextButton() {
        WebDriverWait wait;
        try {
            wait = new WebDriverWait(DriverManager.getInstance().driver, 120);
            wait.until(ExpectedConditions.elementToBeClickable(nextBtnElement));
            WebElement nextBtn = DriverManager.getInstance().driver.findElement(nextBtnElement);
            nextBtn.click();
        } catch (RuntimeException err) {
            DriverManager.getInstance().driver.navigate().refresh();
            wait = new WebDriverWait(DriverManager.getInstance().driver, 120);
            wait.until(ExpectedConditions.elementToBeClickable(nextBtnElement));
            WebElement nextBtn = DriverManager.getInstance().driver.findElement(nextBtnElement);
            nextBtn.click();
        }
    }

    private boolean offerPriceExistOnPage(String price) {
        regularListItems = null;
        WebDriverWait wait = new WebDriverWait(DriverManager.getInstance().driver, 180);
        wait.until(ExpectedConditions.elementToBeClickable(wrapElement));
        regularListItems = regularOfers.findElements(wrapElement);

        Stream<Integer> foundElements = regularListItems.stream()
                .map(el -> getIntPrice(getPriceElementText(el)))
                .filter(intPrice -> intPrice > Integer.parseInt(price))
                .peek(System.out::println);

        return foundElements.count() > 0;
    }

    private String getPriceElementText(WebElement el)
    {
        try {
           return ((WebElement)el).findElement(priceElement).getText();
        } catch (NoSuchElementException | StaleElementReferenceException ignored) {

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
