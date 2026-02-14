package ui.pages;

import org.openqa.selenium.By;
import ui.base.BasePage;

public class TestCasePage extends BasePage {
    private final By testCasesHeader = By.xpath("//h2[normalize-space()='Test Cases']");

    public boolean isTestCasesHeaderDisplayed() {

       boolean result=waitForVisible(testCasesHeader).isDisplayed();
       attachScreenshot("isTestCasesHeaderDisplayed");
       return result;
    }

}
