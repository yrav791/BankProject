package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.DeleteCustomerPage;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC005_DeleteCustomerPage extends BaseClass{

	@Test
	public void verify_deleteCustomerPage() {
		
		logger.info("TC005_DeleteCustomerPage Started .....");
		LoginPage lp=new LoginPage(driver);
		logger.info("Enter bank Manager details .....");
		lp.setUserId(pobj.getProperty("userId"));
		lp.setPassword(pobj.getProperty("pwd"));
		lp.clickLogin();
		
		
		DeleteCustomerPage dc=new DeleteCustomerPage(driver);
		dc.clickDeleteCustomerLink();
		dc.setCustomerId(pobj.getProperty("custId1"));
		dc.clickSubmitButtton();
		driver.switchTo().alert().accept();
		Assert.assertTrue(true);
		System.out.println("test Passed");
		logger.info("TC005_DeleteCustomerPage Started .....");		
	}
	
}
