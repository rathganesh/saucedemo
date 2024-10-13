package pages;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import base.BaseTest;

public class ProductsPage extends BaseTest{
	
	@FindBy(xpath="//span[@class='title' and text()='Products']") 
	private WebElement productsPageTitle;
	
	 
	public ProductsPage() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		PageFactory.initElements(driver, this);
		Assert.assertEquals(this.productsPageTitle.getText(),"Products", "Products title not matching");
	}
	
}
