package api.tests;

import api.base.SearchProductsEndpoint;
import io.qameta.allure.Allure;
import io.restassured.response.Response;
import org.hamcrest.core.IsEqual;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;

public class SearchProductsTest {
    @Test
    public void searchProductsTest(){
        Response response= SearchProductsEndpoint.postToSearchProduct();

        assertThat(response.getStatusCode(), equalTo(200));
        assertThat(response.jsonPath().getInt("responseCode"), equalTo(200));
        assertThat(!response.jsonPath().getList("products").isEmpty(), IsEqual.equalTo(true));
        Allure.addAttachment("POST to Search All Products", response.asPrettyString());
    }
    @Test
    public void searchProductsTest2(){
        Response response= SearchProductsEndpoint.postToSearchProduct2();

        assertThat(response.getStatusCode(), equalTo(200));
        assertThat(response.jsonPath().getInt("responseCode"), equalTo(400));
        assertThat(response.jsonPath().getString("message"),
                containsString("Bad request, search_product parameter is missing in POST request."));
        Allure.addAttachment("POST(no param) to search ALL Products", response.asPrettyString());

    }
}
