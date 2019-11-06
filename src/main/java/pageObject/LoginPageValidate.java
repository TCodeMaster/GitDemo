package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPageValidate {
	
	public WebDriver driver;
	
	By findacourse=By.name("query");
	
	public LoginPageValidate(WebDriver driver)
	{
		this.driver= driver;
	}

	
	public WebElement validatelogin()
	{
		return driver.findElement(findacourse);
	}
}
