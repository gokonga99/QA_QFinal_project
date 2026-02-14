package api.tests;

import api.base.DeleteUserEndpoint;
import api.base.RegisterUserEndpoint;
import api.model.User;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.containsString;
import io.qameta.allure.Allure;

public class DeleteUserTest {

    @Test(description = "Verify a user can be deleted via API")
    public void deleteUserAPI() {
        String email = "DeleteTest" + System.currentTimeMillis() + "@mail.com";
        User user = new User("DeleteUser", email, "Test@123");

        user.setFirstName("John");
        user.setLastName("Doe");

        Response registerResponse = RegisterUserEndpoint.register(user);
        assertThat(registerResponse.getStatusCode(), equalTo(200));
        assertThat(registerResponse.jsonPath().getInt("responseCode"), equalTo(201));


        Response deleteResponse = DeleteUserEndpoint.deleteUser(user);

        assertThat(deleteResponse.getStatusCode(), equalTo(200));
        assertThat(deleteResponse.jsonPath().getInt("responseCode"), equalTo(200));
        assertThat(deleteResponse.jsonPath().getString("message"), containsString("Account deleted!"));

        Allure.addAttachment("Delete User Response", deleteResponse.asPrettyString());
    }
}
