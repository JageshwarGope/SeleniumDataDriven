package TestCasesRediff;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Keywords.*;

public class createPortFolio extends ApplicationKeywords{

	ApplicationKeywords app = new ApplicationKeywords();
	
	
	
	@Test
	public void createPortFolioTest() {
		
		app.openBrowser("chrome");
		app.openUrl("https://www.rediff.com/");
		app.closeBrowser();
		
	}
	
	
	
	
	
	
	
//	@BeforeMethod
//	public void beforeMethod() {
//		
//	}
//	
//	@AfterMethod
//	public void afterMethod() {
//		
//	}
//	
	
}
