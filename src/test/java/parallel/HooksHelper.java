package parallel;

import com.qwertyna.tests.DriverManager;
import cucumber.api.Scenario;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.IOException;

class HooksHelper {

    void attachScreenShot(Scenario scenario) throws IOException {
        makeScreenshot();
    }

    @Attachment(value = "Attachment Screenshot", type = "image/png")
    public byte[] makeScreenshot() {
        //TODO js scroll to element
        return ((TakesScreenshot) DriverManager.getInstance().getDriver()).getScreenshotAs(OutputType.BYTES);
    }


}
