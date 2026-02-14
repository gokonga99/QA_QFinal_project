package ui.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ui.base.BaseTest;
import ui.pages.CartPage;
import ui.pages.HomePage;

public class SubscriptionCartTest extends BaseTest {

    @Test(description = "Verify subscription functionality in Cart page")
    public void verifySubscriptionInCartPage() {
        HomePage home = new HomePage();
        Assert.assertTrue(home.isHomePageVisible(), "Home page should be visible");

        home.clickCartButton();

        CartPage cart = new CartPage();
        Assert.assertTrue(cart.isCartPageVisible(),
                "Cart page should be visible");

        cart.scrollToFooter();
        Assert.assertTrue(cart.isSubscriptionHeaderVisible(),
                "Subscription header should be visible");

        String email = "testuser" + System.currentTimeMillis() + "@mail.com";
        cart.subscribe(email);

        Assert.assertTrue(cart.isSubscriptionSuccessVisible(),
                "Success message should be visible after subscribing");
    }
}
