package testcase;

import java.util.HashMap;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import base.BaseTest;
import pages.LeftHandNavigationBar;
import pages.LoginPage;
import pages.ProductsPage;
import utilities.ReadXMLFile;

public class FunctionalTestCase extends BaseTest{
	
	LoginPage loginPage;
	ProductsPage productsPage;
	LeftHandNavigationBar leftHandNavigationBar;
	
	ReadXMLFile readXMLFile = new ReadXMLFile();
	public HashMap<String, Object> testData;
	
  @Test(testName = "Login")
  public void tc_01() {
	  extentTest = extentReports.createTest("Login test", "Login test for valid user");
	  extentTest.log(Status.INFO, "Login test has started");
	  readXMLFile.user = "standard_user";
	  testData = readXMLFile.readXMLValue("./src/test/resources/testdata/testdata.xml");
	  
	  loginPage = new LoginPage();
	  loginPage.login(testData.get("name").toString(), testData.get("password").toString());
	  
	  productsPage = new ProductsPage();
	  extentTest.log(Status.PASS, "Login test got passed");
  }
  
  @Test(testName = "LHNB")
  public void tc_02(){
	  extentTest = extentReports.createTest("Left Hand Navigation Bar", "Left Hand Navigation Bar link validate");
	  extentTest.log(Status.INFO, "Login test has started");
	  readXMLFile.user = "standard_user";
	  testData = readXMLFile.readXMLValue("./src/test/resources/testdata/testdata.xml");
	  
	  loginPage = new LoginPage();
	  loginPage.login(testData.get("name").toString(), testData.get("password").toString());
	  
	  productsPage = new ProductsPage();
	  
	  leftHandNavigationBar = new LeftHandNavigationBar();
	  leftHandNavigationBar.validateLHNLinkText();
	  extentTest.log(Status.PASS, "Login test got passed");
  }
}
