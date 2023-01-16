package com.nocomerce.user;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import commons.BasePage;
import commons.BaseTest;
import commons.GlobalConstants;
import okhttp3.Address;
import pageObject.nopCommerce.admin.AdminLoginPageObject;
import pageObjects.nopCommerce.user.UserAddressPageObject;
import pageObjects.nopCommerce.user.UserCustomerInforPageObject;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserMyProductreviewPageObject;
import pageObjects.nopCommerce.user.PageGeneratorManager;
import pageObjects.nopCommerce.user.UserRegisterPageObject;
import pageObjects.nopCommerce.user.UserRewardPointPageObject;

public class Level_08_Switch_Role extends BaseTest {
	// Cái này apply kế thừa để khỏi cần khởi tạo đối tượng

	private WebDriver driver;

	String projectPath = System.getProperty("user.dir");
	String firstName, lastName, day, month, year, emailAddress, companyName, password, confirmpassword,
			emailAddresserror, emailnotexits, emailAddress1;
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	private UserLoginPageObject loginPage;
	private UserCustomerInforPageObject customerInforPage;
	private UserRewardPointPageObject rewardPointPage;
	private UserMyProductreviewPageObject myProductReviewPage;
	private UserAddressPageObject addressPage;
	private AdminLoginPageObject adminLoginPage;
	// LoginPageObject loginPage = new LoginPageObject(driver);

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		System.out.println("Run on" + browserName);
		driver = getBrowserDriver(browserName);
		// System.setProperty("webdriver.gecko.driver", projectPath +
		// ".\\browserDrivers\\geckodriver.exe");
		// driver = new ChromeDriver();
		// Khởi tạo
		homePage = PageGeneratorManager.getUserHomePage(driver);

		// driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		driver.get("https://demo.nopcommerce.com");
		firstName = "An";
		lastName = "Nguyen";
		day = "10";
		month = "May";
		year = "1999";
		emailAddress = "soidientan" + generateFakeNumber() + "@gmail.com";
		emailAddress1 = "soidientan1000@gmail.com";
		emailAddresserror = "1231231";
		companyName = "ATTA Global";
		password = "Phucan1!";
		confirmpassword = "Phucan1!";
		emailnotexits = "123123@gmail.com";
		loginPage = new UserLoginPageObject(driver);
		registerPage = new UserRegisterPageObject(driver);

	}

	@Test
	public void Role_01_User() {
		loginPage = homePage.clickToLoginLink();
		loginPage.loginAsuser(emailAddress, password);
		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
	}

	@Test
	public void Role_02_Admin() {
		homePage.openPageUrl(driver, GlobalConstants.ADMIN_PAGE_URL);
		adminLoginPage = PageGeneratorManager.getAdminLoginPage(driver);
	}

	@AfterClass
	public void afterClass() {

	}
}