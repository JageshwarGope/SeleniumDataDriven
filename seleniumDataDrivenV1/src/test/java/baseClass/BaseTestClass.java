package baseClass;

import org.testng.ITestContext;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import Keywords.ApplicationKeywords;

public class BaseTestClass {

	public ApplicationKeywords app;
	
	@BeforeTest(alwaysRun=true)
	public void beforeTest(ITestContext context) {
		app = new ApplicationKeywords();
		context.setAttribute("app2", app);
	}
	
	@BeforeMethod(alwaysRun=true)
	public void beforeMethod(ITestContext context) {
		app = (ApplicationKeywords) context.getAttribute("app2");
	}
}
