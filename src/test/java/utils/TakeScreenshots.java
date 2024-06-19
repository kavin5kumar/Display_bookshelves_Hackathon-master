package utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class TakeScreenshots {
	
	WebDriver driver;
	public TakeScreenshots(WebDriver driver) {
		this.driver = driver;
	}
	
	// method to take screenshot
	public String takeScreenshot(String scName) throws IOException {
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		String filePath = System.getProperty("user.dir")+"\\screenshots\\"+scName+".png";
		File trg = new File(filePath);
		FileUtils.copyFile(src, trg);
		return filePath;
	}
}
