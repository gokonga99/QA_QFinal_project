package ui.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ui.base.BaseTest;
import ui.pages.HomePage;
import ui.pages.LoginPage;
import ui.pages.SignUpPage;

public class RegisterTest extends BaseTest {


    @Test(description = "Verify user can Signup with valid credentials")
    public void registerUser() {
        HomePage home = new HomePage();
        Assert.assertTrue(home.isHomePageVisible(),
                "Home paage should be visible after entering the website");
        home.clickSignupLogin();


        LoginPage login = new LoginPage();
        login.registerEnterName("John");
        String email = "john" + System.currentTimeMillis() + "@mail.com";
        login.registerEnterEmail(email);
        login.clickSignupButton();
        Assert.assertTrue(login.isSignupPageLoaded(),
                "Signup page should be visible after clicking Signup");
        SignUpPage signUp = new SignUpPage();

        signUp
                .selectGender("Male")
                .enterPassword("12345")
                .selectDay("1")
                .selectMonth("January")
                .selectYear("1996")
                .selectNewsletter()
                .selectOffers()
                .enterFirstName("John")
                .enterLastName("Doe")
                .enterCompany("Google Co.")
                .enterAdress1("Pyrmont NSW 2009, Australia")
                .enterAdress2("Ground Floor/48 Pirrama Rd")
                .selectCountry("Australia")
                .enterState("New South Wales")
                .enterCity("Sydney")
                .enterZipcode("2009")
                .enterPhone("555-555-555")
                .submitButton();

        Assert.assertTrue(signUp.isAccountCreated(),
                "ACCOUNT CREATED! should be visible after creating an account");

        signUp.clickContinue();
        Assert.assertTrue(home.isUserLoggedIn(),
                "user should be logged in after creating an account");

        home = new HomePage();
        home.deleteAccount();
        Assert.assertTrue(home.isAccountDeletedVisible(),
                "Account deleted! should be visible after deleting an account");
        home.clickContinue();

    }
}


