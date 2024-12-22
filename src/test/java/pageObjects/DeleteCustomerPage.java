package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DeleteCustomerPage extends BasePage {

	
	
	public DeleteCustomerPage(WebDriver driver){
		super(driver);
	}
	
	@FindBy(xpath="//a[normalize-space()='Delete Customer']") WebElement lnk_DeleteCustomer;
	@FindBy(name="cusid") WebElement text_customerId;
	@FindBy(name="AccSubmit") WebElement btn_submit;
	
	public void clickDeleteCustomerLink() {
		lnk_DeleteCustomer.click();
	}
	
	public void setCustomerId(String cid) {
		text_customerId.sendKeys(cid);
	}
	
	public void clickSubmitButtton() {
		btn_submit.click();
	}
}
