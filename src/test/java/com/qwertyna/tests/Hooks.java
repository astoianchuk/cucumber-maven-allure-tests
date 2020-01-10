package com.qwertyna.tests;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class Hooks {

    @Before
    public void initializeTest() {
        System.out.println("Openning the browser: Chrome");
        WebDriverManager.chromedriver().setup();
        DriverManager.getInstance().driver = new ChromeDriver();
        DriverManager.getInstance().driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);

    }

    @After
    public void closeDriver() {

        DriverManager.getInstance().destroyDriver();
    }
}
