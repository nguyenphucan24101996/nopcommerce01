package commons;

import java.util.List;
import java.util.Set;

import javax.management.RuntimeErrorException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageObjects.nopCommerce.user.UserAddressPageObject;
import pageObjects.nopCommerce.user.UserCustomerInforPageObject;
import pageObjects.nopCommerce.user.UserMyProductreviewPageObject;
import pageObjects.nopCommerce.user.PageGeneratorManager;
import pageObjects.nopCommerce.user.UserRewardPointPageObject;
import pageUIs.nopCommerce.user.AddressPageUI;
import pageUIs.nopCommerce.user.BasePageUI;
import pageUIs.nopCommerce.user.HomePageUI;
import pageUIs.nopCommerce.user.MyproductreviewPageUI;

public class BasePage {
	public static BasePage getBasePageObject() {
		return new BasePage();
	}

	public void openPageUrl(WebDriver driver, String pageUrl) {
		driver.get(pageUrl);
	}

	public String getPageTitle(WebDriver driver) {
		return driver.getTitle();
	}

	public String getPageUrl(WebDriver driver) {
		return driver.getCurrentUrl();
	}

	public String getPageSource(WebDriver driver) {
		return driver.getPageSource();

	}

	public void backToPage(WebDriver driver) {
		driver.navigate().back();

	}

	public void forwartToPage(WebDriver driver) {
		driver.navigate().forward();
	}

	public void refreshCurrnetPage(WebDriver driver) {
		driver.navigate().refresh();
	}

	public Alert waitForAlertPresence(WebDriver driver) {
		WebDriverWait exlicitWait = new WebDriverWait(driver, longTimeout);
		return exlicitWait.until(ExpectedConditions.alertIsPresent());
	}

	public void acceptAlert(WebDriver driver) {
		waitForAlertPresence(driver).accept();
	}

	public void cancelAlert(WebDriver driver) {
		waitForAlertPresence(driver).dismiss();
	}

	public String getAlertText(WebDriver driver) {
		return waitForAlertPresence(driver).getText();

	}

	public void sendkeyToAlert(WebDriver driver, String textValue) {
		waitForAlertPresence(driver).sendKeys(textValue);
	}

	public void switchToWindowByID(WebDriver driver, String parentID) {
		Set<String> allWindows = driver.getWindowHandles();
		for (String runWindow : allWindows) {
			if (!runWindow.equals(parentID)) {
				driver.switchTo().window(runWindow);
				break;
			}
		}
	}

	public void switchToWindowByTitle(WebDriver driver, String title) {
		Set<String> allWindows = driver.getWindowHandles();
		for (String runWindows : allWindows) {
			driver.switchTo().window(runWindows);
			String currentWin = driver.getTitle();
			if (currentWin.equals(title)) {
				break;
			}
		}
	}

	public void closeAllWindowsWithoutParent(WebDriver driver, String parentID) {
		Set<String> allWindows = driver.getWindowHandles();
		for (String runWindows : allWindows) {
			if (!runWindows.equals(parentID)) {
				driver.switchTo().window(runWindows);
				driver.close();
			}
		}
		driver.switchTo().window(parentID);
	}

	private By getByLocator(String locatorType) {
		By by = null;
		if (locatorType.startsWith("id=") || locatorType.startsWith("ID=") || locatorType.startsWith("ID=")) {
			by = By.id(locatorType.substring(3));
		} else if (locatorType.startsWith("class=") || locatorType.startsWith("CLASS=")
				|| locatorType.startsWith("Class=")) {
			by = By.className(locatorType.substring(6));
		} else if (locatorType.startsWith("name=") || locatorType.startsWith("NAME=")
				|| locatorType.startsWith("Name=")) {
			by = By.name(locatorType.substring(5));
		} else if (locatorType.startsWith("css=") || locatorType.startsWith("CSS=") || locatorType.startsWith("Css=")) {
			by = By.cssSelector(locatorType.substring(4));
		} else if (locatorType.startsWith("xpath=") || locatorType.startsWith("XPATH=")
				|| locatorType.startsWith("Xpath=")) {
			by = By.xpath(locatorType.substring(6));
		} else {
			throw new RuntimeException("Locator type isn't support");

		}
		return by;
	}

	private String getDynamicXpath(String locatorType, String... values) {
		if (locatorType.startsWith("xpath=") || locatorType.startsWith("=XPATH") || locatorType.startsWith("Xpath=")) {

			locatorType = String.format(locatorType, (Object[]) values);
		}
		return locatorType;
	}

	public WebElement getWebElement(WebDriver driver, String locatorType) {
		return driver.findElement(getByLocator(locatorType));
	}

	public List<WebElement> getListWebElement(WebDriver driver, String locatorType) {
		return driver.findElements(getByLocator(locatorType));
	}

	public void clickToElement(WebDriver driver, String locatorType) {
		getWebElement(driver, locatorType).click();
	}

	public void clickToElement(WebDriver driver, String locatorType, String... dynamicValues) {
		getWebElement(driver, getDynamicXpath(locatorType, dynamicValues)).click();
	}

	public void sendkeyToElement(WebDriver driver, String locatorType, String value) {
		WebElement element = getWebElement(driver, locatorType);
		element.clear();
		element.sendKeys(value);
	}

	public void sendkeyToElement(WebDriver driver, String locatorType, String value, String... dynamicValues) {
		WebElement element = getWebElement(driver, getDynamicXpath(locatorType, dynamicValues));
		element.clear();
		element.sendKeys(value);
	}

	public void selectItemInDefaultDropdown(WebDriver driver, String locatorType, String itemText) {
		Select select = new Select(getWebElement(driver, locatorType));
		select.selectByVisibleText(itemText);
	}

	public void selectItemInDefaultDropdown(WebDriver driver, String locatorType, String itemText,
			String dymanicValues) {
		Select select = new Select(getWebElement(driver, getDynamicXpath(locatorType, dymanicValues)));
		select.selectByVisibleText(itemText);
	}

	public String getFirstSelectedItemInDefaultDropdown(WebDriver driver, String locatorType) {
		Select select = new Select(getWebElement(driver, locatorType));
		return select.getFirstSelectedOption().getText();
	}

	public boolean isDropdownMultiple(WebDriver driver, String locatorType) {
		Select select = new Select(getWebElement(driver, locatorType));
		return select.isMultiple();
	}

	public void selectItemInCustomDropdown(WebDriver driver, String parentLocator, String childItemLocator,
			String expectedItem) {

		getWebElement(driver, parentLocator).click();
		sleepInSecond(1);
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		// explicitWait = new WebDriverWait(driver, longTimeout);
		List<WebElement> allItems = explicitWait
				.until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByLocator(childItemLocator)));

		for (WebElement item : allItems) {
			if (item.getText().trim().equals(expectedItem)) {
				JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
				jsExecutor.executeScript("arguments[0].scrollIntoView(true);", item);
				sleepInSecond(1);

				item.click();
				sleepInSecond(1);
				break;
			}
		}
	}

	public void sleepInSecond(long timeoutInsecond) {
		try {
			Thread.sleep(timeoutInsecond * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public String getAttreibuteValue(WebDriver driver, String locatorType, String attributname) {
		return getWebElement(driver, locatorType).getAttribute(attributname);
	}

	public String getElementText(WebDriver driver, String locatorType) {
		return getWebElement(driver, locatorType).getText();
	}

	public String getElementText(WebDriver driver, String locatorType, String... dynamicValues) {
		return getWebElement(driver, getDynamicXpath(locatorType, dynamicValues)).getText();
	}

	public String getlementCssValue(WebDriver driver, String locatorType, String propertyName) {
		return getWebElement(driver, locatorType).getCssValue(propertyName);
	}

	public String convertRgbaToHexa(String rgaValue) {
		return Color.fromString(convertRgbaToHexa(rgaValue)).asHex();

	}

	public int getelementSize(WebDriver driver, String locator) {
		return getListWebElement(driver, locator).size();
	}

	public int getelementSize(WebDriver driver, String locator, String... dynamicValues) {
		return getListWebElement(driver, getDynamicXpath(locator, dynamicValues)).size();
	}

	public void checkToDefaultCheckboxRadio(WebDriver driver, String locatorType) {
		WebElement element = getWebElement(driver, locatorType);
		if (!element.isSelected()) {
			element.click();
		}
	}

	public void uncheckToDefaultCheckboxRadio(WebDriver driver, String locatorType) {
		WebElement element = getWebElement(driver, locatorType);
		if (element.isSelected()) {
			element.click();
		}
	}

	public boolean isElementDisplayed(WebDriver driver, String locatorType) {

		return getWebElement(driver, locatorType).isDisplayed();
	}

	public boolean isElementDisplayed(WebDriver driver, String locatorType, String... dynamicValues) {

		return getWebElement(driver, getDynamicXpath(locatorType, dynamicValues)).isDisplayed();
	}

	public boolean isElemenEnabled(WebDriver driver, String locatorType) {
		return getWebElement(driver, locatorType).isEnabled();
	}

	public boolean isElementSelected(WebDriver driver, String locatorType) {
		return getWebElement(driver, locatorType).isSelected();
	}

	public void switchToFrameIframe(WebDriver driver, String locatorType) {
		driver.switchTo().frame(getWebElement(driver, locatorType));

	}

	public void switchToDefaultContent(WebDriver driver, String locatorType) {
		driver.switchTo().defaultContent();
	}

	public void hoverMouseToElement(WebDriver driver, String locatorType) {
		Actions action = new Actions(driver);
		action.moveToElement(getWebElement(driver, locatorType)).perform();
		;
	}

	public void scrollToBottomPage(WebDriver driver) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}

	public void highlightElement(WebDriver driver, String locator) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		WebElement element = getWebElement(driver, locator);
		String originalStyle = element.getAttribute("style");
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style",
				"border: 2px solid red; border-style: dashed;");
		sleepInSecond(1);
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style",
				originalStyle);
	}

	public void clickToElementByJS(WebDriver driver, String locatorType) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].click();", getWebElement(driver, locatorType));
	}

	public void scrollToElement(WebDriver driver, String locatorType) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", getWebElement(driver, locatorType));
	}

	public void removeAttributeInDOM(WebDriver driver, String locatorType, String attributeRemove) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].removeAttribute('" + attributeRemove + "');",
				getWebElement(driver, locatorType));
	}

	public boolean areJQueryAndJSLoadedSuccess(WebDriver driver) {

		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

		ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				try {
					return ((Long) jsExecutor.executeScript("return jQuery.active") == 0);
				} catch (Exception e) {
					return true;
				}
			}
		};

		ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				return jsExecutor.executeScript("return document.readyState").toString().equals("complete");
			}
		};

		return explicitWait.until(jQueryLoad) && explicitWait.until(jsLoad);
	}

	public String getElementValidationMessage(WebDriver driver, String locatorType) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		return (String) jsExecutor.executeScript("return arguments[0].validationMessage;",
				getWebElement(driver, locatorType));
	}

	public boolean isImageLoaded(WebDriver driver, String locatorType) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		boolean status = (boolean) jsExecutor.executeScript(
				"return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0",
				getWebElement(driver, locatorType));
		if (status) {
			return true;
		} else {
			return false;
		}
	}

	public WebElement waitForElementVisible(WebDriver driver, String locatorType) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		return explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByLocator(locatorType)));
	}

	public WebElement waitForElementVisible(WebDriver driver, String locatorType, String... dynamicValues) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		return explicitWait.until(ExpectedConditions
				.visibilityOfElementLocated(getByLocator(getDynamicXpath(locatorType, dynamicValues))));
	}

	public WebElement waitForElementClickAble(WebDriver driver, String locatorType) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		return explicitWait.until(ExpectedConditions.elementToBeClickable(getByLocator(locatorType)));
	}

	public WebElement waitForElementClickAble(WebDriver driver, String locatorType, String... dynamicValues) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		return explicitWait.until(
				ExpectedConditions.elementToBeClickable(getByLocator(getDynamicXpath(locatorType, dynamicValues))));
	}

	public boolean waitForElementInvisible(WebDriver driver, String locatorType) {

		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		return explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByLocator(locatorType)));
	}

	public boolean waitForElementInvisible(WebDriver driver, String locatorType, String... dynamicValues) {

		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		return explicitWait.until(ExpectedConditions
				.invisibilityOfElementLocated(getByLocator(getDynamicXpath(locatorType, dynamicValues))));
	}

	public void waitForAllElementInvisible(WebDriver driver, String locatorType) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.elementToBeClickable(getByLocator(locatorType)));
	}

	public void waitForAllElementInvisible(WebDriver driver, String locatorType, String... dynamicValues) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(
				ExpectedConditions.elementToBeClickable(getByLocator(getDynamicXpath(locatorType, dynamicValues))));
	}

	// Level_09_Dynamic_locator

	public BasePage openPagesAtMyAccountByName(WebDriver driver, String pageName) {
		waitForElementClickAble(driver, BasePageUI.DYNAMIC_PAGE_AT_MY_ACCOUNT_AREA, pageName);
		clickToElement(driver, BasePageUI.DYNAMIC_PAGE_AT_MY_ACCOUNT_AREA, pageName);
		switch (pageName) {
		case "Customer info":
			return PageGeneratorManager.getUserCustomerPage(driver);
		case "Addresses":
			return PageGeneratorManager.getUserAddressPage(driver);
		case "My product reviews":
			return PageGeneratorManager.getUserMyproductReviewPage(driver);
		case "Reward points":
			return PageGeneratorManager.getUserRewardPointPage(driver);
		default:
			throw new RuntimeException("Invalid page name at My account area.");
		}

	}

	// Level_07_Switch_Page

	public UserAddressPageObject openAddressPage(WebDriver driver) {
		waitForElementClickAble(driver, BasePageUI.ADDRESS_LINK);
		clickToElement(driver, BasePageUI.ADDRESS_LINK);
		return PageGeneratorManager.getUserAddressPage(driver);
	}

	public UserMyProductreviewPageObject openMyProductReviewPage(WebDriver driver) {
		waitForElementClickAble(driver, BasePageUI.MYPRODUCTREVIEW_LINK);
		clickToElement(driver, BasePageUI.MYPRODUCTREVIEW_LINK);
		return PageGeneratorManager.getUserMyproductReviewPage(driver);

	}

	public UserRewardPointPageObject openRewardPointPage(WebDriver driver) {
		waitForElementClickAble(driver, BasePageUI.REWARDPOINT_LINK);
		clickToElement(driver, BasePageUI.REWARDPOINT_LINK);
		return PageGeneratorManager.getUserRewardPointPage(driver);
	}

	public UserCustomerInforPageObject openCustomerInforPage(WebDriver driver) {
		waitForElementClickAble(driver, BasePageUI.CUSTOMERINFOR_LINK);
		clickToElement(driver, BasePageUI.CUSTOMERINFOR_LINK);
		return PageGeneratorManager.getUserCustomerPage(driver);
	}

	private long shortTimeout = 5;
	private long longTimeout = 30;
}
