package com.htc.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogoutPage {
	protected WebDriver driver = null;
	
	@FindBy(xpath = "//a[@title='Log Out']")
	private static WebElement logoutbuttonBy;
	
	public static void Logout() {
		logoutbuttonBy.click();
	}
	
}
