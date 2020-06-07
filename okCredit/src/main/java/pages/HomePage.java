package pages;

import org.apache.commons.compress.archivers.zip.GeneralPurposeBit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.google.common.base.Verify;

import utilities.ExtentReport;
import utilities.GenericMethods;

public class HomePage {
	ExtentReport ex = new ExtentReport();
	WebDriver driver;
	GenericMethods gm = new GenericMethods();
	@FindBy(id = "")
	private WebElement amountTxt;

	public HomePage(WebDriver driver) {

		this.driver = driver;

		// This initElements method will create all WebElements

		PageFactory.initElements(driver, this);

	}

}
