package pages.Imdb;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class Film {
    public static final SelenideElement FILM_NAME = $("[data-testid='hero__primary-text']");
    public static final SelenideElement YEAR = $("ul.ipc-inline-list li.ipc-inline-list__item a[href*='/releaseinfo']");
    public static final SelenideElement RATING = $("[data-testid='hero-rating-bar__aggregate-rating__score']");
}
