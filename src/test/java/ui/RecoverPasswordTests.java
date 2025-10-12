package ui;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.RecoverPasswordPage;

import static io.qameta.allure.SeverityLevel.CRITICAL;

@Epic("Авторизация и регистрация")
@Feature("Восстановление пароля")
public class RecoverPasswordTests extends TestBase {
    RecoverPasswordPage recoverPasswordPage = new RecoverPasswordPage();

    @Test
    @DisplayName("При восстановлении данных с несуществующим email появляется ошибка о неактивном аккаунте")
    @Story("Восстановление пароля с невалидными данными")
    @Owner("KharitonovaES")
    @Severity(CRITICAL)
    void recoverPasswordWithInactiveEmail() {
        recoverPasswordPage.openRecoverPasswordPage()
                .enterEmail("12345@efwefwefwefwefw.com")
                .clickOnSendMeAnEmail()
                .checkError("Sorry, but we can't find any active account with that email address!");
    }
}
