package lesson12;

import config.driver.Browser;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.Yakaboo.SearchPage;
import pages.Yakaboo.WelcomePage;
import pages.Yakaboo.BookPage;

public class YakabooTest {

    private WelcomePage welcomePage = new WelcomePage();
    private SearchPage searchPage = new SearchPage();
    private BookPage bookPage = new BookPage();

    private boolean isBookAvailable;

    @BeforeTest
    public void setUpBrowser() {
        Browser.setBrowser();
    }

    @Test(priority = 1)
    public void openWelcomePage() {
        welcomePage.openWelcomePage();
    }

    @Test(priority = 2)
    public void checkSearchBook() {
        welcomePage.setBookName("Василь Симоненко: Задивляюсь у твої зіниці");
        welcomePage.checkSearchResult();
        welcomePage.clickSearchButton();
    }

    @Test(priority = 3)
    public void checkChooseBook() {
        searchPage.checkSearchPageIsLoaded();
        searchPage.chooseBook();
    }

    @Test(priority = 4)
    public void checkBookAvailable() {
        bookPage.checkBookPageIsLoaded();
        isBookAvailable = bookPage.checkBookAvailability();
    }

    @Test(priority = 5)
    public void checkPriceBook() {
        if (isBookAvailable) {
            bookPage.checkBookPrice();
        } else {
            System.out.println("Тест на перевірку ціни не виконується, оскільки книга НЕ доступна для покупки.");
        }
    }

    @AfterTest(alwaysRun = true)
    public void tearDownBrowser() {
        Browser.closeBrowser();
    }
}