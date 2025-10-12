package ui;

import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.RecoverPasswordPage;

import static io.qameta.allure.SeverityLevel.CRITICAL;

public class RecoverPasswordTests extends TestBase {
    RecoverPasswordPage recoverPasswordPage = new RecoverPasswordPage();

    @Test
    @DisplayName("Проверка восстановления данных с неактивным email")
    @Owner("KharitonovaES")
    @Severity(CRITICAL)
    void recoverPasswordWithInactiveEmail() {
        recoverPasswordPage.openRecoverPasswordPage()
                .enterEmail("12345@efwefwefwefwefw.com")
                .clickOnSendMeAnEmail()
                .checkError("Sorry, but we can't find any active account with that email address!");
    }
}
