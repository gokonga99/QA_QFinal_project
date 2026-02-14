package ui.base;

import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.ByteArrayInputStream;
import java.util.List;


public class BasePage {
    private final WebDriver driver;
    private final WebDriverWait wait;


    protected  BasePage()
    {
        this.driver = DriverFactory.getDriver();
        this.wait = DriverFactory.getWait();
    }

    @Step ("Wait for a WebElement to become visible")
    protected WebElement waitForVisible(By locator) {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        } catch (Exception e) {
            attachScreenshot("Failed to locate element: " + locator);
            throw e;
        }
    }


    @Step("Click a button after it becomes clickable")
    public void clickWhenReady(By locator) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
        } catch (Exception e) {
            attachScreenshot("Click failed on: " + locator);
            throw e;
        }
    }

    @Step ("Send data to an input after it becomes visible")
    protected void sendKeysToElement(By locator, String value) {
        WebElement el = waitForVisible(locator);
        el.clear();
        el.sendKeys(value);
    }

    @Step ("Scroll to an WebElements position one the page")
    protected void scrollTo(By locator) {
        WebElement el = waitForVisible(locator);
        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView({block:'center'});", el);
    }
    @Step("List all elements in a Dom Object")
    public List<WebElement> getAllSearchResults(By locator) {
        return driver.findElements(locator);
    }

    @Step ("Select an option from the dropdown select menu")
    protected void selectByVisibleText(By locator, String text) {
        WebElement el = waitForVisible(locator);
        Select select = new Select(el);
        select.selectByVisibleText(text);
    }
    @Attachment(value = "{name}", type = "image/png")
    public void attachScreenshot(String name) {
        byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        Allure.addAttachment(name, new ByteArrayInputStream(screenshot));
    }



}
