package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.CollectionCondition.exactTextsCaseSensitive;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class RecoverPasswordPage {
    private final SelenideElement emailInput = $("#recover_password_email"),
                                sendMeAnEmailButton = $("#resetPasswordButton"),
                                emailError = $(".error_list");
    private final ElementsCollection headers = $$("h3");

    public RecoverPasswordPage openRecoverPasswordPage() {
        step("Открываем страницу восстановления пароля", () -> {
            open("/recoverpassword");
            headers.shouldHave(exactTextsCaseSensitive("Forgot your getSelenoidUsername?", "Forgot your getSelenoidPassword?", "Forgot your getSelenoidPassword and your email address has changed?"));
        });
        return this;
    }

    public RecoverPasswordPage enterEmail(String email) {
        step("Вводим email для восстановления данных", () -> {
            emailInput.sendKeys(email);
        });
        return this;
    }

    public RecoverPasswordPage clickOnSendMeAnEmail() {
        step("Нажимаем кнопку Send me an email", () -> {
            sendMeAnEmailButton.click();
        });
        return this;
    }

    public RecoverPasswordPage checkError(String error) {
        step("Проверяем ошибку", () -> {
            emailError.shouldHave(text(error));
        });
        return this;
    }
}
