package ui.pages;

import org.openqa.selenium.By;
import ui.base.BasePage;

public class SignUpPage extends BasePage {

    private final By passwordInput = By.id("password");
    private final By dayDropdown = By.id("days");
    private final By monthDropdown = By.id("months");
    private final By yearDropdown = By.id("years");
    private final By newsLetter = By.id("newsletter");
    private final By Offers = By.id("optin");

    private final By genderInputMale = By.id("id_gender1");
    private final By genderInputFemale = By.id("id_gender2");
    private final By firstName = By.id("first_name");
    private final By lastName = By.id("last_name");
    private final By companyId = By.id("company");
    private final By address1 = By.id("address1");
    private final By address2 = By.id("address2");
    private final By countryId = By.id("country");
    private final By stateId = By.id("state");
    private final By cityId = By.id("city");
    private final By zipcodeId = By.id("zipcode");
    private final By mobileNumber = By.id("mobile_number");
    private final By submit_Button = By.xpath("//button[text()='Create Account']");
    private final By accountCreated = By.xpath("//h2[contains(normalize-space(),'Account Created!')]");
    private final By continueButton = By.xpath("//a[text()='Continue']");

    public SignUpPage selectGender(String gender) {
        if (gender.equalsIgnoreCase("male")) {
            clickWhenReady(genderInputMale);
        } else if (gender.equalsIgnoreCase("female")) {
            clickWhenReady(genderInputFemale);
        }
        return this;
    }

    public SignUpPage enterPassword(String password) {
        sendKeysToElement(passwordInput, password);
        return this;
    }

    public SignUpPage selectDay(String day) {
        selectByVisibleText(dayDropdown, day);
        return this;
    }

    public SignUpPage selectMonth(String month) {
        selectByVisibleText(monthDropdown, month);
        return this;
    }

    public SignUpPage selectYear(String year) {
        selectByVisibleText(yearDropdown, year);
        return this;
    }

    public SignUpPage selectNewsletter() {
        scrollTo(newsLetter);
        clickWhenReady(newsLetter);
        return this;
    }

    public SignUpPage selectOffers() {
        scrollTo(Offers);
        clickWhenReady(Offers);
        return this;
    }

    public SignUpPage enterFirstName(String first_Name) {
        sendKeysToElement(firstName, first_Name);
        return this;
    }

    public SignUpPage enterLastName(String last_Name) {
        sendKeysToElement(lastName, last_Name);
        return this;
    }

    public SignUpPage enterCompany(String company) {
        scrollTo(companyId);
        sendKeysToElement(companyId, company);
        return this;
    }

    public SignUpPage enterAdress1(String address) {
        sendKeysToElement(address1, address);
        return this;
    }

    public SignUpPage enterAdress2(String address) {
        sendKeysToElement(address2, address);
        return this;
    }

    public SignUpPage selectCountry(String country) {
        scrollTo(countryId);
        selectByVisibleText(countryId, country);
        return this;
    }

    public SignUpPage enterState(String state) {
        sendKeysToElement(stateId, state);
        return this;
    }

    public SignUpPage enterCity(String city) {
        sendKeysToElement(cityId, city);
        return this;
    }

    public SignUpPage enterZipcode(String zipcode) {
        sendKeysToElement(zipcodeId, zipcode);
        return this;
    }

    public SignUpPage enterPhone(String phone) {
        sendKeysToElement(mobileNumber, phone);
        return this;
    }

    public SignUpPage submitButton() {
        scrollTo(submit_Button);
        clickWhenReady(submit_Button);
        return this;
    }

    public SignUpPage clickContinue() {
        clickWhenReady(continueButton);
        return this;
    }

    public boolean isAccountCreated() {
        return waitForVisible(accountCreated).isDisplayed();
    }
}
