package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomePageObject {
	private WebDriver driver;

	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(how = How.XPATH, using = "//a[@class='ico-register']")
	private WebElement registerLink;
	@FindBy(how = How.XPATH, using = "//a[@class='ico-login']")
	private WebElement loginLink;
	@FindBy(how = How.XPATH, using = "//a[@class='ico-logout']")
	private WebElement logoutLink;
	@FindBy(how = How.XPATH, using = "//a[@class='ico-account']")
	private WebElement myaccountLink;

	//page object/Action
}
