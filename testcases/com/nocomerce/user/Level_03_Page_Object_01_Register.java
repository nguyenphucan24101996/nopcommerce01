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
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.RegisterPageObject;

public class Level_03_Page_Object_01_Register {
	// Cái này apply kế thừa để khỏi cần khởi tạo đối tượng

	private WebDriver driver;

	String projectPath = System.getProperty("user.dir");
	String firstName, lastName, day, month, year, emailAddress, companyName, password, confirmpassword, emailAddresserror;
	private HomePageObject homePage;
	private RegisterPageObject registerPage;
	// LoginPageObject loginPage = new LoginPageObject(driver);
	
	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + ".\\browserDrivers\\geckodriver.exe");
		// driver = new ChromeDriver();
		// Khởi tạo
		driver = new FirefoxDriver();
		emailAddress = "an" + generateFakeNumber() + "@gmail.com";
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		driver.get("https://demo.nopcommerce.com");

		firstName = "An";
		lastName = "Nguyen";
		day = "10";
		month = "May";
		year = "1999";
		emailAddress = "soidientan" + generateFakeNumber() + "@gmail.com";
		emailAddresserror = "1231231!@AS";
		companyName = "ATTA Global";
		password = "phucan1!";
		confirmpassword = "phucan1!";
		homePage = new HomePageObject(driver);
		registerPage = new RegisterPageObject(driver);

	}

	@Test
	public void User_01_Register_Empty_Data() {
		System.out.println("Register Page 01 - Step 01: Click to register link");
		homePage.clickToRegisterLink();
		System.out.println("Register Page 01 - Step 02: Click to register button");
		registerPage.clickToRegisterButton();
		System.out.println("Register Page 01 - Step 03: Verify error message displayed");
		Assert.assertEquals(registerPage.getErrorMessageAtFirstnameTextbox(), "First name is required.");
		Assert.assertEquals(registerPage.getErrorMessageAtLastNameTextbox(), "Last name is required.");
		Assert.assertEquals(registerPage.getErrorMessageAtEmailTextbox(), "Email is required.");
		Assert.assertEquals(registerPage.getErrorMessageAtPasswordTextbox(), "Password is required.");
		Assert.assertEquals(registerPage.getErrorMessageAtConfirmPasswordTextbox(), "Password is required.");

	}

	@Test
	public void User_01_Register_Invalid_Email() {
		System.out.println("Register 02 - Step 01: Click to register link");
		homePage.clickToRegisterLink();
		System.out.println("Register 02 - Step 02: Input to required field");
		registerPage.inputToFirstNameTextbox(firstName);
		registerPage.inputToLastNameTextbox(lastName);
		registerPage.inputToEmailTextbox(emailAddresserror);
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(confirmpassword);
		System.out.println("Register 02 - Step 03: Click register button");
		registerPage.clickToRegisterButton();
		System.out.println("Register 02 - Step 04: Verify msg error  displayed");
		Assert.assertEquals(registerPage.getEmailErrorMessage(), "Wrong email");

	}

	@Test
	public void User_01_Register_Success() {
		
		System.out.println("Register Page 03 - Step 01: Click to register link");
		homePage.clickToRegisterLink();

		System.out.println("Register Page 03  - Step 2: Input to required field");
		registerPage.inputToFirstNameTextbox(firstName);
		registerPage.inputToLastNameTextbox(lastName);
		registerPage.inputToEmailTextbox(emailAddress);
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(confirmpassword);
		System.out.println("Register Page 03  - Step 3: Click register button");
		registerPage.clickToRegisterButton();
		System.out.println("Register Page 03  - Step 4: Verify msg error displayed");
		Assert.assertEquals(registerPage.getMessageRegisterSuccess(), "Your registration completed");

		System.out.println("Register Page 03  - Step 5: Click logout");
		registerPage.clickToLogoutButton();



	}

	@Test
	public void User_01_Regpister_Exiting_Email() {

		System.out.println("Register Page 04 - Step 01: Click to register link");
		homePage.clickToRegisterLink();

		System.out.println("Register Page - Step 2: Input to required field");
		registerPage.inputToFirstNameTextbox(firstName);
		registerPage.inputToLastNameTextbox(lastName);
		registerPage.inputToEmailTextbox(emailAddress);
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(confirmpassword);
		
		
		System.out.println("Register Page - Steo 03: Click Button Register");
		registerPage.clickToRegisterButton();
		
		System.out.println("Register Page - Step 4: Verify msg error displayed");
		Assert.assertEquals(registerPage.getErrorExistingEmailMessage(), "The specified email already exists");
	}

	public void User_01_Regieter_Password_Less_Than_6_Chars() {

	}

	public int generateFakeNumber() {
		Random rand = new Random();
		return rand.nextInt(9999);
	}

	@AfterClass
	public void afterClass() {

	}
}