package Keywords;

import org.testng.Assert;

public class ValidationKeywords extends GenericKeywords {
	

	public void verifyTitle(String expectedTitle) {
	    Assert.assertEquals(driver.getTitle(), expectedTitle);
	}

}
