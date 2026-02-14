package api.base;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class AllProductsEndpoint {
        private static final String BASE_URI = "https://automationexercise.com";

        public static Response getAllProducts() {
            return given()
                    .baseUri(BASE_URI)
                    .basePath("/api/productsList")
                    .when().get();
        }
        public static Response postToALlProducts() {
            return given().baseUri(BASE_URI)
                    .basePath("/api/productsList")
                    .when().post();
        }


    }

