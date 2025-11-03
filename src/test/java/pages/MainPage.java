package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.util.List;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;

public class MainPage {
    private final SelenideElement loginButton = $(".user-info .button"),
            createAccountButton = $(".right .pull-right ");
    private final ElementsCollection buttonName = $$("#main-nav .top-menu-entry");

    @Step("Открываем главную страницу")
    public MainPage openMainPage() {
            open("");
            loginButton.shouldHave(text("LOG IN"));
        return this;
    }

    @Step("Проверяем выпадающее меню элемента")
    public MainPage checkDropdownMenu(String dropdownButtonName, List<String> dropdownMenuList) {
        buttonName.findBy(text(dropdownButtonName)).hover();
        buttonName.findBy(text(dropdownButtonName)).parent().$$(".collapsed li").shouldHave(texts(dropdownMenuList));
        return this;
    }

    @Step("Нажимаем на кнопку 'Создать аккаунт'")
    public MainPage clickOnCreateAccountButton() {
            createAccountButton.click();
            webdriver().shouldHave(url("https://www.postcrossing.com/signup"));
        return this;
    }
}


