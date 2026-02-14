package ui.pages;

import org.openqa.selenium.By;
import ui.base.BasePage;

public class LoginPage extends BasePage {

    // Locators

    private final By emailInput_register = By.xpath("//div[@class='signup-form']//input[@name='email']");;
    private final By nameInput = By.name("name");
    private final By signupButton = By.xpath("//button[text()='Signup']");
    private final By enterAccountInfoHeader =
            By.xpath("//h2[contains(normalize-space(),'Enter Account Information')]");
    private final By loginHeader =
            By.xpath("//h2[contains(normalize-space(),'Login to your account')]");
    private final By incorrectLoginHeader=
            By.xpath("//p[contains(normalize-space(),'Your email or password is incorrect!')]");
    private final By emailInput_login =By.xpath("//div[@class='login-form']//input[@name='email']");;
    private final By passwordInput=By.name("password");
    private final By loginButton = By.xpath("//button[text()='Login']");
    private final By incorrectRegisterHeader=
            By.xpath("//p[contains(normalize-space(),'Email Address already exist!')]");



    public void registerEnterEmail(String email) {
        sendKeysToElement(emailInput_register, email);
    }

    public void registerEnterName(String name) {
        sendKeysToElement(nameInput, name);
    }

    public void clickSignupButton() {

        clickWhenReady(signupButton);
    }

    public boolean isSignupPageLoaded() {
        boolean result=waitForVisible(enterAccountInfoHeader).isDisplayed();
        attachScreenshot("Signup page is displayed");
        return result;
    }
    public boolean isLoginPageLoaded() {

        boolean result=waitForVisible(loginHeader).isDisplayed();
        attachScreenshot("Login page is displayed");
        return result;
    }

   public void loginEnterEmail(String email){

        sendKeysToElement(emailInput_login, email);
   }

   public void loginEnterPassword(String password){

        sendKeysToElement(passwordInput, password);
   }
   public void clickLoginButton() {

        clickWhenReady(loginButton);
   }
   public boolean isIncorrectLoginMessageLoaded() {
        boolean result=waitForVisible(incorrectLoginHeader).isDisplayed();
        attachScreenshot("login error message is displayed");
        return result;
   }
   public boolean isIncorrectRegisterMessageLoaded() {

        boolean result=waitForVisible(incorrectRegisterHeader).isDisplayed();
        attachScreenshot("register error message is displayed");
        return result;
   }
}

