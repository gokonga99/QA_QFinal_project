package ui.tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import ui.base.BaseTest;
import ui.pages.HomePage;
import ui.pages.ProductPage;

import java.util.List;

public class ProductSearchTest extends BaseTest {
    @Test(description = "verify that the searched product shows up")
    public void productSearch(){
        HomePage home= new HomePage();
        Assert.assertTrue(home.isHomePageVisible(),
                "Home paage should be visible after entering the website");
        home.clickProducts();
        ProductPage productPage = new ProductPage();
        Assert.assertTrue(productPage.isProductPageDisplayed(),
                "Product page should be displayed after clicking products link");
        productPage.enterSearchKeyWord("shirt");
        productPage.clickSearchButton();
        Assert.assertTrue(productPage.isSearchHeaderDisplayed(),
                "verify search Header is displayed after clicking search button");
        List<WebElement> results = productPage.listSearchResults();
        for (WebElement product : results) {
            Assert.assertTrue(product.isDisplayed(), "Product should be visible in search results");
        }

    }
}
