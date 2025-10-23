package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:auth.properties"
})
public interface AuthConfig extends Config {

    @Key("selenoid.getSelenoidUsername")
    String getSelenoidUsername();

    @Key("selenoid.getSelenoidPassword")
    String getSelenoidPassword();

}