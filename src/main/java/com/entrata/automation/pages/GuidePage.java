package com.entrata.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.entrata.automation.utils.CommonUtils;

public class GuidePage extends CommonUtils {

	WebDriver driver;

	public GuidePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@id='FirstName']")
	public WebElement FirstName;
	@FindBy(xpath = "//input[@id='LastName']")
	public WebElement LastName;
	@FindBy(xpath = "//input[@id='Email']")
	public WebElement Email;
	@FindBy(xpath = "//input[@id='Company']")
	public WebElement Company;
	@FindBy(xpath = "//input[@id='Phone']")
	public WebElement Phone;
	@FindBy(xpath = "//select[@id='Unit_Count__c']")
	public WebElement UnitCount;
	@FindBy(xpath = "//input[@id='Title']")
	public WebElement JobTitle;
	@FindBy(xpath = "//input[@id='demoRequestCheckbox']")
	public WebElement RequestCheckbox;
	@FindBy(xpath = "//button[@class='mktoButton']") public WebElement SubmitButton;

	public void valuesToSelect(int expectedValue) {

		Select select = new Select(UnitCount);

		if (expectedValue >= 1 && expectedValue <= 100) {
			select.selectByValue("1 - 100");
		} else if (expectedValue >= 101 && expectedValue <= 300) {
			select.selectByValue("101 - 300");
		} else if (expectedValue >= 301 && expectedValue <= 2000) {
			select.selectByValue("301 - 2000");
		} else {
			select.selectByValue("2000+");

		}
	}

	public void fillForm(String firstName, String lastName, String email, String company, String phone, String jobTitle,
			int expectedValue) {
		FirstName.sendKeys(firstName);
		LastName.sendKeys(lastName);
		Email.sendKeys(email);
		Company.sendKeys(company);
		Phone.sendKeys(phone);
		valuesToSelect(expectedValue);
		JobTitle.sendKeys(jobTitle);
		RequestCheckbox.click();

	}

}