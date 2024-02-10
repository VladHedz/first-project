package lesson10.Trello;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.*;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.Trello.TrelloPage;
import config.driver.Browser;


public class Trello {
    private static final String LOGIN_PAGE_TRELLO = config.pageUrl.Trello.PageUrl.LOGIN_PAGE_TRELLO.url;
    private TrelloPage trelloPage = new TrelloPage();

    @BeforeTest
    public void setUpBrowser() {
        Browser.setBrowser();
        trelloPage = new TrelloPage();
    }

    @Test(priority = 1, description = "Check login")
    @Severity(value = SeverityLevel.BLOCKER)
    @Owner("Vlad")
    @Feature("Login")
    @Description("Check login page")
    @Issue("TR-1980")
    @TmsLink("TRL-12211")
    @Link("trello.com")
    public void testLogin() {
        Selenide.open(String.valueOf(LOGIN_PAGE_TRELLO));
        trelloPage.loginPageIsLoaded();
        trelloPage.setEmail();
        trelloPage.clickLoginButton();
        trelloPage.setPassword();
        trelloPage.clickLoginButton();

    }

    @Test(priority = 2, dependsOnMethods = "testLogin", description = "Authorization")
    @Severity(value = SeverityLevel.BLOCKER)
    @Owner("Vlad")
    @Feature("Login")
    @Description("Check login")
    @Issue("TR-1980")
    @TmsLink("TRL-12212")
    @Link("trello.com")
    public void testNavigateToDashboard() {
        trelloPage.switchToTrelloBoard();
        trelloPage.switchToMyBoard();
        trelloPage.checkBoardIsDisplay();
    }

    @Test(priority = 3, dependsOnMethods = "testNavigateToDashboard", description = "Open board")
    @Severity(value = SeverityLevel.CRITICAL)
    @Owner("Vlad")
    @Feature("Login")
    @Description("Check created list")
    @Issue("TR-1980")
    @TmsLink("TRL-12213")
    @Link("trello.com")
    public void testCreateList() {
        trelloPage.clickAddNewList();
        trelloPage.setListName();
        trelloPage.createNewList();
        trelloPage.checkListCreated();

    }

    @Test(priority = 4, dependsOnMethods = "testCreateList", retryAnalyzer = RetryAnalyzer.class, description = "Created list")
    @Severity(value = SeverityLevel.BLOCKER)
    @Owner("Vlad")
    @Feature("Login")
    @Description("Check create card")
    @Issue("TR-1980")
    @TmsLink("TRL-12212")
    @Link("trello.com")
    @Flaky
    public void testCreateCard() {
        trelloPage.clickAddNewCard();
        trelloPage.setCardName();
        trelloPage.createNewCard();
        trelloPage.checkCardCreated();
    }

    @Test(priority = 5, dependsOnMethods = "testCreateCard", retryAnalyzer = RetryAnalyzer.class, description = "Creat card")
    @Severity(value = SeverityLevel.BLOCKER)
    @Owner("Vlad")
    @Feature("Login")
    @Description("Check edit description")
    @Issue("TR-1980")
    @TmsLink("TRL-12712")
    @Link("trello.com")
    @Flaky
    public void testAddDescription() {
        trelloPage.clickOnCard();
        trelloPage.checkCardIsOpen();
        trelloPage.setDescription();
        trelloPage.clickSaveDescriptionButton();
    }

    @Test(priority = 6, dependsOnMethods = "testAddDescription", description = "Change description card")
    @Severity(value = SeverityLevel.BLOCKER)
    @Owner("Vlad")
    @Feature("Login")
    @Description("Check add new comment")
    @Issue("TR-1980")
    @TmsLink("TRL-12215")
    @Link("trello.com")
    public void testAddComment() {
        trelloPage.clickPreviewComment();
        trelloPage.setComment();
        trelloPage.clickSaveCommentButton();
    }

    @Test(priority = 7, dependsOnMethods = "testAddComment", retryAnalyzer = RetryAnalyzer.class, description = "Delete card")
    @Severity(value = SeverityLevel.BLOCKER)
    @Owner("Vlad")
    @Feature("Login")
    @Description("Check flow delete card")
    @Issue("TR-1980")
    @TmsLink("TRL-100212")
    @Link("trello.com")
    @Flaky
    public void testDeleteCard() {
        trelloPage.clickArchiveCardButton();
        trelloPage.clickDeleteCardButton();
        trelloPage.clickConfirmDeleteCardButton();
    }

    @Test(priority = 8, dependsOnMethods = "testDeleteCard", retryAnalyzer = RetryAnalyzer.class, description = "Delete list")
    @Severity(value = SeverityLevel.BLOCKER)
    @Owner("Vlad")
    @Feature("Login")
    @Description("Check flow delete list")
    @Issue("TR-1980")
    @TmsLink("TRL-122908812")
    @Link("trello.com")
    @Flaky
    public void testDeleteList() {
        trelloPage.clickEditListButton();
        trelloPage.clickArchiveListButton();
        trelloPage.checkListDeleted();
    }

    @AfterTest
    public void tearDownBrowser() {
        Browser.closeBrowser();
    }
}