package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.HomePageUI;

public class HomePageObject extends BasePage {
private WebDriver driver;

public HomePageObject(WebDriver driver) {
	this.driver = driver;
}

	public RegisterPageObject clickToRegisterLink() {
		waitForElementClickAble(driver, HomePageUI.REGISTER_LINK);
		clickToElement(driver, HomePageUI.REGISTER_LINK);
		return PageGeneratorManager.getRegisterPage(driver);
 		
	}

	public LoginPageObject clickToLoginLink() {
		waitForElementClickAble(driver, HomePageUI.LOGIN_LINK);
		clickToElement(driver, HomePageUI.LOGIN_LINK);
		return PageGeneratorManager.getLoginPage(driver);
		
	}
}
