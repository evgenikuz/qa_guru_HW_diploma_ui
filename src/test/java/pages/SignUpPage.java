package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class SignUpPage {
    private final SelenideElement header = $("h1"),
                            signMeUpButton = $("#signupButton"),
                            usernameInput = $(".form-row #signup_user_username"),
                            usernameAvailable = $(".form-row #usernameAvailable");
    public SignUpPage openSignUpPage() {
        step("Открываем страницу регистрации", () -> {
            open("/signup");
            header.shouldHave(text("Join Postcrossing!"));
        });
        return this;
    }

    public SignUpPage clickOnSignMeUpButton() {
        step("Нажимаем на кнопку Sign me up!", () -> {
            signMeUpButton.click();
        });
        return this;
    }

    public SignUpPage enterUsername(String value) {
        step("Вводим username", () -> {
            usernameInput.sendKeys(value);
        });
        return this;
    }

    public SignUpPage checkUsernameError(String error) {
        step("Проверяем наличие ошибки по короткому имени", () -> {
            usernameAvailable.shouldHave(text(error));
        });
        return this;
    }
}
