package com.opus.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.opus.pageobject.BridgeLoginPage;
import com.opus.pageobject.OpusApproveMapping;

public class TC_OpusVendorCaseAllocation_02 extends BaseClass {
	int totalNewLoadNo;

	// Verify Opus Admin Account Logged In
	@Test(enabled = true, testName = "Verify Opus Admin Account Logged In", priority = 1)
	public void verifyOpusAdminLogin() throws InterruptedException, IOException {
		driver.get(OPUSUrl);
		logger.info("OPus Url is opened Successfully!");
		BridgeLoginPage adminLogin = new BridgeLoginPage(driver);
		adminLogin.opusAdminAcoountLogin(adminUsername, adminPassword);
		logger.info("Opus Admin Username and password has entered sucessfully!");
		if (adminLogin.verifyOpusAdminLogoutText().contains("Logout")) {
			Assert.assertTrue(true);
			logger.info("Opus Admin Account has Logged In successfully.!");
		} else {
			logger.info("Opus Admin Account has Not Logged In successfully.!");
			captureScreen(driver, "verifyOpusAdminLogoutText");
			Assert.assertTrue(false);
		}
	}

	// Verify Check Allocation By Allocator To Vendor
	@Test(enabled = true, testName = "Verify Check Allocation By Allocator To Vendor", priority = 2, dependsOnMethods = {
			"verifyOpusAdminLogin" })
	public void verifyCheckAllocationByAllocatorToVendor() throws InterruptedException, IOException {
		OpusApproveMapping approveMapping = new OpusApproveMapping(driver);
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
}
