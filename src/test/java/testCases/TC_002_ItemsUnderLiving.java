package testCases;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import pageObjects.SecondPage;

public class TC_002_ItemsUnderLiving extends TC_001_FindDetailsOfBookShelves {

	@Test(priority=2)
public void Items() throws InterruptedException {
	
		System.out.println();
		
		System.out.println("----------- * * * -----------");
		System.out.println("----------- Test Case 2 ------------");
		logger.info("***** Starting TC_002_ItemsUnderLivingTest *****");	
		SecondPage Sp = new SecondPage(driver);
		
		Thread.sleep(7000);
		
		logger.info("***** Display Items under Living in the HomePage  *****");	
		Sp.MoveToLiving(driver);
		Thread.sleep(3000);
		
		logger.info("***** Store Items in a list  *****");	
		List<WebElement> Items = Sp.Itemsunderliving;
		System.out.println("Items Under Living:");
		
		logger.info("**** Display Items in the console *****");	
		for(int i=0;i<Items.size();i++) {
			
			System.out.println(Items.get(i).getText());
		}
	
//	Thread.sleep(3000);

//	TakeScreenshot ts = new TakeScreenshot(driver);    // taking screenshot
//	ts.takeScreenshot("Items UnderLiving");
//	logger.info("**** Finished TC_002_ItemsUnderLivingTest *****");	
		Thread.sleep(5000);
		Sp.toGifts(driver);
		
		System.out.println();
		System.out.println("----------- * * * -----------");
		
	}	
}
