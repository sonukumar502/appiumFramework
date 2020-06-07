package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Driver {
	public static WebDriver driver;
	public static final String USERNAME="testsonu";
	public static final String ACCESS_KEY="4a9f1ed5-6e27-4e0e-938a-c0c56510893c";
	public static final String URL="http://"+USERNAME+":"+ACCESS_KEY+"@saucelabs.com/wd/hub";
	public static WebDriver getDriver(String browser) throws Exception{
		
		if (browser.equalsIgnoreCase("chrome")) {
			MutableCapabilities sauceOptions = new MutableCapabilities();
			ChromeOptions browserOptions = new ChromeOptions();
			browserOptions.setExperimentalOption("w3c", true);
			browserOptions.setCapability("platformName", "macOS 10.15");
			browserOptions.setCapability("browserVersion", "83.0");
			browserOptions.setCapability("sauce:options", sauceOptions);
			driver = new RemoteWebDriver(new java.net.URL("http://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:80/wd/hub"), browserOptions);
		}
		
		if(browser.equalsIgnoreCase("android9")){
			DesiredCapabilities caps = DesiredCapabilities.android();
			caps.setCapability("appiumVersion", "1.17.1");
			caps.setCapability("deviceName","Samsung Galaxy S9 WQHD GoogleAPI Emulator");
			caps.setCapability("deviceOrientation", "portrait");
			caps.setCapability("browserName", "");
			caps.setCapability("platformVersion","9.0");
			caps.setCapability("platformName","Android");
			caps.setCapability("name","Android Test version 9");
			caps.setCapability("app","sauce-storage:okCredit.apk");
			caps.setCapability("appPackage", "in.okcredit.merchant");
			caps.setCapability("appActivity", "in.okcredit.app.ui.launcher.LauncherActivity");
			driver = new RemoteWebDriver(new java.net.URL("http://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:80/wd/hub"), caps);
		}
		
		 else {
			// If no browser passed throw exception
			throw new Exception("Browser is not correct");
		}
		return driver;
	}
	
	public static void main(String[] args) throws Exception {
		WebDriver d= Driver.getDriver("android9");
		WebElement en=driver.findElement(By.xpath("//*[@resource-id='in.okcredit.merchant:id/english']"));
		en.click();
	}
	

}
