package ui;

import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import pages.MainPage;

import java.util.List;
import java.util.stream.Stream;

import static io.qameta.allure.SeverityLevel.MINOR;
import static io.qameta.allure.SeverityLevel.NORMAL;

@Feature("Главная страница")
public class MainPageTests extends TestBase {
    MainPage mainPage = new MainPage();

    static Stream<Arguments> checkDropdownMenuTest() {
        return Stream.of(
                Arguments.of("Explore", List.of("Countries", "Gallery", "Rankings", "Stats", "Shop", "Search", "Meetups", "Postal Monitor", "Other links")),
                Arguments.of("Help", List.of("F.A.Q.", "Contact")),
                Arguments.of("About", List.of("Postcrossing", "Community Guidelines", "Logo Usage Guidelines", "Advertising", "Ecological footprint", "Impressum", "Privacy Policy", "Terms of Service"))
                );
    }

    @ParameterizedTest(name = "В выпадающем меню кнопки {0} содержатся элементы {1}")
    @DisplayName("Проверка верхних выпадающих меню")
    @MethodSource
    @Owner("KharitonovaES")
    @Severity(MINOR)
    void checkDropdownMenuTest(String dropdownButtonName, List<String> dropdownMenuList) {
        mainPage.openMainPage()
                .checkDropdownMenu(dropdownButtonName, dropdownMenuList);
    }

    @Test
    @DisplayName("Проверка перехода на страницу регистрации по кнопке 'Create an account' на главной странице")
    @Owner("KharitonovaES")
    @Severity(NORMAL)
    void createAccountButtonTest() {
        mainPage.openMainPage()
                .clickOnCreateAccountButton();
    }
}
