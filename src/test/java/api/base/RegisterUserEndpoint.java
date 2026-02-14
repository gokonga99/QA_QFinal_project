package api.base;

import api.model.User;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class RegisterUserEndpoint {

    private static final String BASE_URI = "https://automationexercise.com";
    private static final String BASE_PATH = "/api/createAccount";

    public static Response register(User user) {
        return given()
                .baseUri(BASE_URI)
                .basePath(BASE_PATH)
                .formParam("name", user.getName())
                .formParam("email", user.getEmail())
                .formParam("password", user.getPassword())
                .formParam("title", user.getTitle())
                .formParam("birth_date", user.getBirthDate())
                .formParam("birth_month", user.getBirthMonth())
                .formParam("birth_year", user.getBirthYear())
                .formParam("firstname", user.getFirstName())
                .formParam("lastname", user.getLastName())
                .formParam("company", user.getCompany())
                .formParam("address1", user.getAddress())
                .formParam("country", user.getCountry())
                .formParam("state", user.getState())
                .formParam("city", user.getCity())
                .formParam("zipcode", user.getZipcode())
                .formParam("mobile_number", user.getMobileNumber())
                .when()
                .post();
    }
}
