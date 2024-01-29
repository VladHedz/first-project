package pages.SwagLabs;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class CartPage {

    private static final ElementsCollection CART_ITEMS = $$(".cart_item");
    private static final String INVENTORY_ITEM_PRICE_LOCATOR = "[class='inventory_item_price']";
    private static final SelenideElement CHECKOUT_BUTTON = $("[data-test='checkout']");

    public void checkCartItems() {
        CART_ITEMS.shouldHave(size(2));

        for (int i = 0; i < CART_ITEMS.size(); i++) {
            CART_ITEMS.get(i).$(INVENTORY_ITEM_PRICE_LOCATOR).shouldHave(text(i == 0 ? "$9.99" : "$7.99"));
        }
    }

    public void clickCheckoutButton() {
        CHECKOUT_BUTTON.shouldBe(visible).click();
    }
}