package ui;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.LoginPage;

import static io.qameta.allure.SeverityLevel.CRITICAL;
import static io.qameta.allure.SeverityLevel.NORMAL;

@Epic("Авторизация и регистрация")
@Feature("Авторизация")
public class LoginTests extends TestBase {
    LoginPage loginPage = new LoginPage();

    @Test
    @DisplayName("При вводе невалидных данных появляется ошибка 'Wrong getSelenoidUsername or getSelenoidPassword'")
    @Story("Проверка авторизации с невалидными данными")
    @Owner("KharitonovaES")
    @Severity(CRITICAL)
    void LoginWithWrongCredentials() {
        loginPage.openLoginPage()
                .closeModal()
                .enterUsername("helga")
                .enterPassword("12345")
                .pressLoginButton()
                .checkError("Wrong getSelenoidUsername or getSelenoidPassword");
    }

    @Test
    @DisplayName("Осуществляется переход на страницу восстановления пароля по кнопке 'Forgot Something'")
    @Story("Проверка перехода на страницу восстановления пароля по кнопке 'Forgot Something'")
    @Owner("KharitonovaES")
    @Severity(NORMAL)
    void ForgotSomethingLinkTest() {
        loginPage.openLoginPage()
                .closeModal()
                .clickOnForgotSomething();
    }

}
