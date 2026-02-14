package ui.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ui.base.BaseTest;
import ui.pages.HomePage;
import ui.pages.TestCasePage;

public class TestCasesPageTest extends BaseTest {
    @Test(description = "verify Test Cases page is shown after clicking an appropriate button")
    public void goToTestCasePage(){
        HomePage home = new HomePage();
        Assert.assertTrue(home.isHomePageVisible(),
                "Home paage should be visible after entering the website");
        home.clickTestCases();

        TestCasePage tcPage = new TestCasePage();
        Assert.assertTrue(tcPage.isTestCasesHeaderDisplayed(),
                "Test Cases page should be visible after clicking an appropriate button");
    }
}
