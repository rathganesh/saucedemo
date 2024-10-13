package pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import utilities.SeleniumUtility;

public class LeftHandNavigationBar extends ProductsPage {
	@FindBy(xpath="//span[@class='title' and text()='Products']") 
	private WebElement productsPageTitle;
	
	@FindBy(xpath="//button[text()='Open Menu']")
	private WebElement openMenuButton;
	
	private String openMenuTextLinks = "//nav/a";
	private String openMenuTextLink = openMenuTextLinks+"[text()='%s']";
	List<WebElement> openMenuTextLinksActual;
	List<String> openMenuTextLinksExpected = new ArrayList<String>();
	
	public LeftHandNavigationBar() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		PageFactory.initElements(driver, this);
		Assert.assertEquals(this.productsPageTitle.getText(),"Products", "Products title not matching");
	}
	
	public void clickAndNavigate(String openMenuVisibleTextLink) {
		this.openMenuButton.click();
		driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(2));
		driver.findElement(By.xpath(String.format(openMenuVisibleTextLink, openMenuVisibleTextLink))).click();
	}
	
	public void validateLHNLinkText() {
		this.openMenuButton.click();
		driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(5));
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		openMenuTextLinksActual = driver.findElements(By.xpath(openMenuTextLinks));
		seleniumUtility = new SeleniumUtility();
		seleniumUtility.explicitWait(driver.findElement(By.xpath(String.format(openMenuTextLink, "All Items"))));
		openMenuTextLinksExpected.add("All Items");
		openMenuTextLinksExpected.add("About");
		openMenuTextLinksExpected.add("Logout");
		openMenuTextLinksExpected.add("Reset App State");
		int i= 0;
		for (WebElement value : openMenuTextLinksActual) {
			Assert.assertEquals(value.getText(), openMenuTextLinksExpected.get(i),value.getText()+ " : is not matched");
			i++;
		}
		
	}
}
