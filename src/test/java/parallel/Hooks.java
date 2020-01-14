package parallel;

import com.qwertyna.tests.DriverManager;
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
        @Nullable
        String browserStr = System.getProperty("browser");
        if (browserStr == null) browserStr = DEF_BROWSER;
        DriverManager.getInstance().driverInit(browserStr);
    }

    @After(value = "@onTestCompleteWithScreenshot", timeout = 0L, order = 0)
    public void makeScreenshot(Scenario scenario) throws IOException {
        hooksHelper.attachScreenShot(scenario);
    }

    @After(value = "@onTestComplete", timeout = 0L, order = 1)
    public void testComplete(Scenario scenario) {
        DriverManager.getInstance().driverDestroy();
    }

}
