package com.okCredit;


import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;


import junit.framework.Assert;
import pages.HomePage;
import pages.LandingPage;
import utilities.Driver;
import utilities.ExcelUtils;
import utilities.ExtentReport;
import utilities.GenericMethods;

public class AppTest {
	public static WebDriver driver;
	ExtentReport ex= new ExtentReport();
	@BeforeTest
	@Parameters("browser")
	public void setup(String browser) throws Exception {
		browser = GenericMethods.getValueFromPropertiesFile("BROWSER");
		ex.startReport(System.getProperty("os.name"), browser);
		driver=Driver.getDriver(browser);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			}

	@Test(dataProvider = "TestData")
	public void testParameterWithXML(String tcName,String language, String username, String pwd, String custname, String ph, String credit, String payment) throws Exception {
		ex.test = ex.extent.createTest(tcName, "");
		HomePage hp=new HomePage(driver);
		LandingPage lp= new LandingPage(driver);
		hp.selectLanguage(language);
		hp.clickOnGetStarted();
		hp.enterMobileNoAndPassword(username, pwd);
		Assert.assertTrue(lp.verifySuccessfullLogin());
		Assert.assertTrue(lp.addCustomer(custname, ph));
		Assert.assertTrue(lp.addCredit(credit));
		List<String> listOfCustomers=lp.getListOfAllCustomers();
		ex.test.log(Status.INFO, "List of Customers: "+listOfCustomers);
		String balance=lp.addPayment(payment);
		if(balance.equals(GenericMethods.convertToIntAndSubstract(credit, payment))){
			Assert.assertTrue(true);
			ex.test.log(Status.PASS, "Expected balance amt: "+GenericMethods.convertToIntAndSubstract(credit, payment)+" is equal to Actual balance: "+balance);
		}
		else{
			ex.test.log(Status.FAIL, "Expected balance amt: "+GenericMethods.convertToIntAndSubstract(credit, payment)+" is not equal to Actual balance: "+balance);
			Assert.assertTrue(false);
		}
		}

	@AfterMethod
	public void afterEveryTest(ITestResult result) throws Exception{
		ex.getResult(result);
		HomePage hp= new HomePage(driver);
		hp.signout();
			}
	
	@AfterClass
	public void tearDown() {
		if (driver != null) {
			System.out.println("Closing browser");
			driver.quit();
			ex.endTest();
					}
	}

	@DataProvider
	public Object[][] TestData() throws Exception {
		Object[][] testObjArray = ExcelUtils.getTableArray("src/resources/TestData.xlsx", "Sheet1");
		return (testObjArray);
	}

}
