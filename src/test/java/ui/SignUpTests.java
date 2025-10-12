package ui;

import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import pages.SignUpPage;

import static io.qameta.allure.SeverityLevel.CRITICAL;

public class SignUpTests extends TestBase {
    SignUpPage signUpPage = new SignUpPage();

    @CsvSource(value = {
            "h, Username is too short (min: 2 chars).",
            "helga, Sorry! Username 'helga' is already taken.",
            "helga1234, 'helga1234' is available!"
    })
    @ParameterizedTest(name = "При вводе {0} появляется ошибка {1}")
    @DisplayName("Проверка поля Username при регистрации")
    @Owner("KharitonovaES")
    @Severity(CRITICAL)
    void UsernameInputTest (String usernameValue, String warning) {
        signUpPage.openSignUpPage()
                .clickOnSignMeUpButton()
                .enterUsername(usernameValue)
                .checkUsernameError(warning);
    }
}
