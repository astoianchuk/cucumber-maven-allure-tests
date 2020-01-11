package com.qwertyna.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
//TODO waitForExist, waitForVisible


public class WebDriverHelper {

    public static void waitElementToBeClickable(By btnElement, int ...timeoutInSec) {
        int timeout = 30;
        WebDriverWait wait;
        if(timeoutInSec.length > 0)
            timeout = timeoutInSec[0];
            wait = new WebDriverWait(DriverManager.getInstance().driver, 120);
            wait.until(ExpectedConditions.elementToBeClickable(btnElement));
    }

}

