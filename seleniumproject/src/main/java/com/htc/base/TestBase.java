package com.htc.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.htc.Constants.Constants;
import com.htc.pages.BillingPage;
import com.htc.pages.CartPage;
import com.htc.pages.HomePage;
import com.htc.pages.Login;
import com.htc.pages.LogoutPage;
import com.htc.pages.OrderConfirmationpage;
import com.htc.pages.ProductsListPage;
import com.htc.pages.ShoppingCartPage;
import com.htc.utility.ScreenShot;

public class TestBase {
	protected WebDriver driver=null;
	protected Login login = null;
	protected HomePage homepage = null;
	protected ProductsListPage productlist = null;
	protected CartPage cartpage = null;
	protected ShoppingCartPage shopping = null;
	protected BillingPage billing = null;
	protected OrderConfirmationpage confirm = null;
	protected LogoutPage logout=null;

	protected ScreenShot screenshot = null;

	public Properties data = null;

	public TestBase() {
		data = new Properties();
		FileInputStream fis = null;
		try {
			fis = new FileInputStream("..\\seleniumproject\\src\\main\\resources\\data.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			data.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@BeforeSuite()
	@Parameters("browser")
	public void start(String browser) {

		this.driver = BrowserFactory.setWebDriver(browser);
		this.driver.get(Constants.URL);
		this.driver.manage().window().maximize();
		this.driver.manage().timeouts().implicitlyWait(Constants.SECONDS, TimeUnit.SECONDS);
	}

	@BeforeClass
	public void browserSetup() {
		login = new Login(driver);
		homepage = new HomePage(driver);
		productlist = new ProductsListPage(driver);
		cartpage = new CartPage(driver);
		shopping = new ShoppingCartPage(driver);
		billing = new BillingPage(driver);
		confirm = new OrderConfirmationpage(driver);
		logout =new LogoutPage(driver);
	}

	/*
	 * @BeforeTest public WebDriver getdriver() { return this.driver;
	 * 
	 * }
	 */
	public WebDriver getDriver() {
		return this.driver;
	}

	@AfterMethod
	public void takescreenshot(ITestResult result) throws IOException, InterruptedException {
		
		 if (ITestResult.SUCCESS == result.getStatus()) {
			
			logout.Logout();
		}
		
	}

}
