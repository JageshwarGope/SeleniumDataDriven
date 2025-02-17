package Keywords;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;


public class GenericKeywords {
	
	public WebDriver driver;
	public Properties prop;

	
	public void openBrowser(String browserKey) {
		
		String browserName = prop.getProperty(browserKey);
		
		if(browserName.equalsIgnoreCase("chrome")) {

		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/driver/chromedriver.exe");
		driver = new ChromeDriver();
		
		} else if(browserName.equalsIgnoreCase("edge")){
			System.setProperty("webdriver.edge.driver", System.getProperty("user.dir")+"/driver/chromedriver.exe");
			driver = new EdgeDriver();
		} else {
			System.out.println("Browser is not available");
		}
	
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	
}
	
	
	public void closeBrowser() {
		driver.quit();
	
	}		
	
	

	public void openUrl(String url) {
		
		driver.get(prop.getProperty(url));

	}

	public void click(String locatorKey) {

		
	}

	public void enterText() {

	}

	public void select() {

	}

	public void getText() {

	}

}
