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
import okhttp3.Address;
import pageObjects.nopCommerce.user.UserAddressPageObject;
import pageObjects.nopCommerce.user.UserCustomerInforPageObject;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserMyProductreviewPageObject;
import pageObjects.nopCommerce.user.PageGeneratorManager;
import pageObjects.nopCommerce.user.UserRegisterPageObject;
import pageObjects.nopCommerce.user.UserRewardPointPageObject;

public class Level_07_Switch_Page extends BaseTest {
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
	public void User_01_Register() {
		System.out.println("Pre-condition - Step 01: Click to register link");
		registerPage = homePage.clickToRegisterLink();
		System.out.println("Pre-condition  - Step 2: Input to required field");
		registerPage.inputToFirstNameTextbox(firstName);
		registerPage.inputToLastNameTextbox(lastName);
		registerPage.inputToEmailTextbox(emailAddress);
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(confirmpassword);
		System.out.println("Pre-condition  - Step 3: Click register button");
		registerPage.clickToRegisterButton();
		System.out.println("Pre-condition  - Step 4: Verify msg error displayed");
		Assert.assertEquals(registerPage.getMessageRegisterSuccess(), "Your registration completed");
		
		loginPage = homePage.clickToLoginLink();
		loginPage.clickToLoginButton();
		Assert.assertEquals(loginPage.getErrorMessageRequiredAtEmailTextBox(), "Please enter your email");
	}

	@Test
	public void User_02_Login() {
		loginPage = homePage.clickToLoginLink();
		loginPage.inputToEmailTextBox(emailAddress);
		loginPage.inputToPasswordTextBox(password);
		homePage = loginPage.clickToLoginButton();
	}

	@Test
	public void User_03_Customer_Infor() {
		customerInforPage = homePage.clickToMyAccountLink();
		Assert.assertTrue(customerInforPage.isCustomerInforPageDisplayed());

	}

	@Test
	public void User_04_Switch_Page() {
		// Customer infor => Address Page
		addressPage = customerInforPage.openAddressPage(driver);
		System.out.println("Customer infor => Address");

		// Address => My ProductReview
		myProductReviewPage = addressPage.openMyProductReviewPage(driver);
		System.out.println("Address => My ProductReview");

		// My product page -> Reward point
		rewardPointPage = myProductReviewPage.openRewardPointPage(driver);
		System.out.println("My product page -> Reward point");

		// Reward pint => Address
		addressPage = rewardPointPage.openAddressPage(driver);
		System.out.println("Reward pint => Address");

		// address page -> reward point page   
		rewardPointPage = addressPage.openRewardPointPage(driver);

		// Reward point => my product review page
		myProductReviewPage = rewardPointPage.openMyProductReviewPage(driver);
		
		//myproduc page => customer page
		customerInforPage = myProductReviewPage.openCustomerInforPage(driver);

	}

	@Test
	public void User_05_User_Role() {

	}

	public int generateFakeNumber() {
		Random rand = new Random();
		return rand.nextInt(9999);
	}

	@AfterClass
	public void afterClass() {

	}
}