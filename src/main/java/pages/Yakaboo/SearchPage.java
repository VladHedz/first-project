package pages.Yakaboo;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class SearchPage {

    private final SelenideElement searchPage = $("[class='product-listing view-category expanded']");
    private final SelenideElement titleBook = $("[class='ui-card-title category-card__name']");

    public void checkSearchPageIsLoaded() {
        searchPage.shouldBe(visible);
    }

    public void chooseBook() {
        titleBook.shouldBe(visible, enabled).shouldHave(text("Задивляюсь у твої зіниці")).click();
    }
}