package pages;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import base.BaseTest;

public class LoginPage extends BaseTest{
	
	@FindBy(id ="user-name")
	private WebElement userNameTextBox;
	
	@FindBy(id="password")
	private WebElement passwordTextBox;
	
	@FindBy(id="login-button")
	private WebElement loginButton;
	
	public LoginPage() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));		
		Assert.assertEquals(driver.getTitle(),"Swag Labs", "LoginPage title not matching");
		PageFactory.initElements(driver, this);
	}
		
	public void login(String userName, String Password){
		this.userNameTextBox.sendKeys(userName);
		this.passwordTextBox.sendKeys(Password);
		this.loginButton.click();
	}
	
}
