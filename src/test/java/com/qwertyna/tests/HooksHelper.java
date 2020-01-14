package com.qwertyna.tests;

import com.qwertyna.tests.utils.DriverManager;
import cucumber.api.Scenario;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.IOException;

class HooksHelper {

    void attachScreenShot(Scenario scenario) throws IOException {
        if (scenario.isFailed()) {
            makeScreenshot();
        }
    }

    @Attachment(value = "Attachment Screenshot", type = "image/png")
    public byte[] makeScreenshot() {
        return ((TakesScreenshot) DriverManager.getInstance().driver).getScreenshotAs(OutputType.BYTES);
    }


}
