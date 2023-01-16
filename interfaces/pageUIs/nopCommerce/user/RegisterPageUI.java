package pageUIs.nopCommerce.user;

public class RegisterPageUI {
	public static final String GENDER_MALE_RADIO = "//input[@id='gender-male']";
	public static final String FIRST_NAME_TEXTBOX = "//input[@id='FirstName']";
	public static final String LAST_NAME_TEXTBOX = "//input[@id='LastName']";
	public static final String DAY_DROPDOWN = "//select[@name='DateOfBirthDay']";
	public static final String MONTH_DROPDOWN = "//select[@name='DateOfBirthMonth']";
	public static final String YEAR_DROPDOWN = "//select[@name='DateOfBirthYear']";
	public static final String EMAIL_TEXTBOX = "//input[@id='Email']";
	public static final String COMPANY_TEXTBOX = "//input[@id='Company']";
	public static final String PASSWORD_TEXTBOX = "//input[@id='Password']";
	public static final String CONFIRMPASSWORD_TEXTBOX = "//input[@id='ConfirmPassword']";
	public static final String REGISTER_BUTTON = "//button[@id='register-button']";
	public static final String REGISTER_MESSAGE = "//div[@class='result' and text()= 'Your registration completed']";
	public static final String LOGOUT_LINK = "//a[@class='ico-logout']";
	public static final String FIRST_NAME_ERROR_MESSAGE = "//span[@id='FirstName-error']";
	public static final String LAST_NAME_ERROR_MESSAGE = "//span[@id='LastName-error']";
	public static final String EMAIL_ERROR_MESSAGE = "//li[text()='Wrong email']";
	public static final String PASSWORD_ERROR_MESSAGE = "//span[@id='Password-error']";
	public static final String CONFIRMPASSWORD_ERROR_MESSAGE = "//span[@id='ConfirmPassword-error']";
	public static final String REGISTER_SUCCESS_MESSAGE = "//div[@class='result']";
	public static final String EXISTING_EMAIL_ERROR_MESSAGE = "//li[text()='The specified email already exists']";
	public static final String COUNTINUE_LINK = "///a[@class='button-1 register-continue-button']/";
}
