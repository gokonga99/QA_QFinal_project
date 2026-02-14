package api.base;

import api.model.User;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class LoginUserEndpoint {
    private static final String BASE_URI = "https://automationexercise.com";
    private static final String BASE_PATH = "/api/verifyLogin";

    public static Response login(User user) {
        return given()
                .baseUri(BASE_URI)
                .basePath(BASE_PATH)
                .formParam("email", user.getEmail())
                .formParam("password", user.getPassword())
                .when()
                .post();
    }
    public static Response loginWithInvalid(User user) {
        return given()
                .baseUri(BASE_URI)
                .basePath(BASE_PATH)
                .formParam("email", user.getEmail())
                .formParam("password", user.getPassword())
                .when()
                .post();
    }
}

