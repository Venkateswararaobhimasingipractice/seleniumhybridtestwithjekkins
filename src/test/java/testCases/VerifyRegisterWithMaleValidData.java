package testCases;


import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;
import utilities.TestRail;

public class VerifyRegisterWithMaleValidData extends BaseClass {
	
	@Test(groups={"Regression","Master"})
	@TestRail(id="57")
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
		arp.selectGender("male");
		//Thread.sleep(2000);
		arp.setLastName("demon");
		//Thread.sleep(2000);
		//arp.setPassword("234567");
		arp.setPassword(email);

		//Thread.sleep(2000);
		//arp.setConfirmPassword("234567");
		arp.setConfirmPassword(email);
		//Thread.sleep(2000);
		
		arp.clickregisterContinue();
		//Thread.sleep(2000);
		System.out.println("register");
		String status=arp.getConfirmationMsg();
		
		//Thread.sleep(2000);
		logger.info("Validating expected message..");
		
		
		
		if(status.equals("Your registration completed")) {
			
			arp.clickOnAccount();
			
			Thread.sleep(5000);
			String g=arp.getGender();
			System.out.println("gender "+g);
			if(g.equalsIgnoreCase("male")) {
			
			hp.clickLogout();
			Assert.assertTrue(true);
		
		logger.info("Test passed...");
			}
			else {
				logger.info("Test fail...");
				logger.error("Test failed: ");
				logger.debug("dedug log ...");
				Assert.assertTrue(false);
			}
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
