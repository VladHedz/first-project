package config.driver;

import com.codeborne.selenide.SelenideConfig;
import com.codeborne.selenide.SelenideDriver;
import com.codeborne.selenide.TextCheck;
import com.codeborne.selenide.WebDriverRunner;

public class Browser {

    public static void setBrowser() {
        var selenideConfig = new SelenideConfig();
        selenideConfig.browser("chrome");
        selenideConfig.browserSize("1920x1080");
        selenideConfig.pageLoadStrategy("normal");
        selenideConfig.pageLoadTimeout(15000);
        selenideConfig.timeout(15000);
        selenideConfig.textCheck(TextCheck.FULL_TEXT);

        var selenideDriver = new SelenideDriver(selenideConfig);

        WebDriverRunner.setWebDriver(selenideDriver.getAndCheckWebDriver());
    }

    public static void closeBrowser() {
        WebDriverRunner.closeWebDriver();
    }
}