package com.jquery.DataTable_DataGird;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import commons.BasePage;
import commons.BaseTest;
import okhttp3.Address;
import pageObjects.nopCommerce.user.UserAddressPageObject;
import pageObjects.nopCommerce.user.UserCustomerInforPageObject;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserMyProductreviewPageObject;
import pageObjects.jQuery.HomePageObject;
import pageObjects.jQuery.PageGeneratorManager;


public class Level10_DataTable_DataGrid extends BaseTest {
	// CÃ¡i nÃ y apply káº¿ thá»«a Ä‘á»ƒ khá»�i cáº§n khá»Ÿi táº¡o Ä‘á»‘i tÆ°á»£ng
	
	private WebDriver driver;
	HomePageObject homePage;
	List<String> actualAllCountryValues;
	List<String> expectedAllCountryValues;
	@Parameters({"browser", "url"})
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
	
		driver = getBrowserDriver(browserName, appUrl);
		homePage = PageGeneratorManager.getHomePage(driver);
	}

	@Test
	public void Table_Paging() {
		homePage.openPagingByPageNumber("10");
		Assert.assertTrue(homePage.isPageNumberActived("10"));
		homePage.openPagingByPageNumber("15");
		Assert.assertTrue(homePage.isPageNumberActived("15"));
		homePage.openPagingByPageNumber("20");
		Assert.assertTrue(homePage.isPageNumberActived("20"));
		homePage.openPagingByPageNumber("21");
		Assert.assertTrue(homePage.isPageNumberActived("21"));
		
		
	}
	@Test
	public void User_02_Search_Page() {
		homePage.refreshCurrnetPage(driver);
		homePage.enterToHeaderTextBox("Females","624");
		homePage.enterToHeaderTextBox("Country", "Seychelles");
		homePage.enterToHeaderTextBox("Males", "651");
		homePage.enterToHeaderTextBox("Total", "1270");


		
	}
	
	@Test
	public void User_03_GetAllValue() {
		
		//đọc dữ liệu file country.txt ra
		//lưu vào list<string> = expected value
		
		//actual value
		actualAllCountryValues = homePage.getValueEachRowAtAllPage();
		Assert.assertEquals(actualAllCountryValues, expectedAllCountryValues);

		
	}


	@AfterClass
	public void afterClass() {

	}
}