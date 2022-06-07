package com.opus.pageobject;

import java.awt.Robot;
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
import org.openqa.selenium.support.ui.WebDriverWait;

import com.opus.utilities.JavaScriptManuplator;

public class OpusOnHoldCheck {
	WebDriver ldriver;
	WebDriverWait wait;
	JavascriptExecutor js;
	Robot rbt;

	public OpusOnHoldCheck(WebDriver rdriver) {
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
	}

	public void verifyCheckCheckId() throws InterruptedException, IOException {
		// How many rows in table
		String data = new String(Files.readAllBytes(Paths.get("CaseCheckId.txt")));
		String checkId[] = data.split(" ");
		String id[] = checkId[1].split("=");
		System.out.println("Check Id==" + id[1]);
		int rows = ldriver.findElements(By.xpath("/html[1]/body[1]/div[1]/div[3]/form[1]/table[1]/tbody[1]/tr")).size();
		// Get Check Id, and select action Update from Drop-down
		for (int r = 1; r <= rows; r++) {
			String addressCheckId = ldriver
					.findElement(
							By.xpath("/html[1]/body[1]/div[1]/div[3]/form[1]/table[1]/tbody[1]/tr[" + r + "]/td[2]"))
					.getText();
			Thread.sleep(2000);
			if (addressCheckId.equals(id[1])) {
				System.out.println("Current Address check id has verified successfully!");
				break;
			}
		}
	}
}
