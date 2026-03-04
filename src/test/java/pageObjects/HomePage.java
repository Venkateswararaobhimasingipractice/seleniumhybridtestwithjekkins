package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
	
	public HomePage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
	}
	

	
	@FindBy(xpath = "//a[normalize-space()='Register']") WebElement  lnkRegister;
	
	@FindBy(xpath = "//a[normalize-space()='Log in']") WebElement linkLogin;
	
	@FindBy(xpath = "//a[normalize-space()='Log out']") WebElement linklogout;
	
	
	public void clickRegister()
	{
		lnkRegister.click();
	}

	public void clickLogin()
	{
		linkLogin.click();
	}
	
	public void clickLogout() {
		linklogout.click();
		
	}
}
