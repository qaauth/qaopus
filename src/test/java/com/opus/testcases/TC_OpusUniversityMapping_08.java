package com.opus.testcases;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.opus.pageobject.BridgeCaseDetails;
import com.opus.pageobject.BridgeLoginPage;
import com.opus.pageobject.OpusUniversityMapping;
import com.opus.utilities.RandomStrings;

public class TC_OpusUniversityMapping_08 extends BaseClass {
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

	// Verify University Mapping by selecting admin role
	@Test(enabled = true, testName = "Verify City Mapping by selecting admin role", priority = 2, dependsOnMethods = {
			"verifyVendorAccountLogin" })
	public void verifyAdminByCityMapping() throws InterruptedException, IOException {
		OpusUniversityMapping universityMapping = new OpusUniversityMapping(driver);
		universityMapping.adminByCityMapping();
		logger.info("City mapping has completed successfuly!");
		if (universityMapping.verifyUniversityMappingName().contains("University of Delhi")) {
			Assert.assertTrue(true);
			logger.info("University Mapping has verified successfully.!");
		} else {
			logger.info("University Mapping has Not verified successfully.!");
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
		BridgeCaseDetails highlighter = new BridgeCaseDetails(driver);
		highlighter.selectUserAdminRoleHighlighter();
		logger.info("Assign Cases with Ageing and selected Topsheet has successfully!");
		OpusUniversityMapping createEduCheck = new OpusUniversityMapping(driver);
		createEduCheck.highlighterAddDetails("1", "1", "1", "1", "1", "1", "1", "1",
				(System.getProperty("user.dir") + "/documents/ARN.pdf"),
				(System.getProperty("user.dir") + "/documents/Mail.pdf"), "Escalation Comment are good",
				"Comments are good");
		logger.info("Highlighter Add Details have added sucessfully!");
		// Documentation Specialist
		BridgeCaseDetails documentationSpecialist = new BridgeCaseDetails(driver);
		documentationSpecialist.selectUserAdminRoleDocumentationSpecialist();
		logger.info("Select Company name and clicked on count number Successfully from Documentation Specialist Role!");
		documentationSpecialist.specialistPendingCases();
		logger.info("Documentation Specialist Pending Cases has been Updated successfully!");
		documentationSpecialist.docSpecialistCandidateDetails();
		logger.info("Documentation Specialist Candidate details have been added successfully!");
		OpusUniversityMapping eductionCheckMap = new OpusUniversityMapping(driver);
		eductionCheckMap.educationVerificationWCheck();
		logger.info("Documentation Specialist All Checks filled successfully...");
		//documentationSpecialist.currentAddressVerification();
		// documentationSpecialist.permanentAddressVerificationCheck();
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
		OpusUniversityMapping universityMapAllocator = new OpusUniversityMapping(driver);
		universityMapAllocator.switchToRoleAllocator();
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
