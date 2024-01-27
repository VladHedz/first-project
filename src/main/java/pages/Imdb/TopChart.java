package pages.Imdb;

import com.codeborne.selenide.ElementsCollection;

import static com.codeborne.selenide.Selenide.$$;

public class TopChart {
    private static final ElementsCollection TITLE = $$(".cli-children .ipc-title__text");
    private static final ElementsCollection HREF = $$(".cli-children .ipc-title-link-wrapper");
    private static final ElementsCollection YEAR = $$("span.cli-title-metadata-item:first-child");
    private static final ElementsCollection FULL_RATING = $$("[aria-label*='IMDb rating']");

    public ElementsCollection getFirst100FilmTitles() {
        return TITLE.first(100);
    }

    public ElementsCollection getFirst100FilmHref() {
        return HREF.first(100);
    }

    public ElementsCollection getFirst100FilmYears() {
        return YEAR.first(100);
    }

    public ElementsCollection getFirst100FilmRatings() {
        return FULL_RATING.first(100);
    }
}