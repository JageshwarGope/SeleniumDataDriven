package reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ReportManager {

	private static ExtentReports extent;
	private static ThreadLocal<ExtentTest> testThread = new ThreadLocal<>();
	
	public static void reportInit(String baseDir) {
		
		if(extent == null) {
			String reportPath = baseDir + "/ExtenrReport_"+ System.currentTimeMillis()+".HTML";
			ExtentSparkReporter spark = new ExtentSparkReporter(reportPath);
			
			extent = new ExtentReports();
			extent.attachReporter(spark);
		}
	}
	
	public static void createTest(String testName) {
		ExtentTest test = extent.createTest(testName);
		testThread.set(test);
	}

	public static ExtentTest getTest() {
		return testThread.get();
	}
	
	public static void flush() {
		if(extent != null) extent.flush();
	}
}
