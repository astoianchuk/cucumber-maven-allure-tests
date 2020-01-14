package com.qwertyna.tests;

import com.qwertyna.tests.utils.DriverManager;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

import javax.annotation.Nullable;
import java.io.IOException;

public class Hooks {

    private final String DEF_BROWSER = "chrome";
    private HooksHelper hooksHelper = new HooksHelper();

    @Before
    public void initializeTest() {
        //TODO change: def browser take from congig.properties System.getProperty("defaultBrowser");

        @Nullable
        String browserStr = System.getProperty("browser");
        if (browserStr == null) browserStr = DEF_BROWSER;
        DriverManager.getInstance().driverInit(browserStr);
    }

    @After
    public void testComplete(Scenario scenario) {
        DriverManager.getInstance().driverDestroy();
    }

    @After(value = "@makeScreenshotIfFailed", timeout = 0L, order = 0)
    public void makeScreenshot(Scenario scenario) throws IOException {
        hooksHelper.attachScreenShot(scenario);
    }


}
