package pages.Trello;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;


public class TrelloPage {

    private static final SelenideElement USERNAME_INPUT = $("[id='username']");
    private static final SelenideElement PASSWORD_INPUT = $("[id='password']");
    private static final SelenideElement LOGIN_BUTTON = $("[id='login-submit']");
    private static final SelenideElement HEADER = $("[data-testid='header']");
    private static final SelenideElement TRELLO_BOARD = $("[class='sc-gNJABI bQntau']");
    private static final SelenideElement MY_BOARD = $("[title='DraftBoard']");
    private static final SelenideElement ADD_NEW_LIST_BUTTON = $("[data-testid='list-composer-button']");
    private static final SelenideElement NAME_NEW_LIST_INPUT = $("[data-testid='list-name-textarea']");
    private static final SelenideElement CREATE_NEW_LIST_BUTTON = $("[data-testid='list-composer-add-list-button']");
    private static final SelenideElement LIST_TITLE = $("[data-testid='list-name']");
    private static final SelenideElement CREATED_LIST = $("[data-testid='list']");
    private static final SelenideElement ADD_NEW_CARD_BUTTON = $("[data-testid='list-add-card-button']");
    private static final SelenideElement NAME_NEW_CARD_INPUT = $("[data-testid='list-card-composer-textarea']");
    private static final SelenideElement CREATE_NEW_CARD_BUTTON = $("[data-testid='list-card-composer-add-card-button']");
    private static final SelenideElement CARD_NAME = $("[data-testid='card-name']");
    private static final SelenideElement DESCRIPTION_INPUT = $("[id='ak-editor-textarea']");
    private static final SelenideElement SAVE_DESCRIPTION_BUTTON = $("[class^='confirm']");
    private static final SelenideElement PREVIEW_COMMENT_INPUT = $("[data-testid='card-back-new-comment-input-skeleton']");
    private static final ElementsCollection COMMENT_INPUT = $$("[id='ak-editor-textarea']");
    private static final SelenideElement SAVE_COMMENT_BUTTON = $("[data-testid='card-back-comment-save-button']");
    private static final SelenideElement ARCHIVE_CARD_BUTTON = $("[class*='js-archive-card']");
    private static final SelenideElement DELETE_CARD_BUTTON = $("[class*='js-delete-card']");
    private static final SelenideElement CONFIRM_DELETE_CARD_BUTTON = $("[class*='nch-button--danger']");
    private static final SelenideElement EDIT_LIST_BUTTON = $("[data-testid='list-edit-menu-button']");
    private static final SelenideElement ARCHIVE_LIST_BUTTON = $("[class='js-close-list']");


    public void loginPageIsLoaded() {
        Configuration.timeout = 15000;
        HEADER.shouldBe(visible);
    }

    @Step("Set email")
    public void setEmail() {
        USERNAME_INPUT.shouldBe(visible).setValue("username");
    }

    @Step("Set password")
    public void setPassword() {
        PASSWORD_INPUT.shouldBe(visible).setValue("password");
    }

    @Step("Click login button")
    public void clickLoginButton() {
        LOGIN_BUTTON.shouldBe(visible).click();
    }

    @Step("Switch board")
    public void switchToTrelloBoard() {
        TRELLO_BOARD.shouldBe(visible).click();
    }

    @Step("Check board switched")
    public void switchToMyBoard() {
        MY_BOARD.shouldBe(visible).click();
    }

    @Step("Check draft board is display")
    public void checkBoardIsDisplay() {
        ADD_NEW_LIST_BUTTON.shouldBe(visible);
    }

    @Step("Click add new list")
    public void clickAddNewList() {
        ADD_NEW_LIST_BUTTON.shouldBe(visible).click();
    }

    @Step("Set list name")
    public void setListName() {
        NAME_NEW_LIST_INPUT.shouldBe(visible).setValue("New List");
    }

    @Step("Create new list")
    public void createNewList() {
        CREATE_NEW_LIST_BUTTON.shouldBe(visible).click();
    }

    @Step("Check list created")
    public void checkListCreated() {
        LIST_TITLE.shouldBe(text("New List"));
    }

    @Step("Click add new card")
    public void clickAddNewCard() {
        ADD_NEW_CARD_BUTTON.shouldBe(visible).click();
    }

    @Step("Set card name")
    public void setCardName() {
        NAME_NEW_CARD_INPUT.shouldBe(visible).setValue("New Card");
    }

    @Step("Create new card")
    public void createNewCard() {
        CREATE_NEW_CARD_BUTTON.shouldBe(visible).click();
    }

    @Step("Check card created")
    public void checkCardCreated() {
        CARD_NAME.shouldBe(text("New Card"));
    }

    @Step("Cleck on card")
    public void clickOnCard() {
        CARD_NAME.shouldBe(visible).click();
    }

    @Step("Check card is visible")
    public void checkCardIsOpen() {
        DESCRIPTION_INPUT.shouldBe(visible).setValue("TEST DESCRIPTION");
    }

    @Step("Set description card")
    public void setDescription() {
        DESCRIPTION_INPUT.shouldBe(visible).setValue("TEST DESCRIPTION");
    }

    @Step("Save new description")
    public void clickSaveDescriptionButton() {
        SAVE_DESCRIPTION_BUTTON.shouldBe(visible).click();
    }

    @Step("Click on comment input")
    public void clickPreviewComment() {
        PREVIEW_COMMENT_INPUT.shouldBe(visible).click();
    }

    @Step("Set new comment")
    public void setComment() {
        COMMENT_INPUT.last().lastChild().setValue("TEST COMMENT");
    }

    @Step("Save new comment")
    public void clickSaveCommentButton() {
        SAVE_COMMENT_BUTTON.shouldBe(visible).click();
    }

    @Step("Click archive card button")
    public void clickArchiveCardButton() {
        ARCHIVE_CARD_BUTTON.shouldBe(visible).click();
    }

    @Step("Click delete card button")
    public void clickDeleteCardButton() {
        DELETE_CARD_BUTTON.shouldBe(visible).click();
    }

    @Step("Confirm delete card")
    public void clickConfirmDeleteCardButton() {
        CONFIRM_DELETE_CARD_BUTTON.shouldBe(visible).click();
    }

    @Step("Click edit list button")
    public void clickEditListButton() {
        EDIT_LIST_BUTTON.shouldBe(visible).click();
    }

    @Step("Click archive list button")
    public void clickArchiveListButton() {
        ARCHIVE_LIST_BUTTON.shouldBe(visible).click();
    }

    @Step("Check list deleted")
    public void checkListDeleted() {
        CREATED_LIST.shouldBe(hidden);
    }
}