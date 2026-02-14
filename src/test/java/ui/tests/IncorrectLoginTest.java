package ui.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ui.base.BaseTest;
import ui.pages.HomePage;
import ui.pages.LoginPage;

public class IncorrectLoginTest extends BaseTest {
    @Test(description = "verify user can't login with incorrect credentials")
    public void loginFailTest() {
        HomePage home=new HomePage();
        Assert.assertTrue(home.isHomePageVisible(),
                "Home paage should be visible after entering the website");
        home.clickSignupLogin();
        LoginPage login=new LoginPage();
        Assert.assertTrue(login.isLoginPageLoaded(),
                "Login page should be loaded after clicking signup/login");
        login.loginEnterEmail("IncorrectUserIrwin@mail.com");
        login.loginEnterPassword("54321");
        login.clickLoginButton();
        Assert.assertTrue(login.isIncorrectLoginMessageLoaded(),
                "Your email or password is incorrect! message should be shown after, failed login attempt");

    }
}
