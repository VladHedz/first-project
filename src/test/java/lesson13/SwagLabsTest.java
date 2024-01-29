package lesson13;

import config.driver.Browser;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.SwagLabs.*;

public class SwagLabsTest {
    private LoginPage loginPage = new LoginPage();
    private InventoryPage inventoryPage = new InventoryPage();
    private CartPage cartPage = new CartPage();
    private CheckoutStepOne checkoutStepOne = new CheckoutStepOne();
    private CheckoutStepTwo checkoutStepTwo = new CheckoutStepTwo();
    private CheckoutCompletePage checkoutCompletePage = new CheckoutCompletePage();

    @BeforeTest
    public void setUpBrowser() {
        Browser.setBrowser();
    }

    @Test(priority = 1)
    public void openWelcomePage() {
        loginPage.openLoginPage();
    }

    @Test(priority = 2)
    public void checkLogin() {
        loginPage.setUserName("standard_user");
        loginPage.setPassword("secret_sauce");
        loginPage.clickOnLoginButton();
        inventoryPage.checkInventoryListIsVisible();
    }

    @Test(priority = 3)
    public void addInventoryToCart() {
        inventoryPage.clickAddToCartForMatchingPrices();
        inventoryPage.clickOnCartBadge();
    }

    @Test(priority = 4)
    public void checkAddedInventoryToCart() {
        cartPage.checkCartItems();
        cartPage.clickCheckoutButton();
    }

    @Test(priority = 5)
    public void setYourInformation() {
        checkoutStepOne.setFirstName("First Name");
        checkoutStepOne.setLastName("Last Name");
        checkoutStepOne.setPostalCode("Postal Code");
        checkoutStepOne.clickContinueButton();
    }

    @Test(priority = 6)
    public void printPercentageTax() {
        checkoutStepTwo.calculateAndPrintTaxPercentage();
        checkoutStepTwo.clickFinishButton();
    }

    @Test(priority = 7)
    public void checkConfirmOrder() {
        checkoutCompletePage.checkOrderConfirmation();
    }

    @AfterTest(alwaysRun = true)
    public void tearDownBrowser() {
        Browser.closeBrowser();
    }
}