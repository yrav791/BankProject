package pageObjects;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class addNewCustomer extends BasePage{

	public WebDriver driver;
	public addNewCustomer(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//input[@name='uid']") WebElement text_uid;
	@FindBy(xpath="//input[@name='password']") WebElement text_pwd;
	@FindBy(xpath="//input[@name='btnLogin']") WebElement btn_login;
	@FindBy(xpath="//a[normalize-space()='New Customer']") WebElement lnk_nc;
	@FindBy(xpath="//input[@name='name']") WebElement text_name;
	@FindBy(xpath="//tbody/tr[5]/td[2]/input[1]") WebElement radio_male;
	@FindBy(xpath="//input[@id='dob']") WebElement text_dob;
	@FindBy(xpath="//textarea[@name='addr']") WebElement text_addr;
	@FindBy(xpath="//input[@name='city']") WebElement text_city;
	@FindBy(xpath="//input[@name='state']") WebElement text_state;
	@FindBy(xpath="//input[@name='pinno']") WebElement text_pin;
	@FindBy(xpath="//input[@name='telephoneno']") WebElement text_pNo;
	@FindBy(xpath="//input[@name='emailid']") WebElement text_email;
	@FindBy(xpath="//input[@name='password']")WebElement text_cpwd;
	@FindBy(xpath="//input[@name='sub']") WebElement btn_sub;
	@FindBy(xpath="//p[@class='heading3']") WebElement cnfmMessage;
	
	public void setBuid(String uid){
		text_uid.sendKeys(uid);
	}
	
	public void setBpwd(String pwd){
		text_pwd.sendKeys(pwd);
	}
	
	public void bclickLogin(){
		btn_login.click();;
	}
	
	public void clickNewCustomer(){
		lnk_nc.click();
	}
	
	public void csetName(String name){
		text_name.sendKeys(name);
	}
	
	public void cclickGender(){
		radio_male.click();;
	}
	
	public void csetDob(String dob){
		text_dob.sendKeys(dob);
	}
	
	public void csetAddress(String addr){
		text_addr.sendKeys(addr);
	}

	public void csetCity(String city){
		text_city.sendKeys(city);
	}

	public void csetState(String state){
		text_state.sendKeys(state);
	}

	public void csetPin(String pin){
		text_pin.sendKeys(pin);
	}
	
	public void csetTelephone(String phone){
		text_pNo.sendKeys(phone);
	}	

	public void csetEmail(String email){
		text_email.sendKeys(email);
	}	
	public void csetPassword(String pwd) {
		text_cpwd.sendKeys(pwd);
	}

	public void cclickSubmit(){
		btn_sub.click();
	}	
	public String accountCnfrmM()
	{
		try {
		return cnfmMessage.getText();
		}catch(Exception e) {
			return e.getMessage();
		}
		
	}
	
	public static String randomStringName(){
		String generateString=RandomStringUtils.randomAlphabetic(5);
		return generateString;
				
	}
	
	public static String randomStringAddress(){
		String generateString=RandomStringUtils.randomAlphabetic(20);
		return generateString;
				
	}

	public static String randomNumber(){
		String generateNumber=RandomStringUtils.randomNumeric(8);
		return generateNumber;		
	}
	public static String randomAlphanumeric(){
		String generateString=RandomStringUtils.randomAlphabetic(5);
		String generateNumber=RandomStringUtils.randomNumeric(3);
		return (generateString+generateNumber);
	}
		

}
