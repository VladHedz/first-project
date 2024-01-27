package lesson12;

import com.codeborne.selenide.Selenide;
import config.driver.Browser;
import config.pageUrl.Yakaboo;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.Yakaboo.SearchPage;
import pages.Yakaboo.WelcomePage;
import pages.Yakaboo.BookPage;

public class YakabooTest {
    private static final String WELCOME_PAGE_YAKABOO = Yakaboo.pageUrl.WELCOME_PAGE_YAKABOO.url;

    private WelcomePage welcomePage;
    private SearchPage searchPage;
    private BookPage bookPage;

    private boolean isBookAvailable;

    @BeforeTest
    public void setUpBrowser() {
        Browser.setBrowser();
        welcomePage = new WelcomePage();
        searchPage = new SearchPage();
        bookPage = new BookPage();
    }

    @Test(priority = 1)
    public void openWelcomePage() {
        Selenide.open(WELCOME_PAGE_YAKABOO);
        welcomePage.checkWelcomePageIsLoaded();
    }

    @Test(priority = 2)
    public void checkSearchBook() {
        welcomePage.setBookName();
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
        bookPage.checkBookAvailability();
        isBookAvailable = bookPage.isBookAvailable();
    }

    @Test(priority = 5)
    public void checkPriceBook() {
        if (isBookAvailable) {
            bookPage.checkBookPrice();
        } else {
            System.out.println("Тест на перевірку ціни не виконується, оскільки книга НЕ доступна для покупки.");
        }
    }

    @AfterTest
    public void tearDownBrowser() {
        Browser.closeBrowser();
    }
}