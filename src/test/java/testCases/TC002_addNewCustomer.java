package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.addNewCustomer;
import testBase.BaseClass;

public class TC002_addNewCustomer extends BaseClass{
	
	@Test (groups = {"Sanity","Regression"})
	public void testAddcustomer() throws InterruptedException {
		logger.info("TC002_addNewCustomer Started....");
		logger.info("Enter banker details....");
		addNewCustomer anc=new addNewCustomer(driver);
		try {
		anc.setBuid(pobj.getProperty("userId"));
		anc.setBpwd(pobj.getProperty("pwd"));
		anc.bclickLogin();
		Thread.sleep(3000);
		anc.clickNewCustomer();
		Thread.sleep(3000);
		logger.info("Enter Customer details....");
		Thread.sleep(3000);
		anc.csetName(anc.randomStringName().toUpperCase());
		anc.cclickGender();
		anc.csetDob("15-20-1996");
		anc.csetAddress(anc.randomStringAddress().toLowerCase());
		anc.csetCity(anc.randomStringName().toUpperCase());
		anc.csetState(anc.randomStringName().toUpperCase());
		anc.csetPin(anc.randomNumber());
		anc.csetTelephone(anc.randomNumber());
		anc.csetEmail(anc.randomStringName()+"@gmail.com");
		anc.csetPassword("Pawan917");
		anc.cclickSubmit();
		logger.info("validation....");
		String msgConfirmationString=anc.accountCnfrmM();
		if(msgConfirmationString.equals("Customer Registered Successfully!!!"))
		{
			Assert.assertTrue(true);
			System.out.println("test Passed...");
		}
		}catch(Exception e){
			logger.error("test failed....");
			logger.debug("debug logs...");
			System.out.println("test failed");
			Assert.fail();
		}
		
		logger.info("TC002_addNewCustomer Finished....");
		
	}


}
