package TestCasesRediff;


import org.testng.annotations.Test;

import Keywords.*;

public class createPortFolio extends ApplicationKeywords{


	
	
	
	@Test
	public void createPortFolioTest() {
		
		openBrowser("browser_name");
		openUrl("url");
		clickOnElement("money_menu_xpath");
		clickOnElement("my_portfolio_xpath");
		//clickOnElement("user_email_id");
		enterText("user_email_id", "jageshwar.gope@rediffmail.com");
		enterText("user_pass_name", "Jagu9905@");
		enterCaptcha("captcha_className");
		waitForSeconds(30);
		clickOnElement("submit_id");
		closeBrowser();
		
	}
	
	
	
// use below code if class is not extends to ApplicationKeywords- create instance and then call all methods
	
//	ApplicationKeywords app = new ApplicationKeywords();
//	
//	@Test
//	public void createPortFolioTest() {
//		
//		app.openBrowser("browser_name");
//		app.openUrl("url");
//		app.clickOnElement("money_menu_xpath");
//		app.clickOnElement("my_portfolio_xpath");
//		//app.clickOnElement("user_email_id");
//		app.enterText("user_email_id", "jageshwar.gope@rediffmail.com");
//		app.enterText("user_pass_name", "Jagu9905@");
//		app.enterCaptcha("captcha_className");
//		app.waitForSeconds(30);
//		app.clickOnElement("submit_id");
//		app.closeBrowser();
//		
//	}
	
	
	
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
