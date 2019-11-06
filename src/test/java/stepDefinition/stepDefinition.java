package stepDefinition;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.junit.Cucumber;
import pageObject.LandingPage;
import pageObject.LoginPage;
import pageObject.LoginPageValidate;
import resources.base;

import org.junit.Assert;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
public class stepDefinition extends base{

	@Given("^Initialize the browser with chrome$")
	public void initialize_the_browser_with_chrome() throws Throwable {
		driver=initializeDriver();
		
	}

	@Given("^Navigate to \"([^\"]*)\" Site$")
	public void navigate_to_Site(String arg1) throws Throwable {
		driver.get(arg1);
		
	}

	@Given("^Click on Login Link on HomePage to land on Secure sign in Page$")
	public void click_on_Login_Link_on_HomePage_to_land_on_Secure_sign_in_Page() throws Throwable {
	    LandingPage l=new LandingPage(driver);
	    if(l.popupsize().size()>0)
		{
			l.popupvalidate().click();
		}
	    l.getLogin().click();
	}

	@When("^User Enter username \"([^\"]*)\" and login password \"([^\"]*)\" and logs in$")
	public void user_Enter_username_and_login_password_and_logs_in(String arg1, String arg2) throws Throwable {
	    
	}

	@Then("^verify user has successfully logged in$")
	public void verify_user_has_successfully_logged_in() throws Throwable {
	    
		LoginPageValidate lpd= new LoginPageValidate(driver);
		Assert.assertTrue(lpd.validatelogin().isDisplayed());
	}
		
	@When("^User Enter (.+) and login (.+) and logs in$")
	    public void user_enter_and_login_and_logs_in(String username, String password) throws Throwable {
			LoginPage lp=new LoginPage(driver);
		    lp.getEmail().sendKeys(username);
			lp.getPassword().sendKeys(password);
			lp.getLogin().click();
	    		}

	@And("^close browser$")
    public void close_browser() throws Throwable {
        driver.quit();
    }
    }

