package com.opus.testcases;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.opus.pageobject.BridgeCaseDetails;
import com.opus.pageobject.BridgeLoginPage;
import com.opus.pageobject.OpusOnHoldCheck;
import com.opus.pageobject.Re_AssignCheck;

public class TC_OpusOnHoldCheck_11 extends BaseClass {
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
				OpusOnHoldCheck verifyOnHoldCheck = new OpusOnHoldCheck(driver);
				verifyOnHoldCheck.verifyCheckCheckId();
				logger.info("Current Address check id has verified successfully!");
				BridgeLoginPage adminLogin = new BridgeLoginPage(driver);
				adminLogin.verifyAdminOpusLogout();
				logger.info("Opus Admin account has Logout successfully!");
			}
			
			// Verify cat role and mark as check on hold
			@Test(enabled = true, testName = "Verify cat role and mark as check on hold", priority = 4,dependsOnMethods = {
			"verifyCheckAllocationByAllocatorToVendor" })
			public void verifyCheckOnHoldByCatRole() throws InterruptedException, IOException {
				driver.get(baseURL);
				logger.info("Bridge Url is opened");
				BridgeLoginPage bridgeLogin = new BridgeLoginPage(driver);
				// bridgeLogin.loginBridgeAccount(bridgeEmail, bridgeUserPassword);
				bridgeLogin.loginBridgeAccount(catRoleUsername, catRolePassword);
				logger.info("Bridge account has Logged successfully!");
			}
}
