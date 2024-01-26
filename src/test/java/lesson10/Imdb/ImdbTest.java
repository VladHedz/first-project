package lesson10.Imdb;

/*import java.io.IOException;
import org.testng.annotations.Test;

public class ImdbTest {

    private final ImdbApi imdbApi = new ImdbApi();

    @Test
    public void imdbTop100ChartTest() throws IOException {
        var top100 = imdbApi.getTop100Films();
        System.out.println(top100);
    }
}*/

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import config.driver.Browser;
import org.testng.annotations.*;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import static com.codeborne.selenide.Selenide.*;

public class ImdbTest {

    private final ImdbApi imdbApi = new ImdbApi();

    @BeforeTest
    public void setUp() {
        Browser.setBrowser();
    }

    @Test(dataProvider = "top100DataProvider")
    public void imdbTop100ChartTest(String filmTitle, String filmLink) {
        open(filmLink);
        SelenideElement filmTitleElement = $("[data-testid='hero__primary-text']").should(Condition.exist);
        filmTitleElement.shouldHave(Condition.text(filmTitle));
    }

    @DataProvider(name = "top100DataProvider")
    public Object[][] top100DataProvider() throws IOException {
        List<Map.Entry<String, String>> top100 = imdbApi.getTop100Films();
        Object[][] data = new Object[top100.size()][2];

        for (int i = 0; i < top100.size(); i++) {
            Map.Entry<String, String> entry = top100.get(i);
            data[i][0] = entry.getKey();
            data[i][1] = entry.getValue();
        }
        return data;
    }

    @AfterTest
    public void tearDownBrowser() {
        Browser.closeBrowser();
    }
}