import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import config.WebDriverConfig;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;

public class TestBase {
    static WebDriverConfig config = ConfigFactory.create(WebDriverConfig.class, System.getProperties());
    @BeforeAll
    static void onSetUpConfigurations() {
        String launchType = System.getProperty("testLaunchType", "remote");
        Configuration.browser = config.getBrowserName();
        Configuration.browserVersion = config.getBrowserVersion();
        Configuration.browserSize = config.getBrowserSize();
        Configuration.baseUrl = config.getBaseUrl();
        Configuration.pageLoadStrategy = "eager";
        if (launchType.equals("remote")) {
            Configuration.remote = "https://user1:1234@" + System.getProperty("selenoid_url") + "/wd/hub";
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                    "enableVNC", true,
                    "enableVideo", true
            ));
            Configuration.browserCapabilities = capabilities;
        }
    }

    @BeforeEach
    void beforeEachTest() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @AfterEach
    void  addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
    }
}
