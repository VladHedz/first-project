package pages.Trello;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

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

    public void setEmail() {
        USERNAME_INPUT.shouldBe(visible).setValue("usernave");
    }

    public void setPassword() {
        PASSWORD_INPUT.shouldBe(visible).setValue("password");
    }

    public void clickLoginButton() {
        LOGIN_BUTTON.shouldBe(visible).click();
    }

    public void switchToTrelloBoard() {
        TRELLO_BOARD.shouldBe(visible).click();
    }

    public void switchToMyBoard() {
        MY_BOARD.shouldBe(visible).click();
    }

    public void checkBoardIsDisplay() {
        ADD_NEW_LIST_BUTTON.shouldBe(visible);
    }

    public void clickAddNewList() {
        ADD_NEW_LIST_BUTTON.shouldBe(visible).click();
    }

    public void setListName() {
        NAME_NEW_LIST_INPUT.shouldBe(visible).setValue("New List");
    }

    public void createNewList() {
        CREATE_NEW_LIST_BUTTON.shouldBe(visible).click();
    }

    public void checkListCreated() {
        LIST_TITLE.shouldBe(text("New List"));
    }

    public void clickAddNewCard() {
        ADD_NEW_CARD_BUTTON.shouldBe(visible).click();
    }

    public void setCardName() {
        NAME_NEW_CARD_INPUT.shouldBe(visible).setValue("New Card");
    }

    public void createNewCard() {
        CREATE_NEW_CARD_BUTTON.shouldBe(visible).click();
    }

    public void checkCardCreated() {
        CARD_NAME.shouldBe(text("New Card"));
    }

    public void clickOnCard() {
        CARD_NAME.shouldBe(visible).click();
    }

    public void checkCardIsOpen() {
        DESCRIPTION_INPUT.shouldBe(visible).setValue("TEST DESCRIPTION");
    }

    public void setDescription() {
        DESCRIPTION_INPUT.shouldBe(visible).setValue("TEST DESCRIPTION");
    }

    public void clickSaveDescriptionButton() {
        SAVE_DESCRIPTION_BUTTON.shouldBe(visible).click();
    }

    public void clickPreviewComment() {
        PREVIEW_COMMENT_INPUT.shouldBe(visible).click();
    }

    public void setComment() {
        COMMENT_INPUT.last().lastChild().setValue("TEST COMMENT");
    }

    public void clickSaveCommentButton() {
        SAVE_COMMENT_BUTTON.shouldBe(visible).click();
    }

    public void clickArchiveCardButton() {
        ARCHIVE_CARD_BUTTON.shouldBe(visible).click();
    }

    public void clickDeleteCardButton() {
        DELETE_CARD_BUTTON.shouldBe(visible).click();
    }

    public void clickConfirmDeleteCardButton() {
        CONFIRM_DELETE_CARD_BUTTON.shouldBe(visible).click();
    }

    public void clickEditListButton() {
        EDIT_LIST_BUTTON.shouldBe(visible).click();
    }

    public void clickArchiveListButton() {
        ARCHIVE_LIST_BUTTON.shouldBe(visible).click();
    }

    public void checkListDeleted() {
        CREATED_LIST.shouldBe(hidden);
    }
}