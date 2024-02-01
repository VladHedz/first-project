package pages.Yakaboo;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class WelcomePage {

    private final SelenideElement searchForm = $("[class='ui-search-form-input']");
    private final SelenideElement searchInput = $("[type='search']");
    private final SelenideElement searchResult = $("[class='scroll-area custom-scroll']");
    private final SelenideElement searchButton = $("[class='ui-btn-primary']");
    private static final String WELCOME_PAGE_YAKABOO = config.pageUrl.Yakaboo.pageUrl.WELCOME_PAGE_YAKABOO.url;

    @Step("Open welcome page")
    public void openWelcomePage() {
        Selenide.open(WELCOME_PAGE_YAKABOO);
        searchForm.shouldBe(visible);
    }

    @Step("Set {bookName}")
    public void setBookName(String bookName) {
        searchInput.shouldBe(visible).setValue(bookName);
    }

    @Step("Check search result visible")
    public void checkSearchResult() {
        searchResult.shouldBe(visible);
    }

    @Step("Click on search button")
    public void clickSearchButton() {
        searchButton.shouldBe(visible, enabled).shouldHave(text("Знайти")).click();
    }
}