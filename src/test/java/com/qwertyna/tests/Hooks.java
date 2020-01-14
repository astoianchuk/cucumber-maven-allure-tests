package com.qwertyna.tests;

import com.qwertyna.tests.utils.WebDriverHelper;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

import java.io.IOException;

public class Hooks {

    private HooksHelper hooksHelper = new HooksHelper();
    private WebDriverHelper driverHelper = new WebDriverHelper();

    @Before
    public void initializeTest() {
        driverHelper.webDriverSetup();
    }

    @After()
    public void testComplete(Scenario scenario) {
        driverHelper.clearAndCloseBrowser();
    }

    @After(value = "@makeScreenshotIfFailed", timeout = 0L, order = 0)
    public void makeScreenshot(Scenario scenario) throws IOException {
        hooksHelper.attachScreenShot(scenario);
    }


}
