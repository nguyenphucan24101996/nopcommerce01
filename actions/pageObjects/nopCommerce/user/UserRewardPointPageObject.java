package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import commons.BasePage;
import pageUIs.nopCommerce.user.RewardPointPageUI;

public class UserRewardPointPageObject extends BasePage {

	WebDriver driver;

	public UserRewardPointPageObject(WebDriver driver) {
		this.driver = driver;
	}

}
