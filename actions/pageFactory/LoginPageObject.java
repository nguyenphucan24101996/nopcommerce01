package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commons.BasePageFactory;
import pageUIs.nopCommerce.user.LoginPageUI;

public class LoginPageObject extends BasePageFactory {
	private WebDriver driver;

	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "Email")
	private WebElement emailTextbox;
	@FindBy(id = "Password")
	private WebElement passwordTextbox;
	@FindBy(xpath = "//button[text()='Log in']")
	private WebElement loginButton;
	@FindBy(xpath = "//span[@id='Email-error']")
	private WebElement emailErrorMessage;
	@FindBy(xpath = "//div[@class='message-error validation-summary-errors']")
	private WebElement unsuccessErrorMessage;

	public void clickToLoginButton() {
		waitForElementClickAble(driver, loginButton);
		clickToElement(driver, loginButton);
	}
	
	public String getErrorMessageEmailNotWrong() {
		waitForElementVisible(driver, emailErrorMessage);
		return getElementText(driver, emailErrorMessage);
	}

	public void inputToEmailTextBox(String emailnotexits) {
		waitForElementVisible(driver, emailTextbox);
		sendkeyToElement(driver, emailTextbox, emailnotexits);
	}

	public void inputToPasswordTextBox(String password) {
		waitForElementVisible(driver, passwordTextbox);
		sendkeyToElement(driver, passwordTextbox, password);
	}

	

	public String getErrorMessageRequiredAtEmailTextBox() {
		waitForElementVisible(driver, emailErrorMessage);
		return getElementText(driver, emailErrorMessage);

	}

	public String getErrorMessageEmailDoNotExits() {
		waitForElementVisible(driver, unsuccessErrorMessage);
		return getElementText(driver, unsuccessErrorMessage);
	}

}
