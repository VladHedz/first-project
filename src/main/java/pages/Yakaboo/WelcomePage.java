package pages.Yakaboo;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class WelcomePage {


    private static final SelenideElement SEARCH_FORM = $("[class='ui-search-form-input']");
    private static final SelenideElement SEARCH_INPUT = $("[type='search']");
    private static final SelenideElement SEARCH_RESULT = $("[class='scroll-area custom-scroll']");

    private static final SelenideElement SEARCH_BUTTON = $("[class='ui-btn-primary']");


    public void checkWelcomePageIsLoaded() {
        SEARCH_FORM.shouldBe(visible);
    }

    public void setBookName() {
        SEARCH_INPUT.shouldBe(visible).setValue("Василь Симоненко: Задивляюсь у твої зіниці");
    }

    public void checkSearchResult() {
        SEARCH_RESULT.shouldBe(visible);
    }

    public void clickSearchButton() {
        SEARCH_BUTTON.shouldBe(visible, enabled).shouldHave(text("Знайти")).click();
    }

}