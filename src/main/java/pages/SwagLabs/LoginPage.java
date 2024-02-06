package pages.SwagLabs;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    private static final String SWAG_LABS_URL = config.pageUrl.SwagLabs.pageUrl.SWAG_LABS_URL.url;
    private static final SelenideElement USERNAME_INPUT = $("[data-test='username']");
    private static final SelenideElement PASSWORD_INPUT = $("[data-test='password']");
    private static final SelenideElement SUBMIT_BUTTON = $("[data-test='login-button']");

    public void openLoginPage() {
        Selenide.open(SWAG_LABS_URL);
        USERNAME_INPUT.shouldBe(visible);
    }

    public void setUserName(String userName) {
        USERNAME_INPUT.shouldBe(visible).setValue(userName);
    }

    public void setPassword(String password) {
        PASSWORD_INPUT.shouldBe(visible).setValue(password);
    }

    public void clickOnLoginButton() {
        SUBMIT_BUTTON.shouldBe(visible).click();
    }
}