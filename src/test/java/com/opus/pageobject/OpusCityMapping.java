package com.opus.pageobject;

import java.awt.Robot;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

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

	// City Mapping By selecting Admin Role
	@FindBy(xpath = "//select[@name='selectedRoleId']")
	@CacheLookup
	WebElement selectAdminRole;// Admin

	@FindBy(xpath = "//span[normalize-space()='Vendor Management']")
	@CacheLookup
	WebElement clickOnVendorManagementModule;

	// Verify Internal Vendor
	@FindBy(xpath = "//td[contains(text(),'Internal Vendor')]")
	@CacheLookup
	WebElement verifyInternalVendorText;

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[3]/form[2]/table[2]/tbody[1]/tr[2]/td[2]/select[1]")
	@CacheLookup
	WebElement selectCountryName;// India

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[3]/form[2]/table[2]/tbody[1]/tr[3]/td[2]/select[1]")
	@CacheLookup
	WebElement selectStateName;// Delhi

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[3]/form[2]/table[3]/tbody[1]/tr[3]/td[2]/input[1]")
	@CacheLookup
	WebElement checkOnCheckBox;

	@FindBy(css = "#master_tat_1")
	@CacheLookup
	WebElement txtTatAddressVerification;

	@FindBy(css = "#master_cost_1")
	@CacheLookup
	WebElement txtCostAddressVerification;

	@FindBy(css = "#master_service_charge_1")
	@CacheLookup
	WebElement txtServiceChargeAddressVerification;

	@FindBy(css = "#master_date_1")
	@CacheLookup
	WebElement txtDateAddressVerification;

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[3]/form[2]/table[3]/tbody[1]/tr[5]/td[1]/input[3]")
	@CacheLookup
	WebElement clickOnUpdateBtn;

	// City Map Module
	@FindBy(xpath = "//span[contains(text(),'City Mapping')]")
	@CacheLookup
	WebElement clickOnCityMappingModule;

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[3]/form[1]/table[1]/tbody[1]/tr[1]/td[3]/select[1]")
	@CacheLookup
	WebElement selectCityMapStateName;// Delhi

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[3]/form[1]/table[1]/tbody[1]/tr[1]/td[3]/input[1]")
	@CacheLookup
	WebElement clickOnCityMapGoBtn;

	// Verify City Name and State
	@FindBy(xpath = "//td[contains(text(),'New Delhi')]")
	@CacheLookup
	WebElement verifyCityNameText;// New Delhi

	// Logout Opus Admin Vendor account
	@FindBy(xpath = "//a[contains(text(),'Logout')]")
	@CacheLookup
	WebElement clickOnLogoutBtn;

	// OPus Admin Credentials Details-- VMT Application Login
	@FindBy(xpath = "/html[1]/body[1]/center[1]/fieldset[1]/form[1]/table[1]/tbody[1]/tr[2]/td[2]/input[1]")
	@CacheLookup
	WebElement txtOpusAdminUserName;

	@FindBy(xpath = "/html[1]/body[1]/center[1]/fieldset[1]/form[1]/table[1]/tbody[1]/tr[3]/td[2]/input[1]")
	@CacheLookup
	WebElement txtOpusAdminPassword;

	@FindBy(xpath = "/html[1]/body[1]/center[1]/fieldset[1]/form[1]/table[1]/tbody[1]/tr[4]/td[2]/input[1]")
	@CacheLookup
	WebElement clickOnLoginBtn;

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

	// Switch to role: Allocator
	@FindBy(xpath = "/html[1]/body[1]/div[1]/table[1]/tbody[1]/tr[1]/td[3]/table[1]/tbody[1]/tr[2]/td[1]/select[1]")
	@CacheLookup
	WebElement selectAllocatorRole;

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/ul[1]/li[2]/a[1]/span[1]")
	@CacheLookup
	WebElement clickOnUnmappedCheckedModule;

	// Case ARS No.
	@FindBy(xpath = "//td[contains(text(),'Case ARS No.')]")
	@CacheLookup
	WebElement verifyCaseArsNoText;// Case ARS No.

	// City Mapping By selecting Admin Role
	public void adminByCityMapping() throws InterruptedException {
		JavaScriptManuplator.waitForElementPresent(ldriver, selectAdminRole, 120);
		JavaScriptManuplator.selectOptionFromDropDown(selectAdminRole, "Admin");
		wait = new WebDriverWait(ldriver, 60);
		wait.until(ExpectedConditions.visibilityOf(clickOnVendorManagementModule));
		Thread.sleep(1000);
		JavaScriptManuplator.javaScriptExecutor(clickOnVendorManagementModule, "arguments[0].click()", ldriver);
		Thread.sleep(2000);

		// How many rows in table
		int rows = ldriver.findElements(By.xpath("/html[1]/body[1]/div[1]/div[3]/table[1]/tbody[1]/tr")).size();
		// Get Vendor name,
		for (int r = 2; r <= rows; r++) {
			String vendorName = ldriver
					.findElement(By.xpath("/html[1]/body[1]/div[1]/div[3]/table[1]/tbody[1]/tr[" + r + "]/td[3]"))
					.getText();
			if (vendorName.equals("Internal Vendor")) {

				WebElement element = ldriver.findElement(
						By.xpath("/html[1]/body[1]/div[1]/div[3]/table[1]/tbody[1]/tr[" + r + "]/td[11]/a[3]"));
				Thread.sleep(2000);
				element.click();
				break;
			}
		}

		// Verify Internal Vendor
		wait = new WebDriverWait(ldriver, 60);
		wait.until(ExpectedConditions.visibilityOf(verifyInternalVendorText));
		JavaScriptManuplator.selectOptionFromDropDown(selectCountryName, "India");
		JavaScriptManuplator.selectOptionFromDropDown(selectStateName, "Delhi");
		JavaScriptManuplator.javaScriptExecutor(checkOnCheckBox, "arguments[0].click()", ldriver);
		Thread.sleep(1000);
		JavaScriptManuplator.javaScriptExecutor(txtTatAddressVerification, "arguments[0].value='5'", ldriver);
		JavaScriptManuplator.javaScriptExecutor(txtCostAddressVerification, "arguments[0].value='245'", ldriver);
		JavaScriptManuplator.javaScriptExecutor(txtServiceChargeAddressVerification, "arguments[0].value='249'",
				ldriver);
		JavaScriptManuplator.javaScriptExecutor(txtDateAddressVerification, "arguments[0].removeAttribute('readonly')",
				ldriver);
		JavaScriptManuplator.javaScriptExecutor(txtDateAddressVerification, "arguments[0].value='03-06-2022'", ldriver);
		JavaScriptManuplator.javaScriptExecutor(clickOnUpdateBtn, "arguments[0].scrollIntoView(true);", ldriver);
		wait = new WebDriverWait(ldriver, 60);
		wait.until(ExpectedConditions.visibilityOf(clickOnUpdateBtn));
		JavaScriptManuplator.javaScriptExecutor(clickOnUpdateBtn, "arguments[0].click()", ldriver);
		Thread.sleep(1000);

		// City Map Module
		wait = new WebDriverWait(ldriver, 60);
		wait.until(ExpectedConditions.visibilityOf(clickOnCityMappingModule));
		JavaScriptManuplator.javaScriptExecutor(clickOnCityMappingModule, "arguments[0].click()", ldriver);
		Thread.sleep(1000);
		wait = new WebDriverWait(ldriver, 60);
		wait.until(ExpectedConditions.visibilityOf(selectCityMapStateName));
		JavaScriptManuplator.selectOptionFromDropDown(selectCityMapStateName, "Delhi");
		JavaScriptManuplator.javaScriptExecutor(clickOnCityMapGoBtn, "arguments[0].click()", ldriver);
		Thread.sleep(1000);
	}

	// Verify City Name and State
	public String verifyLogoutVendorAdminAccount() {
		wait = new WebDriverWait(ldriver, 60);
		wait.until(ExpectedConditions.visibilityOf(verifyCityNameText));
		return verifyCityNameText.getText();
		/*
		 * // Logout Opus Admin Vendor account
		 * JavaScriptManuplator.javaScriptExecutor(clickOnLogoutBtn,
		 * "arguments[0].click()", ldriver); Thread.sleep(1000);
		 */
	}

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

	// Switch to role: Allocator
	public void switchToRoleAllocator() throws InterruptedException, IOException {
		wait = new WebDriverWait(ldriver, 60);
		wait.until(ExpectedConditions.visibilityOf(selectAllocatorRole));
		JavaScriptManuplator.selectOptionFromDropDown(selectAllocatorRole, "Allocator");
		Thread.sleep(1000);
		wait = new WebDriverWait(ldriver, 60);
		wait.until(ExpectedConditions.visibilityOf(clickOnUnmappedCheckedModule));
		JavaScriptManuplator.javaScriptExecutor(clickOnUnmappedCheckedModule, "arguments[0].click()", ldriver);
		Thread.sleep(1000);
		// How many rows in table
		int rows = ldriver.findElements(By.xpath("/html[1]/body[1]/div[1]/div[3]/table[1]/tbody[1]/tr")).size();
		// Get Vendor name,
		for (int r = 2; r <= rows; r++) {
			String familyName = ldriver
					.findElement(By.xpath("/html[1]/body[1]/div[1]/div[3]/table[1]/tbody[1]/tr[" + r + "]/td[1]"))
					.getText();
			if (familyName.equals("Address Family")) {

				WebElement element = ldriver.findElement(
						By.xpath("/html[1]/body[1]/div[1]/div[3]/table[1]/tbody[1]/tr[" + r + "]/td[2]/a[1]"));
				Thread.sleep(2000);
				element.click();
				break;
			}
		}
		wait = new WebDriverWait(ldriver, 120);
		wait.until(ExpectedConditions.visibilityOf(verifyCaseArsNoText));
		String data = new String(Files.readAllBytes(Paths.get("BridgeCaseArsNo.txt")));
		String arsNumber[] = data.split(" ");
		// How many rows in table
		int row = ldriver.findElements(By.xpath("/html[1]/body[1]/div[1]/div[3]/form[1]/table[1]/tbody[1]/tr")).size();
		// Get Vendor name,
		for (int r = 2; r <= row; r++) {
			String caseArsNo = ldriver
					.findElement(
							By.xpath("/html[1]/body[1]/div[1]/div[3]/form[1]/table[1]/tbody[1]/tr[" + r + "]/td[3]"))
					.getText();
			if (caseArsNo.equals(arsNumber[6])) {

				WebElement element = ldriver.findElement(By.xpath(
						"/html[1]/body[1]/div[1]/div[3]/form[1]/table[1]/tbody[1]/tr[" + r + "]/td[9]/select[1]"));
				Thread.sleep(2000);
				wait = new WebDriverWait(ldriver, 60);
				wait.until(ExpectedConditions.visibilityOf(element));
				JavaScriptManuplator.selectOptionFromDropDown(element, "Internal Vendor");
				break;
			}
		}

	}

}
