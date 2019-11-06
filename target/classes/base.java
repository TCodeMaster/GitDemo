package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.io.FileHandler;
 

public class base {
		
	public static WebDriver driver;
	public Properties prop;
	
	public WebDriver initializeDriver() throws IOException
	{
		prop =new Properties();
		FileInputStream fis= new FileInputStream("src\\main\\java\\resources\\data.properties");
		prop.load(fis);
		String browsername= prop.getProperty("browser");
		
		if(browsername.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver_win32\\chromedriver.exe");
			driver=new ChromeDriver();
					}
		else if (browsername.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "C:\\Selenium\\FireFox\\geckodriver.exe");
			driver= new FirefoxDriver();
		}
		
		else if (browsername.equals("IE"))
		{
			System.setProperty("webdriver.ie.driver", "C:\\Selenium\\IEDriver\\IEDriverServer.exe");
			driver= new InternetExplorerDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}
	public void takeScreenshot() 
	{
		String screenName= System.currentTimeMillis()+ ".png";
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try
		{
			FileHandler.copy(src, new File(System.getProperty("user.dir")+"/target/Screenshots/"+screenName+""));
		}
		catch(IOException e)
		{
			System.out.println(e.getMessage());
		}
	}	
		
	

}
