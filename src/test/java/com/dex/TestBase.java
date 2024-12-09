package com.dex;

import com.codeborne.selenide.Configuration;
import com.dex.helpers.Attach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class TestBase {
    @BeforeAll
    static void setUp() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demo1.k3s.dex-it.ru";
        //   Configuration.baseUrl = "http://localhost.client-dev.template.online:3000/";

        // Конфигурация для удаленного запуска
//        Configuration.remote = "http://149.154.70.38:4444/wd/hub";
        //     Configuration.remote = System.getProperty("url");
        //    Configuration.browser = System.getProperty("browser");
        //  Configuration.browserVersion = System.getProperty("version");

//        DesiredCapabilities capabilities = new DesiredCapabilities();
//        capabilities.setCapability("enableVNC", true);
//        capabilities.setCapability("enableVideo", false);
//        Configuration.browserCapabilities = capabilities;
    }

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        closeWebDriver();
    }

}
