package ui.tests;

import api.helpers.DeleteUser;
import api.helpers.RegisterUserHelper;
import api.helpers.UserHelper;
import org.testng.Assert;
import org.testng.annotations.Test;
import ui.base.BaseTest;
import ui.pages.HomePage;
import ui.pages.LoginPage;

public class LogoutUserTest extends BaseTest {

    @Test(description = "logout an user after successful login attempt")
    public void logoutUser() {
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

        home.clickLogout();
        Assert.assertTrue(login.isLoginPageLoaded(),
                "Login page should be loaded after clicking Logout");

        DeleteUser.deleteUser(user.getEmail(),user.getPassword());

    }
}
