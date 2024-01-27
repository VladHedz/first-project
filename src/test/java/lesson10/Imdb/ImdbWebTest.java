package lesson10.Imdb;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;

import config.driver.Browser;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.Imdb.TopChart;

import static com.codeborne.selenide.Selenide.*;
import static pages.Imdb.Film.*;

public class ImdbWebTest {
    private static final String Imdb = config.PageUrl.Imdb.PageUrl.IMDB_URL.url;
    private TopChart topChart;

    @BeforeTest
    public void setUpBrowser() {
        Browser.setBrowser();
        topChart = new TopChart();
    }

    @Test(dataProvider = "filmTitlesProvider")
    public void testFilmTitles(String filmTitle, String hrefValue, String year, String fullRating) {

        String filmName = filmTitle.substring(3).trim();
        String rating = fullRating.substring(0, Math.min(fullRating.length(), 3));

        open(hrefValue);
        FILM_NAME.shouldHave(Condition.text(filmName));
        YEAR.shouldHave(Condition.text(year));
        RATING.shouldHave(Condition.text(rating));

        //Додавав це для дебагу але залишу на провсяк випадок
        System.out.println("Film Name: " + filmName);
        System.out.println("Href Value: " + hrefValue);
        System.out.println("Year: " + year);
        System.out.println("Rating: " + rating);
    }

    @DataProvider(name = "filmTitlesProvider")
    public Object[][] filmTitlesProvider() {
        open(Imdb + "/chart/top/");
        ElementsCollection titles = topChart.getFirst100FilmTitles();
        ElementsCollection hrefs = topChart.getFirst100FilmHref();
        ElementsCollection years = topChart.getFirst100FilmYears();
        ElementsCollection ratings = topChart.getFirst100FilmRatings();

        Object[][] data = new Object[titles.size()][4];

        for (int i = 0; i < titles.size(); i++) {
            data[i][0] = titles.get(i).getText();
            data[i][1] = hrefs.get(i).getAttribute("href");
            data[i][2] = years.get(i).getText();
            data[i][3] = ratings.get(i).getText();
        }

        return data;
    }

    @AfterTest
    public void tearDownBrowser() {
        Browser.closeBrowser();
    }
}