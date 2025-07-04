package com.entrata.automation.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.entrata.automation.utils.CommonUtils;

public class LandingPage extends CommonUtils {

	WebDriver driver;

	public LandingPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "(//div[contains(text(),'3 Keys to Resident Satisfaction')])[2]")
	public WebElement imageElement;
	@FindBy(xpath = "(//div[contains(text(),'DOWNLOAD NOW')])[1]")
	public WebElement hoverLink;

	public void scrollToElement(WebDriver driver, WebElement imageElement) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].scrollIntoView(true);", imageElement);
	}

	public void goTo() {
		driver.get("https://www.entrata.com/");
	}

}
