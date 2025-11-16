package TestCasesRediff;


import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Keywords.*;
import LoginCredentials.ExcelUtils;

public class createPortFolio extends ApplicationKeywords{

	@DataProvider(name = "loginData")
    public Object[][] getData(){
    	
    	String excelPath = System.getProperty("user.dir")+"\\testData\\testData.xlsx";
    	ExcelUtils excel = new ExcelUtils(excelPath, "testData");
    	
    	int rows = excel.getRowCount();
    	
    	Object[][] data = new Object[rows-1][2];
    	
    	for(int i = 1; i<rows; i++) {
    		data[i-1][0] = excel.getCellData(i, 0);
    		data[i-1][1] = excel.getCellData(i, 1);
    	}
    	
    	return data;
    	
    }

	
	@Test(dataProvider = "loginData")
	public void createPortFolioTest(String username, String password) {
		
		openBrowser("browser_name");
		openUrl("url");
		clickOnElement("money_menu_xpath");
		clickOnElement("my_portfolio_xpath");
		//clickOnElement("user_email_id");
		enterText("user_email_id", username);
		enterText("user_pass_name", password);
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
