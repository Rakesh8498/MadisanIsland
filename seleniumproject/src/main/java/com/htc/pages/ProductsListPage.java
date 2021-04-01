package com.htc.pages;

import java.util.NoSuchElementException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsListPage {
	private WebDriver driver = null;
	@FindBy(xpath = "(//*[@class='products-grid products-grid--max-3-col first last odd']/li/a)[1]")
	private WebElement productBy;

	public ProductsListPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void selectproductBy() {
		try {
			productBy.click();
		} catch ( Exception exception) {
			exception.printStackTrace();
		}
	}
}
