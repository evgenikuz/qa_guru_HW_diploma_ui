package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;

import java.util.List;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;
import static io.qameta.allure.Allure.step;

public class PostalMonitorPage {
    private final SelenideElement header = $("h1"),
                        countryCodeSelector = $("#country_code"),
                        header2 = $("#postal-monitor-changes h2");
    private final ElementsCollection sendType = $$("#nav-tabs a"),
    outgoingCountriesList = $$("#postal-monitor-changes .destination-list li");

    public PostalMonitorPage openPostalMonitorPage() {
        step("Открываем страницу Postal Monitor", () -> {
            open("/postal-monitor");
            header.shouldHave(text("Postal Monitor"));
        });
        return this;
    }

    public PostalMonitorPage chooseCountry(String countryCode) {
        step("Выбираем страну", () -> {
            countryCodeSelector.selectOptionByValue(countryCode);
            webdriver().shouldHave(url("https://www.postcrossing.com/postal-monitor/" + countryCode));
        });
        return this;
    }

    public PostalMonitorPage chooseSendingType(String sendingType) {
        step("Выбираем тип отправки", () -> {
            sendType.findBy(text(sendingType)).click();
        });
        return this;
    }

    public PostalMonitorPage checkNonAvailableForPostCountries(String header2text, List<String> countries) {
        step("Проверяем список недоступных стран", () -> {
            header2.shouldHave(text(header2text));
            outgoingCountriesList.shouldHave(texts(countries));
        });
        return this;
    }

}
