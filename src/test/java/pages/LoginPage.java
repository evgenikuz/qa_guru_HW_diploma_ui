package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import pages.components.ConsentModalComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;

public class LoginPage {
    private final SelenideElement header = $("h2"),
            usernameInput = $("#username"),
            passwordInput = $("#password"),
            loginButton = $("#loginButton"),
            loginError = $("#loginForm .error"),
            forgotSomethingLink = $(".forgot-something");

    ConsentModalComponent consentModalComponent = new ConsentModalComponent();

    @Step("Открываем страницу авторизации")
    public LoginPage openLoginPage() {
        open("/login");
        header.shouldHave(text("Log in"));
        return this;
    }

    public LoginPage closeModal() {
        consentModalComponent.checkModalExists();
        return this;
    }

    @Step("Вводим логин")
    public LoginPage enterUsername(String username) {
        usernameInput.sendKeys(username);
        return this;
    }

    @Step("Вводим пароль")
    public LoginPage enterPassword(String password) {
        passwordInput.sendKeys(password);
        return this;
    }

    @Step("Нажимаем кнопку Log in")
    public LoginPage pressLoginButton() {
        loginButton.click();
        return this;
    }

    @Step("Проверяем наличие ошибки")
    public LoginPage checkError(String error) {
        loginError.shouldHave(text(error));
        return this;
    }

    @Step("Проверяем кнопку 'Forgot Something'")
    public LoginPage clickOnForgotSomething() {
        forgotSomethingLink.click();
        webdriver().shouldHave(url("https://www.postcrossing.com/recoverpassword"));
        return this;
    }
}
