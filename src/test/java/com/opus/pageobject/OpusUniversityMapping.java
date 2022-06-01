package com.opus.pageobject;

import java.awt.Robot;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

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
import org.openqa.selenium.support.ui.WebDriverWait;

import com.opus.utilities.JavaScriptManuplator;

public class OpusUniversityMapping {
	WebDriver ldriver;
	WebDriverWait wait;
	JavascriptExecutor js;
	Robot rbt;

	public OpusUniversityMapping(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(ldriver, this);
	}

	// University Mapping By selecting Admin Role
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

	@FindBy(xpath = "//select[@name='STATE_ID']")
	@CacheLookup
	WebElement selectStateName;// Delhi

	@FindBy(xpath = "//select[@id='UNIVERSITY_ID']")
	@CacheLookup
	WebElement selectUniversityName;// University of Delhi
	
	@FindBy(xpath = "//select[@id='CITY_ID']")
	@CacheLookup
	WebElement selectCityName;// New Delhi

	@FindBy(css = "#check_box_1")
	@CacheLookup
	WebElement checkOnCheckBox;

	// Education Verification-- A G DAV Centenary Public School(New Delhi)
	@FindBy(xpath = "//a[contains(text(),'A G DAV Centenary Public School(New Delhi)')]")
	@CacheLookup
	WebElement verifyAGDavSchool;
	
	@FindBy(css = "#master_tat_1_1")
	@CacheLookup
	WebElement txtTatEducationVerification;

	@FindBy(css = "#master_cost_1_1")
	@CacheLookup
	WebElement txtCostEducationVerification;

	@FindBy(css = "#master_service_charge_1_1")
	@CacheLookup
	WebElement txtServiceChargeEducationVerification;

	@FindBy(css = "#master_date_1_1")
	@CacheLookup
	WebElement txtDateEducationVerification;

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[4]/form[2]/table[3]/tbody[1]/tr[5]/td[1]/input[3]")
	@CacheLookup
	WebElement clickOnUpdateBtn;

	// University Map Module
	@FindBy(xpath = "//span[contains(text(),'University Mapping')]")
	@CacheLookup
	WebElement clickOnUniversityMappingModule;

	@FindBy(xpath = "//input[@name='instituteName']")
	@CacheLookup
	WebElement txtSearchUniversityName; //University of Delhi
	
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[3]/form[1]/table[1]/tbody[1]/tr[1]/td[1]/select[1]")
	@CacheLookup
	WebElement selectUniversityMapStateName;// Delhi
	
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[3]/form[1]/table[1]/tbody[1]/tr[1]/td[2]/select[1]")
	@CacheLookup
	WebElement selectUniversityMapCityName;// New Delhi

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[3]/form[1]/table[1]/tbody[1]/tr[1]/td[2]/input[1]")
	@CacheLookup
	WebElement clickOnCityMapSearchBtn;

	// Verify University of Delhi Name and State
	@FindBy(xpath = "//td[contains(text(),'University of Delhi')]")
	@CacheLookup
	WebElement verifyUniversityNameText;// University of Delhi

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

	// University Mapping By selecting Admin Role
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
						By.xpath("/html[1]/body[1]/div[1]/div[3]/table[1]/tbody[1]/tr[" + r + "]/td[11]/a[2]"));
				Thread.sleep(2000);
				element.click();
				break;
			}
		}

		// Verify Internal Vendor
		wait = new WebDriverWait(ldriver, 60);
		wait.until(ExpectedConditions.visibilityOf(verifyInternalVendorText));
		JavaScriptManuplator.selectOptionFromDropDown(selectStateName, "Delhi");
		JavaScriptManuplator.selectOptionFromDropDown(selectUniversityName, "University of Delhi");
		JavaScriptManuplator.selectOptionFromDropDown(selectCityName, "New Delhi");
		//JavaScriptManuplator.javaScriptExecutor(checkOnCheckBox, "arguments[0].click()", ldriver);
		Thread.sleep(1000);
		// Education Verification-- A G DAV Centenary Public School(New Delhi)
		wait = new WebDriverWait(ldriver, 60);
		wait.until(ExpectedConditions.visibilityOf(verifyAGDavSchool));
		JavaScriptManuplator.javaScriptExecutor(txtTatEducationVerification, "arguments[0].value='5'", ldriver);
		JavaScriptManuplator.javaScriptExecutor(txtCostEducationVerification, "arguments[0].value='245'", ldriver);
		JavaScriptManuplator.javaScriptExecutor(txtServiceChargeEducationVerification, "arguments[0].value='249'",
				ldriver);
		JavaScriptManuplator.javaScriptExecutor(txtDateEducationVerification, "arguments[0].removeAttribute('readonly')",
				ldriver);
		JavaScriptManuplator.javaScriptExecutor(txtDateEducationVerification, "arguments[0].value='03-06-2022'", ldriver);
		JavaScriptManuplator.javaScriptExecutor(clickOnUpdateBtn, "arguments[0].scrollIntoView(true);", ldriver);
		wait = new WebDriverWait(ldriver, 60);
		wait.until(ExpectedConditions.visibilityOf(clickOnUpdateBtn));
		JavaScriptManuplator.javaScriptExecutor(clickOnUpdateBtn, "arguments[0].click()", ldriver);
		Thread.sleep(1000);

		// University Map Module
		wait = new WebDriverWait(ldriver, 60);
		wait.until(ExpectedConditions.visibilityOf(clickOnUniversityMappingModule));
		JavaScriptManuplator.javaScriptExecutor(clickOnUniversityMappingModule, "arguments[0].click()", ldriver);
		Thread.sleep(1000);
		wait = new WebDriverWait(ldriver, 60);
		wait.until(ExpectedConditions.visibilityOf(txtSearchUniversityName));
		JavaScriptManuplator.javaScriptExecutor(txtSearchUniversityName, "arguments[0].value='University of Delhi'", ldriver);
		Thread.sleep(1000);
		JavaScriptManuplator.selectOptionFromDropDown(selectUniversityMapStateName, "Delhi");
		Thread.sleep(1000);
		JavaScriptManuplator.selectOptionFromDropDown(selectUniversityMapCityName, "New Delhi");
		wait = new WebDriverWait(ldriver, 60);
		wait.until(ExpectedConditions.visibilityOf(clickOnCityMapSearchBtn));
		Thread.sleep(1000);
		JavaScriptManuplator.javaScriptExecutor(clickOnCityMapSearchBtn, "arguments[0].click()", ldriver);
		Thread.sleep(1000);
	}

	// Verify City Name and State
	public String verifyUniversityMappingName() {
		wait = new WebDriverWait(ldriver, 60);
		wait.until(ExpectedConditions.visibilityOf(verifyUniversityNameText));
		return verifyUniversityNameText.getText();//University of Delhi
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

	// Switch to role: Allocator-- University Mapping
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
			String educationFamily = ldriver
					.findElement(By.xpath("/html[1]/body[1]/div[1]/div[3]/table[1]/tbody[1]/tr[" + r + "]/td[1]"))
					.getText();
			if (educationFamily.equals("Education Family")) {

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
							By.xpath("/html[1]/body[1]/div[1]/div[3]/form[1]/table[1]/tbody[1]/tr[" + r + "]/td[4]"))
					.getText();
			if (caseArsNo.equals(arsNumber[6])) {

				WebElement element = ldriver.findElement(By.xpath(
						"/html[1]/body[1]/div[1]/div[3]/form[1]/table[1]/tbody[1]/tr[" + r + "]/td[10]/select[1]"));
				Thread.sleep(2000);
				wait = new WebDriverWait(ldriver, 60);
				wait.until(ExpectedConditions.visibilityOf(element));
				JavaScriptManuplator.selectOptionFromDropDown(element, "Internal Vendor");
				break;
			}
		}

	}

}
