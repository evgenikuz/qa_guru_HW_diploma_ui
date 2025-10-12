package ui;

import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.LoginPage;

import static io.qameta.allure.SeverityLevel.CRITICAL;
import static io.qameta.allure.SeverityLevel.NORMAL;

public class LoginTests extends TestBase {
    LoginPage loginPage = new LoginPage();

    @Test
    @DisplayName("Проверка авторизации с неверными данными")
    @Owner("KharitonovaES")
    @Severity(CRITICAL)
    void LoginWithWrongCredentials() {
        loginPage.openLoginPage()
                .enterUsername("helga")
                .enterPassword("12345")
                .pressLoginButton()
                .checkError("Wrong username or password");
    }

    @Test
    @DisplayName("Проверка перехода на страницу восстановления пароля по кнопке 'Forgot Something'")
    @Owner("KharitonovaES")
    @Severity(NORMAL)
    void ForgotSomethingLinkTest() {
        loginPage.openLoginPage()
                .clickOnForgotSomething();
    }

}
