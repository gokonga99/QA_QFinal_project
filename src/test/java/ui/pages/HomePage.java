package ui.pages;

import org.openqa.selenium.By;
import ui.base.BasePage;

public class HomePage extends BasePage {

    private final By signupLoginLink = By.linkText("Signup / Login");
    private final By deleteButton = By.linkText("Delete Account");
    private final By TestCaseLink = By.linkText("Test Cases");
    private final By cartLink = By.linkText("Cart");
    private final By homeFooter=By.id("footer");
    private final By productLink = By.xpath("//a[contains(normalize-space(),'Products')]");
    private final By loggedInHeader=By.xpath("//a[contains(text(),'Logged in as')]");
    private final By accountDeletedText =
            By.xpath("//h2[contains(normalize-space(),'Account Deleted!')]");
    private final By continueButton = By.xpath("//a[text()='Continue']");
    private final By logoutButton=By.linkText("Logout");

    private final By subscriptionHeader = By.xpath("//h2[contains(text(),'Subscription')]");
    private final By subscriptionInput = By.id("susbscribe_email");
    private final By subscribeButton = By.id("subscribe");
    private final By successMessage = By.xpath("//div[contains(normalize-space(),'You have been successfully subscribed!')]");




    public void clickSignupLogin() {

        clickWhenReady(signupLoginLink);
    }
    public void clickTestCases() {
        clickWhenReady(TestCaseLink);
    }
    public void clickProducts() {
        clickWhenReady(productLink);
    }
    public void clickCartButton(){
        clickWhenReady(cartLink);
    }
    public void scrollToFooter(){
        clickWhenReady(homeFooter);
    }


    public boolean isHomePageVisible() {
        boolean result=waitForVisible(signupLoginLink).isDisplayed();
        attachScreenshot("Home page is displayed");
        return result;
    }


    public void deleteAccount() {
        clickWhenReady(deleteButton);

    }
    public boolean isAccountDeletedVisible() {
        boolean result= waitForVisible(accountDeletedText).isDisplayed();
        attachScreenshot("Delete Account is displayed");
        return result;
    }

    public void clickContinue(){
        clickWhenReady(continueButton);
    }
    public boolean isUserLoggedIn(){
        boolean result=waitForVisible(loggedInHeader).isDisplayed();
        attachScreenshot("user  is logged in");
        return result;
    }
    public void clickLogout(){
        clickWhenReady(logoutButton);
    }

    public boolean isSubscriptionHeaderVisible() {
        boolean result=waitForVisible(subscriptionHeader).isDisplayed();
        attachScreenshot("subscription header is displayed");
        return result;
    }

    public void subscribe(String email){
        sendKeysToElement(subscriptionInput,email);
        clickWhenReady(subscribeButton);
    }

    public boolean isSubMessageVisible(){
        boolean result=waitForVisible(successMessage).isDisplayed();
        attachScreenshot("sub message is displayed");
        return result;
    }

}
