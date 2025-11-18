package listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import Keywords.ApplicationKeywords;   // make sure package name matches (lowercase)
import reports.ReportManager;
import utils.ScreenshotUtil;

public class TestListener implements ITestListener {

    @Override
    public void onStart(ITestContext context) {
        String baseDir = System.getProperty("user.dir") + "/reports";
        ReportManager.reportInit(baseDir);
    }

    @Override
    public void onTestStart(ITestResult result) {
        ReportManager.createTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        try {
            // Get the ITestContext for this test and fetch the shared app object
            ITestContext ctx = result.getTestContext();
            Object appObj = ctx.getAttribute("app2"); // same key you set in @BeforeTest

            if (appObj != null && appObj instanceof ApplicationKeywords) {
                ApplicationKeywords app = (ApplicationKeywords) appObj;

                String folder = System.getProperty("user.dir") + "/" + app.prop.getProperty("report.outputFolder");

                String screenshotPath = ScreenshotUtil.takeScreenshot(
                        app.driver,
                        folder,
                        "FAIL_" + result.getMethod().getMethodName()
                );

                ReportManager.getTest().fail("Test Failed");
                if (screenshotPath != null) {
                    ReportManager.getTest().addScreenCaptureFromPath(screenshotPath);
                }
                ReportManager.getTest().fail(result.getThrowable());
            } else {
                // fallback: try to get driver from the test instance via reflection (optional)
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ReportManager.getTest().pass("Test Passed");
    }

    @Override
    public void onFinish(ITestContext context) {
        ReportManager.flush();
    }
}
