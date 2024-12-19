package testCases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import pageObjects.LoginPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC003_loginPageTestDDT extends BaseClass{

	
	@Test(dataProvider = "BankerData",dataProviderClass=DataProviders.class,groups = {"Regression"})
	public void verify_LoginDDT(String userid,String pswd,String res) throws InterruptedException {
		logger.info("TC003_loginPageTestDDT Started.....");
		try {
		LoginPage loginpage=new LoginPage(driver);
		logger.info("Enter Banker Details...");
		loginpage.setUserId(userid);
		loginpage.setPassword(pswd);
		loginpage.clickLogin();
		logger.info("Validating details....");
		boolean targetPage=loginpage.isMyAccountExists();
		if(res.equalsIgnoreCase("valid")){
			if(targetPage==true) {
				loginpage.clickLogout();
				driver.switchTo().alert().accept();
			    Assert.assertTrue(true);
			   
			}
			else
			{
				driver.switchTo().alert().accept();
				Assert.assertTrue(false);
			}
		}
		
		if(res.equalsIgnoreCase("invalid")){
			if(targetPage==true) {
				loginpage.clickLogout();
				driver.switchTo().alert().accept();
			    Assert.assertTrue(false);
			}
			else
			{
				Assert.assertTrue(true);
				driver.switchTo().alert().accept();
			}
		}
		}catch(Exception e) {
			//Assert.fail();
		}
		
		logger.info("TC003_loginPageTestDDT Finished.....");
		
	}

}
