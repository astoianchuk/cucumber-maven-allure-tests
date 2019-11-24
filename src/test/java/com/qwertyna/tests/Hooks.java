package com.qwertyna.tests;

import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Hooks {
    private TestUtil util = new TestUtil();

    @Before
    public void initializeTest(){
        System.out.println("Openning the browser: Chrome");
        System.setProperty("webdriver.chrome.driver", "C:\\libs\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--user-agent=Mozilla/5.0 (Linux; Android 6.0; HTC One M9 Build/MRA58K) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/52.0.2743.98 Mobile Safari/537.36");

        TestUtil.driver = new ChromeDriver();
    }
}
