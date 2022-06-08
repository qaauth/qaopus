package com.opus.testcases;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.opus.pageobject.BridgeLoginPage;
import com.opus.pageobject.OpusApproveMapping;
import com.opus.pageobject.Re_AssignCheck;

public class TC_OpusVendorCaseSubmission_03 extends BaseClass {
	// Verify Vendor Account Login Details
	@Test(enabled = true, testName = "Verify Vendor Account Login Details", priority = 1)
	public void verifyVendorAccountLogin() throws InterruptedException, IOException {
		driver.get(OPUSUrl);
		logger.info("OPus Url is opened Successfully!");
		BridgeLoginPage vendorLogin = new BridgeLoginPage(driver);
		vendorLogin.opusVendorAcoountLogin(vendorUsername, vendorPassword);
		logger.info("Opus vendor Account has Logged Successfully!");
		if (vendorLogin.verifyOpusVendorLogoutPage().contains("Logout")) {
			Assert.assertTrue(true);
			logger.info("Opus Vendor account has logged successfully.!");
		} else {
			logger.info("Opus Vendor account has Not logged successfully.!");
			captureScreen(driver, "verifyOpusVendorLogoutPage");
			Assert.assertTrue(false);
		}
	}

	// Assigning check to field executive
	@Test(enabled = true, testName = "Verify Assigning check to field executive", priority = 2, dependsOnMethods = {
			"verifyVendorAccountLogin" })
	public void VerifyAssigningCheckToFieldExecutive() throws InterruptedException, IOException {
		OpusApproveMapping vendorAddressCheck = new OpusApproveMapping(driver);
		vendorAddressCheck.vendorAddressCheckAcceptAssign();
		logger.info("Address check have accepted and assign activity successfully!");
		Thread.sleep(20000);
		String alertText = driver.switchTo().alert().getText();
		if (alertText.contains("Success -: Check successfully assigned to Normal Vendor!")) {
			Assert.assertTrue(true);
			Thread.sleep(2000);
			driver.switchTo().alert().accept();
			logger.info("Success -: Check successfully assigned to Normal Vendor!");
		} else {
			logger.info("Success -: Check Not successfully assigned to Normal Vendor!");
			captureScreen(driver, "vendorAddressCheckAcceptAssign");
			Assert.assertTrue(false);
		}
	}
	
	// FE i.e vishakha Rana which has been assigned to the check , now some other field executive would be assigned on the check
	/*// Verify Update Check Details
		@Test(enabled = true, testName = "Verify Update Check Details", priority = 3, dependsOnMethods = {
					"VerifyAssigningCheckToFieldExecutive" })
			public void verifyReAssignFeName() throws InterruptedException, IOException {
				Re_AssignCheck vendorAddressCheck = new Re_AssignCheck(driver);
				vendorAddressCheck.vendorAddressCheckUpdate();
				logger.info("Vendor Check has updated successfully!");
				vendorAddressCheck.verifyCheckIdAndFeName();
				logger.info("Verify Fe name has successfully!");
				String ActualFeName = new String(Files.readAllBytes(Paths.get("CheckFeName.txt")));
				String ExpectedFeName = "Testing User";
				Assert.assertEquals(ExpectedFeName, ActualFeName);
			}*/
	
	// Verify Update Check Details
	@Test(enabled = true, testName = "Verify Update Check Details", priority = 3, dependsOnMethods = {
			"VerifyAssigningCheckToFieldExecutive" })
	public void verifyUpdateCheckDetails() throws InterruptedException, IOException {
		OpusApproveMapping vendorAddressCheck = new OpusApproveMapping(driver);
		vendorAddressCheck.vendorAddressCheckUpdate();
		logger.info("Vendor Check has updated successfully!");
		vendorAddressCheck.currentAddressVerification();
		logger.info("Current address verification has done successfully!");
		Thread.sleep(2000);
		String alertText = driver.switchTo().alert().getText();
		if (alertText.contains("Sure! you want to save these details.??")) {
			Assert.assertTrue(true);
			Thread.sleep(2000);
			driver.switchTo().alert().accept();
			logger.info("Sure! you want to save these details.??");
		} else {
			logger.info("Sure! you Do Not want to save these details.??");
			captureScreen(driver, "currentAddressVerification");
			Assert.assertTrue(false);
		}
	}

	// Verify Mark Check As Sent
	@Test(enabled = true, testName = "Verify Mark Check As Sent", priority = 4, dependsOnMethods = {
			"verifyUpdateCheckDetails" })
	public void verifyMarkCheckAsSent() throws InterruptedException, IOException {
		OpusApproveMapping vendorAddressCheck = new OpusApproveMapping(driver);
		vendorAddressCheck.verifySendResponse();
		logger.info("Vendor has sent response successfully!");
		if (vendorAddressCheck.responseSentSuccessfully().contains("Response sent successfully.")) {
			Assert.assertTrue(true);
			logger.info("Response Has sent successfully.!");
		} else {
			logger.info("Response Has Not sent successfully.!!");
			captureScreen(driver, "responseSentSuccessfully");
			Assert.assertTrue(false);
		}
		BridgeLoginPage vendorLogin = new BridgeLoginPage(driver);
		vendorLogin.verifyVendorOpusLogout();
		logger.info("Vendor Account Has Logout Successfully!");
	}
}
