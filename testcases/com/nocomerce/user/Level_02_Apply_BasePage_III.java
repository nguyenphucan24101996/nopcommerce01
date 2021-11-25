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

public class Level_02_Apply_BasePage_III extends BasePage {
	//Cái này apply kế thừa để khỏi cần khởi tạo đối tượng

	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String emailAddress;
	BasePage basePage;

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + ".\\browserDrivers\\geckodriver.exe");
		// driver = new ChromeDriver();
		// Khởi tạo
		driver = new FirefoxDriver();
		emailAddress = "an" + generateFakeNumber() + "@gmail.com";
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		driver.get("https://demo1.nopcommerce.com");

	}

	@Test
	public void User_01_Register_Empty_Data() {

		basePage.waitForElementClickAble(driver, "//a[@class='ico-register']");
		basePage.clickToElement(driver, "//a[@class='ico-register']");
		basePage.waitForElementClickAble(driver, "//button[@id='register-button']");
		basePage.clickToElement(driver, "//button[@id='register-button']");

		Assert.assertEquals(basePage.getElementText(driver, "//span[@id='FirstName-error']"),
				"First name is required.");
		Assert.assertEquals(basePage.getElementText(driver, "//span[@id='LastName-error']"), "Last name is required.");
		Assert.assertEquals(basePage.getElementText(driver, "//span[@id='Email-error']"), "Email is required.");
		Assert.assertEquals(basePage.getElementText(driver, "//span[@id='Password-error']"), "Password is required.");
		Assert.assertEquals(basePage.getElementText(driver, "//span[@id='ConfirmPassword-error']"), "Password is required.");

	}

	@Test
	public void User_01_Register_Invalid_Email() {
		basePage.waitForElementClickAble(driver, "//a[@class='ico-register']");
		basePage.clickToElement(driver, "//a[@class='ico-register']");
		basePage.sendkeyToElement(driver, "//input[@id='FirstName']", "An");
		basePage.sendkeyToElement(driver, "//input[@id='LastName']", "Nguyen");
		basePage.sendkeyToElement(driver, "//input[@id='Email']", "234234232");
		basePage.sendkeyToElement(driver, "//input[@id='Password']", "12312312");
		basePage.sendkeyToElement(driver, "//input[@id='ConfirmPassword']", "12312312");

		basePage.clickToElement(driver, "//button[@id='register-button']");
		Assert.assertEquals(basePage.getElementText(driver, "//span[@id='Email-error']"), "Wrong email");

	}

	@Test
	public void User_01_Register_Success() {
		basePage.waitForElementClickAble(driver, "//a[@class='ico-register']");
		basePage.clickToElement(driver, "//a[@class='ico-register']");
		basePage.sendkeyToElement(driver, "//input[@id='FirstName']", "An");
		basePage.sendkeyToElement(driver, "//input[@id='LastName']", "Nguyen");
		basePage.sendkeyToElement(driver, "//input[@id='Email']", emailAddress);
		basePage.sendkeyToElement(driver, "//input[@id='Password']", "12312312");
		basePage.sendkeyToElement(driver, "//input[@id='ConfirmPassword']", "12312312");

		basePage.clickToElement(driver, "//button[@id='register-button']");
		Assert.assertEquals(basePage.getElementText(driver, "//div[@class='result']"), "Your registration completed");
		basePage.clickToElement(driver, "//a[@class='ico-logout']");

	}

	@Test
	public void User_01_Regpister_Exiting_Email() {
		basePage.waitForElementClickAble(driver, "//a[@class='ico-register']");
		basePage.clickToElement(driver, "//a[@class='ico-register']");
		basePage.sendkeyToElement(driver, "//input[@id='FirstName']", "An");
		basePage.sendkeyToElement(driver, "//input[@id='LastName']", "Nguyen");
		basePage.sendkeyToElement(driver, "//input[@id='Email']", emailAddress);
		basePage.sendkeyToElement(driver, "//input[@id='Password']", "12312312");
		basePage.sendkeyToElement(driver, "//input[@id='ConfirmPassword']", "12312312");
		basePage.clickToElement(driver, "//button[@id='register-button']");
		Assert.assertEquals(basePage.getElementText(driver, "//li[text()='The specified email already exists']"),
				"The specified email already exists");

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