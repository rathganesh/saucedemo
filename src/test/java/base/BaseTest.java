package base;

import java.io.IOException;

import javax.management.modelmbean.XMLParseException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.ReadPropertyFile;
import utilities.SeleniumUtility;

public class BaseTest {

	public static WebDriver driver;
	public ReadPropertyFile readPropertyFile = new ReadPropertyFile();
	public ExtentReports extentReports;
	public ExtentSparkReporter extentSparkReporter;
	public ExtentTest extentTest;
	public SeleniumUtility seleniumUtility;
	@BeforeSuite
	public void setupReport() {

		extentReports = new ExtentReports(); 
		extentSparkReporter = new ExtentSparkReporter("test-output/reporter.html");
		extentReports.attachReporter(extentSparkReporter);

	}

	@BeforeMethod
	public void setup() throws IOException, XMLParseException {
		
		if (readPropertyFile.getPropertiesFileValue("browser.property").equalsIgnoreCase("chrome")) {
			//System.setProperty(readPropertyFile.getPropertiesFileValue("browser.property"), System.getProperty("user.dir")+readPropertyFile.getPropertiesFileValue("driver.chrome"));
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.get(readPropertyFile.getPropertiesFileValue("testurl"));

		}else
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.get(readPropertyFile.getPropertiesFileValue("testurl"));
		}

	}

	@AfterMethod
	public void tearDown() {
		driver.close();
		driver.quit();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@AfterSuite
	public void tearDownReport() {
		extentReports.flush(); 
	}
}
