package com.okCredit;

import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class Calc {
	static AppiumDriver<WebElement> driver= null;
	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		// TODO Auto-generated method stub
		DesiredCapabilities caps = DesiredCapabilities.android();
		caps.setCapability("appiumVersion", "1.17.1");
		caps.setCapability("deviceName","emulator-5554");
		caps.setCapability("deviceOrientation", "portrait");
		caps.setCapability("browserName", "");
		caps.setCapability("platformVersion","8.1.0");
		caps.setCapability("platformName","Android");
		caps.setCapability("appPackage", "com.android.calculator2");
		caps.setCapability("appActivity", "com.android.calculator2.Calculator");
		driver= new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
		//driver = (AppiumDriver<WebElement>) new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
		WebElement two=driver.findElement(By.id("com.android.calculator2:id/digit_2"));
		   two.click();
		   Thread.sleep(1000);
		   WebElement plus=driver.findElement(By.id("com.android.calculator2:id/op_add"));
		   plus.click();
		   Thread.sleep(1000);
		   WebElement four=driver.findElement(By.id("com.android.calculator2:id/digit_4"));
		   four.click();
		   Thread.sleep(1000);
		   WebElement equalTo=driver.findElement(By.id("com.android.calculator2:id/eq"));
		   equalTo.click();
		   Thread.sleep(1000);
		   //locate the edit box of the calculator by using By.tagName()
		   WebElement results=driver.findElement(By.id("com.android.calculator2:id/result"));
		   System.out.println(results.getText());
		   driver.quit();
	}

}
