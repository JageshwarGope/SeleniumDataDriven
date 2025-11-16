package TestCasesRediff;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import baseClass.BaseTestClass;
import LoginCredentials.ExcelUtils;

public class createPortFolio extends BaseTestClass {

    @DataProvider(name = "loginData")
    public Object[][] getData() {
        String excelPath = System.getProperty("user.dir") + "\\testData\\testData.xlsx";
        ExcelUtils excel = new ExcelUtils(excelPath, "testData");
        
        int rows = excel.getRowCount();
        Object[][] data = new Object[rows - 1][2];
        
        for (int i = 1; i < rows; i++) {
            data[i - 1][0] = excel.getCellData(i, 0);
            data[i - 1][1] = excel.getCellData(i, 1);
        }
        
        return data;
    }

    @Test(dataProvider = "loginData")
    public void createPortFolioTest(String username, String password) {
        
        app.openBrowser("browser_name");
        app.openUrl("url");
        app.clickOnElement("money_menu_xpath");
        app.clickOnElement("my_portfolio_xpath");
        app.enterText("user_email_id", username);
        app.enterText("user_pass_name", password);
        app.enterCaptcha("captcha_className");
        app.waitForSeconds(30);
        app.clickOnElement("submit_id");
        app.closeBrowser();
    }
}
