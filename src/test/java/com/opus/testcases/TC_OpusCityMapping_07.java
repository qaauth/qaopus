package com.opus.testcases;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.opus.pageobject.BridgeCaseDetails;
import com.opus.pageobject.BridgeLoginPage;
import com.opus.pageobject.OpusCityMapping;
import com.opus.utilities.RandomStrings;

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

	// Verify Bridge Login Test
	@Test(enabled = true, testName = "Bridge Login Test", priority = 3, dependsOnMethods = {
			"verifyAdminByCityMapping" })
	public void bridgeLoginTest() throws IOException, InterruptedException {
		driver.get(baseURL);
		logger.info("Bridge Url is opened Successfully!");
		BridgeLoginPage login = new BridgeLoginPage(driver);
		login.loginBridgeAccount(username, password);
		logger.info("Bridge Username and password has entered sucessfully!");
		Thread.sleep(2000);
		if (login.verifyBridgeLogoutText().contains("Logout")) {
			Assert.assertTrue(true);
			logger.info("Bridge Client has logged Successfully!");
		} else {
			logger.info("Bridge Client has not logged Successfully!");
			captureScreen(driver, "verifyNotificationAlerts");
			Assert.assertTrue(false);
		}
	}

	// Bridge Case Add Details
	@Test(enabled = true, testName = "Verify Bridge Case Add Details", priority = 4, dependsOnMethods = {
			"bridgeLoginTest" })
	public void bridgeCaseAddDetails() throws InterruptedException, IOException {
		BridgeCaseDetails caseAddDetails = new BridgeCaseDetails(driver);
		caseAddDetails.selectUserAdminRoleDocumentProcessor();
		logger.info("User Admin Role DocumentProcessor has selected Successfully!");
		firstName = RandomStrings.randomeStringCandidateFirstName();
		caseAddDetails.candidateFirstName(firstName);
		middleName = RandomStrings.randomeStringCandidateMiddleName();
		caseAddDetails.candidateMiddleName(middleName);
		String lastName = RandomStrings.randomeStringCandidateLastName();
		caseAddDetails.candidateLastName(lastName);
		String email = RandomStrings.randomeStringCandidateEmail() + "@mailinator.com";
		caseAddDetails.candidateEmail(email);
		String mobileNumber = RandomStrings.randomeStringMobileNumber();
		caseAddDetails.candidateMobileNumber(mobileNumber);
		logger.info("Candidate First Name, Middle Name, Last Name and Email address have added successfully!");
		caseAddDetails.createNewBridgeCase("1-Apr-2021", "1-Apr-2021 00:00:00", "ARN", "panCard", "passportNo",
				"drivingLicenceNo", "voterId", "Awaanish", "5-Apr-1991", "7858975467", "123456789", "4-Apr-1991",
				"Run departments", "Penalties", "4-Apr-2002", "AKSP1234", "Sujeet", "British Telecom", "Gurgaow",
				"8-Apr-2019", "Unit20", "Senior QA", "6098", "btemailid@gmail.com", "6098", "hrdpemail@gmail.com",
				"6098", "Candidate has filled all details");
		logger.info("Bridge new case Candidate details have added successully!");
		if (caseAddDetails.verifyCaseDetailsSavedSuccessfullyMsg()
				.contains("Case detail has been saved successfully")) {
			Assert.assertTrue(true);
			logger.info("Case detail has been saved successfully!");
		} else {
			logger.info("Case detail has Not been saved successfully!");
			captureScreen(driver, "verifyCaseDetailsSavedSuccessfullyMsg");
			Assert.assertTrue(false);
		}
	}

	// Highlighter Allocator
	@Test(enabled = true, testName = " Verify Case allocated to highlighter Allocator", priority = 5, dependsOnMethods = {
			"bridgeCaseAddDetails" })
	public void verifyAdminUserRoleHighlighterAllocator() throws InterruptedException, IOException {
		BridgeCaseDetails highlighterAllocator = new BridgeCaseDetails(driver);
		highlighterAllocator.selectAdminUserRoleHighlighterAllocator();
		logger.info("British Telecom client Case has been Allocated Cases Successfully!");
		if (highlighterAllocator.verifySuccessfullyAllocatedMsg()
				.contains("Case is successfully allocated to highlighter.")) {
			Assert.assertTrue(true);
			logger.info("Case is successfully allocated to highlighter.!");
		} else {
			logger.info("Case is Not successfully allocated to highlighter.!");
			captureScreen(driver, "verifySuccessfullyAllocatedMsg");
			Assert.assertTrue(false);
		}
	}

	// Highlighter
	@Test(enabled = true, testName = "Verify Case allocated to highlighter", priority = 6, dependsOnMethods = {
			"verifyAdminUserRoleHighlighterAllocator" })
	public void verifyUserAdminRoleHighlighter() throws InterruptedException, IOException {
		BridgeCaseDetails highlighter = new BridgeCaseDetails(driver);
		highlighter.selectUserAdminRoleHighlighter();
		logger.info("Assign Cases with Ageing and selected Topsheet has successfully!");
		highlighter.highlighterAddDetails("1", "1", "1", "1", "1", "1", "1", "1",
				(System.getProperty("user.dir") + "/documents/ARN.pdf"),
				(System.getProperty("user.dir") + "/documents/Mail.pdf"), "Escalation Comment are good",
				"Comments are good");
		logger.info("Highlighter Add Details have added sucessfully!");
		if (highlighter.verifyTopsheetSuccessfullyCreatedMsg().contains(
				"Topsheet is successfully created. You can now proceed with checks creation for the given candidate.")) {
			Assert.assertTrue(true);
			logger.info(
					"Topsheet is successfully created. You can now proceed with checks creation for the given candidate.!");
		} else {
			logger.info(
					"Topsheet is Not successfully created. You can Not now proceed with checks creation for the given candidate.!");
			captureScreen(driver, "verifyTopsheetSuccessfullyCreatedMsg");
			Assert.assertTrue(false);
		}
	}

	// Documentation Specialist
	@Test(enabled = true, testName = "Verify Case Documentation Specialist", priority = 7, dependsOnMethods = {
			"verifyUserAdminRoleHighlighter" })
	public void verifyUserAdminRoleDocumentationSpecialist() throws IOException, InterruptedException {
		BridgeCaseDetails documentationSpecialist = new BridgeCaseDetails(driver);
		documentationSpecialist.selectUserAdminRoleDocumentationSpecialist();
		logger.info("Select Company name and clicked on count number Successfully from Documentation Specialist Role!");
		documentationSpecialist.specialistPendingCases();
		logger.info("Documentation Specialist Pending Cases has been Updated successfully!");
		documentationSpecialist.docSpecialistCandidateDetails();
		logger.info("Documentation Specialist Candidate details have been added successfully!");
		OpusCityMapping cityMapping = new OpusCityMapping(driver);
		cityMapping.currentAddressVerification();
		// documentationSpecialist.currentAddressVerification();
		// documentationSpecialist.permanentAddressVerificationCheck();
		logger.info("Documentation Specialist All Checks filled successfully...");
		if (documentationSpecialist.verifyCheckDetailsSuccessfullyMsg().contains("Case Detail")) {
			Assert.assertTrue(true);
			logger.info("Check details are successfully saved. Case is Completed.!");
		} else {
			logger.info("Check details are Not successfully saved. Case is Completed.!");
			captureScreen(driver, "verifyCheckDetailsSuccessfullyMsg");
			Assert.assertTrue(false);
		}
	}

	// Verify Docs Qc Allocator-- Bridge Portal
	@Test(enabled = true, testName = "Verify Docs Qc Allocator", priority = 8, dependsOnMethods = {
			"verifyUserAdminRoleDocumentationSpecialist" })
	public void verifyInsufficientDocsQcAllocator() throws InterruptedException, IOException {
		BridgeCaseDetails bridgeDocsQcAllocator = new BridgeCaseDetails(driver);
		bridgeDocsQcAllocator.superAdminDocsQcAllocator();
		logger.info("Select Docs Qc Allocator has Successfully!");
		if (bridgeDocsQcAllocator.verifyCaseSuccessAllocatedMsg()
				.contains("All selected cases were successfully allocated to QC Team Member.")) {
			Assert.assertTrue(true);
			logger.info("All selected cases were successfully allocated to QC Team Member.!");
		} else {
			logger.info("All selected cases were Not successfully allocated to QC Team Member.!");
			captureScreen(driver, "verifyDocsQcAllocatorCase");
			Assert.assertTrue(false);
		}
	}

	// Verify Docs Quality-- Bridge Portal
	@Test(enabled = true, testName = "Verify Docs Quality", priority = 9, dependsOnMethods = {
			"verifyInsufficientDocsQcAllocator" })
	public void verifyInsufficientDocsQuality() throws InterruptedException, IOException {
		BridgeCaseDetails bridgeDocsQuality = new BridgeCaseDetails(driver);
		String data = new String(Files.readAllBytes(Paths.get("BridgeCaseArsNo.txt")));
		String arsNumber[] = data.split(" ");
		bridgeDocsQuality.superAdminDocsQuality(arsNumber[6]);
		if (bridgeDocsQuality.verifyCaseQCReviewArsNumber().contains(arsNumber[6])) {
			Assert.assertTrue(true);
			logger.info("Case QC Review Ars Number has verified successfully!");
		} else {
			logger.info("Case QC Review Ars Number has Not verified successfully!");
			captureScreen(driver, "verifyDocsQcAllocatorCase");
			Assert.assertTrue(false);
		}
		bridgeDocsQuality.verifyQcDoneChecksSummary("Case level comments are good", "1",
				"Case level comments are good");
		if (bridgeDocsQuality.verifyReleasedForVerificationMsg()
				.contains("The Case was successfully released for Verification.")) {
			Assert.assertTrue(true);
			logger.info("The Case was successfully released for Verification.!");
		} else {
			logger.info("The Case was Not successfully released for Verification.!");
			captureScreen(driver, "verifyQcDoneChecksSummary");
			Assert.assertTrue(false);
		}
	}

	// Verify Allocator-- Bridge Portal
	@Test(enabled = true, testName = "Verify Case Allocation", priority = 10, dependsOnMethods = {
			"verifyInsufficientDocsQuality" })
	public void verifyInsufficientAllocator() throws IOException, InterruptedException {
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
	@Test(enabled = true, testName = "Verify Switch to role: Allocator", priority = 11, dependsOnMethods = {
			"verifyInsufficientAllocator" })
	public void verifySwitchToRoleAllocator() throws IOException, InterruptedException {
		driver.get(OPUSUrl);
		logger.info("OPus Url is opened Successfully!");
		//BridgeLoginPage vendorLogin = new BridgeLoginPage(driver);
		//vendorLogin.opusAdminAcoountLogin(adminUsername, adminPassword);
		logger.info("Opus Admin Username and password has entered sucessfully!");
		OpusCityMapping cityMapAllocator = new OpusCityMapping(driver);
		cityMapAllocator.switchToRoleAllocator();
		logger.info("Internal Vendor has verified in Vendor action dropdown List!");
		/*if (bridgeAllocator.verifyAllocatorArsNumber().contains(arsNumber[6])) {
			Assert.assertTrue(true);
			logger.info("Check id is Released, DueTo, Already released to vendor..!");
		} else {
			logger.info("Check id is Not Released, DueTo, Has Not Already released to vendor..!");
			captureScreen(driver, "verifyAllocatorArsNumber");
			Assert.assertTrue(false);
		}*/
	}

}
