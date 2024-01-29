package pages.Yakaboo;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class BookPage {
    private final SelenideElement BOOK_IMAGE = $("[class='slide__item']");
    private final SelenideElement PRESELECT_TYPE = $("[class='ui-btn-format option-button selected']");
    private final SelenideElement FORMAT_TEXT_ELEMENT = PRESELECT_TYPE.$(".format__text");
    private final SelenideElement PRICE_DISPLAY = PRESELECT_TYPE.$(".ui-price-display__main");
    private final SelenideElement NOT_AVAILABLE_BUTTON = $("[class='ui-btn-accept waiting-list button-accept']");

    public void checkBookPageIsLoaded() {
        BOOK_IMAGE.shouldBe(visible);
    }

    public void checkBookPrice() {
        String formatText = FORMAT_TEXT_ELEMENT.getText();

        if ("Паперова".equals(formatText)) {
            System.out.println("Ціна паперової книги: " + PRICE_DISPLAY.getText());
        } else if ("Електронна".equals(formatText)) {
            System.out.println("Паперова книга не доступна, але в наявності є електронна, ціна електронної книги: " + PRICE_DISPLAY.getText());
        } else {
            System.out.println("Невідомий формат книги.");
        }
    }

    public boolean checkBookAvailability() {
        boolean isBookAvailable = !NOT_AVAILABLE_BUTTON.exists();
        System.out.println(isBookAvailable ? "Книга доступна для покупки." : "Книга не доступна для покупки.");
        return isBookAvailable;
    }
}