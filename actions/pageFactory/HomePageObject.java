package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import commons.BasePage;
import commons.BasePageFactory;
import pageUIs.nopCommerce.user.HomePageUI;

public class HomePageObject extends BasePageFactory {
	private WebDriver driver;

	public HomePageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//a[@class='ico-register']")
	private WebElement registerLink;
	@FindBy(xpath = "//a[@class='ico-login']")
	private WebElement loginLink;
//	@FindBy(how = How.XPATH, using = "//a[@class='ico-logout']")
//	private WebElement logoutLink;
	@FindBy(css = "//a[@class='ico-account']")
	private WebElement myaccountLink;

	//page object/Action
	public void clickToRegisterLink()	{
		waitForElementClickAble(driver, registerLink);
		clickToElement(driver, registerLink);
	}
	
	public void clickToLoginLink() {
		waitForElementClickAble(driver, loginLink);
		clickToElement(driver, loginLink);
	}
	public boolean isMyAccountLinkDisplayed() {
		waitForElementVisible(driver, myaccountLink);
		return isElementDisplayed(driver, myaccountLink);
	}
}