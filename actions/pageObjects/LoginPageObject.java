package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import commons.BasePage;
import pageUIs.LoginPageUI;

public class LoginPageObject extends BasePage {
	private WebDriver driver;
	private WebDriverWait explicitWait;
	
	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
	}
//	
//	public LoginPageObject(WebDriver driver, WebDriverWait explicitWait) {
//		this.driver = driver;
//		this.explicitWait = explicitWait;
//	}

	public void inputToEmailTextBox(String emailnotexits) {
		waitForElementVisible(driver, LoginPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, LoginPageUI.EMAIL_TEXTBOX, emailnotexits);
	}

	public void inputToPasswordTextBox(String password) {
		waitForElementVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, password);
	}

	public HomePageObject clickToLoginButton() {
		waitForElementClickAble(driver, LoginPageUI.LOGIN_LINK);
		clickToElement(driver, LoginPageUI.LOGIN_LINK);
		return PageGeneratorManager.getHomePage(driver);
		
	}

	public String getErrorMessageRequiredAtEmailTextBox() {
		waitForElementVisible(driver, LoginPageUI.ERRORMESSAGE_EMAIL);
		return getElementText(driver, LoginPageUI.ERRORMESSAGE_EMAIL);
		
	}
	
	public String getErrorMessageEmailNotWrong() {
		waitForElementVisible(driver, LoginPageUI.ERRORMESSAGE_EMAIL);
		return getElementText(driver, LoginPageUI.ERRORMESSAGE_EMAIL);
	}

	public String getErrorMessageEmailDoNotExits() {
		waitForElementVisible(driver, LoginPageUI.ERRORMESSAGE_EMAIL_NOTEXITS);
		return getElementText(driver, LoginPageUI.ERRORMESSAGE_EMAIL_NOTEXITS);
	}



}
