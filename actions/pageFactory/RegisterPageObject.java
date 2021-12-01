package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commons.BasePageFactory;
import pageUIs.RegisterPageUI;

public class RegisterPageObject extends BasePageFactory {
	private WebDriver driver;

	public RegisterPageObject(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@id='gender-male']")
	private WebElement genderMale;

	@FindBy(xpath = "//input[@id='FirstName']")
	private WebElement firstnameTextBox;

	@FindBy(xpath = "//input[@id='LastName']")
	private WebElement lastnameTextBox;
	
	@FindBy(xpath = "//select[@name='DateOfBirthDay']")
	private WebElement dateofbirthDay;
	
	@FindBy(xpath = "//select[@name='DateOfBirthMonth']")
	private WebElement dateofbirthMonth;
	
	@FindBy(xpath = "//select[@name='DateOfBirthYear']")
	private WebElement dateofbirthYear;
	
	@FindBy(xpath = "//input[@id='Email']")
	private WebElement emailTextBox;
	
	@FindBy(xpath = "//input[@id='Company']")
	private WebElement companyTextBox;
	
	@FindBy(xpath = "//input[@id='Password']")
	private WebElement passwordTextBox;
	
	@FindBy(xpath = "//input[@id='ConfirmPassword']")
	private WebElement confirmpasswordTextBox;
	@FindBy(xpath = "//button[@id='register-button']")
	private WebElement registerButton;
	
	@FindBy(xpath = "//div[@class='result' and text()= 'Your registration completed']")
	private WebElement registerMessage;
	
	@FindBy(xpath = "//a[@class='ico-logout']")
	private WebElement logoutButton;
	
	@FindBy(xpath = "//span[@id='FirstName-error']")
	private WebElement firstnameErrorMessage;
	
	@FindBy(xpath = "//span[@id='LastName-error']")
	private WebElement lastnameErrorMessage;
	
	@FindBy(xpath = "//li[text()='Wrong email']")
	private WebElement emailErrorMessage;
	
	@FindBy(xpath = "//span[@id='Password-error']")
	private WebElement passwordErrorMessage;
	
	@FindBy(xpath = "//span[@id='ConfirmPassword-error']")
	private WebElement confirmpasswordErrorMessage;
	
	@FindBy(xpath = "//div[@class='result']")
	private WebElement registerSuccessMessage;
	
	@FindBy(xpath = "//li[text()='The specified email already exists']")
	private WebElement emailexistsErrorMessage;
	
	public void clickToRegisterButton() {
		waitForElementClickAble(driver, registerButton);
		clickToElement(driver, registerButton);
	}

	public String getErrorMessageAtFirstnameTextbox() {
		waitForElementVisible(driver, firstnameErrorMessage);
		return getElementText(driver, firstnameErrorMessage);
	}
	
	public String getErrorMessageAtLastNameTextbox() {
		waitForElementVisible(driver, lastnameErrorMessage);
		return getElementText(driver, lastnameErrorMessage);
	}
	public String getErrorMessageAtEmailTextbox() {
		waitForElementVisible(driver, emailErrorMessage);
		return getElementText(driver, emailErrorMessage);
	}
	public String getErrorMessageAtPasswordTextbox() {
		waitForElementVisible(driver, passwordErrorMessage);
		return getElementText(driver, passwordErrorMessage);
	}
	public String getErrorMessageAtConfirmPasswordTextbox() {
		waitForElementVisible(driver, confirmpasswordErrorMessage);
		return getElementText(driver, confirmpasswordErrorMessage);
	}
	

	public void inputToLastNameTextbox(String lastName) {
		waitForElementVisible(driver, lastnameTextBox);
		sendkeyToElement(driver, lastnameTextBox, lastName);

	}
	public void inputToEmailTextbox(String email) {
		waitForElementVisible(driver, emailTextBox);
		sendkeyToElement(driver, emailTextBox, email);
	}

	public void inputToFirstNameTextbox(String firstName) {
		waitForElementVisible(driver, firstnameTextBox);
		sendkeyToElement(driver, firstnameTextBox, firstName);
	}

	public void inputToPasswordTextbox(String password) {
		waitForElementVisible(driver, passwordTextBox);
		sendkeyToElement(driver, passwordTextBox, password);
		// TODO Auto-generated method stub

	}

	public void inputToConfirmPasswordTextbox(String confirmpassword) {
		waitForElementVisible(driver, confirmpasswordTextBox);
		sendkeyToElement(driver, confirmpasswordTextBox, confirmpassword);
		// TODO Auto-generated method stub

	}

	public String getEmailErrorMessage() {
		waitForElementVisible(driver, emailErrorMessage);
		return getElementText(driver, emailErrorMessage);
	}

	public String getMessageRegisterSuccess() {
		waitForElementVisible(driver, registerSuccessMessage);
		return getElementText(driver, registerSuccessMessage);

	}

	public void clickToLogoutButton() {
		waitForElementClickAble(driver, logoutButton);
		clickToElement(driver, logoutButton);
	}

	public String getErrorExistingEmailMessage() {
		waitForElementVisible(driver, emailexistsErrorMessage);
		return getElementText(driver, emailexistsErrorMessage);
	}
}
