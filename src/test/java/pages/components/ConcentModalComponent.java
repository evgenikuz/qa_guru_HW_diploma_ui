package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;

public class ConcentModalComponent {
    private final SelenideElement concentModal = $(".fc-dialog-container"),
                                concentButton = $(".fc-button-label");

    public ConcentModalComponent checkModalExists() {
        step("Проверяем наличие модального окна", () -> {
            if (concentModal.isDisplayed()) {
                step("Закрываем модальное окно", () -> {
                    concentButton.click();
                });
            }
        });
        return this;
    }
}

