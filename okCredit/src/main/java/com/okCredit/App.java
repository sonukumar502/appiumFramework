package com.okCredit;

import org.openqa.selenium.WebDriver;

import junit.framework.Assert;
import pages.HomePage;
import pages.LandingPage;
import utilities.Driver;
import utilities.ExtentReport;

public class App {
	static ExtentReport ex= new ExtentReport();
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Hello World");
		ex.startReport(System.getProperty("os.name"), "android9");
		ex.test = ex.extent.createTest("TestCase", "");
		WebDriver driver=Driver.getDriver("android9");
		HomePage hp=new HomePage(driver);
		LandingPage lp= new LandingPage(driver);
		hp.selectLanguage("english");
		hp.clickOnGetStarted();
		hp.enterMobileNoAndPassword("7406764431", "123456");
		Assert.assertTrue(lp.verifySuccessfullLogin());
		Assert.assertTrue(lp.addCustomer("test1", ""));
		Assert.assertTrue(lp.addCredit("100"));
		driver.quit();
		
	}

}
