package com.opus.pageobject;

import java.awt.Robot;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.opus.utilities.JavaScriptManuplator;

public class Re_AssignCheck {
	WebDriver ldriver;
	WebDriverWait wait;
	JavascriptExecutor js;
	Robot rbt;

	public Re_AssignCheck(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(ldriver, this);
	}

	// Approve Mapping
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/ul[1]/li[1]/a[1]/span[1]")
	@CacheLookup
	WebElement clickOnApproveMapping;

	// Get New Load Count
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[3]/table[1]/tbody[1]/tr[7]/td[3]/a[1]")
	@CacheLookup
	WebElement getNewLoadCountNo;

	@FindBy(xpath = "//td[contains(text(),'Vendor Name')]")
	@CacheLookup
	WebElement verifyVendorName;

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[3]/form[1]/table[1]/tbody[1]/tr[1]/td[1]/input[1]")
	@CacheLookup
	WebElement checkAllCaseCheckIdCheckBox;

	@FindBy(xpath = "//input[@name='aprove']")
	@CacheLookup
	WebElement clickOnApproveMappingBtn;

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/ul[1]/li[1]/a[1]/span[1]")
	@CacheLookup
	WebElement clickOnAgainApproveMapping;

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[3]/table[1]/tbody[1]/tr[6]/td[3]/a[1]")
	@CacheLookup
	WebElement getOldNewLoadCountNo;

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/ul[1]/li[1]/a[1]/span[1]")
	@CacheLookup
	WebElement verifyApproveMappingText;

	// Address Checks(0)-- Current Load
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/ul[1]/li[1]/a[1]/span[1]")
	@CacheLookup
	WebElement clickOnAddressChecksCountNo;

	// Current Load Count-- Address Check
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[3]/table[1]/tbody[1]/tr[5]/td[4]/a[1]")
	@CacheLookup
	WebElement getOldCurrentNewCount;

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[3]/table[1]/tbody[1]/tr[5]/td[4]/a[1]")
	@CacheLookup
	WebElement clickOnCurrentLoadCountNo;

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[5]/form[1]/table[2]/tbody[1]/tr[1]/td[4]/select[1]")
	@CacheLookup
	WebElement selectExecutiveAddressCheck;// Vishakha Rana ( Normal )

	// Opus Vendor Login-- Address Checks
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/ul[1]/li[1]/a[1]/span[1]")
	@CacheLookup
	WebElement clickOnAddressChecks;

	// Current Workload
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[3]/table[1]/tbody[1]/tr[2]/td[4]/a[1]")
	@CacheLookup
	WebElement clickOnNewLoadCountNo;

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[5]/form[1]/table[1]/tbody[1]/tr[1]/td[1]/select[1]")
	@CacheLookup
	WebElement selectFieldExecutiveName;// Vishakha Rana ( Normal )

	@FindBy(xpath = "//input[@id='selectAll']")
	@CacheLookup
	WebElement checkAllCheckboxOfCheckId;

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[5]/form[1]/table[1]/tbody[1]/tr[1]/td[1]/input[1]")
	@CacheLookup
	WebElement clickOnAcceptAssignBtn;

	// Re-Assign Activity
	@FindBy(xpath = "//select[@id='feList-RE']")
	@CacheLookup
	WebElement selectReAssignName;// Testing User ( Normal )

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[4]/form[1]/span[1]/table[1]/tbody[1]/tr[1]/td[1]/input[1]")
	@CacheLookup
	WebElement clickOnReAssignBtn;

	// Sure! You want to Re-Assign this check to `Testing User` .??

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/ul[1]/li[1]/a[1]/span[1]")
	@CacheLookup
	WebElement clickOnAddressChecksBtn;

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[3]/table[1]/tbody[1]/tr[5]/td[4]/a[1]")
	@CacheLookup
	WebElement clickOnCurrentLoadCountNumber;

	@FindBy(xpath = "//select[@id='fil_exe']")
	@CacheLookup
	WebElement selectExecutiveName;// Testing User ( Normal )

	public String getNewLoadCountNumber() {
		wait = new WebDriverWait(ldriver, 60);
		wait.until(ExpectedConditions.visibilityOf(clickOnApproveMapping));
		return getNewLoadCountNo.getText();
	}

	// Admin Approve Mapping
	public void adminApproveMapping() throws IOException, InterruptedException {
		JavaScriptManuplator.waitForElementPresent(ldriver, clickOnApproveMapping, 120);
		JavaScriptManuplator.javaScriptExecutor(clickOnApproveMapping, "arguments[0].click()", ldriver);
		JavaScriptManuplator.waitForElementPresent(ldriver, verifyVendorName, 60);
		// How many rows in table
		int rows = ldriver.findElements(By.xpath("/html[1]/body[1]/div[1]/div[3]/table[1]/tbody[1]/tr")).size();
		// Get Internal Vendor, and clicked on Internal Vendor New Load count number.
		for (int r = 1; r <= rows; r++) {
			String vendorName = ldriver
					.findElement(By.xpath("/html[1]/body[1]/div[1]/div[3]/table[1]/tbody[1]/tr[" + r + "]/td[1]"))
					.getText();
			if (vendorName.equals("Internal Vendor")) {

				WebElement element = ldriver.findElement(
						By.xpath("/html[1]/body[1]/div[1]/div[3]/table[1]/tbody[1]/tr[" + r + "]/td[3]/a[1]"));
				Thread.sleep(2000);
				element.click();
				break;
			}
		}
		JavaScriptManuplator.waitForElementPresent(ldriver, checkAllCaseCheckIdCheckBox, 120);
		JavaScriptManuplator.javaScriptExecutor(checkAllCaseCheckIdCheckBox, "arguments[0].click()", ldriver);
		JavaScriptManuplator.javaScriptExecutor(clickOnApproveMappingBtn, "arguments[0].click()", ldriver);
		JavaScriptManuplator.javaScriptExecutor(clickOnAgainApproveMapping, "arguments[0].click()", ldriver);
		Thread.sleep(1000);
	}

	public String getOldNewLoadCountNumber() {
		wait = new WebDriverWait(ldriver, 60);
		wait.until(ExpectedConditions.visibilityOf(verifyApproveMappingText));
		return getOldNewLoadCountNo.getText();
	}

	// Opus Vendor Login-- Address Checks
	public void vendorAddressCheckAcceptAssign() throws InterruptedException {
		wait = new WebDriverWait(ldriver, 120);
		wait.until(ExpectedConditions.visibilityOf(clickOnAddressChecks));
		JavaScriptManuplator.javaScriptExecutor(clickOnAddressChecks, "arguments[0].click()", ldriver);
		// Current Workload
		wait = new WebDriverWait(ldriver, 120);
		wait.until(ExpectedConditions.visibilityOf(clickOnNewLoadCountNo));
		JavaScriptManuplator.javaScriptExecutor(clickOnNewLoadCountNo, "arguments[0].click()", ldriver);
		wait = new WebDriverWait(ldriver, 120);
		wait.until(ExpectedConditions.visibilityOf(selectFieldExecutiveName));
		JavaScriptManuplator.selectOptionFromDropDown(selectFieldExecutiveName, "Vishakha Rana ( Normal )");
		Thread.sleep(1000);
		JavaScriptManuplator.javaScriptExecutor(checkAllCheckboxOfCheckId, "arguments[0].click()", ldriver);
		Thread.sleep(1000);
		JavaScriptManuplator.javaScriptExecutor(clickOnAcceptAssignBtn, "arguments[0].click()", ldriver);
		Thread.sleep(2000);
		// Sure! You want to allocate these checks to `Vishakha Rana` .??
		ldriver.switchTo().alert().accept();
		Thread.sleep(2000);
	}

	public String getOldCurrentLoadCountNumber() {
		JavaScriptManuplator.waitForElementPresent(ldriver, clickOnAddressChecksCountNo, 120);
		JavaScriptManuplator.javaScriptExecutor(clickOnAddressChecksCountNo, "arguments[0].click()", ldriver);
		wait = new WebDriverWait(ldriver, 60);
		wait.until(ExpectedConditions.visibilityOf(getOldCurrentNewCount));
		return getOldCurrentNewCount.getText();
	}

	// Address Checks(0)-- Current Load
	public void vendorAddressCheckUpdate() throws IOException, InterruptedException {
		JavaScriptManuplator.waitForElementPresent(ldriver, clickOnAddressChecksCountNo, 120);
		JavaScriptManuplator.javaScriptExecutor(clickOnAddressChecksCountNo, "arguments[0].click()", ldriver);
		JavaScriptManuplator.waitForElementPresent(ldriver, clickOnCurrentLoadCountNo, 60);
		JavaScriptManuplator.javaScriptExecutor(clickOnCurrentLoadCountNo, "arguments[0].click()", ldriver);
		JavaScriptManuplator.waitForElementPresent(ldriver, selectExecutiveAddressCheck, 60);
		JavaScriptManuplator.selectOptionFromDropDown(selectExecutiveAddressCheck, "Vishakha Rana ( Normal )");
		Thread.sleep(1000);
		// How many rows in table
		String data = new String(Files.readAllBytes(Paths.get("CaseCheckId.txt")));
		String checkId[] = data.split(" ");
		String id[] = checkId[1].split("=");
		System.out.println("Check Id==" + id[1]);
		int rows = ldriver.findElements(By.xpath("/html[1]/body[1]/div[1]/div[5]/form[1]/table[2]/tbody[2]/tr")).size();
		// Get Check Id, and select action Update from Drop-down
		for (int r = 1; r <= rows; r++) {
			String addressCheckId = ldriver
					.findElement(
							By.xpath("/html[1]/body[1]/div[1]/div[5]/form[1]/table[2]/tbody[2]/tr[" + r + "]/td[1]"))
					.getText();
			Thread.sleep(2000);
			if (addressCheckId.equals(id[1])) {

				WebElement element = ldriver.findElement(By.xpath(
						"/html[1]/body[1]/div[1]/div[5]/form[1]/table[2]/tbody[2]/tr[" + r + "]/td[13]/select[1]"));
				Thread.sleep(2000);
				JavaScriptManuplator.selectOptionFromDropDown(element, "Re-Assign");
				break;
			}
		}
		// Check Re-Assign Activity has been done
		Thread.sleep(2000);
		JavaScriptManuplator.selectOptionFromDropDown(selectReAssignName, "Testing User ( Normal )");
		wait = new WebDriverWait(ldriver, 120);
		wait.until(ExpectedConditions.visibilityOf(clickOnReAssignBtn));
		Thread.sleep(2000);
		JavaScriptManuplator.javaScriptExecutor(clickOnReAssignBtn, "arguments[0].click()", ldriver);
		Thread.sleep(2000);
		// Sure! You want to Re-Assign this check to `Testing User` .??
		ldriver.switchTo().alert().accept();
		Thread.sleep(2000);
		JavaScriptManuplator.javaScriptExecutor(clickOnAddressChecksBtn, "arguments[0].click()", ldriver);
		wait = new WebDriverWait(ldriver, 120);
		wait.until(ExpectedConditions.visibilityOf(clickOnCurrentLoadCountNumber));
		Thread.sleep(2000);
		JavaScriptManuplator.javaScriptExecutor(clickOnCurrentLoadCountNumber, "arguments[0].click()", ldriver);
		wait = new WebDriverWait(ldriver, 120);
		wait.until(ExpectedConditions.visibilityOf(selectExecutiveName));
		JavaScriptManuplator.selectOptionFromDropDown(selectExecutiveName, "Testing User ( Normal )");
		Thread.sleep(2000);
	}

	public void verifyCheckIdAndFeName() throws InterruptedException, IOException {
		// How many rows in table
		String data = new String(Files.readAllBytes(Paths.get("CaseCheckId.txt")));
		String checkId[] = data.split(" ");
		String id[] = checkId[1].split("=");
		System.out.println("Check Id==" + id[1]);
		int rows = ldriver.findElements(By.xpath("/html[1]/body[1]/div[1]/div[5]/form[1]/table[2]/tbody[2]/tr")).size();
		// Get Check Id, and select action Update from Drop-down
		for (int r = 1; r <= rows; r++) {
			String addressCheckId = ldriver
					.findElement(
							By.xpath("/html[1]/body[1]/div[1]/div[5]/form[1]/table[2]/tbody[2]/tr[" + r + "]/td[1]"))
					.getText();
			Thread.sleep(2000);
			if (addressCheckId.equals(id[1])) {

				WebElement element = ldriver.findElement(
						By.xpath("/html[1]/body[1]/div[1]/div[5]/form[1]/table[2]/tbody[2]/tr[" + r + "]//td[12]"));
				Thread.sleep(2000);
				wait = new WebDriverWait(ldriver, 120);
				wait.until(ExpectedConditions.visibilityOf(element));
				try {
					File output = new File("CheckFeName.txt");
					FileWriter writer = new FileWriter(output);
					writer.write(element.getText());
					writer.flush();
					writer.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			}
		}

	}

}
