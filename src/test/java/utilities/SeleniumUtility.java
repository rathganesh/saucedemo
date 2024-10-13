package utilities;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BaseTest;

public class SeleniumUtility {

	public WebDriverWait explicityWait;
	
	public void explicitWait(WebElement revealed) {
		explicityWait = new WebDriverWait(BaseTest.driver, Duration.ofSeconds(5));
		explicityWait.until(ExpectedConditions.visibilityOf(revealed));
	}
}
