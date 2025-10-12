package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;
import static io.qameta.allure.Allure.step;

public class LoginPage {
    private final SelenideElement header = $("h2"),
            usernameInput = $("#username"),
            passwordInput = $("#password"),
            loginButton = $("#loginButton"),
            loginError = $("#loginForm .error"),
            forgotSomethingLink = $(".forgot-something");

    public LoginPage openLoginPage() {
        step("Открываем страницу авторизации", () -> {
            open("/login");
            header.shouldHave(text("Log in"));
        });
        return this;
    }

    public LoginPage enterUsername(String username) {
        step("Вводим логин", () -> {
            usernameInput.sendKeys(username);
        });
        return this;
    }

    public LoginPage enterPassword(String password) {
        step("Вводим пароль", () -> {
            passwordInput.sendKeys(password);
        });
        return this;
    }

    public LoginPage pressLoginButton() {
        step("Нажимаем кнопку Log in", () -> {
            loginButton.click();
        });
        return this;
    }

    public LoginPage checkError(String error) {
        step("Проверяем наличие ошибки", () -> {
            loginError.shouldHave(text(error));
        });
        return this;
    }

    public LoginPage clickOnForgotSomething() {
        step("Проверяем кнопку 'Forgot Something'", () -> {
            forgotSomethingLink.click();
            webdriver().shouldHave(url("https://www.postcrossing.com/recoverpassword"));
        });
        return this;
    }
}
