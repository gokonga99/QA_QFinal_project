package api.base;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class SearchProductsEndpoint
{
    private static final String BASE_URI = "https://automationexercise.com";
    private static final String BASE_PATH = "/api/searchProduct";
    public static Response postToSearchProduct()
    {
        return given()
                .baseUri(BASE_URI)
                .basePath(BASE_PATH)
                .formParam("search_product","tshirt")
                .when()
                .post();

    }
    public static Response postToSearchProduct2()
    {
        return given()
                .baseUri(BASE_URI)
                .basePath(BASE_PATH)
                .when()
                .post();
    }
}
