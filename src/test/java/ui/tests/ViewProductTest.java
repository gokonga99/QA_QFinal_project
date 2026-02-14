package ui.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ui.base.BaseTest;
import ui.pages.HomePage;
import ui.pages.ProductPage;

public class ViewProductTest extends BaseTest {
    @Test(description = "verify navigation to the product page, verify that first products details are displayed")
    public void viewProduct(){
        HomePage home = new HomePage();
        Assert.assertTrue(home.isHomePageVisible(),
                "Home paage should be visible after entering the website");
        home.clickProducts();

        ProductPage productPage = new ProductPage();
        Assert.assertTrue(productPage.isProductPageDisplayed(),
                "Product page should be displayed after clicking products link");
        productPage.clickFirstProductViewButton();
        Assert.assertTrue(productPage.isProductNameDisplayed(),
                "product Name should be Displayed after clicking View Product");
        Assert.assertTrue(productPage.isProductCategoryDisplayed(),
                "product Category should be Displayed after clicking View Product");
        Assert.assertTrue(productPage.isProductPriceDisplayed(),
                "product Price should be Displayed after clicking View Product");
        Assert.assertTrue(productPage.isProductAvailabilityDisplayed(),
                "product Availability should be Displayed after clicking View Product");
        Assert.assertTrue(productPage.isProductConditionDisplayed(),
                "product Condition should be Displayed after clicking View Product");
        Assert.assertTrue(productPage.isProductBrandDisplayed(),
                "product Condition should be Displayed after clicking View Product");

    }
}
