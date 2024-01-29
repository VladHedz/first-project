package pages.Yakaboo;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class SearchPage {

    private final SelenideElement SEARCH_PAGE = $("[class='product-listing view-category expanded']");
    private final SelenideElement TITLE_BOOK = $("[class='ui-card-title category-card__name']");


    public void checkSearchPageIsLoaded() {
        SEARCH_PAGE.shouldBe(visible);
    }

    public void chooseBook() {
        TITLE_BOOK.shouldBe(visible, enabled).shouldHave(text("Задивляюсь у твої зіниці")).click();
    }
}