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
import org.testng.annotations.Test;
import commons.BasePage;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;

public class Level_03_Page_Object_02_Login {
	// Cái này apply kế thừa để khỏi cần khởi tạo đối tượng

	private WebDriver driver;

	String projectPath = System.getProperty("user.dir");
	String firstName, lastName, day, month, year, emailAddress, companyName, password, confirmpassword, emailAddresserror, emailnotexits;
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	private UserLoginPageObject loginPage;
	// LoginPageObject loginPage = new LoginPageObject(driver);
	
	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + ".\\browserDrivers\\geckodriver.exe");
		// driver = new ChromeDriver();
		// Khởi tạo
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		driver.get("https://demo.nopcommerce.com");
		firstName = "An";
		lastName = "Nguyen";
		day = "10";
		month = "May";
		year = "1999";
		emailAddress = "soidientan" + generateFakeNumber() + "@gmail.com";
		emailAddresserror = "1231231";
		companyName = "ATTA Global";
		password = "phucan1!";
		confirmpassword = "phucan1!";
		emailnotexits = "123123@gmail.com";
		homePage = new UserHomePageObject(driver);
		loginPage = new UserLoginPageObject(driver);
		registerPage = new UserRegisterPageObject(driver);
		
		System.out.println("Pre-condition - Step 01: Click to register link");
		homePage.clickToRegisterLink();
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
		System.out.println("Pre-condition  - Step 5: Click logout");
		registerPage.clickToLogoutButton();
	}

	
	public void User_01_Login_Empty_Data() {
	homePage.clickToLoginLink();
	loginPage.clickToLoginButton();
	Assert.assertEquals(loginPage.getErrorMessageRequiredAtEmailTextBox(), "Please enter your email");
	
	}

	@Test
	public void User_01_Login_Invalid_Email() {
	homePage.clickToLoginLink();
	loginPage.inputToEmailTextBox(emailAddresserror);
	loginPage.clickToLoginButton();
	Assert.assertEquals(loginPage.getErrorMessageEmailNotWrong(),"Wrong email");
	
	}

	

	@Test
	public void User_01_Login_NotExiting_Email() {
		
		homePage.clickToLoginLink();
		loginPage.inputToEmailTextBox(emailnotexits);
		loginPage.inputToPasswordTextBox(password);
		loginPage.clickToLoginButton();
		Assert.assertEquals(loginPage.getErrorMessageEmailDoNotExits(),"Login was unsuccessful. Please correct the errors and try again.\nNo customer account found");

		
	}
	@Test
	public void User_01_Login_Success() {
		homePage.clickToLoginLink();
		loginPage.inputToEmailTextBox(emailAddress);
		loginPage.inputToPasswordTextBox(password);
		loginPage.clickToLoginButton();
	}

	public int generateFakeNumber() {
		Random rand = new Random();
		return rand.nextInt(9999);
	}

	@AfterClass
	public void afterClass() {

	}
}