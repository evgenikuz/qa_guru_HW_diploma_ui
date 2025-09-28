import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class AuthorizationTests extends TestBase {

    @Test
    @DisplayName("Проверка главной страницы")
    void openTest() {
        open("/");
        $(".user-info .button").shouldHave(text("LOG IN"));
    }
}
