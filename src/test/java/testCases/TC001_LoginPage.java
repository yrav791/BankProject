package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import freemarker.log.Logger;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC001_LoginPage extends BaseClass{
 
	@Test(groups = {"Sanity"})
	public void testLoginPage() throws InterruptedException
	{
		logger.info("TC001_LoginPage Started .....");
		LoginPage lp=new LoginPage(driver);
		logger.info("Entering Banker deatils");
		lp.setUserId(pobj.getProperty("userId"));
		lp.setPassword(pobj.getProperty("pwd"));
		lp.clickLogin();
		boolean accountMsg=lp.isMyAccountExists();
		Thread.sleep(3000);
		logger.info("validating banker information");
		try {
		if(accountMsg==true)
		{
		Assert.assertTrue(true);
		System.out.println("test passed....");
		lp.clickLogout();
		driver.switchTo().alert().accept();
		
		}
		if(accountMsg==false)
		{
			logger.error("Test Failed");
			logger.debug("debug logs...");
			Assert.fail();
		}
		}catch(Exception e) {
			
		}
		logger.info("TC001_LoginPage finished .....");
		
	
	}
	

}
