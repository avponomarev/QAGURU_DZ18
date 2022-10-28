package config;

import config.web.WebConfig;
import io.restassured.RestAssured;
import org.openqa.selenium.remote.DesiredCapabilities;

public class ProjectConfiguration {
    private final WebConfig webConfig;

    public ProjectConfiguration(WebConfig webConfig) {
        this.webConfig = webConfig;
    }

    public void apiConfig() {
        RestAssured.baseURI = webConfig.baseUrl ();
    }

    public void webConfig() {
        com.codeborne.selenide.Configuration.baseUrl = webConfig.baseUrl ();
        com.codeborne.selenide.Configuration.browser = webConfig.browser ().toString ();
        com.codeborne.selenide.Configuration.browserVersion = webConfig.browserVersion ();
        com.codeborne.selenide.Configuration.browserSize = webConfig.browserSize ();
        if (webConfig.isRemote ()){
            com.codeborne.selenide.Configuration.remote = webConfig.remoteUrl ();
            DesiredCapabilities capabilities = new DesiredCapabilities ();
            capabilities.setCapability ("enableVNC", true);
            capabilities.setCapability ("enableVideo", true);
            com.codeborne.selenide.Configuration.browserCapabilities = capabilities;
        }
    }
}