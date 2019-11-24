package com.qwertyna.tests.pages;

import com.qwertyna.tests.TestUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ItemPage {

    @FindBy(how = How.CLASS_NAME, using = "details")
    private WebElement detailsPanel;

    public ItemPage() {
        PageFactory.initElements(TestUtil.driver, this);
    }

    public boolean isContainCorrectFieldValue(String field, String value) {
        List<WebElement> detailsList = detailsPanel.findElements(By.tagName("tbody"));
        for (int i = 1; i < detailsList.size(); i++) {
            if (detailsList.get(i).getText().contains(field + " " + value)) return true;
        }
        return false;
    }

}
