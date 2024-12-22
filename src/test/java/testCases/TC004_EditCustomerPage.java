package testCases;

import java.util.Scanner;

import org.testng.annotations.Test;

import pageObjects.EditCustomerPage;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC004_EditCustomerPage extends BaseClass{

	 public Scanner sc;
	 @Test(groups = "smoke")
	public void verify_editCustomerPage() throws InterruptedException {
	    sc=new Scanner(System.in);
	    LoginPage lp=new LoginPage(driver);
	    lp.setUserId(pobj.getProperty("userId"));
	    lp.setPassword(pobj.getProperty("pwd"));
	    lp.clickLogin();
	    EditCustomerPage ed=new EditCustomerPage(driver);
	    ed.clickLinkEdit();
	    ed.setCustId(pobj.getProperty("custId"));
	    ed.clickButtonSubmit1();
	    System.out.println("Enter option change: \nEnter 1 for Name correction\nEnter 2 for Dob Correction\nEnter 3 for add\nEnter 4 for telephone no change\nEnter 5 for email :");
	    int option=sc.nextInt();
	    Thread.sleep(4000);
	    switch(option) {
	    case 1:ed.changeName("Golu");break;
	    case 2:ed.changeDob("1993-10-25");break;
	    case 3:ed.changeAddress("Siwan");
	            ed.changeCity("Siwan");
	            ed.changeState("Bihar");
	            ed.changePin("841236");break;
	    case 4:ed.changeTelephone("785670352");break;
	    case 5:ed.changeEmail("golu@email.com");break;
	    default:System.out.println("np option selected : ");return;
	    }
	    Thread.sleep(3000);
	    ed.clickButtonSubmit2();
	}
	
}
