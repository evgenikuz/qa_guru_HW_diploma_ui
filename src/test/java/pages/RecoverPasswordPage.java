package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.CollectionCondition.exactTextsCaseSensitive;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class RecoverPasswordPage {
    private final SelenideElement emailInput = $("#recover_password_email"),
                                sendMeAnEmailButton = $("#resetPasswordButton"),
                                emailError = $(".error_list");
    private final ElementsCollection headers = $$("h3");

    @Step("Открываем страницу восстановления пароля")
    public RecoverPasswordPage openRecoverPasswordPage() {
            open("/recoverpassword");
            headers.shouldHave(exactTextsCaseSensitive("Forgot your username?", "Forgot your password?", "Forgot your password and your email address has changed?"));
        return this;
    }

    @Step("Вводим email для восстановления данных")
    public RecoverPasswordPage enterEmail(String email) {
            emailInput.sendKeys(email);
        return this;
    }

    @Step("Нажимаем кнопку Send me an email")
    public RecoverPasswordPage clickOnSendMeAnEmail() {
            sendMeAnEmailButton.click();
        return this;
    }

    @Step("Проверяем ошибку")
    public RecoverPasswordPage checkError(String error) {
            emailError.shouldHave(text(error));
        return this;
    }
}
