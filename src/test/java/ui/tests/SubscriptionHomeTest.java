package ui.tests;


import org.testng.Assert;
import org.testng.annotations.Test;
import ui.base.BaseTest;
import ui.pages.HomePage;

public class SubscriptionHomeTest extends BaseTest {
    @Test(description = "verify that the user is Subscribed")
    public void verifySubscription(){

        HomePage home = new HomePage();
        Assert.assertTrue(home.isHomePageVisible(),
                "Home paage should be visible after entering the website");

        home.scrollToFooter();
        Assert.assertTrue(home.isSubscriptionHeaderVisible(),
                "Subscription header should be visible after entering the website");
        String email = "testUser" + System.currentTimeMillis() + "@mail.com";
        home.subscribe(email);

        Assert.assertTrue(home.isSubMessageVisible(),
                "Success message should be visible after subscribing");

    }
}
