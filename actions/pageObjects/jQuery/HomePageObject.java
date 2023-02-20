package pageObjects.jQuery;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import pageUIs.jQuery.HomePageUI;

public class HomePageObject extends BasePage {
	WebDriver driver;

	public HomePageObject(WebDriver driver) {
		this.driver = driver;

	}

	public void openPagingByPageNumber(String pageNumber) {
		waitForElementClickAble(driver, HomePageUI.PAGINATION_PAGE_BY_NUMBER, pageNumber);
		clickToElement(driver, HomePageUI.PAGINATION_PAGE_BY_NUMBER, pageNumber);
	}

	public void enterToHeaderTextBox(String headerLabel, String value) {

		waitForElementVisible(driver, HomePageUI.HEADER_PAGE_BY_NUMBER, headerLabel);
		sendkeyToElement(driver, HomePageUI.HEADER_PAGE_BY_NUMBER, value, headerLabel);
	}

	public boolean isPageNumberActived(String pageNumber) {
		waitForElementVisible(driver, HomePageUI.PAGINATION_PAGE_ACTIVED_BY_NUMBER, pageNumber);
		return isElementDisplayed(driver, HomePageUI.PAGINATION_PAGE_ACTIVED_BY_NUMBER, pageNumber);

	}

	public List<String> getValueEachRowAtAllPage() {
		int totalPage = getelementSize(driver, HomePageUI.TOTAL_PAGINATION);
		System.out.println("Total size = " + totalPage);
		List<String> allRowValueAllPage = new ArrayList<String>();
		// Duyệt qua các page number phân trang
		for (int index = 1; index <= totalPage; index++) {
			clickToElement(driver, HomePageUI.PAGEINATION_PAGE_INDEX, String.valueOf(index));
			// get text cuả all row rồi đưa vào array list
			List<WebElement> allRowElementEachPage = getListWebElement(driver, HomePageUI.ALL_Row_Country_Each_Page);
			for (WebElement eachRow : allRowElementEachPage) {
				allRowValueAllPage.add(eachRow.getText());

			}

		}
		//in ra tất cả giá trị row ra - của tất cả các page
		for(String value : allRowValueAllPage) {
			//System.out.println("--------------------");
			System.out.println(value);
		}
		return allRowValueAllPage;
	}
}
