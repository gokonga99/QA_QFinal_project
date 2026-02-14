package ui.pages;

import org.openqa.selenium.By;
import ui.base.BasePage;

public class CartPage extends BasePage {


    private final By cartHeader = By.xpath("//li[contains(text(),'Shopping Cart')]");
    private final By subscriptionHeader = By.xpath("//h2[contains(text(),'Subscription')]");
    private final By cartFooter=By.id("footer");
    private final By subscriptionInput = By.id("susbscribe_email");
    private final By subscribeButton = By.id("subscribe");
    private final By successMessage =
            By.xpath("//div[contains(normalize-space(),'You have been successfully subscribed!')]");

    public boolean isCartPageVisible() {
        boolean result=waitForVisible(cartHeader).isDisplayed();
        attachScreenshot("cart page is displayed");
        return result;
    }

    public void scrollToFooter() {
        waitForVisible(cartFooter);
    }

    public boolean isSubscriptionHeaderVisible() {
        boolean result=waitForVisible(subscriptionHeader).isDisplayed();
        attachScreenshot("Subscription Header is displayed");
        return result;
    }

    public void subscribe(String email) {
        sendKeysToElement(subscriptionInput, email);
        clickWhenReady(subscribeButton);
    }

    public boolean isSubscriptionSuccessVisible() {
        boolean result = waitForVisible(subscriptionInput).isDisplayed();
        attachScreenshot("Subscription Success");
        return result;
    }
}
