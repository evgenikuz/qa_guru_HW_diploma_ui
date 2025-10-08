package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.util.List;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class MainPage {
    private final SelenideElement loginButton = $(".user-info .button");
    private final ElementsCollection buttonName = $$("#main-nav .top-menu-entry");

    public MainPage openMainPage() {
        step("Открываем главную страницу", () -> {
            open("/");
            loginButton.shouldHave(text("LOG IN"));
        });
        return this;
    }
    public MainPage checkDropdownMenu(String dropdownButtonName, List<String> dropdownMenuList) {
        step("Проверяем выпадающее меню элемента", () -> {
        buttonName.findBy(text(dropdownButtonName)).hover();
        buttonName.findBy(text(dropdownButtonName)).parent().$$(".collapsed li").shouldHave(texts(dropdownMenuList));
        });
        return this;
    }
}


