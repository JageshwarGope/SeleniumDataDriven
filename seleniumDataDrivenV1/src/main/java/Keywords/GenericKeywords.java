package Keywords;

import java.time.Duration;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GenericKeywords {

	public WebDriver driver;
	public Properties prop;

	public void openBrowser(String browserKey) {

		String browserName = prop.getProperty(browserKey);

		if (browserName.equalsIgnoreCase("chrome")) {

			ChromeOptions options = new ChromeOptions();

//			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/driver/chromedriver.exe");
			driver = new ChromeDriver(options);

		} else if (browserName.equalsIgnoreCase("edge")) {

			System.setProperty("webdriver.edge.driver", System.getProperty("user.dir") + "/driver/msedgedriver.exe");
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

	public void clickOnElement(String locatorKey) {
		getElement(locatorKey).click();
	}

	public void clickEnterKey(String locatorKey) {
		getElement(locatorKey).sendKeys(Keys.ENTER);
	}

	public void enterText(String locatorKey, String value) {
		getElement(locatorKey).sendKeys(value);
	}

	public void enterCaptcha(String locatorKey) {
		try (Scanner sc = new Scanner(System.in)) { // Using try to auto-close Scanner
			System.out.print("Enter Captcha: ");
			String captcha = sc.nextLine();
			getElement(locatorKey).sendKeys(captcha);
		}
	}

	public void select() {

		
	}

	public void getText() {

	}

	public void waitForSeconds(int seconds) {
		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public WebElement getElement(String locatorKey) {

		WebElement element = driver.findElement(getLocator(locatorKey));

		return element;
	}

	public List<WebElement> getElements(String locatorKey) {

		List<WebElement> elements = driver.findElements(getLocator(locatorKey));

		return elements;
	}

	public By getLocator(String locatorKey) {

		By by = null;

		if (locatorKey.endsWith("_id"))
			by = By.id(prop.getProperty(locatorKey));
		else if (locatorKey.endsWith("_className"))
			by = By.className(prop.getProperty(locatorKey));
		else if (locatorKey.endsWith("_name"))
			by = By.name(prop.getProperty(locatorKey));
		else if (locatorKey.endsWith("_cssSelector"))
			by = By.cssSelector(prop.getProperty(locatorKey));
		else if (locatorKey.endsWith("_linkText"))
			by = By.linkText(prop.getProperty(locatorKey));
		else if (locatorKey.endsWith("_tagName"))
			by = By.tagName(prop.getProperty(locatorKey));
		else if (locatorKey.endsWith("_xpath"))
			by = By.xpath(prop.getProperty(locatorKey));
		else if (locatorKey.endsWith("_partialLinkText"))
			by = By.partialLinkText(prop.getProperty(locatorKey));

		return by;
	}

}
