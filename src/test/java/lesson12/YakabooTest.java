package lesson12;

import config.driver.Browser;
import io.qameta.allure.*;
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

    @Test(priority = 1, description = "Open welcome page")
    @Severity(value = SeverityLevel.BLOCKER)
    @Owner("Vlad")
    @Feature("Welcome page")
    @Description("Check welcome page")
    @Issue("FP-1")
    @TmsLink("AQA-111")
    @Link("google.com")
    public void openWelcomePage() {
        welcomePage.openWelcomePage();
    }

    @Test(priority = 2, description = "Set book name")
    @Owner("Vlad")
    @Feature("Search page")
    @Description("Set book name")
    @Issue("FP-2")
    @TmsLink("AQA-211")
    @Severity(value = SeverityLevel.CRITICAL)
    @Flaky
    public void checkSearchBook() {
        welcomePage.setBookName("Василь Симоненко: Задивляюсь у твої зіниці");
        welcomePage.checkSearchResult();
        welcomePage.clickSearchButton();
    }

    @Test(priority = 3, description = "Choose book")
    @Owner("Vlad")
    @Feature("Search page")
    @Description("Check choosed book")
    @Issue("FP-3")
    @TmsLink("AQA-113")
    @Severity(value = SeverityLevel.CRITICAL)
    public void checkChooseBook() {
        searchPage.checkSearchPageIsLoaded();
        searchPage.chooseBook();
    }

    @Test(priority = 4, description = "Check available book")
    @Owner("Vlad")
    @Feature("Book page")
    @Description("Check available book")
    @Issue("FP-4")
    @TmsLink("AQA-151")
    @Severity(value = SeverityLevel.NORMAL)
    public void checkBookAvailable() {
        bookPage.checkBookPageIsLoaded();
        isBookAvailable = bookPage.checkBookAvailability();
    }

    @Test(priority = 5, description = "Check price book")
    @Owner("Vlad")
    @Feature("Book page")
    @Description("Check price")
    @Issue("FP-5")
    @TmsLink("AQA-1101011")
    @Severity(value = SeverityLevel.MINOR)
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