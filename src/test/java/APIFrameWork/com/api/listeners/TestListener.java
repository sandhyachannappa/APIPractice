package APIFrameWork.com.api.listeners;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


public class TestListener implements ITestListener {
   private static final Logger logger= LogManager.getLogger(TestListener.class);

    @Override
    public void onStart(ITestContext context) {
        logger.info("Test Suite Started!!!");
    }

    @Override
    public void onTestStart(ITestResult result) {
        logger.info("Test Suite Started!!!"+result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        logger.info("Testcase Passed : " + result.getMethod().getMethodName());
        logger.info("Testcase Description : " + result.getMethod().getDescription());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        logger.error("Testcase Failed : " + result.getMethod().getMethodName());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        logger.info("Testcase Skipped : " + result.getMethod().getMethodName());
    }

    @Override
    public void onFinish(ITestContext context) {
        logger.info("Test Suite Completed!!!");
    }
}
