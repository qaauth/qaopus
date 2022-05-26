package com.opus.pageobject;

import java.awt.Robot;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BridgeLoginPage {
	WebDriver ldriver;
	WebDriverWait wait;
	JavascriptExecutor js;
	Robot rbt;

	public BridgeLoginPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(ldriver, this);
	}

	// Login functionalities of the Bridge Portal
	@FindBy(xpath = "//input[@id='login_email']")
	@CacheLookup
	WebElement txtUserName;

	@FindBy(xpath = "//input[@id='login_password']")
	@CacheLookup
	WebElement txtPassword;

	@FindBy(xpath = "//button[contains(text(),'Login')]")
	@CacheLookup
	WebElement btnLogin;

	// Verify Bridge Logout Button Text.
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[1]/ul[1]/li[16]/a[1]")
	@CacheLookup
	WebElement verifyBridgeLogoutBtn;

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

	// Opus Admin Logout Text
	@FindBy(xpath = "//a[contains(text(),'Logout')]")
	@CacheLookup
	WebElement verifyOpusAdminLogoutText;

	// Opus Vendor Credentials Details-- VMT Application Login
	@FindBy(xpath = "/html[1]/body[1]/center[1]/fieldset[1]/form[1]/table[1]/tbody[1]/tr[2]/td[2]/input[1]")
	@CacheLookup
	WebElement txtOpusVendorUserName;

	@FindBy(xpath = "/html[1]/body[1]/center[1]/fieldset[1]/form[1]/table[1]/tbody[1]/tr[3]/td[2]/input[1]")
	@CacheLookup
	WebElement txtOpusVendorPassword;

	@FindBy(xpath = "/html[1]/body[1]/center[1]/fieldset[1]/form[1]/table[1]/tbody[1]/tr[4]/td[2]/input[1]")
	@CacheLookup
	WebElement clickOnVendorLoginBtn;

	// Opus Logout Text
	@FindBy(xpath = "//a[contains(text(),'Logout')]")
	@CacheLookup
	WebElement verifyOpusVendorLogoutText;

	// Logout Admin Opus Account
	@FindBy(xpath = "//a[contains(text(),'Logout')]")
	@CacheLookup
	WebElement clickOnAdminLogoutBtn;

	// Logout Vendor Opus Account
	@FindBy(xpath = "//a[contains(text(),'Logout')]")
	@CacheLookup
	WebElement clickOnVendorLogoutBtn;

	@FindBy(xpath = "//b[contains(text(),'VMT Application Login')]")
	@CacheLookup
	WebElement verifyVMTApplicationLoginText;

	// Logout Raju Yadav Account for Cat Role -- Bridge.
	@CacheLookup
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Logout')]")
	WebElement clickOnBridgeLogoutBtn;

	// Action Methods for Login functionalities of the Bridge Portal
	public void loginBridgeAccount(String username, String password) throws InterruptedException {
		wait = new WebDriverWait(ldriver, 120);
		wait.until(ExpectedConditions.visibilityOf(txtUserName));
		txtUserName.sendKeys(username);
		txtPassword.sendKeys(password);
		btnLogin.click();
		Thread.sleep(1000);
	}

	public String verifyBridgeLogoutText() {
		wait = new WebDriverWait(ldriver, 120);
		wait.until(ExpectedConditions.visibilityOf(verifyBridgeLogoutBtn));
		return verifyBridgeLogoutBtn.getText();
	}

	// Opus Admin Credentials Details-- VMT Application Login
	public void opusAdminAcoountLogin(String username, String password) throws InterruptedException {
		wait = new WebDriverWait(ldriver, 120);
		wait.until(ExpectedConditions.visibilityOf(txtOpusAdminUserName));
		txtOpusAdminUserName.sendKeys(username);
		txtOpusAdminPassword.sendKeys(password);
		Thread.sleep(2000);
		clickOnLoginBtn.click();
		Thread.sleep(1000);
	}

	// Opus Admin Logout Text
	public String verifyOpusAdminLogoutText() {
		wait = new WebDriverWait(ldriver, 120);
		wait.until(ExpectedConditions.visibilityOf(verifyOpusAdminLogoutText));
		return verifyOpusAdminLogoutText.getText();
	}

	// Logout Admin Opus Account
	public void verifyAdminOpusLogout() {
		wait = new WebDriverWait(ldriver, 120);
		wait.until(ExpectedConditions.visibilityOf(clickOnAdminLogoutBtn));
		clickOnAdminLogoutBtn.click();
	}

	// Logout Vendor Opus Account
	public void verifyVendorOpusLogout() throws InterruptedException {
		wait = new WebDriverWait(ldriver, 120);
		wait.until(ExpectedConditions.visibilityOf(clickOnVendorLogoutBtn));
		clickOnVendorLogoutBtn.click();
		Thread.sleep(2000);
		//ldriver.switchTo().alert().accept();
		//Thread.sleep(2000);
	}

	public String verifyAdminLogoutPage() {
		wait = new WebDriverWait(ldriver, 120);
		wait.until(ExpectedConditions.visibilityOf(verifyVMTApplicationLoginText));
		return verifyVMTApplicationLoginText.getText();
	}

	// Opus Vendor Credentials Details-- VMT Application Login
	public void opusVendorAcoountLogin(String username, String password) throws InterruptedException {
		wait = new WebDriverWait(ldriver, 120);
		wait.until(ExpectedConditions.visibilityOf(txtOpusVendorUserName));
		txtOpusVendorUserName.sendKeys(username);
		txtOpusVendorPassword.sendKeys(password);
		Thread.sleep(2000);
		clickOnVendorLoginBtn.click();
		Thread.sleep(1000);
	}

	// Opus Vendor Logout Text
	public String verifyOpusVendorLogoutPage() {
		wait = new WebDriverWait(ldriver, 120);
		wait.until(ExpectedConditions.visibilityOf(verifyOpusVendorLogoutText));
		return verifyOpusVendorLogoutText.getText();
	}

	public String verifyVendorLogoutText() {
		wait = new WebDriverWait(ldriver, 120);
		wait.until(ExpectedConditions.visibilityOf(verifyVMTApplicationLoginText));
		return verifyVMTApplicationLoginText.getText();
	}

	public void bridgeAccountLoggedOut() throws InterruptedException {
		Thread.sleep(2000);
		clickOnBridgeLogoutBtn.click();
		Thread.sleep(1000);
	}
}
