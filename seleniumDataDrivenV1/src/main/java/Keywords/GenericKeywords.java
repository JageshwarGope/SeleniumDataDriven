package Keywords;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class GenericKeywords {
	
	WebDriver driver;

	
	public void openBrowser(String browserName) {
		
		if(browserName.equalsIgnoreCase("chrome")) {

		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/driver/chromedriver.exe");
		driver = new ChromeDriver();
		
		} else if(browserName.equalsIgnoreCase("edge")){
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/driver/chromedriver.exe");
			driver = new EdgeDriver();
		} else {
			System.out.println("Browser is not available");
		}
	
	
		}
	
	
	public void closeBrowser() {
		driver.quit();
	
	}		
	
	

	public void openUrl(String url) {
		driver.get(url);

	}

	public void click() {

	}

	public void enterText() {

	}

	public void select() {

	}

	public void getText() {

	}

}
