package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditCustomerPage extends BasePage{

	public 	WebDriver driver;
	
	public EditCustomerPage(WebDriver driver){
		super(driver);
	}
	
	@FindBy(xpath="//a[normalize-space()='Edit Customer']") WebElement lnk_edit;
	@FindBy(xpath="//input[@name='cusid']") WebElement txt_customerId;
	@FindBy(xpath="//input[@name='AccSubmit']") WebElement btn_submit1;
	@FindBy(xpath="//input[@name='name']") WebElement text_name;
	@FindBy(xpath="//input[@id='dob']") WebElement text_dob;
	@FindBy(xpath="//textarea[@name='addr']") WebElement text_addr;
	@FindBy(xpath="//input[@name='city']") WebElement text_city;
	@FindBy(xpath="//input[@name='state']") WebElement text_state;
	@FindBy(xpath="//input[@name='pinno']") WebElement text_pin;
	@FindBy(xpath="//input[@name='telephoneno']")WebElement txt_telephone;
	@FindBy(xpath="//input[@name='emailid']") WebElement text_email;
	@FindBy(xpath="//input[@name='sub']") WebElement btn_submit2;
	
	
	public void clickLinkEdit() {
		lnk_edit.click();
	}
	
	public void setCustId(String custId) {
		txt_customerId.sendKeys(custId);
	}
	
	public void clickButtonSubmit1(){
		btn_submit1.click();
	}
	public void changeName(String name){
		text_name.clear();
		text_name.sendKeys(name);
	}
	
	public void changeDob(String dob){
		text_dob.clear();
		text_dob.sendKeys(dob);
	}
	
	public void changeAddress(String addr){
		text_addr.clear();
		text_addr.sendKeys(addr);
	}

	public void changeCity(String city){
		text_city.clear();
		text_city.sendKeys(city);
	}

	public void changeState(String state){
		text_state.clear();
		text_state.sendKeys(state);
	}

	public void changePin(String pin){
		text_pin.clear();
		text_pin.sendKeys(pin);
	}
	
	public void changeTelephone(String phone){
		txt_telephone.clear();
		txt_telephone.sendKeys(phone);
	}	

	public void changeEmail(String email){
		text_email.clear();
		text_email.sendKeys(email);
	}	
	
	public void clickButtonSubmit2(){
		btn_submit2.click();
	}
}
