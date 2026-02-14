package ui.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ui.base.BasePage;

import java.util.List;

public class ProductPage extends BasePage {
    private final By productPageHeader=By.xpath("//h2[normalize-space()='All Products']");
    private final By firstProductViewButton = By.xpath("(//a[contains(text(),'View Product')])[1]");
    private final By productName=By.xpath("//h2[contains(text(),'Blue Top')]");
    private final By productCategory =By.xpath("//p[contains(text(),'Category: Women > Tops')]");
    private final By productPrice = By.xpath("//div[@class='product-information']//span");
    private final By productAvailability=By.xpath("//b[contains(text(),'Availability:')]");
    private final By productCondition=By.xpath("//b[contains(text(),'Condition')]");
    private final By productBrand=By.xpath("//b[contains(text(),'Brand:')]");
    private final By productSearchInput=By.id("search_product");
    private final By searchButton=By.id("submit_search");
    private final By productSearchHeader=By.xpath("//h2[normalize-space()='Searched Products']");
    private final By searchResults = By.xpath("//div[@class='productinfo text-center']");


    public boolean isProductPageDisplayed(){
        return waitForVisible(productPageHeader).isDisplayed();
    }

    public void clickFirstProductViewButton(){
        scrollTo(firstProductViewButton);
        clickWhenReady(firstProductViewButton);
    }

    public boolean isProductNameDisplayed(){
        return waitForVisible(productName).isDisplayed();
    }
    public boolean isProductCategoryDisplayed(){
        return waitForVisible(productCategory).isDisplayed();
    }
    public boolean isProductPriceDisplayed(){
        return waitForVisible(productPrice).isDisplayed();
    }

    public boolean isProductAvailabilityDisplayed(){
        return waitForVisible(productAvailability).isDisplayed();
    }
    public boolean isProductConditionDisplayed(){
        return waitForVisible(productCondition).isDisplayed();
    }
    public boolean isProductBrandDisplayed(){
        boolean result= waitForVisible(productBrand).isDisplayed();
        attachScreenshot("all of product details are displayed");
        return  result;
    }

    public void enterSearchKeyWord(String searchKeyWord){
        sendKeysToElement(productSearchInput,searchKeyWord);
    }
    public void clickSearchButton(){
        clickWhenReady(searchButton);
    }
    public boolean isSearchHeaderDisplayed(){
        boolean result= waitForVisible(productSearchHeader).isDisplayed();
        attachScreenshot("search header is displayed");
        return result;
    }

    public List<WebElement>  listSearchResults(){
        return getAllSearchResults(searchResults);
    }

}
