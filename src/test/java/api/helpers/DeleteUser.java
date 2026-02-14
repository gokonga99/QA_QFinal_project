package api.helpers;

import static io.restassured.RestAssured.given;

public class DeleteUser {
    public static void deleteUser(String email, String password) {
        given()
                .baseUri("https://automationexercise.com")
                .basePath("/api/deleteAccount")
                .formParam("email", email)
                .formParam("password", password)
                .when()
                    .delete()
                .then()
                .statusCode(200);

    }
}
