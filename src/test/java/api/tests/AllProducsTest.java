package api.tests;

import api.base.AllProductsEndpoint;
import io.qameta.allure.Allure;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.core.IsEqual.equalTo;

public class AllProducsTest {

    @Test
    public void getAllProductsTest() {
        Response response = AllProductsEndpoint.getAllProducts();
        assertThat(response.getStatusCode(), equalTo(200));
        assertThat(response.jsonPath().getInt("responseCode"), Matchers.equalTo(200));
        assertThat(!response.jsonPath().getList("products").isEmpty(), equalTo(true));
        Allure.addAttachment("GET All Products", response.asPrettyString());
    }
    @Test
    public void postToALlProductsTest() {
        Response response=AllProductsEndpoint.postToALlProducts();
        assertThat(response.getStatusCode(), equalTo(200));
        assertThat(response.jsonPath().getInt("responseCode"), Matchers.equalTo(405));
        assertThat(response.jsonPath().getString("message"), containsString("This request method is not supported."));
        Allure.addAttachment("POST to All products", response.asPrettyString());
    }

}
