package com.qwertyna.tests.utils;

import org.openqa.selenium.WebDriver;

public class DriverManager {
    private static DriverManager instance;
    public WebDriver driver;
    private DriverManager() {
    }

    public static DriverManager getInstance() {
        if (instance == null) {
            instance = new DriverManager();
        }
        return instance;
    }

    void destroyDriver() {
        if (driver != null) {
            driver.close();
            driver.quit();
        }
    }

}
