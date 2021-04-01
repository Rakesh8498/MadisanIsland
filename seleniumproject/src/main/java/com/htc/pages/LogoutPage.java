package com.htc.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutPage {
	protected WebDriver driver = null;
	
	@FindBy(xpath = "(//span[@class='label'])[3]")
	private WebElement accountBy;
	
	@FindBy(xpath = "//a[@title='Log Out']")
	private static WebElement logoutbuttonBy;
	
	public LogoutPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void Logout() {
		accountBy.click();
		logoutbuttonBy.click();
	}
	
}
