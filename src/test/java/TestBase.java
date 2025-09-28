import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {

    @BeforeAll
    static void onSetUpConfigurations() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://www.postcrossing.com/";
        Configuration.pageLoadStrategy = "eager";
    }
}
