package api.tests;


import api.base.ProductBrandListEndpoint;
import io.qameta.allure.Allure;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.core.IsEqual.equalTo;

public class ProductBrandListTest
{
    @Test
    public void getProductBrandListTest()
    {
        Response response = ProductBrandListEndpoint.getAllBrands();
        assertThat(response.getStatusCode(), equalTo(200));
        assertThat(response.jsonPath().getInt("responseCode"), Matchers.equalTo(200));
        assertThat(!response.jsonPath().getList("brands").isEmpty(), equalTo(true));
        Allure.addAttachment("GET All Products Brands", response.asPrettyString());
    }
    @Test
    public void putProductBrandListTest()
    {
        Response response = ProductBrandListEndpoint.putToAllBrands();
        assertThat(response.getStatusCode(), equalTo(200));
        assertThat(response.jsonPath().getInt("responseCode"), Matchers.equalTo(405));
        assertThat(response.jsonPath().getString("message"), containsString("This request method is not supported."));
        Allure.addAttachment("PUT All Products Brands", response.asPrettyString());
    }
}
