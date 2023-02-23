package pageUIs.jQuery;

public class HomePageUI {

	public static final String PAGINATION_PAGE_BY_NUMBER = "xpath=//li[@class='qgrd-pagination-page']/a[text()='%s']";
	public static final String PAGINATION_PAGE_ACTIVED_BY_NUMBER = "xpath=//LI[@class='qgrd-pagination-page']/a[@class='qgrd-pagination-page-link active' and text()='%s']";
	public static final String HEADER_PAGE_BY_NUMBER = "xpath=//div[@class='qgrd-header-text' and text()='%s']/parent::div/following-sibling::input";
	public static final String TOTAL_PAGINATION = "xpath=//ul[@class='qgrd-pagination-ul']/li";
	public static final String PAGEINATION_PAGE_INDEX = "xpath=//ul[@class='qgrd-pagination-ul']/li[@class='qgrd-pagination-page'][%s]/a";
	public static final String ALL_Row_Each_Page = "xpath=//tbody/tr";
	public static final String ALL_Row_Country_Each_Page = "xpath=//tbody/tr/td[@data-key='country']";
	public static final String COLUMN_INDEX_BY_COMPANY = "xpath=//tr//th[text()='%s']/preceding-sibling::th";
	public static final String TEXT_BOX_BY_COLUMN_INDEX_AND_ROW_INDEX = "xpath=//tbody/tr[%s]/td[%s]/input";

}

