package pages.Yakaboo;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class BookPage {
    private final SelenideElement bookImage = $("[class='slide__item']");
    private final SelenideElement preselectType = $("[class='ui-btn-format option-button selected']");
    private final SelenideElement formatTextElement = preselectType.$(".format__text");
    private final SelenideElement priceDisplay = preselectType.$(".ui-price-display__main");
    private final SelenideElement notAvailableButton = $("[class='ui-btn-accept waiting-list button-accept']");

    public void checkBookPageIsLoaded() {
        bookImage.shouldBe(visible);
    }

    public void checkBookPrice() {
        String formatText = formatTextElement.getText();

        if ("Паперова".equals(formatText)) {
            System.out.println("Ціна паперової книги: " + priceDisplay.getText());
        } else if ("Електронна".equals(formatText)) {
            System.out.println("Паперова книга не доступна, але в наявності є електронна, ціна електронної книги: " + priceDisplay.getText());
        } else {
            System.out.println("Невідомий формат книги.");
        }
    }

    public boolean checkBookAvailability() {
        boolean isBookAvailable = !notAvailableButton.exists();
        System.out.println(isBookAvailable ? "Книга доступна для покупки." : "Книга не доступна для покупки.");
        return isBookAvailable;
    }
}