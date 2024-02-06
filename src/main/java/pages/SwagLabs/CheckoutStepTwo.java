package pages.SwagLabs;

import com.codeborne.selenide.SelenideElement;

import java.util.Locale;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class CheckoutStepTwo {
    private static final SelenideElement TAX_LABEL = $(".summary_tax_label");
    private static final SelenideElement TOTAL_LABEL = $(".summary_total_label");
    private static final SelenideElement FINISH_BUTTON = $("[data-test='finish']");

    public void calculateAndPrintTaxPercentage() {
        double taxValue = extractValueFromLabel(TAX_LABEL);
        double totalValue = extractValueFromLabel(TOTAL_LABEL);
        double taxPercentage = (taxValue / totalValue) * 100;

        String formattedTaxPercentage = String.format(Locale.US, "%.2f", taxPercentage);
        System.out.println("Tax Percentage: " + formattedTaxPercentage + "%");
    }

    private double extractValueFromLabel(SelenideElement label) {
        String labelText = label.getText().replaceAll("[^\\d.]", "");
        return Double.parseDouble(labelText);
    }

    public void clickFinishButton() {
        FINISH_BUTTON.shouldBe(visible).click();
    }
}