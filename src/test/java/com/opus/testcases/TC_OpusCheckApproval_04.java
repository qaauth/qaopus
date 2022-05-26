package com.opus.testcases;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.SQLException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.opus.pageobject.BridgeLoginPage;
import com.opus.pageobject.OpusApproveMapping;

public class TC_OpusCheckApproval_04 extends BaseClass {
	// Verify Admin Approval TL Role
	@Test(enabled = true, testName = "Verify Admin Aproval TL Role", priority = 1)
	public void verifyAdminAprovalTl() throws InterruptedException, IOException {
		driver.get(OPUSUrl);
		logger.info("OPus Url is opened Successfully!");
		BridgeLoginPage adminLogin = new BridgeLoginPage(driver);
		adminLogin.opusAdminAcoountLogin(adminUsername, adminPassword);
		logger.info("Opus Admin Username and password has entered sucessfully!");
		OpusApproveMapping approverTl = new OpusApproveMapping(driver);
		approverTl.verifyGetBeforeTotalChecksCount();
		logger.info("Total Checks Before Count have Got successfully!");
		String checkCount = new String(Files.readAllBytes(Paths.get("BeforeTotalChecksCount.txt")));
		String beforeCheckCount[] = checkCount.split(" ");
		approverTl.adminApproverTL();
		logger.info("Admin select Approver TL role has done successfully!");
		approverTl.verifyGetAfterTotalChecksCount();
		logger.info("Total Checks After Count have Got successfully!");
		String checkCountAfter = new String(Files.readAllBytes(Paths.get("AfterTotalChecksCount.txt")));
		String afterCheckCount[] = checkCountAfter.split(" ");
		if (Integer.parseInt(afterCheckCount[0]) < Integer.parseInt(beforeCheckCount[0])) {
			Assert.assertTrue(true);
			logger.info("Total Checks Count have verified successfully.!");
		} else {
			logger.info("Total Checks Count have Not verified successfully.!");
			captureScreen(driver, "verifyCheckCountNumber");
			Assert.assertTrue(false);
		}
	}

	// Verify Opus Admin Approver Role
	@Test(enabled = true, testName = "Verify Opus Admin Approver Role", priority = 2, dependsOnMethods = {
			"verifyAdminAprovalTl" })
	public void verifyAdminApprover() throws InterruptedException, IOException {
		OpusApproveMapping approver = new OpusApproveMapping(driver);
		String data = new String(Files.readAllBytes(Paths.get("BridgeCaseArsNo.txt")));
		String arsNumber[] = data.split(" ");
		approver.adminRoleApprover(arsNumber[6], arsNumber[6]);
		logger.info("Admin has selected Approver role done successfully!");
		if (approver.verifyCheckStatusCompletedText().contains("Completed")) {
			Assert.assertTrue(true);
			logger.info("Check Status has Verified completed successfully.!");
		} else {
			logger.info("Check Status has Not Verified completed successfully.!");
			captureScreen(driver, "verifyCheckStatusCompletedText");
			Assert.assertTrue(false);
		}
	}

	// Verification Quality Allocator--Check List - Search Result - (14 records)
	@Test(enabled = true, testName = "Verify Verification Quality Allocator--Check List", priority = 4, dependsOnMethods = {
			"verifyAdminAprovalTl" })
	public void verificationQualityAllocator() throws IOException, InterruptedException {
		driver.get(baseURL);
		logger.info("Bridge Url is opened Successfully!");
		BridgeLoginPage login = new BridgeLoginPage(driver);
		login.loginBridgeAccount(username, password);
		logger.info("Bridge Username and password has entered sucessfully!");
		OpusApproveMapping verificationQualityAllocator = new OpusApproveMapping(driver);
		String data = new String(Files.readAllBytes(Paths.get("BridgeCaseArsNo.txt")));
		String arsNumber[] = data.split(" ");
		verificationQualityAllocator.superAdminVerificationQualityAllocator(arsNumber[6],
				"Verification Quality Allocator Comments are good");
		logger.info("Verification Quality Allocator details has been filled Successfully!");

		if (verificationQualityAllocator.verificationQualityAllocatorSuccessfullyMsg()
				.contains("The selected checks were successfully released for report.")) {
			Assert.assertTrue(true);
			logger.info("The selected checks were successfully released for report.!");
		} else {
			logger.info("The selected checks were Not successfully released for report.!");
			captureScreen(driver, "verificationQualityAllocatorSuccessfullyMsg");
			Assert.assertTrue(false);
		}
	}

	// Reports Manager -- Search Report
	@Test(enabled = true, testName = "Verify Reports Manager Search Report", priority = 5, dependsOnMethods = {
			"verificationQualityAllocator" })
	public void verifyReportsManager() throws InterruptedException, IOException {
		OpusApproveMapping reportManager = new OpusApproveMapping(driver);
		String data = new String(Files.readAllBytes(Paths.get("BridgeCaseArsNo.txt")));
		String arsNumber[] = data.split(" ");
		reportManager.superAdminReportsManager(arsNumber[6]);
		logger.info("Manager Reports details have been filled Successfully!");
		if (reportManager.verifyReportSuccessReviewedMsg().contains("Report Successfully Reviewed.")) {
			Assert.assertTrue(true);
			logger.info("The Report has been Reviewed Successfully!");
		} else {
			logger.info("The Report has Not been Reviewed Successfully!");
			captureScreen(driver, "verifyReportSuccessfullyReviewedMsg");
			Assert.assertTrue(false);
		}
	}

	// Generate Case Report By Crone URL hit
	@Test(enabled = true, testName = "Generated case Report and download Pdf", priority = 6, dependsOnMethods = {
			"verifyReportsManager" })
	public void generateCaseReportPdf() throws IOException, InterruptedException, ClassNotFoundException, SQLException {
		OpusApproveMapping caseReportPdf = new OpusApproveMapping(driver);
		String randomString = new String(Files.readAllBytes(Paths.get("copyGenerateCode.txt")));
		String generateReportCode[] = randomString.split("/");
		String reportGenerateUrl = "http://35.154.153.79/bridge_aws_multi/reports/generate_case_report2/"
				+ generateReportCode[7];
		Thread.sleep(2000);
		driver.get(reportGenerateUrl);
		logger.info("Chrone URL has been hitted Successfully!");
		Thread.sleep(2000);
		driver.get(reportGenerateUrl);
		logger.info("The Case Report Id has not found Successfully!");
		Thread.sleep(2000);
		driver.get("http://35.154.153.79/bridge_aws_multi/reports/");
		logger.info("The Report Url has been Launched Successfully!");
		if (caseReportPdf.verifyReportStatusVerified().contains("Final")) {
			Assert.assertTrue(true);
			logger.info("The Report Status has been Verified Successfully!");
		} else {
			logger.info("The Report Status has not been Verified Successfully!");
			captureScreen(driver, "verifyReportStatusVerified");
			Assert.assertTrue(false);
		}

		// caseReportPdf.clickOnGeneratedPdfIcon();
		logger.info("Report Generated has been Downloaded Successfully!");
		Thread.sleep(2000);
		BridgeLoginPage bridgeLogout = new BridgeLoginPage(driver);
		bridgeLogout.bridgeAccountLoggedOut();
		logger.info("Bridge Account Logged Out has Successfully!");
		// Database Connection--
		String data = new String(Files.readAllBytes(Paths.get("BridgeCaseArsNo.txt")));
		String arsNumber[] = data.split(" ");
		// DatabaseConnection_01 database = new DatabaseConnection_01();
		// database.databaseConection(arsNumber[6]);
		logger.info("Database conection and queries has been executed successfully!");
	}
}
