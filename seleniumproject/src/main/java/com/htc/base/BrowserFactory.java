package com.htc.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.htc.Constants.Constants;


public class BrowserFactory {
	

	public static WebDriver setWebDriver(String browser) {
		WebDriver driver=null;
		if(browser.equalsIgnoreCase("chrome")) {
			System.setProperty(Constants.CHROME_PROPERTY, Constants.CHROME_PATH);
			driver = new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox")) {
			System.setProperty(Constants.GECKO_PROPERTY, Constants.GECKO_PATH);
			driver = new FirefoxDriver();
		}
		else
			System.out.println("Enter Browser properly");
		return driver;

	}
}
