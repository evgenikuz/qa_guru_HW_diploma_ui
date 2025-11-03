package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class SignUpPage {
    private final SelenideElement header = $("h1"),
                            signMeUpButton = $("#signupButton"),
                            usernameInput = $(".form-row #signup_user_username"),
                            usernameAvailable = $(".form-row #usernameAvailable");
    @Step("Открываем страницу регистрации")
    public SignUpPage openSignUpPage() {
            open("/signup");
            header.shouldHave(text("Join Postcrossing!"));
        return this;
    }

    @Step("Нажимаем на кнопку Sign me up!")
    public SignUpPage clickOnSignMeUpButton() {
            signMeUpButton.click();
        return this;
    }

    @Step("Вводим getSelenoidUsername")
    public SignUpPage enterUsername(String value) {
            usernameInput.sendKeys(value);
        return this;
    }

    @Step("Проверяем наличие ошибки по короткому имени")
    public SignUpPage checkUsernameError(String error) {
            usernameAvailable.shouldHave(text(error));
        return this;
    }
}
