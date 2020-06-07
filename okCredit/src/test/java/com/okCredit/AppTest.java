package com.okCredit;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import io.github.bonigarcia.wdm.WebDriverManager;
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
	public void testParameterWithXML(String tcName,String amt, String srcCurr, String targetCurr) throws Exception {
		ex.test = ex.extent.createTest(tcName, "");
		HomePage hp=new HomePage(driver);
		LandingPage lp= new LandingPage(driver);
		hp.selectLanguage("english");
		hp.clickOnGetStarted();
		hp.enterMobileNoAndPassword("7406764431", "123456");
		Assert.assertTrue(lp.verifySuccessfullLogin());
		Assert.assertTrue(lp.addCustomer("test1", ""));
		Assert.assertTrue(lp.addCredit("100"));
		List<String> listOfCustomers=lp.getListOfAllCustomers();
		ex.test.log(Status.INFO, "List of Customers: "+listOfCustomers);
		}

	@AfterMethod
	public void afterEveryTest(ITestResult result) throws Exception{
		ex.getResult(result);
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
