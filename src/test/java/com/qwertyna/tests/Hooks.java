package com.qwertyna.tests;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Hooks {

    @Before
    public void initializeTest() {
        System.out.println("Openning the browser: Chrome");
        System.setProperty("webdriver.chrome.driver", "C:\\libs\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();

        DriverManager.getInstance().driver = new ChromeDriver();
    }

    @After
    public void closeDriver() {
        DriverManager.getInstance().destroyDriver();
    }
}
