package ui.base;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        attachFailureScreenshot(result);
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        attachFailureScreenshot(result);
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        attachFailureScreenshot(result);

        }
    @Attachment(value = "Failure Screenshot", type = "image/png")
    public byte[] attachFailureScreenshot(ITestResult result) {
        if (DriverFactory.getDriver() != null) {
            return ((TakesScreenshot) DriverFactory.getDriver())
                    .getScreenshotAs(OutputType.BYTES);
        }
        return new byte[0];
    }

}
