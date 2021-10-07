package SelindeConfigAndListeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class LocalRetry implements IRetryAnalyzer {
    private int count = 0;
    private static int maxTry = 3;

    //  Retry annotation to run failed test 3 times

    @Override
    public boolean retry(ITestResult iTestResult) {
        if (!iTestResult.isSuccess()) {
            if (count < maxTry) {
                count++;
                iTestResult.setStatus(ITestResult.FAILURE);
                return true;
            } else {
                iTestResult.setStatus(ITestResult.FAILURE);
            }
        } else {
            iTestResult.setStatus(ITestResult.SUCCESS);
        }
        return false;
    }

}


