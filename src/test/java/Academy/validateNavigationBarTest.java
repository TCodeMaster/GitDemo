package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import junit.framework.Assert;
import pageObject.LandingPage;
import resources.base;

public class validateNavigationBarTest extends base {
	
	public static Logger Log= LogManager.getLogger(base.class.getName()); 
	
	@BeforeTest
	public void initialize() throws IOException
	{
		driver= initializeDriver();
		driver.get(prop.getProperty("url"));
	}
	
	@Test()
	public void basePageNavigation() throws IOException
	{
		
		LandingPage l=new LandingPage(driver);
		
		Assert.assertTrue(l.Navigation().isDisplayed());
		Log.info("Navigation Bar is displayed");
		
		
		
	}

	@AfterTest
	public void exit()
	{
		driver.close();
		driver=null;
	}

}
