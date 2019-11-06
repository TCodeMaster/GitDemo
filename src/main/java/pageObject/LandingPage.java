package pageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
	
	public WebDriver driver;
	
	By signin= By.xpath("//span[contains(text(),'Login')]");
	By validatetext= By.xpath("//h2[contains(text(),'Featured Courses')]");
	By navbar= By.xpath("/html[1]/body[1]/header[1]/div[2]");
	By popup=By.xpath("//button[text()='NO THANKS']");
	
	public LandingPage(WebDriver driver) {
		
		this.driver= driver;
	}

	public List<WebElement> popupsize()
	{
		return driver.findElements(popup);
	} 
	
	public WebElement popupvalidate()
	{
		return driver.findElement(popup);
	} 
	
	public WebElement getLogin()
	{
		return driver.findElement(signin);
	}
	
	
	public WebElement getTitle()
	{
		return driver.findElement(validatetext);
	}
	
	public WebElement Navigation()
	{
		return driver.findElement(navbar);
	}
	
	
	
}
