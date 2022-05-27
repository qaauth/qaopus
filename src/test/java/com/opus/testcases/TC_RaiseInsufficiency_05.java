package com.opus.testcases;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.opus.pageobject.BridgeLoginPage;
import com.opus.pageobject.OpusApproveMapping;
import com.opus.pageobject.RaiseInsufficiency;

public class TC_RaiseInsufficiency_05 extends BaseClass {
	int totalVendorInsuffNo;
	int totalInsuffFullfillNo;
	int totalInsuffFullfillNoMapping;

	// Verify Vendor/Admin Account Login Details
	@Test(enabled = true, testName = "Verify Vendor/Admin Account Login Details", priority = 1)
	public void verifyVendorAccountLogin() throws InterruptedException, IOException {
		driver.get(OPUSUrl);
		logger.info("OPus Url is opened Successfully!");
		BridgeLoginPage vendorLogin = new BridgeLoginPage(driver);
		vendorLogin.opusAdminAcoountLogin(adminUsername, adminPassword);
		logger.info("Opus Admin Username and password has entered sucessfully!");
		RaiseInsufficiency insuffFullfilCount = new RaiseInsufficiency(driver);
		totalInsuffFullfillNo = Integer.parseInt(insuffFullfilCount.verifygetBeforeInsuffFullfilCountNo());
		vendorLogin.verifyAdminOpusLogout();
		logger.info("Opus Admin account has Logout successfully!");
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
		//driver.switchTo().alert().accept();
		/*try{
		} catch (Exception e) {
		if(e.toString().contains("org.openqa.selenium.UnhandledAlertException"))
		 {
		    Alert alert = getDriver().switchTo().alert();
		    alert.accept();
		 }
		}*/
		Thread.sleep(2000);
		/*String alertText = driver.switchTo().alert().getText();
		System.out.println("Alert Printing..."+alertText);
		if (alertText.contains("Success -: Check successfully assigned to Normal Vendor!")) {
			Assert.assertTrue(true);
			Thread.sleep(2000);
			driver.switchTo().alert().accept();
			logger.info("Success -: Check successfully assigned to Normal Vendor!");
		} else {
			logger.info("Success -: Check Not successfully assigned to Normal Vendor!");
			captureScreen(driver, "vendorAddressCheckAcceptAssign");
			Assert.assertTrue(false);
		}*/
	}

	/*private WebDriver getDriver() {
		// TODO Auto-generated method stub
		return null;
	}*/

	// Verify Update Check Details, and Raised insuff
	@Test(enabled = true, testName = "Verify Update Check Details, and Raised insuff", priority = 3, dependsOnMethods = {
			"VerifyAssigningCheckToFieldExecutive" })
	public void verifyUpdateCheckDetails() throws InterruptedException, IOException {
		OpusApproveMapping vendorAddressCheck = new OpusApproveMapping(driver);
		vendorAddressCheck.vendorAddressCheckUpdate();
		logger.info("Vendor Check has updated successfully!");
		RaiseInsufficiency raiseInsuff = new RaiseInsufficiency(driver);
		raiseInsuff.vendorRaiseInsuff();
		logger.info("Vendor has raised insuff Successfully!");
		String alertText = driver.switchTo().alert().getText();
		if (alertText.contains("Insuff raised successfully.")) {
			Assert.assertTrue(true);
			Thread.sleep(2000);
			driver.switchTo().alert().accept();
			logger.info("Insuff has raised successfully.");
		} else {
			logger.info("Insuff has Not raised successfully.");
			captureScreen(driver, "InsuffRaisedSuccessfully");
			Assert.assertTrue(false);
		}
		BridgeLoginPage vendorLogin = new BridgeLoginPage(driver);
		vendorLogin.verifyVendorOpusLogout();
		logger.info("Vendor Account Has Logout Successfully!");
	}

	// Verify vendor raised insuff by Admin using Approver TL Role
	@Test(enabled = true, testName = "Verify vendor raised insuff by Admin", priority = 4, dependsOnMethods = {
			"verifyUpdateCheckDetails" })
	public void verifyAdminApproverTl() throws InterruptedException, IOException {
		driver.get(OPUSUrl);
		logger.info("OPus Url is opened Successfully!");
		BridgeLoginPage adminLogin = new BridgeLoginPage(driver);
		adminLogin.opusAdminAcoountLogin(adminUsername, adminPassword);
		logger.info("Opus Admin Username and password has entered sucessfully!");
		RaiseInsufficiency raiseInsuffApproverTl = new RaiseInsufficiency(driver);
		logger.info("Total Vendor Insuff Check Count has got successfully!");
		totalVendorInsuffNo = Integer.parseInt(raiseInsuffApproverTl.getBeforeInsuffRaiseCountNo());
		logger.info("Total Vendor Insuff Check has got successfully!");
		raiseInsuffApproverTl.raiseInsuffAllocate();
		logger.info("Vendor raise insuff have allocated Successfully!");
		raiseInsuffApproverTl.verifyVendorInsuffCount();
		logger.info("After Vendor raise insuff count have got successfully!");
		int afterRaiseInsuffCount = Integer.parseInt(raiseInsuffApproverTl.verifyVendorInsuffCount());
		if (afterRaiseInsuffCount < totalVendorInsuffNo) {
			Assert.assertTrue(true);
			logger.info("Vendor Raised Insuff Count number have verified successfully!");
		} else {
			logger.info("Vendor Raised Insuff Count number have Not verified successfully!");
			captureScreen(driver, "AfterVendorRaisedInsuffCount");
			Assert.assertTrue(false);
		}
	}

	// Verify accept insuff by Admin using Approver Role
	@Test(enabled = true, testName = "Verify accept insuff by Admin using Approver Role", priority = 5, dependsOnMethods = {
			"verifyAdminApproverTl" })
	public void verifyAdminApprover() throws InterruptedException, IOException {
		RaiseInsufficiency approver = new RaiseInsufficiency(driver);
		String data = new String(Files.readAllBytes(Paths.get("BridgeCaseArsNo.txt")));
		String arsNumber[] = data.split(" ");
		approver.adminRoleApprover(arsNumber[6], arsNumber[6]);
		logger.info("Admin has selected Approver role done successfully!");
		if (approver.verifyCheckStatusInsufficientText().contains("Insufficient")) {
			Assert.assertTrue(true);
			logger.info("Check Status has Verified Insufficient successfully.!");
		} else {
			logger.info("Check Status has Not Verified Insufficient successfully.!");
			captureScreen(driver, "verifyCheckStatusInsufficientText");
			Assert.assertTrue(false);
		}
		BridgeLoginPage adminLogin = new BridgeLoginPage(driver);
		adminLogin.verifyAdminOpusLogout();
		logger.info("Opus Admin account has Logout successfully!");
	}

	// Verify Check Status Summary Insufficient on Bridge Portal
	@Test(enabled = true, testName = "Verify Check Status Summary Insufficient on Bridge Portal", priority = 6, dependsOnMethods = {
			"verifyAdminApprover" })
	public void verifyCheckStatusSummaryInsufficient() throws InterruptedException, IOException {
		driver.get(baseURL);
		logger.info("Bridge Url is opened Successfully!");
		BridgeLoginPage login = new BridgeLoginPage(driver);
		login.loginBridgeAccount(username, password);
		logger.info("Bridge Username and password has entered sucessfully!");
		RaiseInsufficiency Insufficient = new RaiseInsufficiency(driver);
		String data = new String(Files.readAllBytes(Paths.get("BridgeCaseArsNo.txt")));
		String arsNumber[] = data.split(" ");
		Insufficient.superCheckStatusSummaryInsufficiency(arsNumber[6]);
		logger.info("Doc Tl has role load and search case have Done Successfully!");
		if (Insufficient.verifyBridgeCheckStatusInsufficient().contains("Insufficient")) {
			Assert.assertTrue(true);
			logger.info("Check Status Summary has verified Insufficient Successfully!!");
		} else {
			logger.info("Check Status Summary has Not verified Insufficient Successfully!!!");
			captureScreen(driver, "verifyBridgeCheckStatusInsufficient");
			Assert.assertTrue(false);
		}
	}

	// Verify Bridge-- Fulfill Check Insufficiency
	@Test(enabled = true, testName = "Verify Bridge Fulfill Check Insufficiency", priority = 7, dependsOnMethods = {
			"verifyCheckStatusSummaryInsufficient" })
	public void verifyBridgeFullfillCheckInsufficiency() throws InterruptedException, IOException {
		RaiseInsufficiency insuffDocsTL = new RaiseInsufficiency(driver);
		insuffDocsTL.superAdminFulfillCheckInsufficiency((System.getProperty("user.dir") + "/documents/ARN.pdf"));
		logger.info("Fulfill Check Insufficiency have done successfully!");

		if (insuffDocsTL.verifyCheckInsuffSuccessFulfilled().contains(
				"Check insufficiency is successfully fulfilled. Insuff Fulfill Documents are successfully added with the Check.")) {
			Assert.assertTrue(true);
			logger.info("Check insufficiency is successfully fulfilled.!");
		} else {
			logger.info("Check insufficiency is Not successfully fulfilled.!!");
			captureScreen(driver, "verifyCheckInsuffSuccessFulfilled");
			Assert.assertTrue(false);
		}
	}

	// Verify Opus-- Documents Received : Address Proof
	@Test(enabled = true, testName = "Verify Documents Received : Address Proof", priority = 8, dependsOnMethods = {
			"verifyBridgeFullfillCheckInsufficiency" })
	public void verifyDocumentsReceivedAddressProof() throws InterruptedException, IOException {
		driver.get(OPUSUrl);
		logger.info("OPus Url is opened Successfully!");
		BridgeLoginPage adminLogin = new BridgeLoginPage(driver);
		adminLogin.opusAdminAcoountLogin(adminUsername, adminPassword);
		logger.info("Opus Admin Username and password has entered sucessfully!");
		RaiseInsufficiency documentsReceived = new RaiseInsufficiency(driver);
		String data = new String(Files.readAllBytes(Paths.get("BridgeCaseArsNo.txt")));
		String arsNumber[] = data.split(" ");
		documentsReceived.documentsReceivedAddressProof(arsNumber[6]);
		logger.info("Documents Received and Check Insufficiency Fulfilled");
		if (documentsReceived.verifyDocumentsReceivedText().contains("Address Proof")) {
			Assert.assertTrue(true);
			logger.info("Verify Documents Received Address Proof Has Successfully.!");
		} else {
			logger.info("Verify Documents Received Address Proof Has Not Successfully.!!");
			captureScreen(driver, "verifyDocumentsReceivedText");
			Assert.assertTrue(false);
		}
	}

	// Verify Insuff Fullfill Bucket Count
	@Test(enabled = true, testName = "Verify Insuff Fullfill Bucket Count", priority = 9, dependsOnMethods = {
			"verifyDocumentsReceivedAddressProof" })
	public void verifyInsuffFullfillBucketCount() throws InterruptedException, IOException {
		RaiseInsufficiency insuffFullfillBucketCount = new RaiseInsufficiency(driver);
		insuffFullfillBucketCount.insuffFullfilBucketCountNo();
		logger.info("Insuff Fullfill Bucket Count has verified successfully!");
		int afterInsuffFullfilCountNo = Integer
				.parseInt(insuffFullfillBucketCount.verifygetAfterInsuffFullfilCountNo());
		if (afterInsuffFullfilCountNo > totalInsuffFullfillNo) {
			Assert.assertTrue(true);
			logger.info("Vendor Raised Insuff Count number have verified successfully!");
		} else {
			logger.info("Vendor Raised Insuff Count number have Not verified successfully!");
			captureScreen(driver, "AfterVendorRaisedInsuffCount");
			Assert.assertTrue(false);
		}
	}

	// Verify Insuff Fullfill, and Approval Mapping
	@Test(enabled = true, testName = "Verify Insuff Fullfill, and Approval Mapping ", priority = 10, dependsOnMethods = {
			"verifyInsuffFullfillBucketCount" })
	public void verifyInsuffFullfillApprovalMapping() throws InterruptedException, IOException {
		RaiseInsufficiency insuffFullfillMapping = new RaiseInsufficiency(driver);
		totalInsuffFullfillNoMapping = Integer.parseInt(insuffFullfillMapping.verifygetBeforeInsuffFullfilCountNo());
		insuffFullfillMapping.insuffFullfillBucketCount();
		logger.info("Insuff Fullfill Bucket Count has clicked successfully!");
		insuffFullfillMapping.verifyCheckIdInsuffFullfil();
		logger.info("Insuff Fullfill has approval mapping Successfuly!");
		insuffFullfillMapping.verifyClickOnApprovalMappingBtn();
		logger.info("Clicked on Approval Mapping Button has Successfully!");
		insuffFullfillMapping.clickOnApproveMappingModule();
		logger.info("Clicked on Approval Mapping Module has successfully!");
		int afterInsuffFullfilCountNoMapping = Integer
				.parseInt(insuffFullfillMapping.verifygetAfterInsuffFullfilCountNo());
		if (afterInsuffFullfilCountNoMapping < totalInsuffFullfillNoMapping) {
			Assert.assertTrue(true);
			logger.info("Admin Raised Insuff Count number have Approval Mapped verified successfully!");
		} else {
			logger.info("Admin Raised Insuff Count number have Not Approval Mapped verified successfully!");
			captureScreen(driver, "afterInsuffFullfilCountNoMapping");
			Assert.assertTrue(false);
		}
		BridgeLoginPage adminLogin = new BridgeLoginPage(driver);
		adminLogin.verifyAdminOpusLogout();
		logger.info("Opus Admin account has Logout successfully!");
	}
}
