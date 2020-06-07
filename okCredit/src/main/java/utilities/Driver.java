package utilities;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
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
		
		 else {
			// If no browser passed throw exception
			throw new Exception("Browser is not correct");
		}
		return driver;
	}
	

}
