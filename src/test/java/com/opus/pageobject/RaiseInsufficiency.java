package com.opus.pageobject;

import java.awt.Robot;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.opus.utilities.JavaScriptManuplator;

public class RaiseInsufficiency {
	WebDriver ldriver;
	WebDriverWait wait;
	JavascriptExecutor js;
	Robot rbt;

	public RaiseInsufficiency(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(ldriver, this);
	}

	// Vendor -- Raise Insuff
	@FindBy(xpath = "/html/body/div/div[3]/table/tbody/tr/td[2]/table/tbody/tr[13]/td[2]/input")
	@CacheLookup
	WebElement clickOnRaiseInsuffBtn;

	// Document Insufficient for Verification
	@FindBy(xpath = "//select[@id='insuff_reason']")
	@CacheLookup
	WebElement selectInsuffReason;// Address Incomplete

	@FindBy(xpath = "//textarea[@id='VENDOR_INSUFF_REMARKS']")
	@CacheLookup
	WebElement txtVendorInsuffRemarks;

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[3]/table[1]/tbody[1]/tr[2]/td[2]/table[1]/tbody[1]/tr[5]/td[1]/input[3]")
	@CacheLookup
	WebElement clickOnMarkCheckAsInsufficientBtn;

	// Document Insufficient for Verification-- Left Job
	@FindBy(xpath = "//select[@id='insuff_reason']")
	@CacheLookup
	WebElement selectInsuffReasonJob;// Left the Job

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[3]/table[1]/tbody[1]/tr[2]/td[2]/table[1]/tbody[1]/tr[5]/td[1]/input[3]")
	@CacheLookup
	WebElement clickOnMarkCheckAsInsuffBtn;

	// Admin-- Admin Approver TL
	@FindBy(xpath = "/html[1]/body[1]/div[1]/table[1]/tbody[1]/tr[1]/td[3]/table[1]/tbody[1]/tr[2]/td[1]/select[1]")
	@CacheLookup
	WebElement selectApproverTL;

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[4]/form[1]/table[2]/tbody[1]/tr[7]/td[10]/a[1]")
	@CacheLookup
	WebElement getBeforeInsuffRaiseCount;

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[4]/form[1]/table[2]/tbody[1]/tr[7]/td[10]/a[1]")
	@CacheLookup
	WebElement clickOnBeforeInsuffRaiseCount;

	// Summary Of Checks-- Allocate
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[3]/form[1]/table[1]/tbody[1]/tr[3]/td[1]/input[1]")
	@CacheLookup
	WebElement clickOnAllCheckBox;

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[3]/form[1]/table[2]/tbody[1]/tr[1]/td[1]/table[1]/tbody[1]/tr[1]/td[1]/select[1]")
	@CacheLookup
	WebElement selectApproverName;// Ajay Sahoo VB

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[3]/form[1]/table[2]/tbody[1]/tr[1]/td[1]/table[1]/tbody[1]/tr[1]/td[1]/input[1]")
	@CacheLookup
	WebElement clickOnAllocateBtn;

	@FindBy(xpath = "//span[contains(text(),'Home')]")
	@CacheLookup
	WebElement clickOnHomeName;

	// Home Module
	@FindBy(xpath = "//td[contains(text(),'Cases with Approver')]")
	@CacheLookup
	WebElement verifyCasesWithApprover;

	@FindBy(xpath = "//span[contains(text(),'Home')]")
	@CacheLookup
	WebElement clickOnHomeModuleNameInsuff;

	// After Vendor Insuff Count
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[4]/form[1]/table[2]/tbody[1]/tr[7]/td[10]/a[1]")
	@CacheLookup
	WebElement getAfterVendorInsuffCount;

	// Admin Approver
	@FindBy(xpath = "/html[1]/body[1]/div[1]/table[1]/tbody[1]/tr[1]/td[3]/table[1]/tbody[1]/tr[2]/td[1]/select[1]")
	@CacheLookup
	WebElement selectAdminApprover;

	@FindBy(xpath = "//input[@id='search']")
	@CacheLookup
	WebElement txtArsNoSearch;

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[3]/table[1]/tbody[1]/tr[1]/td[2]/form[1]/input[2]")
	@CacheLookup
	WebElement clickOnSearchBtn;

	@FindBy(xpath = "//td[contains(text(),'British Telecom')]")
	@CacheLookup
	WebElement verifyClientName;

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[3]/form[1]/table[1]/tbody[1]/tr[4]/td[7]/a[1]")
	@CacheLookup
	WebElement clickOnArsNumber;

	// Disposition
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[3]/table[1]/tbody[1]/tr[1]/td[2]/table[1]/tbody[1]/tr[10]/td[2]/table[1]/tbody[1]/tr[1]/td[1]/input[1]")
	@CacheLookup
	WebElement clickOnDispositionRadioBtn;

	// Verified Via
	@FindBy(xpath = "//select[@id='VERIFICATION_PROCEDURE']")
	@CacheLookup
	WebElement selectVerifiedVia;// Email

	// Closure Comments
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[3]/table[1]/tbody[1]/tr[1]/td[2]/table[1]/tbody[1]/tr[14]/td[2]/table[1]/tbody[1]/tr[1]/td[1]/input[1]")
	@CacheLookup
	WebElement clickOnClosureCommentsRadioBtn;

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[3]/table[1]/tbody[1]/tr[1]/td[2]/table[1]/tbody[1]/tr[14]/td[2]/table[1]/tbody[1]/tr[1]/td[1]/input[1]")
	@CacheLookup
	WebElement checkSubjectIsResidingRadioBtn;

	// Antecedents to Verify
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[3]/table[1]/tbody[1]/tr[1]/td[2]/table[1]/tbody[1]/tr[16]/td[1]/table[1]/tbody[1]/tr[1]/td[3]/label[1]/input[1]")
	@CacheLookup
	WebElement checkCopyStatedCheckBox;

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[3]/table[1]/tbody[1]/tr[1]/td[2]/table[1]/tbody[1]/tr[16]/td[1]/table[1]/tbody[1]/tr[2]/td[3]/textarea[1]")
	@CacheLookup
	WebElement txtAnyOtherComment;

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[3]/table[1]/tbody[1]/tr[1]/td[2]/table[1]/tbody[1]/tr[16]/td[1]/table[1]/tbody[1]/tr[3]/td[3]/input[1]")
	@CacheLookup
	WebElement txtGateColorName;

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[3]/table[1]/tbody[1]/tr[1]/td[2]/table[1]/tbody[1]/tr[16]/td[1]/table[1]/tbody[1]/tr[4]/td[3]/input[1]")
	@CacheLookup
	WebElement txtColorOfBulding;

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[3]/table[1]/tbody[1]/tr[1]/td[2]/table[1]/tbody[1]/tr[16]/td[1]/table[1]/tbody[1]/tr[5]/td[3]/input[1]")
	@CacheLookup
	WebElement txtNameOfFieldExecutiveName;

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[3]/table[1]/tbody[1]/tr[1]/td[2]/table[1]/tbody[1]/tr[16]/td[1]/table[1]/tbody[1]/tr[6]/td[3]/textarea[1]")
	@CacheLookup
	WebElement txtNewAddressDetailsObtainedName;

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[3]/table[1]/tbody[1]/tr[1]/td[2]/table[1]/tbody[1]/tr[16]/td[1]/table[1]/tbody[1]/tr[10]/td[3]/textarea[1]")
	@CacheLookup
	WebElement txtDurationOfStayName;

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[3]/table[1]/tbody[1]/tr[1]/td[2]/table[1]/tbody[1]/tr[16]/td[1]/table[1]/tbody[1]/tr[11]/td[3]/select[1]")
	@CacheLookup
	WebElement selectResidenceTypeName;// Not Applicable

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[3]/table[1]/tbody[1]/tr[1]/td[2]/table[1]/tbody[1]/tr[16]/td[1]/table[1]/tbody[1]/tr[12]/td[3]/textarea[1]")
	@CacheLookup
	WebElement txtVerifiedFormName;

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[3]/table[1]/tbody[1]/tr[1]/td[2]/table[1]/tbody[1]/tr[16]/td[1]/table[1]/tbody[1]/tr[13]/td[3]/textarea[1]")
	@CacheLookup
	WebElement txtRelationshipWithCandidateName;

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[3]/table[1]/tbody[1]/tr[1]/td[2]/table[1]/tbody[1]/tr[16]/td[1]/table[1]/tbody[1]/tr[14]/td[3]/select[1]")
	@CacheLookup
	WebElement selectVerificationTypeName;// Not Applicable

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[3]/table[1]/tbody[1]/tr[1]/td[2]/table[1]/tbody[1]/tr[16]/td[1]/table[1]/tbody[1]/tr[15]/td[3]/input[1]")
	@CacheLookup
	WebElement txtDateOfVerificationName;// 10/10/2021

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[3]/table[1]/tbody[1]/tr[1]/td[2]/table[1]/tbody[1]/tr[16]/td[1]/table[1]/tbody[1]/tr[16]/td[3]/input[1]")
	@CacheLookup
	WebElement txtTimeOfVerificationName;

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[3]/table[1]/tbody[1]/tr[1]/td[2]/table[1]/tbody[1]/tr[18]/td[3]/input[1]")
	@CacheLookup
	WebElement clickOnSaveDeatilsBtn;

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[3]/table[1]/tbody[1]/tr[1]/td[2]/table[1]/tbody[1]/tr[17]/td[1]/p[1]/input[1]")
	@CacheLookup
	WebElement txtGPSCoordinates;

	// Release for Report
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[3]/table[1]/tbody[1]/tr[1]/td[2]/table[1]/tbody[1]/tr[18]/td[1]/select[1]")
	@CacheLookup
	WebElement selectActionName;// Raise & accept insuff

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[3]/table[1]/tbody[1]/tr[1]/td[2]/table[1]/tbody[1]/tr[18]/td[1]/input[18]")
	@CacheLookup
	WebElement clickOnAcceptInsuffGoBtn;

	// Document Insufficient for Verification
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[3]/table[1]/tbody[1]/tr[2]/td[2]/table[1]/tbody[1]/tr[3]/td[2]/textarea[1]")
	@CacheLookup
	WebElement txtDocumentInsuffForVerification;

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[3]/table[1]/tbody[1]/tr[2]/td[2]/table[1]/tbody[1]/tr[4]/td[1]/input[5]")
	@CacheLookup
	WebElement clickOnMarkAsInsufficient;

	// Admin Home Module
	@FindBy(xpath = "//span[contains(text(),'Home')]")
	@CacheLookup
	WebElement clickOnHomeModule;

	@FindBy(xpath = "//input[@id='search']")
	@CacheLookup
	WebElement txtHomeArsNoSearch;

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[3]/table[1]/tbody[1]/tr[1]/td[2]/form[1]/input[2]")
	@CacheLookup
	WebElement clickOnHomeSearchBtn;

	// Check Status -- Insufficient
	@FindBy(xpath = "//td[contains(text(),'Insufficient')]")
	@CacheLookup
	WebElement verifyCheckStatusInsufficient;

	// Bridge-- Fulfill Check Insufficiency
	@CacheLookup
	@FindBy(how = How.XPATH, using = "//select[@id='user_current_role']")
	WebElement selectUserRoleDocsTL;

	@CacheLookup
	@FindBy(how = How.XPATH, using = "//h4[contains(text(),'Notification Alerts')]")
	WebElement verifyNotificationAlerts;

	@CacheLookup
	@FindBy(how = How.XPATH, using = "//input[@id='complete_search_no']")
	WebElement txtEnterArsNumber;

	@CacheLookup
	@FindBy(how = How.XPATH, using = "//button[@id='complete_search']")
	WebElement clickOnArsNoSearchBtn;

	@CacheLookup
	@FindBy(how = How.XPATH, using = "/html[1]/body[1]/div[1]/div[2]/div[2]/div[2]/form[1]/table[1]/tbody[1]/tr[1]/td[5]/a[1]")
	WebElement clickOnInsuffArsNumber;

	@CacheLookup
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Current Address Verification')]")
	WebElement clickOnCurrentAddressVerificationCheck;

	// Verify Check Status Insufficient Text
	@CacheLookup
	@FindBy(how = How.XPATH, using = "//td[contains(text(),'Insufficient')]")
	WebElement verifyCheckStatusInsufficientText;

	@CacheLookup
	@FindBy(how = How.XPATH, using = "//select[@id='CaseCheckVERIFIERACTION']")
	WebElement selectFulfillCheckInsufficiency;// Fulfill Check Insufficiency

	// Fulfill Check Level Insufficiency
	@CacheLookup
	@FindBy(how = How.XPATH, using = "//textarea[@id='insuff_comment']")
	WebElement txtInsuffFulfillComments;

	@CacheLookup
	@FindBy(how = How.XPATH, using = "//input[@id='insuff_statusCompleteFulfillInsuff']")
	WebElement checkStatusYesRadioBtn;

	// Attach Insuff Fulfill Documents
	@CacheLookup
	@FindBy(how = How.XPATH, using = "//select[@id='document_id']")
	WebElement selectDocumentTypeCategory;// Address Proof

	@CacheLookup
	@FindBy(how = How.XPATH, using = "//input[@id='btnAddFiles']")
	WebElement clickOnAddFilesBtn;// Upload doc

	@CacheLookup
	@FindBy(how = How.XPATH, using = "/html[1]/body[1]/div[1]/div[2]/div[1]/div[2]/form[1]/table[2]/thead[1]/tr[3]/td[1]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[6]/button[1]/span[1]")
	WebElement clickOnUploadStartBtn;

	@CacheLookup
	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Address Proof')]")
	WebElement verifyAddressProofText;

	@CacheLookup
	@FindBy(how = How.XPATH, using = "//select[@id='CaseCheckDOCUMENTSOURCE']")
	WebElement selectSourceOfVerification;// Email

	@CacheLookup
	@FindBy(how = How.XPATH, using = "//textarea[@id='CaseCheckPROOFCOMMENT']")
	WebElement txtProofsComments;

	@CacheLookup
	@FindBy(how = How.XPATH, using = "//input[@id='submit_btn_attach_proof']")
	WebElement clickOnFulfillInsuffBtn;

	// Check insufficiency is successfully fulfilled. Insuff Fulfill Documents are
	// successfully added with the Check.
	@CacheLookup
	@FindBy(how = How.XPATH, using = "/html[1]/body[1]/div[1]/div[2]/div[1]")
	WebElement verifyCheckInsuffSuccessfullyFulfilled;

	// Admin Approver
	@FindBy(xpath = "/html[1]/body[1]/div[1]/table[1]/tbody[1]/tr[1]/td[3]/table[1]/tbody[1]/tr[2]/td[1]/select[1]")
	@CacheLookup
	WebElement selectAdminApproverRole;

	@FindBy(xpath = "//input[@id='search']")
	@CacheLookup
	WebElement txtAdminArsNoSearch;

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[3]/table[1]/tbody[1]/tr[1]/td[2]/form[1]/input[2]")
	@CacheLookup
	WebElement clickOnAdminSearchBtn;

	@FindBy(xpath = "//td[contains(text(),'British Telecom')]")
	@CacheLookup
	WebElement verifyBTClientName;

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[3]/form[1]/table[1]/tbody[1]/tr[4]/td[7]/a[1]")
	@CacheLookup
	WebElement clickOnBTArsNumber;

	// Documents Received : Address Proof
	@CacheLookup
	@FindBy(how = How.XPATH, using = "/html[1]/body[1]/div[1]/div[3]/table[1]/tbody[1]/tr[1]/td[2]/table[1]/tbody[1]/tr[6]/td[2]/a[1]")
	WebElement verifyDocumentsReceivedAddressProof;

	// Before Insuff Fullfil Count Number
	@CacheLookup
	@FindBy(how = How.XPATH, using = "/html[1]/body[1]/div[1]/div[3]/table[1]/tbody[1]/tr[6]/td[5]/a[1]")
	WebElement getBeforeInsuffFullfilCountNo;

	// After Insuff Fullfil Count Number
	@CacheLookup
	@FindBy(how = How.XPATH, using = "/html[1]/body[1]/div[1]/div[3]/table[1]/tbody[1]/tr[6]/td[5]/a[1]")
	WebElement getAfterInsuffFullfilCountNo;

	// Check Insufficiency Fulfilled
	@CacheLookup
	@FindBy(how = How.XPATH, using = "//td[contains(text(),'Check Insufficiency Fulfilled')]")
	WebElement verifyCheckInsufficiencyFulfilled;

	// Click On Dashboard Module
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[1]/ul[1]/li[3]/a[1]")
	@CacheLookup
	WebElement clickOnDashboardModule;

	// Admin Approve Mapping- Insuff Fullfill
	@FindBy(xpath = "/html[1]/body[1]/div[1]/table[1]/tbody[1]/tr[1]/td[3]/table[1]/tbody[1]/tr[2]/td[1]/select[1]")
	@CacheLookup
	WebElement selectAllocatorRole;// Allocator

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[3]/table[1]/tbody[1]/tr[6]/td[5]/a[1]")
	@CacheLookup
	WebElement clickOnInsuffFullfillCount;

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[3]/form[1]/table[1]/tbody[1]/tr[20]/td[1]/input[2]")
	@CacheLookup
	WebElement clickOnApproveMappingBtn;

	// Clicked on Approval Mapping Module
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/ul[1]/li[1]/a[1]/span[1]")
	@CacheLookup
	WebElement clickOnApproveMappingModule;

	// Actions Summary-- Approver
	@FindBy(xpath = "/html[1]/body[1]/div[1]/table[1]/tbody[1]/tr[1]/td[3]/table[1]/tbody[1]/tr[2]/td[1]/select[1]")
	@CacheLookup
	WebElement selectAdminRoleApprover;// Approver

	@FindBy(xpath = "//input[@id='search']")
	@CacheLookup
	WebElement txtSearchArsNumber;

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[3]/table[1]/tbody[1]/tr[1]/td[2]/form[1]/input[2]")
	@CacheLookup
	WebElement clickOnArsSearchButton;

	// Summary Of Checks
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[3]/form[1]/table[1]/tbody[1]/tr[3]/td[1]/input[1]")
	@CacheLookup
	WebElement verifyCheckBox;

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[3]/form[1]/table[1]/tbody[1]/tr[3]/td[1]/input[1]")
	@CacheLookup
	WebElement clickOnAllCheckBoxRadio;

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[3]/form[1]/table[1]/tbody[1]/tr[5]/td[7]/a[1]")
	@CacheLookup
	WebElement clickOnCompletedArsNumber;

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[3]/table[1]/tbody[1]/tr[1]/td[2]/table[1]/tbody[1]/tr[19]/td[1]/select[1]")
	@CacheLookup
	WebElement selectReleaseForReport;// Release for Report

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[3]/table[1]/tbody[1]/tr[1]/td[2]/table[1]/tbody[1]/tr[9]/td[1]/div[1]/div[1]/span[1]/img[1]")
	@CacheLookup
	WebElement clickOnSelectDocumentsCrossBtn;

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[3]/table[1]/tbody[1]/tr[1]/td[2]/table[1]/tbody[1]/tr[19]/td[1]/input[18]")
	@CacheLookup
	WebElement clickOnReleaseForReportGoBtn;

	// Home Module
	@FindBy(xpath = "//span[contains(text(),'Home')]")
	@CacheLookup
	WebElement clickOnHomeModuleApprover;

	@FindBy(xpath = "//input[@id='search']")
	@CacheLookup
	WebElement txtSearchHomeArsNumber;

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[3]/table[1]/tbody[1]/tr[1]/td[2]/form[1]/input[2]")
	@CacheLookup
	WebElement clickOnSearchButton;

	// Verify Completed Text
	@FindBy(xpath = "//td[contains(text(),'Completed')]")
	@CacheLookup
	WebElement verifyCompletedText;

	// Vendor -- Raise Insuff
	public void vendorRaiseInsuff() throws InterruptedException {
		JavaScriptManuplator.javaScriptExecutor(clickOnRaiseInsuffBtn, "arguments[0].scrollIntoView(true);", ldriver);
		JavaScriptManuplator.waitForElementPresent(ldriver, clickOnRaiseInsuffBtn, 120);
		JavaScriptManuplator.javaScriptExecutor(clickOnRaiseInsuffBtn, "arguments[0].click()", ldriver);
		// Document Insufficient for Verification
		/*
		 * JavaScriptManuplator.waitForElementPresent(ldriver, selectInsuffReason, 120);
		 * JavaScriptManuplator.selectOptionFromDropDown(selectInsuffReason,
		 * "Address Incomplete");
		 * JavaScriptManuplator.javaScriptExecutor(txtVendorInsuffRemarks,
		 * "arguments[0].value='Address Insufficient for Verification'", ldriver);
		 * JavaScriptManuplator.javaScriptExecutor(clickOnMarkCheckAsInsufficientBtn,
		 * "arguments[0].click()", ldriver); Thread.sleep(3000);
		 */

		// Document Insufficient for Verification-- Left Job
		JavaScriptManuplator.waitForElementPresent(ldriver, selectInsuffReasonJob, 120);
		JavaScriptManuplator.selectOptionFromDropDown(selectInsuffReasonJob, "Left the Job");
		JavaScriptManuplator.javaScriptExecutor(clickOnMarkCheckAsInsuffBtn, "arguments[0].click()", ldriver);
		Thread.sleep(3000);
	}

	// Admin-- Admin Approver TL
	public String getBeforeInsuffRaiseCountNo() throws InterruptedException {
		JavaScriptManuplator.waitForElementPresent(ldriver, selectApproverTL, 120);
		JavaScriptManuplator.selectOptionFromDropDown(selectApproverTL, "Approver TL");
		Thread.sleep(3000);
		return getBeforeInsuffRaiseCount.getText();
	}

	public void raiseInsuffAllocate() throws InterruptedException {
		JavaScriptManuplator.waitForElementPresent(ldriver, clickOnBeforeInsuffRaiseCount, 120);
		JavaScriptManuplator.javaScriptExecutor(clickOnBeforeInsuffRaiseCount, "arguments[0].click()", ldriver);
		// Summary Of Checks-- Allocate
		JavaScriptManuplator.waitForElementPresent(ldriver, clickOnAllCheckBox, 120);
		JavaScriptManuplator.javaScriptExecutor(clickOnAllCheckBox, "arguments[0].click()", ldriver);
		Thread.sleep(1000);
		JavaScriptManuplator.selectOptionFromDropDown(selectApproverName, "Ajay Sahoo VB");
		JavaScriptManuplator.javaScriptExecutor(clickOnAllocateBtn, "arguments[0].click()", ldriver);
		Thread.sleep(3000);
		JavaScriptManuplator.javaScriptExecutor(clickOnHomeName, "arguments[0].click()", ldriver);
		Thread.sleep(1000);
	}

	// Home Module
	public String verifyVendorInsuffCount() throws InterruptedException {
		JavaScriptManuplator.waitForElementPresent(ldriver, verifyCasesWithApprover, 120);
		return getAfterVendorInsuffCount.getText();
	}

	// Admin Approver
	public void adminRoleApprover(String arsNumber, String homeArsNumber) throws InterruptedException {
		JavaScriptManuplator.waitForElementPresent(ldriver, selectAdminApprover, 120);
		JavaScriptManuplator.selectOptionFromDropDown(selectAdminApprover, "Approver");
		txtArsNoSearch.sendKeys(arsNumber);
		Thread.sleep(3000);
		JavaScriptManuplator.javaScriptExecutor(clickOnSearchBtn, "arguments[0].click()", ldriver);
		JavaScriptManuplator.waitForElementPresent(ldriver, verifyClientName, 120);
		Thread.sleep(2000);
		JavaScriptManuplator.javaScriptExecutor(clickOnArsNumber, "arguments[0].click()", ldriver);

		// Disposition
		JavaScriptManuplator.javaScriptExecutor(clickOnDispositionRadioBtn, "arguments[0].scrollIntoView(true);",
				ldriver);
		JavaScriptManuplator.javaScriptExecutor(clickOnDispositionRadioBtn, "arguments[0].click()", ldriver);
		// Verified Via
		JavaScriptManuplator.javaScriptExecutor(selectVerifiedVia, "arguments[0].scrollIntoView(true);", ldriver);
		JavaScriptManuplator.selectOptionFromDropDown(selectVerifiedVia, "Email");
		Thread.sleep(2000);
		// Closure Comments
		JavaScriptManuplator.javaScriptExecutor(clickOnClosureCommentsRadioBtn, "arguments[0].click()", ldriver);
		Thread.sleep(2000);
		JavaScriptManuplator.javaScriptExecutor(checkSubjectIsResidingRadioBtn, "arguments[0].click()", ldriver);

		// Antecedents to Verify
		JavaScriptManuplator.javaScriptExecutor(clickOnSaveDeatilsBtn, "arguments[0].scrollIntoView(true);", ldriver);
		JavaScriptManuplator.javaScriptExecutor(checkCopyStatedCheckBox, "arguments[0].click()", ldriver);
		JavaScriptManuplator.javaScriptExecutor(txtAnyOtherComment, "arguments[0].value='Good Comments'", ldriver);
		JavaScriptManuplator.javaScriptExecutor(txtGateColorName, "arguments[0].value='Black'", ldriver);
		JavaScriptManuplator.javaScriptExecutor(txtColorOfBulding, "arguments[0].value='White'", ldriver);
		JavaScriptManuplator.javaScriptExecutor(txtNameOfFieldExecutiveName, "arguments[0].value='Rajeev Kumar'",
				ldriver);
		JavaScriptManuplator.javaScriptExecutor(txtNewAddressDetailsObtainedName, "arguments[0].value='Gurgaow'",
				ldriver);
		JavaScriptManuplator.javaScriptExecutor(txtDurationOfStayName, "arguments[0].value='Test'", ldriver);
		JavaScriptManuplator.selectOptionFromDropDown(selectResidenceTypeName, "Not Applicable");
		JavaScriptManuplator.javaScriptExecutor(txtVerifiedFormName, "arguments[0].value='Aman Kumar'", ldriver);
		JavaScriptManuplator.javaScriptExecutor(txtRelationshipWithCandidateName, "arguments[0].value='Brother'",
				ldriver);
		JavaScriptManuplator.selectOptionFromDropDown(selectVerificationTypeName, "Not Applicable");
		JavaScriptManuplator.javaScriptExecutor(txtDateOfVerificationName, "arguments[0].removeAttribute('readonly')",
				ldriver);
		Thread.sleep(2000);
		JavaScriptManuplator.javaScriptExecutor(txtDateOfVerificationName, "arguments[0].value='10/10/2021'", ldriver);
		JavaScriptManuplator.javaScriptExecutor(txtTimeOfVerificationName, "arguments[0].value='12PM'", ldriver);
		Thread.sleep(2000);
		JavaScriptManuplator.javaScriptExecutor(clickOnSaveDeatilsBtn, "arguments[0].click()", ldriver);
		Thread.sleep(2000);
		JavaScriptManuplator.javaScriptExecutor(txtGPSCoordinates, "arguments[0].scrollIntoView(true);", ldriver);
		JavaScriptManuplator.waitForElementPresent(ldriver, txtGPSCoordinates, 120);
		JavaScriptManuplator.javaScriptExecutor(txtGPSCoordinates, "arguments[0].value='TestGps'", ldriver);

		// Accept Insuff -- Insufficient
		JavaScriptManuplator.selectOptionFromDropDown(selectActionName, "Accept Insuff");
		Thread.sleep(2000);
		JavaScriptManuplator.javaScriptExecutor(clickOnAcceptInsuffGoBtn, "arguments[0].click()", ldriver);
		Thread.sleep(3000);

		// Document Insufficient for Verification
		JavaScriptManuplator.javaScriptExecutor(txtDocumentInsuffForVerification, "arguments[0].scrollIntoView(true);",
				ldriver);
		JavaScriptManuplator.waitForElementPresent(ldriver, txtDocumentInsuffForVerification, 120);
		Thread.sleep(2000);
		JavaScriptManuplator.javaScriptExecutor(txtDocumentInsuffForVerification,
				"arguments[0].value='Document Insufficient for Verification'", ldriver);
		JavaScriptManuplator.javaScriptExecutor(clickOnMarkAsInsufficient, "arguments[0].click()", ldriver);
		Thread.sleep(1000);

		// Admin Home Module
		JavaScriptManuplator.waitForElementPresent(ldriver, clickOnHomeModule, 120);
		JavaScriptManuplator.javaScriptExecutor(clickOnHomeModule, "arguments[0].click()", ldriver);
		txtHomeArsNoSearch.sendKeys(homeArsNumber);
		Thread.sleep(2000);
		JavaScriptManuplator.javaScriptExecutor(clickOnHomeSearchBtn, "arguments[0].click()", ldriver);
		Thread.sleep(1000);
	}

	// Check Status -- Insufficient
	public String verifyCheckStatusInsufficientText() {
		JavaScriptManuplator.waitForElementPresent(ldriver, clickOnHomeModule, 120);
		return verifyCheckStatusInsufficient.getText();
	}

	// Verify Check Status Summary Insufficient on Bridge Portal
	public void superCheckStatusSummaryInsufficiency(String enterArsNo) throws InterruptedException {
		wait = new WebDriverWait(ldriver, 120);
		wait.until(ExpectedConditions.visibilityOf(selectUserRoleDocsTL));
		JavaScriptManuplator.selectOptionFromDropDown(selectUserRoleDocsTL, "Docs TL");
		Thread.sleep(3000);
		clickOnDashboardModule.click();
		wait = new WebDriverWait(ldriver, 240);
		wait.until(ExpectedConditions.visibilityOf(verifyNotificationAlerts));
		txtEnterArsNumber.sendKeys(enterArsNo);
		clickOnArsNoSearchBtn.click();
		wait = new WebDriverWait(ldriver, 120);
		wait.until(ExpectedConditions.visibilityOf(clickOnInsuffArsNumber));
		clickOnInsuffArsNumber.click();
		Thread.sleep(1000);
		// Bridge-- Checks Summary
		JavaScriptManuplator.javaScriptExecutor(verifyCheckStatusInsufficientText, "arguments[0].scrollIntoView(true);",
				ldriver);
	}

	// Verify Bridge Check Status Insufficient
	public String verifyBridgeCheckStatusInsufficient() {
		wait = new WebDriverWait(ldriver, 120);
		wait.until(ExpectedConditions.visibilityOf(verifyCheckStatusInsufficientText));
		return verifyCheckStatusInsufficientText.getText();
	}

	// Bridge-- Fulfill Check Insufficiency
	public void superAdminFulfillCheckInsufficiency(String addressProof) throws InterruptedException {
		wait = new WebDriverWait(ldriver, 120);
		wait.until(ExpectedConditions.visibilityOf(clickOnCurrentAddressVerificationCheck));
		// Bridge-- Fulfill Check Insufficiency
		JavaScriptManuplator.javaScriptExecutor(clickOnCurrentAddressVerificationCheck,
				"arguments[0].scrollIntoView(true);", ldriver);
		JavaScriptManuplator.javaScriptExecutor(clickOnCurrentAddressVerificationCheck, "arguments[0].click()",
				ldriver);
		JavaScriptManuplator.javaScriptExecutor(selectFulfillCheckInsufficiency, "arguments[0].scrollIntoView(true);",
				ldriver);
		JavaScriptManuplator.waitForElementPresent(ldriver, selectFulfillCheckInsufficiency, 120);
		JavaScriptManuplator.selectOptionFromDropDown(selectFulfillCheckInsufficiency, "Fulfill Check Insufficiency");

		// Fulfill Check Level Insufficiency
		JavaScriptManuplator.javaScriptExecutor(txtInsuffFulfillComments, "arguments[0].scrollIntoView(true);",
				ldriver);
		wait = new WebDriverWait(ldriver, 120);
		wait.until(ExpectedConditions.visibilityOf(txtInsuffFulfillComments));
		JavaScriptManuplator.javaScriptExecutor(txtInsuffFulfillComments, "arguments[0].value='Good Comments'",
				ldriver);
		JavaScriptManuplator.javaScriptExecutor(checkStatusYesRadioBtn, "arguments[0].click()", ldriver);

		// Attach Insuff Fulfill Documents
		JavaScriptManuplator.selectOptionFromDropDown(selectDocumentTypeCategory, "Address Proof");
		Thread.sleep(2000);
		clickOnAddFilesBtn.sendKeys(addressProof);
		Thread.sleep(3000);
		JavaScriptManuplator.javaScriptExecutor(clickOnUploadStartBtn, "arguments[0].click()", ldriver);
		wait = new WebDriverWait(ldriver, 180);
		wait.until(ExpectedConditions.visibilityOf(verifyAddressProofText));
		JavaScriptManuplator.selectOptionFromDropDown(selectSourceOfVerification, "Email");
		JavaScriptManuplator.javaScriptExecutor(txtProofsComments, "arguments[0].value='Good Comments'", ldriver);
		JavaScriptManuplator.javaScriptExecutor(clickOnFulfillInsuffBtn, "arguments[0].click()", ldriver);
		Thread.sleep(1000);
	}

	// Check insufficiency is successfully fulfilled. Insuff Fulfill Documents are
	// successfully added with the Check.
	public String verifyCheckInsuffSuccessFulfilled() {
		wait = new WebDriverWait(ldriver, 180);
		wait.until(ExpectedConditions.visibilityOf(verifyCheckInsuffSuccessfullyFulfilled));
		return verifyCheckInsuffSuccessfullyFulfilled.getText();
	}

	// Admin Approver-- Documents Received : Address Proof
	public void documentsReceivedAddressProof(String enterArsNo) throws InterruptedException {
		wait = new WebDriverWait(ldriver, 180);
		wait.until(ExpectedConditions.visibilityOf(selectAdminApproverRole));
		JavaScriptManuplator.selectOptionFromDropDown(selectAdminApproverRole, "Approver");
		txtAdminArsNoSearch.sendKeys(enterArsNo);
		Thread.sleep(2000);
		clickOnAdminSearchBtn.click();
		JavaScriptManuplator.waitForElementPresent(ldriver, verifyBTClientName, 120);
		Thread.sleep(2000);
		JavaScriptManuplator.javaScriptExecutor(clickOnBTArsNumber, "arguments[0].click()", ldriver);

		// Check Insufficiency Fulfilled
		wait = new WebDriverWait(ldriver, 180);
		wait.until(ExpectedConditions.visibilityOf(verifyCheckInsufficiencyFulfilled));
	}

	public void insuffFullfilBucketCountNo() {
		wait = new WebDriverWait(ldriver, 180);
		wait.until(ExpectedConditions.visibilityOf(selectAllocatorRole));
		JavaScriptManuplator.selectOptionFromDropDown(selectAllocatorRole, "Allocator");
	}

	// Get Before Insuff Fullfill count number
	public String verifygetBeforeInsuffFullfilCountNo() {
		wait = new WebDriverWait(ldriver, 180);
		wait.until(ExpectedConditions.visibilityOf(getBeforeInsuffFullfilCountNo));
		return getBeforeInsuffFullfilCountNo.getText();
	}

	// Documents Received : Address Proof
	public String verifyDocumentsReceivedText() {
		wait = new WebDriverWait(ldriver, 180);
		wait.until(ExpectedConditions.visibilityOf(verifyDocumentsReceivedAddressProof));
		return verifyDocumentsReceivedAddressProof.getText();
	}

	// Get After Insuff Fullfil Count Number
	public String verifygetAfterInsuffFullfilCountNo() {
		wait = new WebDriverWait(ldriver, 180);
		wait.until(ExpectedConditions.visibilityOf(getAfterInsuffFullfilCountNo));
		return getAfterInsuffFullfilCountNo.getText();
	}

	// Admin Approve Mapping- Insuff Fullfill
	public void insuffFullfillBucketCount() throws InterruptedException {
		wait = new WebDriverWait(ldriver, 180);
		wait.until(ExpectedConditions.visibilityOf(selectAllocatorRole));
		// JavaScriptManuplator.selectOptionFromDropDown(selectAllocatorRole,
		// "Allocator");
		// How many rows in table
		int rows = ldriver.findElements(By.xpath("/html[1]/body[1]/div[1]/div[3]/table[1]/tbody[1]/tr")).size();
		// Get Internal Vendor, and clicked on Internal Vendor New Load count number.
		for (int r = 1; r <= rows; r++) {
			String vendorName = ldriver
					.findElement(By.xpath("/html[1]/body[1]/div[1]/div[3]/table[1]/tbody[1]/tr[" + r + "]/td[1]"))
					.getText();
			if (vendorName.equals("Internal Vendor")) {

				WebElement element = ldriver.findElement(
						By.xpath("/html[1]/body[1]/div[1]/div[3]/table[1]/tbody[1]/tr[" + r + "]/td[5]/a[1]"));
				Thread.sleep(2000);
				element.click();
				break;
			}
		}
	}

	public void verifyCheckIdInsuffFullfil() throws IOException, InterruptedException {
		// How many rows in table
		String data = new String(Files.readAllBytes(Paths.get("CaseCheckId.txt")));
		String checkId[] = data.split(" ");
		String id[] = checkId[1].split("=");
		int rows = ldriver.findElements(By.xpath("/html[1]/body[1]/div[1]/div[3]/form[1]/table[1]/tbody[1]/tr")).size();
		// Get Check Id, and select action Update from Drop-down
		for (int r = 1; r <= rows; r++) {
			String addressCheckId = ldriver
					.findElement(
							By.xpath("/html[1]/body[1]/div[1]/div[3]/form[1]/table[1]/tbody[1]/tr[" + r + "]/td[2]"))
					.getText();
			Thread.sleep(2000);
			if (addressCheckId.equals(id[1])) {
				WebElement checkBoxCheck = ldriver.findElement(By.xpath(
						"/html[1]/body[1]/div[1]/div[3]/form[1]/table[1]/tbody[1]/tr[" + r + "]/td[1]/input[1]"));
				Thread.sleep(2000);
				JavaScriptManuplator.javaScriptExecutor(checkBoxCheck, "arguments[0].click()", ldriver);
				Thread.sleep(2000);
				break;
			}
		}
	}

	public void verifyClickOnApprovalMappingBtn() throws InterruptedException {
		// ADD TO QUEUE
		List<WebElement> tag = ldriver.findElements(By.tagName("input"));
		for (int i = 0; i < tag.size(); i++) {
			// System.out.println(tag.get(i).getAttribute("class"));
			if (tag.get(i).getAttribute("class").equals("button2")) {
				// tag.get(i).click();
				JavaScriptManuplator.javaScriptExecutor(tag.get(i), "arguments[0].scrollIntoView(true);", ldriver);
				Thread.sleep(2000);
				JavascriptExecutor executor = (JavascriptExecutor) ldriver;
				executor.executeScript("arguments[0].click();", tag.get(i));
				Thread.sleep(1000);
				break;
			}
		}
	}

	public void clickOnApproveMappingModule() throws InterruptedException {
		wait = new WebDriverWait(ldriver, 180);
		wait.until(ExpectedConditions.visibilityOf(clickOnApproveMappingModule));
		JavaScriptManuplator.javaScriptExecutor(clickOnApproveMappingModule, "arguments[0].click()", ldriver);
	}

	// Actions Summary-- Approver
	public void adminApproverRole(String arsNo, String arsNumber) throws InterruptedException {
		wait = new WebDriverWait(ldriver, 180);
		wait.until(ExpectedConditions.visibilityOf(selectAdminRoleApprover));
		JavaScriptManuplator.selectOptionFromDropDown(selectAdminRoleApprover, "Approver");
		txtSearchArsNumber.sendKeys(arsNo);
		JavaScriptManuplator.javaScriptExecutor(clickOnArsSearchButton, "arguments[0].click()", ldriver);
		JavaScriptManuplator.javaScriptExecutor(verifyCheckBox, "arguments[0].scrollIntoView(true);", ldriver);
		JavaScriptManuplator.javaScriptExecutor(clickOnAllCheckBoxRadio, "arguments[0].click()", ldriver);
		Thread.sleep(3000);
		JavaScriptManuplator.javaScriptExecutor(clickOnCompletedArsNumber, "arguments[0].click()", ldriver);
		JavaScriptManuplator.javaScriptExecutor(selectReleaseForReport, "arguments[0].scrollIntoView(true);", ldriver);
		wait = new WebDriverWait(ldriver, 180);
		wait.until(ExpectedConditions.visibilityOf(selectReleaseForReport));
		JavaScriptManuplator.selectOptionFromDropDown(selectReleaseForReport, "Release for Report");
		Thread.sleep(3000);
		JavaScriptManuplator.javaScriptExecutor(clickOnSelectDocumentsCrossBtn, "arguments[0].click()", ldriver);
		Thread.sleep(3000);
		JavaScriptManuplator.javaScriptExecutor(clickOnReleaseForReportGoBtn, "arguments[0].click()", ldriver);

		// Home Module
		wait = new WebDriverWait(ldriver, 180);
		wait.until(ExpectedConditions.visibilityOf(clickOnHomeModuleApprover));
		JavaScriptManuplator.javaScriptExecutor(clickOnHomeModuleApprover, "arguments[0].click()", ldriver);
		txtSearchHomeArsNumber.sendKeys(arsNumber);
		Thread.sleep(1000);
		JavaScriptManuplator.javaScriptExecutor(clickOnSearchButton, "arguments[0].click()", ldriver);
		Thread.sleep(1000);
	}

	// Verify Completed Text
	public String verifyCheckCompletedText() {
		wait = new WebDriverWait(ldriver, 180);
		wait.until(ExpectedConditions.visibilityOf(verifyCompletedText));
		return verifyCompletedText.getText();
	}
}
