package com.opus.pageobject;

import java.awt.Robot;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.opus.utilities.JavaScriptManuplator;

public class OpusCityMapping {
	WebDriver ldriver;
	WebDriverWait wait;
	JavascriptExecutor js;
	Robot rbt;

	public OpusCityMapping(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(ldriver, this);
	}

	// Documentation Specialist-- Add Check Details
	// Current Address Verification
	@FindBy(xpath = "//strong[contains(text(),'Current Address Verification')]")
	@CacheLookup
	WebElement clickOnCurrentAddressVerification;

	@FindBy(xpath = "//input[@id='unique_city']")
	@CacheLookup
	WebElement txtCityName;

	@FindBy(css = "#dynamic_5")
	@CacheLookup
	WebElement txtCurrentAddressContactNo;

	@FindBy(css = "#dynamic_6")
	@CacheLookup
	WebElement txtCurrentAddress;

	@FindBy(css = "#dynamic_7")
	@CacheLookup
	WebElement txtCurrentAddressPinCode;

	@FindBy(css = "#dynamic_15")
	@CacheLookup
	WebElement txtCurrentAddressPeriodOfStay;

	@FindBy(xpath = "//textarea[@id='check_comment']")
	@CacheLookup
	WebElement txtCurrentAddressChecksComment;

	@FindBy(css = "#ProcessCheckFieldForm > div:nth-child(16) > div:nth-child(2) > input")
	@CacheLookup
	WebElement clickOnCurrentAddressSaveCheckBtn;

	// Documentation Specialist-- Add Check Details
	// Current Address Verification
	public void currentAddressVerification() throws InterruptedException {
		JavaScriptManuplator.waitForElementPresent(ldriver, clickOnCurrentAddressVerification, 60);
		JavaScriptManuplator.javaScriptExecutor(clickOnCurrentAddressVerification, "arguments[0].click()", ldriver);
		WebElement addressCityName = ldriver.findElement(By.xpath("//input[@id='unique_city']"));
		try {
			addressCityName.clear();
			Thread.sleep(2000);
		} catch (StaleElementReferenceException e) {
			Thread.sleep(2000);
			addressCityName.sendKeys("New Delhi");
		}
		addressCityName.sendKeys("New Delhi");
		Thread.sleep(2000);
		String addressCity;
		do {
			addressCityName.sendKeys(Keys.ARROW_DOWN);
			addressCity = addressCityName.getAttribute("value");
			if (addressCity.equals("New Delhi, Delhi, India")) {
				addressCityName.sendKeys(Keys.ENTER);
				break;
			}
			Thread.sleep(2000);
		} while (!addressCity.isEmpty());
		Thread.sleep(2000);
		JavaScriptManuplator.javaScriptExecutor(txtCurrentAddressContactNo, "arguments[0].value='8989897878'", ldriver);
		JavaScriptManuplator.javaScriptExecutor(txtCurrentAddress, "arguments[0].value='Gurgaon'", ldriver);
		JavaScriptManuplator.javaScriptExecutor(txtCurrentAddressPinCode, "arguments[0].value='110091'", ldriver);
		JavaScriptManuplator.javaScriptExecutor(txtCurrentAddressPeriodOfStay, "arguments[0].value='02-02-2020'",
				ldriver);
		JavaScriptManuplator.javaScriptExecutor(txtCurrentAddressChecksComment, "arguments[0].scrollIntoView(true);",
				ldriver);
		JavaScriptManuplator.waitForElementPresent(ldriver, txtCurrentAddressChecksComment, 60);
		JavaScriptManuplator.javaScriptExecutor(txtCurrentAddressChecksComment, "arguments[0].value='Good Comments'",
				ldriver);
		JavaScriptManuplator.javaScriptExecutor(clickOnCurrentAddressSaveCheckBtn, "arguments[0].click()", ldriver);
		Thread.sleep(2000);
		ldriver.navigate().refresh();
		Thread.sleep(2000);
	}

}
