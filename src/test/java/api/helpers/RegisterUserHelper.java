package api.helpers;

import static io.restassured.RestAssured.given;

public class RegisterUserHelper {
        public static UserHelper createUser() {
            String email = "TestUser" + System.currentTimeMillis() + "@mail.com";
            String password = "Test@123";

             given()
                    .baseUri("https://automationexercise.com")
                    .basePath("/api/createAccount")
                    .formParam("name", "TestUser")
                    .formParam("email", email)
                    .formParam("password", password)
                    .formParam("title", "Mr")
                    .formParam("birth_date", "1")
                    .formParam("birth_month", "January")
                    .formParam("birth_year", "1996")
                    .formParam("firstname", "John")
                    .formParam("lastname", "Doe")
                    .formParam("company", "QA")
                    .formParam("address1", "Test")
                    .formParam("country", "Australia")
                    .formParam("state", "NSW")
                    .formParam("city", "Sydney")
                    .formParam("zipcode", "2000")
                    .formParam("mobile_number", "123456789")
                    .when()
                        .post()
                    .then()
                        .statusCode(200);


            return new UserHelper(email, password, "TestUser");
        }
}


