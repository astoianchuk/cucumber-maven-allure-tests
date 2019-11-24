package com.qwertyna.tests;

import cucumber.api.java.Before;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Hooks {
    private TestUtil util = new TestUtil();

    @Before
    public void initializeTest() {
        System.out.println("Openning the browser: Chrome");
        System.setProperty("webdriver.chrome.driver", "C:\\libs\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();

        TestUtil.driver = new ChromeDriver();
    }
}
