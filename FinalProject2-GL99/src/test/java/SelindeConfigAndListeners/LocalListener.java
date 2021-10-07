package SelindeConfigAndListeners;

import com.codeborne.selenide.Selenide;
import org.openqa.selenium.OutputType;
import org.testng.ITestListener;
import org.testng.ITestResult;

// Listener to take screenshot on test fail and send it to allure report

public class LocalListener implements ITestListener {
    public void onTestSuccess(ITestResult result) {
        System.out.println("TestngListener on TestSuccess: ");
        System.out.println("SUCCEED " + result.getName());
    }


    public void onTestFailure(ITestResult result) {
        System.out.println("TestngListener on TestFailure: ");
        System.out.println("FAILED " + result.getName());

//        takes screenshot for allure
        Attachments attach = new Attachments();
        attach.saveScreenshot(Selenide.screenshot(OutputType.BYTES));
    }

    public void onTestSkipped(ITestResult result) {
        System.out.println("TestngListener on TestSkipped : ");
        System.out.println("SKIPPED " + result.getName());
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        System.out.println("TestngListener on testSuccessPercent: ");
        System.out.println("PASSED BY PERCENT  " + result.getName());
    }
}
