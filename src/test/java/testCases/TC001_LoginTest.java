package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC001_LoginTest extends BaseClass{
	
	@Test(groups={"Sanity","Master"})
	public void verify_login()
	{
		logger.info("****** Startign TC_002_LoginTest *****");
		
		try
		{
		//HomePage
		HomePage hp=new HomePage(driver);
		
		hp.clickLogin();
	
		//Login
		LoginPage lp=new LoginPage(driver);
		lp.setEmail(p.getProperty("email"));
		lp.setPassword(p.getProperty("passwd"));
		lp.clickLogin();
		
		String accountDetails=lp.accountFound();
		if(accountDetails.equals(p.getProperty("email"))) {
			logger.info("****** Pass TC_002_LoginTest *****");
			Assert.assertTrue(true);
			
		}
		else {
			Assert.assertTrue(false);
		}
		//Assert.assertTrue(targetPage);//Assert.assertEquals(targetPage, true,"Login failed");
		}
		catch(Exception e)
		{
			Assert.assertTrue(false);
		}
		logger.info("****** Finished TC_002_LoginTest *****");
	}

}
