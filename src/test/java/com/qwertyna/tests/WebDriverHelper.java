package com.qwertyna.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;


public class WebDriverHelper {

    public static void waitElementToBeClickable(By btnElement, int... timeoutInSec) {
        int timeout = 30;
        WebDriverWait wait;
        if (timeoutInSec.length > 0)
            timeout = timeoutInSec[0];
        wait = new WebDriverWait(DriverManager.getInstance().driver, 120);
        wait.until(ExpectedConditions.elementToBeClickable(btnElement));
    }

    public void webDriverSetup() {
        String browser = System.getProperty("browser");
        //TODO change: def browser take from congig.properties
        if (browser.equals("null")) browser = "chrome";
        System.out.printf("Openning the browser: $%s1", browser);

        switch (browser) {
            case "chrome":
                //chromeDriverSetup();
                WebDriverManager.chromedriver().setup();
                DriverManager.getInstance().driver = new ChromeDriver();
                DriverManager.getInstance().driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
                break;
            case "fireFox":
                //firefoxDriverSetup();
                WebDriverManager.firefoxdriver().setup();
                DriverManager.getInstance().driver = new FirefoxDriver();
                break;
            case "edge":
                // edgeDriverSetup();
                WebDriverManager.edgedriver().setup();
                DriverManager.getInstance().driver = new EdgeDriver();
                break;
            case "opera":
                // operaDriverSetup();
                WebDriverManager.operadriver().setup();
                DriverManager.getInstance().driver = new OperaDriver();
                break;
            case "InternetExplorer":
                //ieDriverSetup();
                WebDriverManager.iedriver().setup();
                DriverManager.getInstance().driver = new InternetExplorerDriver();
                break;
            default:
                throw new Error("browser " + browser + " not defined");
        }
    }

    void clearAndCloseBrowser() {
        DriverManager.getInstance().destroyDriver();
    }

}

