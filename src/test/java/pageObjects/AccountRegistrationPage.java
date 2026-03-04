package pageObjects;



import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage{
	public JavascriptExecutor js;
	public AccountRegistrationPage(WebDriver driver)
	{
		super(driver);
			
	}
	

@FindBy(xpath="//input[@id='FirstName']") 
WebElement txtFirstname;


@FindBy(xpath="//input[@id='LastName']") 
WebElement txtLasttname;


@FindBy(xpath = "//input[@id='gender-male']")
WebElement clickmale;



@FindBy(xpath = "//input[@id='gender-female']")
WebElement clickfemale;



@FindBy(xpath="//input[@id='Email']") 
WebElement txtEmail;



@FindBy(xpath="//input[@id='Password']") 
WebElement txtPassword;


@FindBy(xpath = "//input[@id='ConfirmPassword']")
WebElement confPassword;



@FindBy(xpath="//input[@id='register-button']") 
WebElement btnregisterContinue;

@FindBy(xpath = "//div[@class='result']")
WebElement msgConfirmation;

//"Your registration completed"

@FindBy(xpath = "//input[@value='Continue']")
WebElement btnContinue;


@FindBy(xpath = "//span[@for='Email']") WebElement Email_is_is_req_msg;

@FindBy(xpath="(//a[@class='account'])[1]")  WebElement emailAccount;

@FindBy(xpath = "//span[@for='ConfirmPassword']") WebElement passwdMatchMsg;


@FindBy(xpath = "//span[@data-valmsg-for='Email']") WebElement worngmsg;

public void setFirstName(String fname) {
	
	txtFirstname.sendKeys(fname);

}

public void setLastName(String lname) {
	txtLasttname.sendKeys(lname);

}

public void setEmail(String email) {
	txtEmail.sendKeys(email);

}



public void setPassword(String pwd) {
	txtPassword.sendKeys(pwd);

}


public void setConfirmPassword(String pwd) {
	confPassword.sendKeys(pwd);

}


public void clickregisterContinue() {
	//sol1 
	
	btnregisterContinue.click();
	
	//sol2 
	//btnregisterContinue.submit();
	
	//sol3
	//Actions act=new Actions(driver);
	//act.moveToElement(btnregisterContinue).click().perform();
				
	//sol4
	//JavascriptExecutor js=(JavascriptExecutor)driver;
	//js.executeScript("arguments[0].click();", btnregisterContinue);
	
	//Sol 5
	//btnregisterContinue.sendKeys(Keys.RETURN);
	
	//Sol6  
	//WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(10));
	//mywait.until(ExpectedConditions.elementToBeClickable(btnregisterContinue)).click();
	
}

public void selectGender(String gen) {
	// TODO Auto-generated method stub
	
	String s=gen.toLowerCase();

	if(s.equals("male")) {
		clickmale.click();
	}
	else {
		clickfemale.click();
	}

}



public String getConfirmationMsg() {
	try {
		return (msgConfirmation.getText());
	} catch (Exception e) {
		return (e.getMessage());

	}
}

public boolean getMsgDisplay_Email_is_required() {
	if(Email_is_is_req_msg.isDisplayed()) {
		String s=Email_is_is_req_msg.getText();
		System.out.println("staus email req" +s);
		if(s.equalsIgnoreCase("Email is required.")) {
			System.out.println("email req  pass");
			return true;
		}
		else {
			System.out.println("email req fail");
			return false;
		}
	}
	else {
		System.out.println("email req fail");
		return false;
	}
	
}

public boolean getMsgWrong_email() {
	if(worngmsg.isDisplayed()) {
		String s=worngmsg.getText();
		System.out.println("staus of email"+s);
		if(s.equalsIgnoreCase("Wrong email")) {
			System.out.println("email pass");
			return true;
		}
		else {
			System.out.println("email fail");
			return false;
		}
	}
	else {
		String s=Email_is_is_req_msg.getText();
		System.out.println("staus of email 22"+s);
		System.out.println("email fail");
		return false;
	}
	
}


public void clickOnAccount() {
	emailAccount.click();
}

public String getGender() {
	
	if(clickfemale.isSelected()) {
		System.out.println("female");
		return "female";
	}
	else if(clickmale.isSelected()) {
		System.out.println("male ");
		return "male";
				
	}
	else {
		System.out.println("error");
		return "error";
	}
}


//The password and confirmation password do not match.

public boolean getPasswdMismatchMsgDisplay() {
	if(passwdMatchMsg.isDisplayed()) {
		String s=passwdMatchMsg.getText();
		System.out.println("status passwd"+s);
		if(s.equalsIgnoreCase("The password and confirmation password do not match.")) {
			System.out.println("passwd pass");
			return true;
		}
	}
	String s=passwdMatchMsg.getText();
	System.out.println("status passwd"+s);
	System.out.println("passwd fail");
	return false;
}


}