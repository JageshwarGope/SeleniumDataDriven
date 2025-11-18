package utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtil {
	
	public static String takeScreenshot(WebDriver driver, String folderPath, String prefix) {
		try {
			if(!(driver instanceof TakesScreenshot)) return null;
			
			File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			
			File folder = new File(folderPath);
			if(!folder.exists()) folder.mkdir();
			
			String filePath = folderPath + File.separator + prefix +"_" + System.currentTimeMillis()+".png";
			
			FileUtils.copyFile(src, new File(filePath));

			return filePath;
			
		} catch(IOException e) {
			e.printStackTrace();
			return null;
		}
		
	}

}
