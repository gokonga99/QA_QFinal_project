package api.tests;

import api.base.*;
import api.model.User;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.containsString;
import io.qameta.allure.Allure;


public class LoginUserTest{

    @Test
    public void loginUserTest() {
        User user = new User("APIUser", "APILogin" + System.currentTimeMillis() + "@mail.com", "Test@123");

        user.setFirstName("John");
        user.setLastName("Doe");
        Response registerResponse = RegisterUserEndpoint.register(user);
        assertThat(registerResponse.getStatusCode(), equalTo(200));
        assertThat(registerResponse.jsonPath().getInt("responseCode"), equalTo(201));


        Response response = LoginUserEndpoint.login(user);

        assertThat(response.getStatusCode(), equalTo(200));
        assertThat(response.jsonPath().getInt("responseCode"), equalTo(200));
        assertThat(response.jsonPath().getString("message"), containsString("User exists!"));
        Allure.addAttachment("Login Response", response.asPrettyString());
    }
    @Test
    public void loginUserWithInvalidEmailTest() {
        User user = new User("APIUser", "APILogin" + System.currentTimeMillis() + "@mail.com", "Test@123");
        user.setFirstName("John");
        user.setLastName("Doe");

        Response response = LoginUserEndpoint.login(user);

        assertThat(response.getStatusCode(), equalTo(200));
        assertThat(response.jsonPath().getInt("responseCode"), equalTo(404));
        assertThat(response.jsonPath().getString("message"), containsString("User not found!"));
        Allure.addAttachment("Login Response with invalid credentials", response.asPrettyString());
    }
}


