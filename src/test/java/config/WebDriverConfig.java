package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:${testLaunchType}.config"
})

public interface WebDriverConfig extends Config {

    @Key("base.url")
    @DefaultValue("https://www.postcrossing.com")
    String getBaseUrl();

    @Key("browser.name")
    @DefaultValue("chrome")
    String getBrowserName();

    @Key("browser.version")
    @DefaultValue("141")
    String getBrowserVersion();

    @Key("browser.size")
    @DefaultValue("1920x1080")
    String getBrowserSize();

    @Key("remote.url")
    String getRemoteUrl();
}
