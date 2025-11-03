package pages.components;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class ConsentModalComponent {
    private final SelenideElement consentModal = $(".fc-dialog-container"),
                                consentButton = $(".fc-button-label");

    @Step("Проверяем наличие модального окна")
    public ConsentModalComponent checkModalExists() {
        if (consentModal.is(Condition.visible)) {
            consentButton.click();
        }
        return this;
    }

}

