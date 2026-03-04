package testCases;


import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistration extends BaseClass {
	
	@Test(groups={"Regression","Master"})
	public void verify_account_registration() throws InterruptedException {
		
		
		// TODO Auto-generated method stub'
		
		logger.info("***** Starting TC001_AccountRegistrationTest  ****");
		logger.debug("This is a debug log message");
		try
		{
		HomePage hp=new HomePage(driver);
		
		
		hp.clickRegister();
		logger.info("Clicked on Register Link.. ");
		
		AccountRegistrationPage arp=new AccountRegistrationPage(driver);
		
		logger.info("Providing customer details...");
		String email=randomStringGen()+"@gmail.com";
		arp.setEmail(email);
		//arp.setEmail(p.getProperty("email"));
		//Thread.sleep(2000);
		arp.setFirstName("demo234567");
		//Thread.sleep(2000);
		arp.selectGender(p.getProperty("gender"));
		//Thread.sleep(2000);
		arp.setLastName("demo");
		//Thread.sleep(2000);
		//arp.setPassword("234567");
		arp.setPassword(p.getProperty("passwd"));

		//Thread.sleep(2000);
		//arp.setConfirmPassword("234567");
		arp.setConfirmPassword(p.getProperty("cpasswd"));
		//Thread.sleep(2000);
		
		arp.clickregisterContinue();
		//Thread.sleep(2000);
		System.out.println("register");
		String status=arp.getConfirmationMsg();
		
		//Thread.sleep(2000);
		logger.info("Validating expected message..");
		
		
		
		if(status.equals("Your registration completed")) {
			hp.clickLogout();
			Assert.assertTrue(true);
		
		logger.info("Test passed...");
		}else {
			logger.info("Test fail...");
			logger.error("Test failed: ");
			logger.debug("dedug log ...");
			Assert.assertTrue(false);
		}
		
		
		}
		catch (Exception e)
		{
			
			Assert.assertTrue(false);
		} 
		

	}
	
	

}
