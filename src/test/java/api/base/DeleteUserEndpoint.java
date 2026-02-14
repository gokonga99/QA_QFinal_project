package api.base;

import api.model.User;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class DeleteUserEndpoint {

    private static final String BASE_URI = "https://automationexercise.com";
    private static final String BASE_PATH = "/api/deleteAccount";

    public static Response deleteUser(User user) {
        return given()
                .baseUri(BASE_URI)
                .basePath(BASE_PATH)
                .formParam("email", user.getEmail())
                .formParam("password", user.getPassword()) // if required
                .when()
                .delete();
    }
}
