package pages.SwagLabs;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class CheckoutCompletePage {
    private static final SelenideElement COMPLETE_HEADER = $("[class='complete-header']");

    public void checkOrderConfirmation() {
        COMPLETE_HEADER.shouldHave(text("Thank you for your order!"));
    }
}