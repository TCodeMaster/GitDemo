package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObject.LandingPage;
import pageObject.LoginPage;
import resources.base;

public class HomePageTest extends base {
	
	public static Logger Log= LogManager.getLogger(base.class.getName()); 
	
	@BeforeTest
	public void initialize() throws IOException
	{
		driver= initializeDriver();
			}
	
	@Test(dataProvider = "getData")
	public void basePageNavigation(String Username, String Password, String Comment) throws IOException
	{
		driver.get(prop.getProperty("url"));		
		LandingPage l=new LandingPage(driver);
		l.getLogin().click();
		
		LoginPage lp=new LoginPage(driver);
		
		lp.getEmail().sendKeys(Username);
		lp.getPassword().sendKeys(Password);
		lp.getLogin().click();
		//System.out.println(Comment);
		Log.info(Comment);
		
	}

	@AfterTest
	public void exit()
	{
		driver.close();
		driver=null;
	}
	
	@DataProvider
	public Object[][] getData()
	{
		Object[][] data= new Object[2][3]; // 2 is set of data and 3 for how many values.
		//0th row
		data[0][0]="nonrestricteduser@email.com";
		data[0][1]="yes";		
		data[0][2]="non-restricted user";
		//1st row
		data[1][0]="restricteduser@email.com";
		data[1][1]="yes";
		data[1][2]="restricted user";
		
		return data;
		
	}
	
	
	
}
