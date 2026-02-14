package ui.tests;

import api.helpers.RegisterUserHelper;
import api.helpers.UserHelper;
import org.testng.Assert;
import org.testng.annotations.Test;
import ui.base.BaseTest;
import ui.pages.HomePage;
import ui.pages.LoginPage;

public class LoginTest extends BaseTest {

    @Test(description = "verify user can Login with his credentials")
    public void loginUser() {
        UserHelper user= RegisterUserHelper.createUser();

        HomePage home=new HomePage();
        Assert.assertTrue(home.isHomePageVisible(),
                "Home paage should be visible after entering the website");
        home.clickSignupLogin();

        LoginPage login=new LoginPage();
        Assert.assertTrue(login.isLoginPageLoaded(),
                "Login page should be loaded after clicking signup/login");
        login.loginEnterEmail(user.getEmail());
        login.loginEnterPassword(user.getPassword());
        login.clickLoginButton();


        Assert.assertTrue(home.isUserLoggedIn(),
                "User should be logged in after entering credentials and clicking login");
        home.deleteAccount();
        Assert.assertTrue(home.isAccountDeletedVisible(),
                "Account deleted should be visible after clicking deleteAccount");
        home.clickContinue();

    }
}
