package api.tests;

import api.base.RegisterUserEndpoint;
import api.model.User;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.containsString;
import io.qameta.allure.Allure;

public class RegisterUserTest {

    @Test(description = "Verify a user can register via API")
    public void registerUserAPI() {
        String email = "APITestUser" + System.currentTimeMillis() + "@mail.com";
        User user = new User("APIUser", email, "Test@123");

        user.setTitle("Mr");
        user.setBirthDate("1");
        user.setBirthMonth("January");
        user.setBirthYear("1996");
        user.setFirstName("John");
        user.setLastName("Doe");
        user.setCompany("QA");
        user.setAddress("123 Test St");
        user.setCountry("Australia");
        user.setState("NSW");
        user.setCity("Sydney");
        user.setZipcode("2000");
        user.setMobileNumber("123456789");

        Response response = RegisterUserEndpoint.register(user);

        assertThat(response.getStatusCode(), equalTo(200));
        assertThat(response.jsonPath().getInt("responseCode"), equalTo(201));
        assertThat(response.jsonPath().getString("message"), containsString("User created!"));
        Allure.addAttachment("Register User API Response", response.asPrettyString());
    }
}
