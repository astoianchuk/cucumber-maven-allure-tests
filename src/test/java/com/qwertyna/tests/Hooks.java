package com.qwertyna.tests;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Hooks {

    private HooksHelper hooksHelper = new HooksHelper();

    @Before
    public void initializeTest() {
        System.out.println("Openning the browser: Chrome");
        WebDriverManager.chromedriver().setup();
        DriverManager.getInstance().driver = new ChromeDriver();
        DriverManager.getInstance().driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);

    }

    @After
    public void testComplete(Scenario scenario) throws IOException {
        hooksHelper.clearAndCloseBrowser();
    }

    @After("@makeScreenshotIfFailed")
    public void makeScreenshot(Scenario scenario) throws IOException {
       hooksHelper.attachScreenShot(scenario);
    }



}
