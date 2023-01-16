package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import pageObject.nopCommerce.admin.AdminLoginPageObject;
import pageUIs.nopCommerce.user.MyproductreviewPageUI;

public class PageGeneratorManager {

	public static UserHomePageObject getUserHomePage(WebDriver driver) {
		return new UserHomePageObject(driver);
	}

	public static UserLoginPageObject getUserLoginPage(WebDriver driver) {
		return new UserLoginPageObject(driver);
	}

	public static UserRegisterPageObject getUserRegisterPage(WebDriver driver) {
		return new UserRegisterPageObject(driver);
	}

	public static UserCustomerInforPageObject getUserCustomerPage(WebDriver driver) {
		return new UserCustomerInforPageObject(driver);
	}

	public static UserMyProductreviewPageObject getUserMyproductReviewPage(WebDriver driver) {
		return new UserMyProductreviewPageObject(driver);
	}

	public static UserRewardPointPageObject getUserRewardPointPage(WebDriver driver) {
		return new UserRewardPointPageObject(driver);
	}

	public static UserAddressPageObject getUserAddressPage(WebDriver driver) {
		return new UserAddressPageObject(driver);
	}
	
	public static AdminLoginPageObject getAdminLoginPage(WebDriver driver) {
		return new AdminLoginPageObject(driver);
	}

	
}
