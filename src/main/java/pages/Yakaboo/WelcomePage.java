package pages.Yakaboo;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class WelcomePage {

    private final SelenideElement SEARCH_FORM = $("[class='ui-search-form-input']");
    private final SelenideElement SEARCH_INPUT = $("[type='search']");
    private final SelenideElement SEARCH_RESULT = $("[class='scroll-area custom-scroll']");

    private final SelenideElement SEARCH_BUTTON = $("[class='ui-btn-primary']");
    private static final String WELCOME_PAGE_YAKABOO = config.pageUrl.Yakaboo.pageUrl.WELCOME_PAGE_YAKABOO.url;

    public void checkWelcomePageIsLoaded() {
        Selenide.open(WELCOME_PAGE_YAKABOO);
        SEARCH_FORM.shouldBe(visible);
    }

    public void setBookName(String bookName) {
        SEARCH_INPUT.shouldBe(visible).setValue(bookName);
    }

    public void checkSearchResult() {
        SEARCH_RESULT.shouldBe(visible);
    }

    public void clickSearchButton() {
        SEARCH_BUTTON.shouldBe(visible, enabled).shouldHave(text("Знайти")).click();
    }
}