package Keywords;

import java.time.Duration;
import java.util.ArrayList;
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
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import reports.ReportManager;
import utils.ScreenshotUtil;

public class GenericKeywords {

	public WebDriver driver;
	public Properties prop;
	
	private static final Logger log = LoggerFactory.getLogger(GenericKeywords.class);

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
			log.info("Browser is not available" );
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

	}
	
	
	public void takeScreenShot(String message) {
	    boolean stepFlag = Boolean.parseBoolean(prop.getProperty("screenshot.onEveryStep"));

	    try {
	        if (stepFlag) {
	            String folder = System.getProperty("user.dir") + "/" + prop.getProperty("report.outputFolder");
	            String path = ScreenshotUtil.takeScreenshot(driver, folder, "STEP");

	            ReportManager.getTest().info(message)
	                         .addScreenCaptureFromPath(path);

	        } else {
	            ReportManager.getTest().info(message);
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	    }
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
	
	public void clearText(String locatorKey) {
		getElement(locatorKey).clear();
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
	
	// ---select methods

	public void selectByText(String locatorKey, String text) {
		
		WebElement element = getElement(locatorKey);
		
		Select select = new Select(element);
		select.selectByVisibleText(text);
		log.info("Got selected the option for locator: " + locatorKey);
	}
	
	public void selectByIndex(String locatorKey, int index) {
		
		WebElement element = getElement(locatorKey);
		
		Select select = new Select(element);
		select.selectByIndex(index);
		log.info("Got selected the option for locator: " + locatorKey);
	}
	
	public void selectByValue(String locatorKey, String value) {
		
		WebElement element = getElement(locatorKey);
		
		Select select = new Select(element);
		select.selectByValue(value);
		log.info("Got selected the option for locator: " + locatorKey);
		
	}
	
	public void selectByTextContains(String locatorKey, String text) {
		
		WebElement element = getElement(locatorKey);
		
		Select select = new Select(element);
		select.selectByContainsVisibleText(text);
		log.info("Got selectByContainsVisibleText the option for locator: " + locatorKey);
		
	}
	
	public void getFirstSelectedOption(String locatorKey) {
		
		WebElement element = getElement(locatorKey);
		
		Select select = new Select(element);
		select.getFirstSelectedOption();
		log.info("Got getFirstSelectedOption the option for locator: " + locatorKey);
		
	}
	
	public List<String> getAllSelectedOptions(String locatorKey) {
		
		WebElement element = getElement(locatorKey);
		Select select = new Select(element);
		List<WebElement> selectedOptions = select.getAllSelectedOptions();
		List<String> selectedtexts = new ArrayList<>();
		
		for(WebElement option : selectedOptions) {
			String text = option.getText();
			selectedtexts.add(text);
		}
		log.info("Got all the selected options for locator: " + locatorKey);
		return selectedtexts;
	}
	
	public List<String> getOptions(String locatorKey) {
		
		WebElement element = getElement(locatorKey);
		Select select = new Select(element);
		
		List<WebElement> allOptions = select.getOptions();
		List<String> options = new ArrayList<>();
		
		for(WebElement option : allOptions) {
			String text = option.getText();
			options.add(text);
		}
		log.info("Got all the options for locator: " + locatorKey);
		return options;
		
	}
	
	public void selectMultipleByText(String locatorKey, List<String> values) {
	    WebElement element = getElement(locatorKey);
	    Select select = new Select(element);

	    if (!select.isMultiple()) {
	        log.error("Dropdown is NOT multi-select");
	        return;
	    }

	    for (String value : values) {
	        select.selectByVisibleText(value);
	        log.info("Selected value: " + value);
	    }

	}

	
	// ---- Deselect methods
	
	public void deselectByText(String locatorKey, String text) {
		
		WebElement element = getElement(locatorKey);
		
		Select select = new Select(element);
		select.deselectByVisibleText(text);
		log.info("Deselected the selected option for locator: " + locatorKey);
		
	}
	
	public void deselectByIndex(String locatorKey, int index) {
		
		WebElement element = getElement(locatorKey);
		
		Select select = new Select(element);
		select.deselectByIndex(index);
		log.info("Deselected the selected option for locator: " + locatorKey);
		
	}
	
	public void deselectByValue(String locatorKey, String value) {
		
		WebElement element = getElement(locatorKey);
		
		Select select = new Select(element);
		select.deselectByValue(value);
		log.info("Deselected the selected option for locator: " + locatorKey);
		
	}
	
	public void deselectByTextContains(String locatorKey, String text) {
		
		WebElement element = getElement(locatorKey);
		
		Select select = new Select(element);
		select.deSelectByContainsVisibleText(text);
		log.info("Deselected the selected option for locator: " + locatorKey);
		
	}
	
	public void deselectAll(String locatorKey) {

	    try {
	        WebElement element = getElement(locatorKey);
	        Select select = new Select(element);

	        if (!select.isMultiple()) {
	            log.error("Cannot deselect: Dropdown '" + locatorKey + "' is NOT multi-select.");
	            ReportManager.getTest().warning("Dropdown is NOT multi-select: " + locatorKey);
	            return;
	        }

	        select.deselectAll();

	        log.info("Deselected all options for locator: " + locatorKey);

	    } catch (Exception e) {
	        log.error("Failed to deselect all options for locator: " + locatorKey, e);
	        ReportManager.getTest().fail("Deselect all failed for: " + locatorKey);
	    }
	}


	public void getText(String locatorKey) {
		getElement(locatorKey).getText();
		log.info("Fetched the text for locator: " + locatorKey);
		
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
