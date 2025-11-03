package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.util.List;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;

public class PostalMonitorPage {
    private final SelenideElement header = $("h1"),
                        countryCodeSelector = $("#country_code"),
                        header2 = $("#postal-monitor-changes h2");
    private final ElementsCollection sendType = $$("#nav-tabs a"),
    outgoingCountriesList = $$("#postal-monitor-changes .destination-list li");

    @Step("Открываем страницу Postal Monitor")
    public PostalMonitorPage openPostalMonitorPage() {
            open("/postal-monitor");
            header.shouldHave(text("Postal Monitor"));
        return this;
    }

    @Step("Выбираем страну")
    public PostalMonitorPage chooseCountry(String countryCode) {
            countryCodeSelector.selectOptionByValue(countryCode);
            webdriver().shouldHave(url("https://www.postcrossing.com/postal-monitor/" + countryCode));
        return this;
    }

    @Step("Выбираем тип отправки")
    public PostalMonitorPage chooseSendingType(String sendingType) {
            sendType.findBy(text(sendingType)).click();
        return this;
    }

    @Step("Проверяем список недоступных стран")
    public PostalMonitorPage checkNonAvailableForPostCountries(String header2text, List<String> countries) {
            header2.shouldHave(text(header2text));
            outgoingCountriesList.shouldHave(texts(countries));
        return this;
    }

}
