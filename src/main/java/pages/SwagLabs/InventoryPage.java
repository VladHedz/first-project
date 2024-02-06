package pages.SwagLabs;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class InventoryPage {

    private static final ElementsCollection INVENTORY_ITEMS = $$(".inventory_item");
    private static final String ADD_TO_CART_BUTTON_LOCATOR = "[data-test^='add-to-cart']";
    private static final String INVENTORY_ITEM_PRICE_LOCATOR = "[class='inventory_item_price']";
    private static final SelenideElement CART_BADGE = $("[class='shopping_cart_badge']");


    public void checkInventoryListIsVisible() {
        INVENTORY_ITEMS.forEach(item -> item.$(INVENTORY_ITEM_PRICE_LOCATOR).shouldBe(visible));
    }

    public void clickAddToCartForMatchingPrices(String[] prices) {
        for (String price : prices) {
            for (int i = 0; i < INVENTORY_ITEMS.size(); i++) {
                String itemPriceText = INVENTORY_ITEMS.get(i).$(INVENTORY_ITEM_PRICE_LOCATOR).getText();
                if (itemPriceText.equals(price)) {
                    INVENTORY_ITEMS.get(i).$(ADD_TO_CART_BUTTON_LOCATOR).click();
                }
            }
        }
    }


    public void clickOnCartBadge() {
        CART_BADGE.shouldBe(visible).click();
    }
}