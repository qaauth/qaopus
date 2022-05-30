package com.opus.pageobject;

import java.awt.Robot;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.opus.utilities.JavaScriptManuplator;

public class OpusApproveMapping {
	WebDriver ldriver;
	WebDriverWait wait;
	JavascriptExecutor js;
	Robot rbt;

	public OpusApproveMapping(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(ldriver, this);
	}

	// Approve Mapping
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/ul[1]/li[1]/a[1]/span[1]")
	@CacheLookup
	WebElement clickOnApproveMapping;

	@FindBy(xpath = "//td[contains(text(),'Vendor Name')]")
	@CacheLookup
	WebElement verifyVendorName;

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[3]/form[1]/table[1]/tbody[1]/tr[1]/td[1]/input[1]")
	@CacheLookup
	WebElement checkAllCaseCheckIdCheckBox;

	@FindBy(xpath = "//input[@name='aprove']")
	@CacheLookup
	WebElement clickOnApproveMappingBtn;

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/ul[1]/li[1]/a[1]/span[1]")
	@CacheLookup
	WebElement clickOnAgainApproveMapping;

	// Opus Vendor Login-- Address Checks
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/ul[1]/li[1]/a[1]/span[1]")
	@CacheLookup
	WebElement clickOnAddressChecks;

	// Current Workload
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[3]/table[1]/tbody[1]/tr[2]/td[4]/a[1]")
	@CacheLookup
	WebElement clickOnNewLoadCountNo;

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[5]/form[1]/table[1]/tbody[1]/tr[1]/td[1]/select[1]")
	@CacheLookup
	WebElement selectFieldExecutiveName;// Vishakha Rana ( Normal )

	@FindBy(xpath = "//input[@id='selectAll']")
	@CacheLookup
	WebElement checkAllCheckboxOfCheckId;

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[5]/form[1]/table[1]/tbody[1]/tr[1]/td[1]/input[1]")
	@CacheLookup
	WebElement clickOnAcceptAssignBtn;

	// Address Checks(0)-- Current Load
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/ul[1]/li[1]/a[1]/span[1]")
	@CacheLookup
	WebElement clickOnAddressChecksCountNo;

	// Current Load Count-- Address Check
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[3]/table[1]/tbody[1]/tr[5]/td[4]/a[1]")
	@CacheLookup
	WebElement getOldCurrentNewCount;

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[3]/table[1]/tbody[1]/tr[5]/td[4]/a[1]")
	@CacheLookup
	WebElement clickOnCurrentLoadCountNo;

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[5]/form[1]/table[2]/tbody[1]/tr[1]/td[4]/select[1]")
	@CacheLookup
	WebElement selectExecutiveAddressCheck;// Vishakha Rana ( Normal )

	// Current Address Verification -- Summary of Case
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[3]/table[1]/tbody[1]/tr[1]/td[2]/table[1]/tbody[1]/tr[9]/td[2]/table[1]/tbody[1]/tr[1]/td[1]/input[1]")
	@CacheLookup
	WebElement clickSelectDispositionsRadioBtn;

	// Antecedents to Verify
	@FindBy(xpath = "//input[@name='checkbox']")
	@CacheLookup
	WebElement checkCopyStated;

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[3]/table[1]/tbody[1]/tr[1]/td[2]/table[1]/tbody[1]/tr[11]/td[1]/table[1]/tbody[1]/tr[3]/td[3]/select[1]")
	@CacheLookup
	WebElement selectVerificationType;// Not Applicable

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[3]/table[1]/tbody[1]/tr[1]/td[2]/table[1]/tbody[1]/tr[11]/td[1]/table[1]/tbody[1]/tr[4]/td[3]/textarea[1]")
	@CacheLookup
	WebElement txtVerifiedType;

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[3]/table[1]/tbody[1]/tr[1]/td[2]/table[1]/tbody[1]/tr[11]/td[1]/table[1]/tbody[1]/tr[5]/td[3]/textarea[1]")
	@CacheLookup
	WebElement txtRelationshipWithCandidate;

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[3]/table[1]/tbody[1]/tr[1]/td[2]/table[1]/tbody[1]/tr[11]/td[1]/table[1]/tbody[1]/tr[6]/td[3]/textarea[1]")
	@CacheLookup
	WebElement txtDurationOfStay;

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[3]/table[1]/tbody[1]/tr[1]/td[2]/table[1]/tbody[1]/tr[11]/td[1]/table[1]/tbody[1]/tr[7]/td[3]/input[1]")
	@CacheLookup
	WebElement txtDateOfVerification;// 06/10/2021 readonly

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[3]/table[1]/tbody[1]/tr[1]/td[2]/table[1]/tbody[1]/tr[11]/td[1]/table[1]/tbody[1]/tr[8]/td[3]/textarea[1]")
	@CacheLookup
	WebElement txtAnyOtherComments;

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[3]/table[1]/tbody[1]/tr[1]/td[2]/table[1]/tbody[1]/tr[11]/td[1]/table[1]/tbody[1]/tr[10]/td[3]/input[1]")
	@CacheLookup
	WebElement txtNameOfFieldExecutive;

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[3]/table[1]/tbody[1]/tr[1]/td[2]/table[1]/tbody[1]/tr[11]/td[1]/table[1]/tbody[1]/tr[11]/td[3]/input[1]")
	@CacheLookup
	WebElement txtTimeOfVerification;

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[3]/table[1]/tbody[1]/tr[1]/td[2]/table[1]/tbody[1]/tr[11]/td[1]/table[1]/tbody[1]/tr[12]/td[3]/input[1]")
	@CacheLookup
	WebElement txtGateColor;

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[3]/table[1]/tbody[1]/tr[1]/td[2]/table[1]/tbody[1]/tr[11]/td[1]/table[1]/tbody[1]/tr[13]/td[3]/input[1]")
	@CacheLookup
	WebElement txtColorOfBuilding;

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[3]/table[1]/tbody[1]/tr[1]/td[2]/table[1]/tbody[1]/tr[11]/td[1]/table[1]/tbody[1]/tr[15]/td[3]/textarea[1]")
	@CacheLookup
	WebElement txtNewAddressDetailsObtained;

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[3]/table[1]/tbody[1]/tr[1]/td[2]/table[1]/tbody[1]/tr[11]/td[1]/table[1]/tbody[1]/tr[16]/td[3]/select[1]")
	@CacheLookup
	WebElement selectResidenceType;// Not Applicable

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[3]/table[1]/tbody[1]/tr[1]/td[2]/table[1]/tbody[1]/tr[12]/td[1]/p[1]/input[1]")
	@CacheLookup
	WebElement txtGPSCoordinates;

	@FindBy(xpath = "//input[@name='save_details']")
	@CacheLookup
	WebElement clickOnSaveDetails;

	// Sure! you want to save these details.?? //ACCEPT OK ALERT
	// Send Response
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[5]/form[1]/table[2]/tbody[2]/tr[10]/td[14]/input[1]")
	@CacheLookup
	WebElement clickOnSendResponseBtn;

	// Response sent successfully.
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[5]/div[1]")
	@CacheLookup
	WebElement verifyResponseSentSuccessfully;
	
	// Unassigned Check Summary - Client wise-- Total Checks Count
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[4]/form[1]/table[2]/tbody[1]/tr[6]/td[3]")
	@CacheLookup
	WebElement getBeforeTotalChecksCount;
	
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[4]/form[1]/table[2]/tbody[1]/tr[6]/td[3]")
	@CacheLookup
	WebElement getAfterTotalChecksCount;
	
	// Cases with Approver-- Ajay Sahoo VB TC(0)
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[4]/form[1]/table[1]/tbody[1]/tr[3]/td[2]/table[1]/tbody[1]/tr[2]/td[1]")
	@CacheLookup
	WebElement getBeforeAjaySahooVBTotalCheckCount;
	
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[4]/form[1]/table[1]/tbody[1]/tr[3]/td[2]/table[1]/tbody[1]/tr[2]/td[1]")
	@CacheLookup
	WebElement getAfterAjaySahooVBTotalCheckCount;

	// Admin Approver Tl
	@FindBy(xpath = "/html[1]/body[1]/div[1]/table[1]/tbody[1]/tr[1]/td[3]/table[1]/tbody[1]/tr[2]/td[1]/select[1]")
	@CacheLookup
	WebElement selectApproverTl;

	// Select CheckBox-- Unassigned Check Summary - Client wise
	@FindBy(xpath = "//input[@id='checkAllId']")
	@CacheLookup
	WebElement selectAllCheckBoxButton;

	// Address Family
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[4]/form[1]/table[2]/tbody[1]/tr[4]/td[2]/input[1]")
	@CacheLookup
	WebElement checkAddressFamilyCheckbox;

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[4]/form[1]/table[3]/tbody[1]/tr[1]/td[1]/table[1]/tbody[1]/tr[1]/td[1]/select[1]")
	@CacheLookup
	WebElement selectApproverName;// Ajay Sahoo VB

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[4]/form[1]/table[3]/tbody[1]/tr[1]/td[1]/table[1]/tbody[1]/tr[1]/td[1]/input[1]")
	@CacheLookup
	WebElement clickOnApproverGoBtn;

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

	// Verified Via
	@FindBy(xpath = "//select[@id='VERIFICATION_PROCEDURE']")
	@CacheLookup
	WebElement selectVerifiedVia;// Email

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[3]/table[1]/tbody[1]/tr[1]/td[2]/table[1]/tbody[1]/tr[15]/td[2]/table[1]/tbody[1]/tr[1]/td[1]/input[1]")
	@CacheLookup
	WebElement checkSubjectIsResidingRadioBtn;

	// Antecedents to Verify
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[3]/table[1]/tbody[1]/tr[1]/td[2]/table[1]/tbody[1]/tr[17]/td[1]/table[1]/tbody[1]/tr[1]/td[3]/label[1]/input[1]")
	@CacheLookup
	WebElement checkCopyStatedCheckBox;

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[3]/table[1]/tbody[1]/tr[1]/td[2]/table[1]/tbody[1]/tr[17]/td[1]/table[1]/tbody[1]/tr[2]/td[3]/textarea[1]")
	@CacheLookup
	WebElement txtAnyOtherComment;

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[3]/table[1]/tbody[1]/tr[1]/td[2]/table[1]/tbody[1]/tr[17]/td[1]/table[1]/tbody[1]/tr[3]/td[3]/input[1]")
	@CacheLookup
	WebElement txtGateColorName;

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[3]/table[1]/tbody[1]/tr[1]/td[2]/table[1]/tbody[1]/tr[17]/td[1]/table[1]/tbody[1]/tr[4]/td[3]/input[1]")
	@CacheLookup
	WebElement txtColorOfBulding;

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[3]/table[1]/tbody[1]/tr[1]/td[2]/table[1]/tbody[1]/tr[17]/td[1]/table[1]/tbody[1]/tr[5]/td[3]/input[1]")
	@CacheLookup
	WebElement txtNameOfFieldExecutiveName;

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[3]/table[1]/tbody[1]/tr[1]/td[2]/table[1]/tbody[1]/tr[17]/td[1]/table[1]/tbody[1]/tr[6]/td[3]/textarea[1]")
	@CacheLookup
	WebElement txtNewAddressDetailsObtainedName;

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[3]/table[1]/tbody[1]/tr[1]/td[2]/table[1]/tbody[1]/tr[17]/td[1]/table[1]/tbody[1]/tr[10]/td[3]/textarea[1]")
	@CacheLookup
	WebElement txtDurationOfStayName;

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[3]/table[1]/tbody[1]/tr[1]/td[2]/table[1]/tbody[1]/tr[17]/td[1]/table[1]/tbody[1]/tr[11]/td[3]/select[1]")
	@CacheLookup
	WebElement selectResidenceTypeName;// Not Applicable

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[3]/table[1]/tbody[1]/tr[1]/td[2]/table[1]/tbody[1]/tr[17]/td[1]/table[1]/tbody[1]/tr[12]/td[3]/textarea[1]")
	@CacheLookup
	WebElement txtVerifiedFormName;

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[3]/table[1]/tbody[1]/tr[1]/td[2]/table[1]/tbody[1]/tr[17]/td[1]/table[1]/tbody[1]/tr[13]/td[3]/textarea[1]")
	@CacheLookup
	WebElement txtRelationshipWithCandidateName;

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[3]/table[1]/tbody[1]/tr[1]/td[2]/table[1]/tbody[1]/tr[17]/td[1]/table[1]/tbody[1]/tr[14]/td[3]/select[1]")
	@CacheLookup
	WebElement selectVerificationTypeName;// Not Applicable

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[3]/table[1]/tbody[1]/tr[1]/td[2]/table[1]/tbody[1]/tr[17]/td[1]/table[1]/tbody[1]/tr[15]/td[3]/input[1]")
	@CacheLookup
	WebElement txtDateOfVerificationName;// 10/10/2021

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[3]/table[1]/tbody[1]/tr[1]/td[2]/table[1]/tbody[1]/tr[17]/td[1]/table[1]/tbody[1]/tr[16]/td[3]/input[1]")
	@CacheLookup
	WebElement txtTimeOfVerificationName;

	// Overseas Country
	@FindBy(xpath = "//select[@id='VER_OVERSEAS_DROPDOWN_ID']")
	@CacheLookup
	WebElement selectOverseasCountry;//India
	
	@FindBy(xpath = "//input[@name='save_details']")
	@CacheLookup
	WebElement clickOnSaveDeatilsBtn;

	// Release for Report
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[3]/table[1]/tbody[1]/tr[1]/td[2]/table[1]/tbody[1]/tr[20]/td[1]/select[1]")
	@CacheLookup
	WebElement selectActionName;// Release for Report

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[3]/table[1]/tbody[1]/tr[1]/td[2]/table[1]/tbody[1]/tr[20]/td[1]/input[18]")
	@CacheLookup
	WebElement clickOnReleaseForReportGoBtn;

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

	// Check Status -- Completed
	@FindBy(xpath = "//td[contains(text(),'Completed')]")
	@CacheLookup
	WebElement verifyCheckStatusCompleted;

	// Verification Quality Allocator--
	@CacheLookup
	@FindBy(how = How.XPATH, using = "//select[@id='user_current_role']")
	WebElement selectUserRoleVerificationQualityAllocator;

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
	@FindBy(how = How.XPATH, using = "/html/body/div[1]/div[2]/div[2]/div[2]/form/table/tbody/tr/td[11]/a")
	WebElement clickOnVerifiedCountNumber;
	
	@CacheLookup
	@FindBy(how = How.XPATH, using = "/html[1]/body[1]/div[1]/div[2]/div[2]/div[2]/form[1]/table[1]/tbody[1]/tr[1]/td[10]/a[1]")
	WebElement clickOnApplicableCountNo;


	// Check List - Search Result - (14 records)
	@CacheLookup
	@FindBy(how = How.XPATH, using = "/html[1]/body[1]/div[1]/div[2]/div[2]/div[2]/form[1]/table[1]/thead[1]/tr[1]/th[1]/input[2]")
	WebElement checkOnCheckBoxCheckListAll;

	@CacheLookup
	@FindBy(how = How.XPATH, using = "//select[@id='CaseCheckBULKACTIONTAKEN']")
	WebElement selectActionAllocateToVqc;

	@CacheLookup
	@FindBy(how = How.XPATH, using = "//select[@id='ddlChecksAssignedToRelease']")
	WebElement selectTeamMemberName;

	@CacheLookup
	@FindBy(how = How.XPATH, using = "//textarea[@id='check_comments']")
	WebElement txtCheckComments;

	@CacheLookup
	@FindBy(how = How.XPATH, using = "//button[@id='btnGo']")
	WebElement clickOnGoBtn;

	// Verification Quality Allocator Successfully Message--
	@CacheLookup
	@FindBy(how = How.XPATH, using = "/html[1]/body[1]/div[1]/div[2]/div[1]")
	WebElement verifyQualityAllocatorSuccessMsg;

	// Reports Manager -- Search Report
	@CacheLookup
	@FindBy(how = How.XPATH, using = "//select[@id='user_current_role']")
	WebElement selectUserRoleReportsManager;

	@CacheLookup
	@FindBy(how = How.XPATH, using = "//h4[contains(text(),'Notification Alerts - Reports Status')]")
	WebElement verifyNotificationAlertsReportsStatus;

	@CacheLookup
	@FindBy(how = How.XPATH, using = "/html[1]/body[1]/div[1]/div[1]/div[1]/ul[1]/li[6]/a[1]")
	WebElement clickOnReportsManagerReports;

	@CacheLookup
	@FindBy(how = How.XPATH, using = "//input[@id='CaseReportCASEARSNO']")
	WebElement txtArsNumber;

	@CacheLookup
	@FindBy(how = How.XPATH, using = "//button[contains(text(),'Search Report')]")
	WebElement clickOnSearchReportBtn;

	// Report List - Search Result -- Single Window Review Report
	@CacheLookup
	@FindBy(how = How.XPATH, using = "/html[1]/body[1]/div[1]/div[2]/div[2]/div[2]/form[1]/table[1]/tbody[1]/tr[1]/td[14]/select[1]")
	WebElement selectActionWindowReviewReport;

	// Current Address Verification -- Closed by Client
	@CacheLookup
	@FindBy(how = How.XPATH, using = "/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[3]/div[4]/div[2]/form[1]/div[2]/div[2]/div[5]/button[1]")
	WebElement clickOnCurrentAddressVerificationSubmitBtn;

	// Report Review--
	@CacheLookup
	@FindBy(how = How.XPATH, using = "//select[@id='report_severity']")
	WebElement selectReportSeverity;

	@CacheLookup
	@FindBy(how = How.XPATH, using = "//select[@id='standard_comment']")
	WebElement selectStandardComments;

	@CacheLookup
	@FindBy(how = How.XPATH, using = "//button[@id='final_form_btn']")
	WebElement clickOnReportReviewBtn;

	// Report Successfully Reviewed.
	@CacheLookup
	@FindBy(how = How.XPATH, using = "/html[1]/body[1]/div[1]/div[2]/div[1]")
	WebElement verifyReportSuccessReviewedMsg;

	@CacheLookup
	@FindBy(how = How.XPATH, using = "//*[contains(text(),'Report Successfully Reviewed.')]")
	WebElement verifyReportSuccessReviewMsg;

	// Verified --Report Status- Report List - Search Result
	@CacheLookup
	@FindBy(how = How.XPATH, using = "//td[contains(text(),'Final')]")
	WebElement verifyReportStatusVerifiedText;

	// Click On Dashboard Module
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[1]/ul[1]/li[3]/a[1]")
	@CacheLookup
	WebElement clickOnDashboardModule;

	// Get New Load Count
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[3]/table[1]/tbody[1]/tr[7]/td[3]/a[1]")
	@CacheLookup
	WebElement getNewLoadCountNo;

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[3]/table[1]/tbody[1]/tr[6]/td[3]/a[1]")
	@CacheLookup
	WebElement getOldNewLoadCountNo;

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/ul[1]/li[1]/a[1]/span[1]")
	@CacheLookup
	WebElement verifyApproveMappingText;

	public String getNewLoadCountNumber() {
		wait = new WebDriverWait(ldriver, 60);
		wait.until(ExpectedConditions.visibilityOf(clickOnApproveMapping));
		return getNewLoadCountNo.getText();
	}

	// Admin Approve Mapping
	public void adminApproveMapping() throws IOException, InterruptedException {
		JavaScriptManuplator.waitForElementPresent(ldriver, clickOnApproveMapping, 120);
		JavaScriptManuplator.javaScriptExecutor(clickOnApproveMapping, "arguments[0].click()", ldriver);
		JavaScriptManuplator.waitForElementPresent(ldriver, verifyVendorName, 60);
		// How many rows in table
		int rows = ldriver.findElements(By.xpath("/html[1]/body[1]/div[1]/div[3]/table[1]/tbody[1]/tr")).size();
		// Get Internal Vendor, and clicked on Internal Vendor New Load count number.
		for (int r = 1; r <= rows; r++) {
			String vendorName = ldriver
					.findElement(By.xpath("/html[1]/body[1]/div[1]/div[3]/table[1]/tbody[1]/tr[" + r + "]/td[1]"))
					.getText();
			if (vendorName.equals("Internal Vendor")) {

				WebElement element = ldriver.findElement(
						By.xpath("/html[1]/body[1]/div[1]/div[3]/table[1]/tbody[1]/tr[" + r + "]/td[3]/a[1]"));
				Thread.sleep(2000);
				element.click();
				break;
			}
		}
		JavaScriptManuplator.waitForElementPresent(ldriver, checkAllCaseCheckIdCheckBox, 120);
		JavaScriptManuplator.javaScriptExecutor(checkAllCaseCheckIdCheckBox, "arguments[0].click()", ldriver);
		JavaScriptManuplator.javaScriptExecutor(clickOnApproveMappingBtn, "arguments[0].click()", ldriver);
		JavaScriptManuplator.javaScriptExecutor(clickOnAgainApproveMapping, "arguments[0].click()", ldriver);
		Thread.sleep(1000);
	}

	public String getOldNewLoadCountNumber() {
		wait = new WebDriverWait(ldriver, 60);
		wait.until(ExpectedConditions.visibilityOf(verifyApproveMappingText));
		return getOldNewLoadCountNo.getText();
	}

	// Opus Vendor Login-- Address Checks
	public void vendorAddressCheckAcceptAssign() throws InterruptedException {
		wait = new WebDriverWait(ldriver, 120);
		wait.until(ExpectedConditions.visibilityOf(clickOnAddressChecks));
		JavaScriptManuplator.javaScriptExecutor(clickOnAddressChecks, "arguments[0].click()", ldriver);
		// Current Workload
		wait = new WebDriverWait(ldriver, 120);
		wait.until(ExpectedConditions.visibilityOf(clickOnNewLoadCountNo));
		JavaScriptManuplator.javaScriptExecutor(clickOnNewLoadCountNo, "arguments[0].click()", ldriver);
		wait = new WebDriverWait(ldriver, 120);
		wait.until(ExpectedConditions.visibilityOf(selectFieldExecutiveName));
		JavaScriptManuplator.selectOptionFromDropDown(selectFieldExecutiveName, "Vishakha Rana ( Normal )");
		Thread.sleep(1000);
		JavaScriptManuplator.javaScriptExecutor(checkAllCheckboxOfCheckId, "arguments[0].click()", ldriver);
		Thread.sleep(1000);
		JavaScriptManuplator.javaScriptExecutor(clickOnAcceptAssignBtn, "arguments[0].click()", ldriver);
		;
		Thread.sleep(2000);
		// Sure! You want to allocate these checks to `Vishakha Rana` .??
		ldriver.switchTo().alert().accept();
		Thread.sleep(2000);
	}

	public String getOldCurrentLoadCountNumber() {
		JavaScriptManuplator.waitForElementPresent(ldriver, clickOnAddressChecksCountNo, 120);
		JavaScriptManuplator.javaScriptExecutor(clickOnAddressChecksCountNo, "arguments[0].click()", ldriver);
		wait = new WebDriverWait(ldriver, 60);
		wait.until(ExpectedConditions.visibilityOf(getOldCurrentNewCount));
		return getOldCurrentNewCount.getText();
	}

	// Address Checks(0)-- Current Load
	public void vendorAddressCheckUpdate() throws IOException, InterruptedException {
		JavaScriptManuplator.waitForElementPresent(ldriver, clickOnAddressChecksCountNo, 120);
		JavaScriptManuplator.javaScriptExecutor(clickOnAddressChecksCountNo, "arguments[0].click()", ldriver);
		JavaScriptManuplator.waitForElementPresent(ldriver, clickOnCurrentLoadCountNo, 60);
		JavaScriptManuplator.javaScriptExecutor(clickOnCurrentLoadCountNo, "arguments[0].click()", ldriver);
		JavaScriptManuplator.waitForElementPresent(ldriver, selectExecutiveAddressCheck, 60);
		JavaScriptManuplator.selectOptionFromDropDown(selectExecutiveAddressCheck, "Vishakha Rana ( Normal )");
		Thread.sleep(1000);
		// How many rows in table
		String data = new String(Files.readAllBytes(Paths.get("CaseCheckId.txt")));
		String checkId[] = data.split(" ");
		String id[] = checkId[1].split("=");
		System.out.println("Check Id=="+id[1]);
		int rows = ldriver.findElements(By.xpath("/html[1]/body[1]/div[1]/div[5]/form[1]/table[2]/tbody[2]/tr")).size();
		// Get Check Id, and select action Update from Drop-down
		for (int r = 1; r <= rows; r++) {
			String addressCheckId = ldriver
					.findElement(
							By.xpath("/html[1]/body[1]/div[1]/div[5]/form[1]/table[2]/tbody[2]/tr[" + r + "]/td[1]"))
					.getText();
			Thread.sleep(2000);
			if (addressCheckId.equals(id[1])) {

				WebElement element = ldriver.findElement(By.xpath(
						"/html[1]/body[1]/div[1]/div[5]/form[1]/table[2]/tbody[2]/tr[" + r + "]/td[13]/select[1]"));
				Thread.sleep(2000);
				JavaScriptManuplator.selectOptionFromDropDown(element, "Update");
				break;
			}
		}
	}

	// Current Address Verification-- Summary of Case
	public void currentAddressVerification() throws InterruptedException {
		JavaScriptManuplator.waitForElementPresent(ldriver, clickSelectDispositionsRadioBtn, 120);
		JavaScriptManuplator.javaScriptExecutor(clickSelectDispositionsRadioBtn, "arguments[0].click()", ldriver);

		// Antecedents to Verify
		JavaScriptManuplator.javaScriptExecutor(clickOnSaveDetails, "arguments[0].scrollIntoView(true);", ldriver);
		JavaScriptManuplator.javaScriptExecutor(checkCopyStated, "arguments[0].click()", ldriver);
		JavaScriptManuplator.selectOptionFromDropDown(selectVerificationType, "Not Applicable");
		JavaScriptManuplator.javaScriptExecutor(txtVerifiedType, "arguments[0].value='Test Verified'", ldriver);
		JavaScriptManuplator.javaScriptExecutor(txtRelationshipWithCandidate, "arguments[0].value='Brother'", ldriver);

		JavaScriptManuplator.javaScriptExecutor(txtDurationOfStay, "arguments[0].value='Test'", ldriver);
		JavaScriptManuplator.javaScriptExecutor(txtDateOfVerification, "arguments[0].removeAttribute('readonly')",
				ldriver);
		Thread.sleep(2000);
		JavaScriptManuplator.javaScriptExecutor(txtDateOfVerification, "arguments[0].value='06/10/2021'", ldriver);
		JavaScriptManuplator.javaScriptExecutor(txtAnyOtherComments, "arguments[0].value='Good Comments'", ldriver);
		JavaScriptManuplator.javaScriptExecutor(txtNameOfFieldExecutive, "arguments[0].value='Raju Yadav'", ldriver);
		JavaScriptManuplator.javaScriptExecutor(txtTimeOfVerification, "arguments[0].value='12PM'", ldriver);

		JavaScriptManuplator.javaScriptExecutor(txtGateColor, "arguments[0].value='Green'", ldriver);
		JavaScriptManuplator.javaScriptExecutor(txtColorOfBuilding, "arguments[0].value='White'", ldriver);
		JavaScriptManuplator.javaScriptExecutor(txtNewAddressDetailsObtained, "arguments[0].value='Gurgaow'", ldriver);
		JavaScriptManuplator.selectOptionFromDropDown(selectResidenceType, "Not Applicable");

		JavaScriptManuplator.javaScriptExecutor(txtGPSCoordinates, "arguments[0].value='Test'", ldriver);
		JavaScriptManuplator.javaScriptExecutor(clickOnSaveDetails, "arguments[0].click()", ldriver);
		Thread.sleep(2000);
		//Sure! you want to save these details.??
		ldriver.switchTo().alert().accept();
		Thread.sleep(2000);
	}

	// Verify Send Response
	public void verifySendResponse() throws InterruptedException, IOException {
		// How many rows in table
		String data = new String(Files.readAllBytes(Paths.get("CaseCheckId.txt")));
		String checkId[] = data.split(" ");
		String id[] = checkId[1].split("=");
		System.out.println("Check id printed"+id[1]);
		int rows = ldriver.findElements(By.xpath("/html[1]/body[1]/div[1]/div[5]/form[1]/table[2]/tbody[2]/tr")).size();
		// Get Check Id, and select action Update from Drop-down
		for (int r = 1; r <= rows; r++) {
			String addressCheckId = ldriver
					.findElement(
							By.xpath("/html[1]/body[1]/div[1]/div[5]/form[1]/table[2]/tbody[2]/tr[" + r + "]/td[1]"))
					.getText();
			if (addressCheckId.equals(id[1])) {

				WebElement element = ldriver.findElement(By.xpath(
						"/html[1]/body[1]/div[1]/div[5]/form[1]/table[2]/tbody[2]/tr[" + r + "]/td[14]/input[1]"));
				Thread.sleep(2000);
				JavaScriptManuplator.javaScriptExecutor(element, "arguments[0].click()", ldriver);
				Thread.sleep(2000);
				break;
			}
		}
		// Sure! You want send this case.??
		ldriver.switchTo().alert().accept();
		Thread.sleep(2000);
	}

	// Response sent successfully.
	public String responseSentSuccessfully() {
		JavaScriptManuplator.waitForElementPresent(ldriver, verifyResponseSentSuccessfully, 120);
		return verifyResponseSentSuccessfully.getText();
	}

	// Unassigned Check Summary - Client wise--  Before Total Checks Count
		public String verifyGetBeforeTotalChecksCount() throws InterruptedException {
			JavaScriptManuplator.waitForElementPresent(ldriver, selectApproverTl, 60);
			JavaScriptManuplator.selectOptionFromDropDown(selectApproverTl, "Approver TL");
			Thread.sleep(2000);
			wait = new WebDriverWait(ldriver, 120);
			wait.until(ExpectedConditions.visibilityOf(getBeforeTotalChecksCount));
			try {

				File output = new File("BeforeTotalChecksCount.txt");
				FileWriter writer = new FileWriter(output);
				writer.write(getBeforeTotalChecksCount.getText());
				writer.flush();
				writer.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return getBeforeTotalChecksCount.getText();
		}
		
	// Admin Approver TL
	public void adminApproverTL() throws InterruptedException {
		wait = new WebDriverWait(ldriver, 120);
		wait.until(ExpectedConditions.visibilityOf(selectAllCheckBoxButton));
		JavaScriptManuplator.javaScriptExecutor(selectAllCheckBoxButton, "arguments[0].click()", ldriver);
		JavaScriptManuplator.javaScriptExecutor(checkAddressFamilyCheckbox, "arguments[0].click()", ldriver);
		JavaScriptManuplator.javaScriptExecutor(selectApproverName, "arguments[0].scrollIntoView(true);", ldriver);
		JavaScriptManuplator.selectOptionFromDropDown(selectApproverName, "Ajay Sahoo VB");
		Thread.sleep(2000);
		JavaScriptManuplator.javaScriptExecutor(clickOnApproverGoBtn, "arguments[0].click()", ldriver);
	}
	
	// Unassigned Check Summary - Client wise-- After Total Checks Count
	public String verifyGetAfterTotalChecksCount() throws InterruptedException {
		wait = new WebDriverWait(ldriver, 120);
		wait.until(ExpectedConditions.visibilityOf(getAfterTotalChecksCount));
		Thread.sleep(2000);
		try {

			File output = new File("AfterTotalChecksCount.txt");
			FileWriter writer = new FileWriter(output);
			writer.write(getAfterTotalChecksCount.getText());
			writer.flush();
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return getAfterTotalChecksCount.getText();
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

		// Verified Via
		JavaScriptManuplator.javaScriptExecutor(selectVerifiedVia, "arguments[0].scrollIntoView(true);", ldriver);
		JavaScriptManuplator.selectOptionFromDropDown(selectVerifiedVia, "Email");
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

		// Overseas Country
		JavaScriptManuplator.javaScriptExecutor(selectOverseasCountry, "arguments[0].scrollIntoView(true);", ldriver);
		JavaScriptManuplator.selectOptionFromDropDown(selectOverseasCountry, "India");
		// Release for Report
		JavaScriptManuplator.selectOptionFromDropDown(selectActionName, "Release for Report");
		Thread.sleep(2000);
		JavaScriptManuplator.javaScriptExecutor(clickOnReleaseForReportGoBtn, "arguments[0].click()", ldriver);
		Thread.sleep(3000);

		// Admin Home Module
		JavaScriptManuplator.waitForElementPresent(ldriver, clickOnHomeModule, 120);
		JavaScriptManuplator.javaScriptExecutor(clickOnHomeModule, "arguments[0].click()", ldriver);
		txtHomeArsNoSearch.sendKeys(homeArsNumber);
		Thread.sleep(2000);
		JavaScriptManuplator.javaScriptExecutor(clickOnHomeSearchBtn, "arguments[0].click()", ldriver);
		Thread.sleep(1000);
	}

	// Check Status -- Completed
	public String verifyCheckStatusCompletedText() {
		JavaScriptManuplator.waitForElementPresent(ldriver, clickOnHomeModule, 120);
		return verifyCheckStatusCompleted.getText();
	}

	// Verification Quality Allocator--Check List - Search Result - (14 records)
	public void superAdminVerificationQualityAllocator(String enterArsNo, String checkComments)
			throws InterruptedException {
		wait = new WebDriverWait(ldriver, 360);
		wait.until(ExpectedConditions.visibilityOf(selectUserRoleVerificationQualityAllocator));
		JavaScriptManuplator.selectOptionFromDropDown(selectUserRoleVerificationQualityAllocator, "Verification Quality Allocator");
		Thread.sleep(3000);
		clickOnDashboardModule.click();
		wait = new WebDriverWait(ldriver, 240);
		wait.until(ExpectedConditions.visibilityOf(verifyNotificationAlerts));
		txtEnterArsNumber.sendKeys(enterArsNo);
		clickOnArsNoSearchBtn.click();
		wait = new WebDriverWait(ldriver, 360);
		wait.until(ExpectedConditions.visibilityOf(clickOnApplicableCountNo));
		//clickOnVerifiedCountNumber.click();
		//New added code
		clickOnApplicableCountNo.click();

		// Check List - Search Result - (14 records)
		wait = new WebDriverWait(ldriver, 60);
		wait.until(ExpectedConditions.visibilityOf(checkOnCheckBoxCheckListAll));
		checkOnCheckBoxCheckListAll.click();

		Select actionAllocateToVqc = new Select(selectActionAllocateToVqc);
		actionAllocateToVqc.selectByIndex(1);
		txtCheckComments.sendKeys(checkComments);
		clickOnGoBtn.click();

		WebElement element = ldriver.findElement(By.xpath("//span[contains(text(),'Yes')]"));
		Actions actions = new Actions(ldriver);
		actions.moveToElement(element).click().perform();
		Thread.sleep(1000);
	}

	// The selected checks were successfully released for report.
	public String verificationQualityAllocatorSuccessfullyMsg() {
		wait = new WebDriverWait(ldriver, 120);
		wait.until(ExpectedConditions.visibilityOf(verifyQualityAllocatorSuccessMsg));
		return verifyQualityAllocatorSuccessMsg.getText();
	}

	// Reports Manager -- Search Report
	public void superAdminReportsManager(String enterArsNo) throws InterruptedException {
		wait = new WebDriverWait(ldriver, 180);
		wait.until(ExpectedConditions.visibilityOf(selectUserRoleReportsManager));
		//Select userRoleReportsManager = new Select(selectUserRoleReportsManager);
		//userRoleReportsManager.selectByIndex(50);
		JavaScriptManuplator.selectOptionFromDropDown(selectUserRoleReportsManager, "Reports Manager");
		Thread.sleep(3000);
		clickOnDashboardModule.click();
		wait = new WebDriverWait(ldriver, 240);
		wait.until(ExpectedConditions.visibilityOf(verifyNotificationAlertsReportsStatus));
		clickOnReportsManagerReports.click();
		WebElement element = ldriver.findElement(By.xpath("//a[contains(text(),'Search Report')]"));
		Actions actions = new Actions(ldriver);
		actions.moveToElement(element).click().perform();

		wait = new WebDriverWait(ldriver, 60);
		wait.until(ExpectedConditions.visibilityOf(txtArsNumber));
		txtArsNumber.sendKeys(enterArsNo);
		clickOnSearchReportBtn.click();

		// Report List - Search Result -- Single Window Review Report
		wait = new WebDriverWait(ldriver, 120);
		wait.until(ExpectedConditions.visibilityOf(selectActionWindowReviewReport));
		JavaScriptManuplator.selectOptionFromDropDown(selectActionWindowReviewReport, "Single Window Review Report");
		// Do you wish to continue with the action "Single Window Review Report"?
		WebElement ele = ldriver.findElement(By.xpath("//span[contains(text(),'Yes')]"));
		Actions act = new Actions(ldriver);
		act.moveToElement(ele).click().perform();

		// Current Address Verification
		js = (JavascriptExecutor) ldriver;
		js.executeScript("arguments[0].scrollIntoView(true);", clickOnCurrentAddressVerificationSubmitBtn);
		wait = new WebDriverWait(ldriver, 60);
		wait.until(ExpectedConditions.visibilityOf(clickOnCurrentAddressVerificationSubmitBtn));
		js = (JavascriptExecutor) ldriver;
		Thread.sleep(1000);
		js.executeScript("arguments[0].click()", clickOnCurrentAddressVerificationSubmitBtn);
		Thread.sleep(1000);
		// Report Review--
		js = (JavascriptExecutor) ldriver;
		js.executeScript("arguments[0].scrollIntoView(true);", clickOnReportReviewBtn);
		wait = new WebDriverWait(ldriver, 60);
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOf(selectReportSeverity));
		Thread.sleep(1000);
		JavaScriptManuplator.selectOptionFromDropDown(selectReportSeverity, "Clear");
		Thread.sleep(1000);
		JavaScriptManuplator.selectOptionFromDropDown(selectStandardComments, "Verified Comments 1");
		Thread.sleep(2000);
		String url = ldriver.getCurrentUrl();
		try {

			File output = new File("copyGenerateCode.txt");
			FileWriter writer = new FileWriter(output);
			writer.write(url);
			writer.flush();
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		Thread.sleep(2000);
		clickOnReportReviewBtn.click();
		Thread.sleep(1000);
	}

	// Report Successfully Reviewed.
	public String verifyReportSuccessReviewedMsg() {
		wait = new WebDriverWait(ldriver, 120);
		wait.until(ExpectedConditions.visibilityOf(verifyReportSuccessReviewMsg));
		return verifyReportSuccessReviewMsg.getText();
	}

	public String verifyReportStatusVerified() {
		wait = new WebDriverWait(ldriver, 120);
		wait.until(ExpectedConditions.visibilityOf(verifyReportStatusVerifiedText));
		return verifyReportStatusVerifiedText.getText();
	}
}
