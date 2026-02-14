package api.base;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class ProductBrandListEndpoint {
        private static final String BASE_URI = "https://automationexercise.com";
        private static final String BASE_PATH= "/api/brandsList";

        public static Response getAllBrands() {
            return given()
                    .baseUri(BASE_URI)
                    .basePath(BASE_PATH)
                    .when().get();
        }
        public static Response putToAllBrands() {
            return given()
                    .baseUri(BASE_URI)
                    .basePath(BASE_PATH)
                    .when().put();
        }
}