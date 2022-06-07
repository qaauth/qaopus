package com.opus.testcases;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.opus.pageobject.BridgeCaseDetails;
import com.opus.pageobject.BridgeLoginPage;
import com.opus.pageobject.OpusApproveMapping;
import com.opus.pageobject.Re_AssignCheck;

public class TC_Re_AssignCheck_10 extends BaseClass {
	int totalNewLoadNo;
		// Verify Bridge case initiation
		@Test(enabled = true, testName = "Verify Bridge case initiation", priority = 1)
		public void verifyBridgeCaseInitiation() throws IOException, InterruptedException {
			TC_CaseInitiation_01 bridgeCaseInition = new TC_CaseInitiation_01();
			// Verify Bridge Login Test
			bridgeCaseInition.bridgeLoginTest();
			logger.info("Bridge Username and password has entered sucessfully!");
			// Bridge Case Add Details
			bridgeCaseInition.bridgeCaseAddDetails();
			logger.info("Bridge new case Candidate details have added successully!");
			// Highlighter Allocator
			bridgeCaseInition.verifyAdminUserRoleHighlighterAllocator();
			logger.info("British Telecom client Case has been Allocated Cases Successfully!");
			// Highlighter
			bridgeCaseInition.verifyUserAdminRoleHighlighter();
			logger.info("Highlighter Add Details have added sucessfully!");
			// Documentation Specialist
			bridgeCaseInition.verifyUserAdminRoleDocumentationSpecialist();
			logger.info("Documentation Specialist All Checks filled successfully...");
			// Verify Docs Qc Allocator-- Bridge Portal
			bridgeCaseInition.verifyInsufficientDocsQcAllocator();
			logger.info("Select Docs Qc Allocator has Successfully!");
			// Verify Docs Quality-- Bridge Portal
			bridgeCaseInition.verifyInsufficientDocsQuality();
			logger.info("Case QC Review Ars Number has verified successfully!");
			// Verify Allocator-- Bridge Portal
			BridgeCaseDetails bridgeAllocator = new BridgeCaseDetails(driver);
			String data = new String(Files.readAllBytes(Paths.get("BridgeCaseArsNo.txt")));
			String arsNumber[] = data.split(" ");
			bridgeAllocator.superAdminAllocator(arsNumber[6], "Allocator check Comments has entered successfully");
			if (bridgeAllocator.verifyAllocatorArsNumber().contains(arsNumber[6])) {
				Assert.assertTrue(true);
				logger.info("Check id is Released, DueTo, Already released to vendor..!");
			} else {
				logger.info("Check id is Not Released, DueTo, Has Not Already released to vendor..!");
				captureScreen(driver, "verifyAllocatorArsNumber");
				Assert.assertTrue(false);
			}

		}
		
		// Verify Vendor/Admin Account Login Details
		@Test(enabled = true, testName = "Verify Vendor/Admin Account Login Details", priority = 2, dependsOnMethods = {
		"verifyBridgeCaseInitiation" })
		public void verifyAdminAccountLogin() throws InterruptedException, IOException {
			driver.get(OPUSUrl);
			logger.info("OPus Url is opened Successfully!");
			BridgeLoginPage vendorLogin = new BridgeLoginPage(driver);
			vendorLogin.opusAdminAcoountLogin(adminUsername, adminPassword);
			logger.info("Opus Admin Username and password has entered sucessfully!");
			if (vendorLogin.verifyOpusVendorLogoutPage().contains("Logout")) {
				Assert.assertTrue(true);
				logger.info("Opus Vendor account has logged successfully.!");
			} else {
				logger.info("Opus Vendor account has Not logged successfully.!");
				captureScreen(driver, "verifyOpusVendorLogoutPage");
				Assert.assertTrue(false);
			}
		}
		
		// Verify Check Allocation By Allocator To Vendor
		@Test(enabled = true, testName = "Verify Check Allocation By Allocator To Vendor", priority = 3, dependsOnMethods = {
				"verifyAdminAccountLogin" })
		public void verifyCheckAllocationByAllocatorToVendor() throws InterruptedException, IOException {
			Re_AssignCheck approveMapping = new Re_AssignCheck(driver);
			totalNewLoadNo = Integer.parseInt(approveMapping.getNewLoadCountNumber());
			approveMapping.adminApproveMapping();
			logger.info("Approve mapping has done successfully!");
			int oldNewLoadNo = Integer.parseInt(approveMapping.getOldNewLoadCountNumber());
			if (oldNewLoadNo < totalNewLoadNo) {
				Assert.assertTrue(true);
				logger.info("Vendor New Load Count number have verified successfully!");
			} else {
				logger.info("Vendor New Load Count number have Not verified successfully!");
				captureScreen(driver, "getOldNewLoadCountNumber");
				Assert.assertTrue(false);
			}
			BridgeLoginPage adminLogin = new BridgeLoginPage(driver);
			adminLogin.verifyAdminOpusLogout();
			logger.info("Opus Admin account has Logout successfully!");
		}
		
		// Verify Vendor Account Login Details
		@Test(enabled = true, testName = "Verify Vendor Account Login Details", priority = 4,dependsOnMethods = {
		"verifyCheckAllocationByAllocatorToVendor" })
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
		@Test(enabled = true, testName = "Verify Assigning check to field executive", priority = 5, dependsOnMethods = {
				"verifyVendorAccountLogin" })
		public void VerifyAssigningCheckToFieldExecutive() throws InterruptedException, IOException {
			OpusApproveMapping vendorAddressCheck = new OpusApproveMapping(driver);
			vendorAddressCheck.vendorAddressCheckAcceptAssign();
			logger.info("Address check have accepted and assign activity successfully!");
			Thread.sleep(20000);
			/*String alertText = driver.switchTo().alert().getText();
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
		
		// Verify Update Check Details
		@Test(enabled = true, testName = "Verify Update Check Details", priority = 6, dependsOnMethods = {
				"VerifyAssigningCheckToFieldExecutive" })
		public void verifyUpdateCheckDetails() throws InterruptedException, IOException {
			Re_AssignCheck vendorAddressCheck = new Re_AssignCheck(driver);
			vendorAddressCheck.vendorAddressCheckUpdate();
			logger.info("Vendor Check has updated successfully!");
			vendorAddressCheck.verifyCheckIdAndFeName();
			logger.info("Verify Fe name has successfully!");
			String ActualFeName = new String(Files.readAllBytes(Paths.get("CheckFeName.txt")));
			String ExpectedFeName = "Testing User";
			Assert.assertEquals(ExpectedFeName, ActualFeName);
		}

}
