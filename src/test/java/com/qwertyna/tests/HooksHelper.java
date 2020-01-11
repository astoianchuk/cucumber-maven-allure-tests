package com.qwertyna.tests;

import cucumber.api.Scenario;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

class HooksHelper {

    void attachScreenShot(Scenario scenario) throws IOException {
        if (scenario.isFailed()){
            makeScreenshot();
        }
       // else clearAndCloseBrowser();
        }

    @Attachment(value = "Attachment Screenshot", type = "image/png")
    public byte[] makeScreenshot() {
        return ((TakesScreenshot)  DriverManager.getInstance().driver).getScreenshotAs(OutputType.BYTES);
    }
    void clearAndCloseBrowser() {
        DriverManager.getInstance().destroyDriver();
    }
}
