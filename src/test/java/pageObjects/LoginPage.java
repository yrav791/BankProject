package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

	
	public LoginPage(WebDriver driver)
	{
		super(driver);
	}
	

	@FindBy(xpath="//input[@name='uid']") WebElement txt_userId;
	@FindBy(xpath="//input[@name='password']") WebElement txt_pwd;
	@FindBy(xpath="//input[@name='btnLogin']") WebElement clk_login;
	@FindBy(xpath="//marquee[@class='heading3']") WebElement msgHeading;
	@FindBy(xpath="//a[normalize-space()='Log out']") WebElement lnk_logout;
	
	public void setUserId(String uid)
	{
		txt_userId.sendKeys(uid);
	}
	public void setPassword(String pwd)
	{
		txt_pwd.sendKeys(pwd);
	}
	public void clickLogin()
	{
		clk_login.click();
	}
	public boolean isMyAccountExists(){
		try {
		return msgHeading.isDisplayed();
		}catch(Exception e) {
			return false;
		}
	}
	
	public void clickLogout() {
		lnk_logout.click();
	}
}
