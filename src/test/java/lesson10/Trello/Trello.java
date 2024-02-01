package lesson10.Trello;

import com.codeborne.selenide.Selenide;
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

    @Test(priority = 1)
    public void testLogin() {
        Selenide.open(String.valueOf(LOGIN_PAGE_TRELLO));
        trelloPage.loginPageIsLoaded();
        trelloPage.setEmail();
        trelloPage.clickLoginButton();
        trelloPage.setPassword();
        trelloPage.clickLoginButton();

    }

    @Test(priority = 2, dependsOnMethods = "testLogin")
    public void testNavigateToDashboard() {
        trelloPage.switchToTrelloBoard();
        trelloPage.switchToMyBoard();
        trelloPage.checkBoardIsDisplay();
    }

    @Test(priority = 3, dependsOnMethods = "testNavigateToDashboard")
    public void testCreateList() {
        trelloPage.clickAddNewList();
        trelloPage.setListName();
        trelloPage.createNewList();
        trelloPage.checkListCreated();

    }

    @Test(priority = 4, dependsOnMethods = "testCreateList", retryAnalyzer = RetryAnalyzer.class)
    public void testCreateCard() {
        trelloPage.clickAddNewCard();
        trelloPage.setCardName();
        trelloPage.createNewCard();
        trelloPage.checkCardCreated();
    }

    @Test(priority = 5, dependsOnMethods = "testCreateCard", retryAnalyzer = RetryAnalyzer.class)
    public void testAddDescription() {
        trelloPage.clickOnCard();
        trelloPage.checkCardIsOpen();
        trelloPage.setDescription();
        trelloPage.clickSaveDescriptionButton();
    }

    @Test(priority = 6, dependsOnMethods = "testAddDescription")
    public void testAddComment() {
        trelloPage.clickPreviewComment();
        trelloPage.setComment();
        trelloPage.clickSaveCommentButton();
    }

    @Test(priority = 7, dependsOnMethods = "testAddComment", retryAnalyzer = RetryAnalyzer.class)
    public void testDeleteCard() {
        trelloPage.clickArchiveCardButton();
        trelloPage.clickDeleteCardButton();
        trelloPage.clickConfirmDeleteCardButton();
    }

    @Test(priority = 8, dependsOnMethods = "testDeleteCard", retryAnalyzer = RetryAnalyzer.class)
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