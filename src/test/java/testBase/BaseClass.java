package testBase;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
 
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import org.testng.annotations.*;
 
 
public class BaseClass {
	public static WebDriver driver;
	public Logger logger;
	public Properties p;
 
	@BeforeTest
	@Parameters({"browser"})
	public void setUp(String br) throws IOException {
		// Loading properties file
		FileReader file = new FileReader(".//src//test//resources//config.properties");
		p = new Properties();
		p.load(file);
		// Loading log4j file
		logger = LogManager.getLogger(this.getClass());

		//launching browser based on condition - locally
		switch(br.toLowerCase())
		{
		case "chrome": driver=new ChromeDriver(); break;
		case "edge": driver=new EdgeDriver(); break;
		default: System.out.println("No matching browser..");
					return;
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(p.getProperty("PageURL"));
	}
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}
