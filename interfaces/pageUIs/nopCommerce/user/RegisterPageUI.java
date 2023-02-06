package pageUIs.nopCommerce.user;

public class RegisterPageUI {
	public static final String GENDER_MALE_RADIO = "xpath=//input[@id='gender-male']";
	public static final String FIRST_NAME_TEXTBOX = "xpath=//input[@id='FirstName']";
	public static final String LAST_NAME_TEXTBOX = "xpath=//input[@id='LastName']";
	public static final String DAY_DROPDOWN = "xpath=//select[@name='DateOfBirthDay']";
	public static final String MONTH_DROPDOWN = "xpath=//select[@name='DateOfBirthMonth']";
	public static final String YEAR_DROPDOWN = "xpath=//select[@name='DateOfBirthYear']";
	public static final String EMAIL_TEXTBOX = "xpath=//input[@id='Email']";
	public static final String COMPANY_TEXTBOX = "xpath=//input[@id='Company']";
	public static final String PASSWORD_TEXTBOX = "xpath=//input[@id='Password']";
	public static final String CONFIRMPASSWORD_TEXTBOX = "xpath=//input[@id='ConfirmPassword']";
	public static final String REGISTER_BUTTON = "xpath=//button[@id='register-button']";
	public static final String REGISTER_MESSAGE = "xpath=//div[@class='result' and text()= 'Your registration completed']";
	public static final String LOGOUT_LINK = "xpath=//a[@class='ico-logout']";
	public static final String FIRST_NAME_ERROR_MESSAGE = "xpath=//span[@id='FirstName-error']";
	public static final String LAST_NAME_ERROR_MESSAGE = "xpath=//span[@id='LastName-error']";
	public static final String EMAIL_ERROR_MESSAGE = "xpath=//li[text()='Wrong email']";
	public static final String PASSWORD_ERROR_MESSAGE = "xpath=//span[@id='Password-error']";
	public static final String CONFIRMPASSWORD_ERROR_MESSAGE = "xpath=//span[@id='ConfirmPassword-error']";
	public static final String REGISTER_SUCCESS_MESSAGE = "xpath=//div[@class='result']";
	public static final String EXISTING_EMAIL_ERROR_MESSAGE = "xpath=//li[text()='The specified email already exists']";
	public static final String COUNTINUE_LINK = "xpath=//a[@class='button-1 register-continue-button']/";
}
