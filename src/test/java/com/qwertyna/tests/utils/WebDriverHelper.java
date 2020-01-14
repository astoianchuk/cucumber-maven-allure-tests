package com.qwertyna.tests.utils;

import com.qwertyna.tests.utils.DriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.annotation.Nullable;
import java.time.Duration;
import java.util.concurrent.TimeUnit;


public class WebDriverHelper {
    //TODO waitForExist, waitForVisible
    final String DEF_BROWSER = "chrome";

    public static void waitElementToBeClickable(By btnElement, int... timeoutInSec) {
        int timeout = 30;
        WebDriverWait wait;
        if (timeoutInSec.length > 0)
            timeout = timeoutInSec[0];
        wait = new WebDriverWait(DriverManager.getInstance().driver, Duration.ofSeconds(timeout));
        wait.until(ExpectedConditions.elementToBeClickable(btnElement));
    }

    public static void waitUntilPageContentLoaded(By pagePreloaderLocator, int... timeoutInSec) {
        int timeout = 30;
        WebDriverWait wait;
        if (timeoutInSec.length > 0)
            timeout = timeoutInSec[0];
        wait = new WebDriverWait(DriverManager.getInstance().driver, Duration.ofSeconds(timeout));
        try {
            wait.until(ExpectedConditions.numberOfElementsToBe(pagePreloaderLocator, 1));
            wait.until(ExpectedConditions.numberOfElementsToBe(pagePreloaderLocator, 0));
        } catch (TimeoutException ignore) {

        }
    }

    public void webDriverSetup() {
        //TODO change: def browser take from congig.properties System.getProperty("defaultBrowser");

        @Nullable
        String browserStr = System.getProperty("browser");
        if (browserStr == null) browserStr = DEF_BROWSER;
        System.out.printf("Opening the browser: $%s1", browserStr);

        switch (browserStr) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                DriverManager.getInstance().driver = new ChromeDriver();
                break;
            case "fireFox":
                WebDriverManager.firefoxdriver().setup();
                DriverManager.getInstance().driver = new FirefoxDriver();
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                DriverManager.getInstance().driver = new EdgeDriver();
                break;
            case "opera":
                WebDriverManager.operadriver().setup();
                DriverManager.getInstance().driver = new OperaDriver();
                break;
            case "InternetExplorer":
                WebDriverManager.iedriver().setup();
                DriverManager.getInstance().driver = new InternetExplorerDriver();
                break;
            default:
                throw new Error("browser " + browserStr + " not defined");
        }
        DriverManager.getInstance().driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

    }

   public void clearAndCloseBrowser() {
        DriverManager.getInstance().destroyDriver();
    }

}

