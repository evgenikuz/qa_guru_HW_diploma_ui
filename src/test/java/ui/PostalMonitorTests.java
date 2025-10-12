package ui;

import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import pages.PostalMonitorPage;

import java.util.List;
import java.util.stream.Stream;

import static io.qameta.allure.SeverityLevel.NORMAL;

public class PostalMonitorTests extends TestBase{
    PostalMonitorPage postalMonitorPage = new PostalMonitorPage();

    static Stream<Arguments> checkPostalMonitorShowsCorrectOutgoingInfo() {
        return Stream.of(
                Arguments.of("FO", "Faroe Islands", List.of("Canada", "Eritrea", "Haiti", "Syria", "Vanuatu", "Yemen")),
                Arguments.of("FR", "France", List.of("Canada", "Haiti", "Syria", "Vanuatu", "Yemen")),
                Arguments.of("MT", "Malta", List.of("Belarus", "Russia"))
        );
    }
    @ParameterizedTest(name = "Для страны {1} недоступна отправка почты в страны {2}")
    @DisplayName("Проверка работы Postal Monitor по отправке")
    @MethodSource
    @Owner("KharitonovaES")
    @Severity(NORMAL)
    void checkPostalMonitorShowsCorrectOutgoingInfo(String countryCode, String countryName, List<String> countriesList) {
        postalMonitorPage.openPostalMonitorPage()
                .chooseCountry(countryCode)
                .checkNonAvailableForPostCountries("Destinations not available from " + countryName, countriesList);
    }

    static Stream<Arguments> checkPostalMonitorShowsCorrectIncomingInfo() {
        return Stream.of(
                Arguments.of("BR", "Brazil", List.of("Bosnia-Herzegovina", "Jamaica", "Montserrat", "Myanmar", "Nepal", "Nicaragua")),
                Arguments.of("FR", "France", List.of("Myanmar", "Nicaragua", "Panama")),
                Arguments.of("CN", "China", List.of("Barbados", "Ecuador", "Montserrat", "Nicaragua", "Panama", "Trinidad and Tobago"))
        );
    }
    @ParameterizedTest(name = "Для страны {1} недоступно получение почты из стран {2}")
    @DisplayName("Проверка работы Postal Monitor по получению")
    @MethodSource
    @Owner("KharitonovaES")
    @Severity(NORMAL)
    void checkPostalMonitorShowsCorrectIncomingInfo(String countryCode, String countryName, List<String> countriesList) {
        postalMonitorPage.openPostalMonitorPage()
                .chooseCountry(countryCode)
                .chooseSendingType("Incoming")
                .checkNonAvailableForPostCountries("Countries that don't send to " + countryName, countriesList);
    }
}
