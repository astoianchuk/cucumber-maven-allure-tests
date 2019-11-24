package com.qwertyna.tests.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class ItemPage {

    @FindBy(how = How.ID, using = "details fixed marginbott20 margintop5 full")
    private WebElement detailsPanel;

    public ItemPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public boolean isContainItemField(String field){

        return false;
    }

    public boolean isContainCorrectFieldValue(String field, String value){

        return false;
    }

}
