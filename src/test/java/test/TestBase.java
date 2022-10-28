package test;

import com.codeborne.selenide.logevents.SelenideLogger;
import config.ConfigReader;
import config.ProjectConfiguration;
import config.web.WebConfig;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {
    private static final WebConfig webConfig = ConfigReader.Instance.read();

    @BeforeAll
    public static void setUp() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        ProjectConfiguration projectConfiguration = new ProjectConfiguration (webConfig);
        projectConfiguration.webConfig();
        projectConfiguration.apiConfig();
    }
}