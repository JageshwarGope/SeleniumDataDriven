package TestCasesRediff;


import org.testng.annotations.Test;

import Keywords.*;

public class createPortFolio extends ApplicationKeywords{

	ApplicationKeywords app = new ApplicationKeywords();
	
	
	
	@Test
	public void createPortFolioTest() {
		
		app.openBrowser("browser_name");
		app.openUrl("url");
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
