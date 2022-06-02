package com.opus.testcases;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.opus.pageobject.BridgeCaseDetails;
import com.opus.pageobject.BridgeLoginPage;
import com.opus.pageobject.OpusCityMapping;

public class TC_OpusCityMapping_07 extends BaseClass {
	String firstName;
	String middleName;

	// Verify Vendor/Admin Account Login Details
	@Test(enabled = true, testName = "Verify Vendor/Admin Account Login Details", priority = 1)
	public void verifyVendorAccountLogin() throws InterruptedException, IOException {
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

	// Verify City Mapping by selecting admin role
	@Test(enabled = true, testName = "Verify City Mapping by selecting admin role", priority = 2, dependsOnMethods = {
			"verifyVendorAccountLogin" })
	public void verifyAdminByCityMapping() throws InterruptedException, IOException {
		OpusCityMapping cityMapping = new OpusCityMapping(driver);
		cityMapping.adminByCityMapping();
		logger.info("City mapping has completed successfuly!");
		if (cityMapping.verifyLogoutVendorAdminAccount().contains("New Delhi")) {
			Assert.assertTrue(true);
			logger.info("City Mapping has verified successfully.!");
		} else {
			logger.info("City Mapping has Not verified successfully.!");
			captureScreen(driver, "verifyLogoutVendorAdminAccount");
			Assert.assertTrue(false);
		}
	}

	// Verify Bridge case initiation
	@Test(enabled = true, testName = "Verify Bridge case initiation", priority = 3, dependsOnMethods = {
			"verifyAdminByCityMapping" })
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

	// Verify Switch to role: Allocator
	@Test(enabled = true, testName = "Verify Switch to role: Allocator", priority = 4, dependsOnMethods = {
			"verifyBridgeCaseInitiation" })
	public void verifySwitchToRoleAllocator() throws IOException, InterruptedException {
		driver.get(OPUSUrl);
		logger.info("OPus Url is opened Successfully!");
		// BridgeLoginPage vendorLogin = new BridgeLoginPage(driver);
		// vendorLogin.opusAdminAcoountLogin(adminUsername, adminPassword);
		logger.info("Opus Admin Username and password has entered sucessfully!");
		OpusCityMapping cityMapAllocator = new OpusCityMapping(driver);
		cityMapAllocator.switchToRoleAllocator();
		logger.info("Internal Vendor has verified in Vendor action dropdown List!");
		/*
		 * if (bridgeAllocator.verifyAllocatorArsNumber().contains(arsNumber[6])) {
		 * Assert.assertTrue(true);
		 * logger.info("Check id is Released, DueTo, Already released to vendor..!"); }
		 * else { logger.
		 * info("Check id is Not Released, DueTo, Has Not Already released to vendor..!"
		 * ); captureScreen(driver, "verifyAllocatorArsNumber");
		 * Assert.assertTrue(false); }
		 */
	}

}
