package pages.SwagLabs;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class CheckoutStepOne {

    private static final SelenideElement FIRST_NAME = $("[data-test='firstName']");
    private static final SelenideElement LAST_NAME = $("[data-test='lastName']");
    private static final SelenideElement POSTAL_CODE = $("[data-test='postalCode']");
    private static final SelenideElement CONTINUE_BUTTON = $("[data-test='continue']");

    public void setFirstName(String firstName) {
        FIRST_NAME.shouldBe(visible).setValue(firstName);
    }

    public void setLastName(String lastName) {
        LAST_NAME.shouldBe(visible).setValue(lastName);
    }

    public void setPostalCode(String postalCode) {
        POSTAL_CODE.shouldBe(visible).setValue(postalCode);
    }

    public void clickContinueButton() {
        CONTINUE_BUTTON.shouldBe(visible).click();
    }
}