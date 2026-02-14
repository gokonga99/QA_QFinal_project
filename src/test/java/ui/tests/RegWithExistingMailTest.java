package ui.tests;

import api.helpers.DeleteUser;
import api.helpers.RegisterUserHelper;
import api.helpers.UserHelper;
import org.testng.Assert;
import org.testng.annotations.Test;
import ui.base.BaseTest;
import ui.pages.HomePage;
import ui.pages.LoginPage;

public class RegWithExistingMailTest extends BaseTest {
    @Test(description = "verify that a proper error message is displayed when registering with an existing mail")
    public void regWithExistingMail(){
        UserHelper user= RegisterUserHelper.createUser();
        HomePage home=new HomePage();
        Assert.assertTrue(home.isHomePageVisible(),
                "Home paage should be visible after entering the website");
        home.clickSignupLogin();
        LoginPage login=new LoginPage();
        Assert.assertTrue(login.isLoginPageLoaded(),
                "Login page should be loaded after clicking signup/login");
        login.registerEnterEmail(user.getEmail());
        login.registerEnterName(user.getName());
        login.clickSignupButton();
        Assert.assertTrue(login.isIncorrectRegisterMessageLoaded(),
                "error message should be displayed after entering existing email and clicking signup");

        DeleteUser.deleteUser(user.getEmail(),user.getPassword());


    }
}
