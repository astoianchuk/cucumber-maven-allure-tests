package com.qwertyna.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class DriverManager {
    private static DriverManager instance;
    private ThreadLocal<WebDriver> driver = new ThreadLocal<>();;

    private DriverManager() {
    }

    public static DriverManager getInstance() {
        if (instance == null) {
            instance = new DriverManager();
        }
        return instance;
    }

    public void driverInit(String browserStr) {

        System.out.printf("Opening the browser: $%s1", browserStr);

        switch (browserStr) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver.set(new ChromeDriver());
                break;
            case "fireFox":
                WebDriverManager.firefoxdriver().setup();
                driver.set(new FirefoxDriver());
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                driver.set(new EdgeDriver());
                break;
            case "opera":
                WebDriverManager.operadriver().setup();
                driver.set(new OperaDriver());
                break;
            case "InternetExplorer":
                WebDriverManager.iedriver().setup();
                driver.set(new InternetExplorerDriver());
                break;
            default:
                throw new Error("browser " + browserStr + " not defined");
        }
        driver.get().manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

    }

    public void driverDestroy() {
        if (driver != null) {
             driver.get().quit();
            // driver.get().close();
        }
    }

    public void waitElementToBeClickable(By btnElement, int... timeoutInSec) {
        int timeout = 30;
        WebDriverWait wait;
        if (timeoutInSec.length > 0)
            timeout = timeoutInSec[0];
        wait = new WebDriverWait(driver.get(), Duration.ofSeconds(timeout));
        wait.until(ExpectedConditions.elementToBeClickable(btnElement));
    }

    public void waitUntilPageContentLoaded(By pagePreloaderLocator, int... timeoutInSec) {
        int timeout = 30;
        WebDriverWait wait;
        if (timeoutInSec.length > 0)
            timeout = timeoutInSec[0];
        wait = new WebDriverWait(driver.get(), Duration.ofSeconds(timeout));
        try {
            wait.until(ExpectedConditions.numberOfElementsToBe(pagePreloaderLocator, 1));
            wait.until(ExpectedConditions.numberOfElementsToBe(pagePreloaderLocator, 0));
        } catch (TimeoutException ignore) {

        }
    }

    public WebDriver getDriver() {
        return driver.get();
    }
}
