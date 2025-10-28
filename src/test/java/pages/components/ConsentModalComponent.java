package pages.components;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;

public class ConsentModalComponent {
    private final SelenideElement consentModal = $(".fc-dialog-container"),
                                consentButton = $(".fc-button-label");

    public ConsentModalComponent checkModalExists() {
        step("Проверяем наличие модального окна", () -> {
            if (consentModal.is(Condition.visible)) {
                consentButton.click();
            }
        });
        return this;
    }

}

