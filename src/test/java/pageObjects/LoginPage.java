package pageObjects;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//input[@id='Email']")
	WebElement txtEmailAddress;

	@FindBy(xpath = "//input[@id='Password']")
	WebElement txtPassword;

	@FindBy(xpath = "//input[@value='Log in']")
	WebElement btnLogin;

	//div[@class='header']//a[@class='account']  test login 
	
	@FindBy(xpath = "//div[@class='header']//a[@class='account']") WebElement account;
	public void setEmail(String email) {
		txtEmailAddress.sendKeys(email);
	}

	public void setPassword(String pwd) {
		txtPassword.sendKeys(pwd);
	}

	public void clickLogin() {
		btnLogin.click();
	}
	
	public String accountFound() {
		try {
			return account.getText();
		}
		catch (Exception e) {
			// TODO: handle exception
			return "";
		}
	}
	

	
	
	
}