package com.opus.pageobject;

import java.awt.Robot;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
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

public class BridgeCaseDetails {
	WebDriver ldriver;
	WebDriverWait wait;
	JavascriptExecutor js;
	Robot rbt;

	public BridgeCaseDetails(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(ldriver, this);
	}

	// Bridge Role DocumentProcessor,Add Details
	@FindBy(xpath = "//select[@id='user_current_role']")
	@CacheLookup
	WebElement selectRoleDocumentProcessor;

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[1]/ul[1]/li[3]/a[1]")
	@CacheLookup
	WebElement clickOnCasesMenu;

	@FindBy(xpath = "//a[contains(text(),'Add Details')]")
	@CacheLookup
	WebElement clickOnAddDetails;

	// Bridge Case Add Details
	@FindBy(xpath = "//select[@id='client_id']")
	@CacheLookup
	WebElement selectClientName;

	@FindBy(xpath = "//select[@id='process_id']")
	@CacheLookup
	WebElement selectProcessName;

	@FindBy(xpath = "//select[@id='CaseMasterDATASOURCE']")
	@CacheLookup
	WebElement selectCaseSourceName;

	@FindBy(xpath = "//input[@id='date_casemaster_received']")
	@CacheLookup
	WebElement txtCaseReceivedDate;

	@FindBy(xpath = "//input[@id='date_casemaster_accepted']")
	@CacheLookup
	WebElement txtCaseAcceptanceDate;

	@FindBy(xpath = "//input[@id='CaseMasterDOCREFNO']")
	@CacheLookup
	WebElement txtDocumentRefNo;

	// NID Details
	@FindBy(xpath = "//input[@id='pan_card']")
	@CacheLookup
	WebElement txtPanCard;

	@FindBy(xpath = "//input[@id='passport_no']")
	@CacheLookup
	WebElement txtPassportNo;

	@FindBy(xpath = "//input[@id='dl_no']")
	@CacheLookup
	WebElement txtDrivingLicenceNo;

	@FindBy(xpath = "//input[@id='voter_id']")
	@CacheLookup
	WebElement txtVoterId;

	// Candidate Details
	@FindBy(xpath = "//input[@id='first_name']")
	@CacheLookup
	WebElement txtFirstName;

	@FindBy(xpath = "//input[@id='middle_name']")
	@CacheLookup
	WebElement txtMiddleName;

	@FindBy(xpath = "//input[@id='last_name']")
	@CacheLookup
	WebElement txtLastName;

	@FindBy(xpath = "//input[@id='father_name']")
	@CacheLookup
	WebElement txtFatherName;

	@FindBy(xpath = "//input[@id='dob']")
	@CacheLookup
	WebElement txtDateOfBirth;

	@FindBy(xpath = "//input[@id='email_address']")
	@CacheLookup
	WebElement txtEmailAddress;

	@FindBy(xpath = "//input[@id='mobile_no']")
	@CacheLookup
	WebElement txtMobileNo;

	// Client Specific Fields
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[2]/div[1]/form[1]/table[2]/tbody[1]/tr[1]/td[1]/div[1]/fieldset[1]/table[1]/tbody[1]/tr[1]/td[2]/input[1]")
	@CacheLookup
	WebElement txtEIN;

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[2]/div[1]/form[1]/table[2]/tbody[1]/tr[1]/td[1]/div[1]/fieldset[1]/table[1]/tbody[1]/tr[2]/td[2]/input[1]")
	@CacheLookup
	WebElement txtDob;

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[2]/div[1]/form[1]/table[2]/tbody[1]/tr[1]/td[1]/div[1]/fieldset[1]/table[1]/tbody[1]/tr[3]/td[2]/select[1]")
	@CacheLookup
	WebElement selectOuc;

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[2]/div[1]/form[1]/table[2]/tbody[1]/tr[1]/td[1]/div[1]/fieldset[1]/table[1]/tbody[1]/tr[4]/td[2]/input[1]")
	@CacheLookup
	WebElement txtLineManager;

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[2]/div[1]/form[1]/table[2]/tbody[1]/tr[1]/td[1]/div[1]/fieldset[1]/table[1]/tbody[1]/tr[5]/td[2]/input[1]")
	@CacheLookup
	WebElement txtLegalEntity;

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[2]/div[1]/form[1]/table[2]/tbody[1]/tr[1]/td[1]/div[1]/fieldset[1]/table[1]/tbody[1]/tr[6]/td[2]/input[1]")
	@CacheLookup
	WebElement txtDateOfProvisional;

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[2]/div[1]/form[1]/table[2]/tbody[1]/tr[1]/td[1]/div[1]/fieldset[1]/table[1]/tbody[1]/tr[7]/td[2]/input[1]")
	@CacheLookup
	WebElement txtPanNo;

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[2]/div[1]/form[1]/table[2]/tbody[1]/tr[1]/td[1]/div[1]/fieldset[1]/table[1]/tbody[1]/tr[8]/td[2]/select[1]")
	@CacheLookup
	WebElement selectRecruiterName;

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[2]/div[1]/form[1]/table[2]/tbody[1]/tr[1]/td[1]/div[1]/fieldset[1]/table[1]/tbody[1]/tr[9]/td[2]/select[1]")
	@CacheLookup
	WebElement selectBGVSpoc;

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[2]/div[1]/form[1]/table[2]/tbody[1]/tr[1]/td[1]/div[1]/fieldset[1]/table[1]/tbody[1]/tr[10]/td[2]/input[1]")
	@CacheLookup
	WebElement txtHRDPName;

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[2]/div[1]/form[1]/table[2]/tbody[1]/tr[1]/td[1]/div[1]/fieldset[1]/table[1]/tbody[1]/tr[11]/td[2]/input[1]")
	@CacheLookup
	WebElement txtClientProcessName;

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[2]/div[1]/form[1]/table[2]/tbody[1]/tr[1]/td[1]/div[1]/fieldset[1]/table[1]/tbody[1]/tr[12]/td[2]/input[1]")
	@CacheLookup
	WebElement txtAddress;

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[2]/div[1]/form[1]/table[2]/tbody[1]/tr[1]/td[1]/div[1]/fieldset[1]/table[1]/tbody[1]/tr[1]/td[4]/input[1]")
	@CacheLookup
	WebElement txtDateOfJoining;

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[2]/div[1]/form[1]/table[2]/tbody[1]/tr[1]/td[1]/div[1]/fieldset[1]/table[1]/tbody[1]/tr[2]/td[4]/input[1]")
	@CacheLookup
	WebElement txtBusinessUnit;

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[2]/div[1]/form[1]/table[2]/tbody[1]/tr[1]/td[1]/div[1]/fieldset[1]/table[1]/tbody[1]/tr[3]/td[4]/input[1]")
	@CacheLookup
	WebElement txtDesignation;

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[2]/div[1]/form[1]/table[2]/tbody[1]/tr[1]/td[1]/div[1]/fieldset[1]/table[1]/tbody[1]/tr[4]/td[4]/input[1]")
	@CacheLookup
	WebElement txtRoleCode;

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[2]/div[1]/form[1]/table[2]/tbody[1]/tr[1]/td[1]/div[1]/fieldset[1]/table[1]/tbody[1]/tr[5]/td[4]/input[1]")
	@CacheLookup
	WebElement txtBtEmailId;

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[2]/div[1]/form[1]/table[2]/tbody[1]/tr[1]/td[1]/div[1]/fieldset[1]/table[1]/tbody[1]/tr[6]/td[4]/input[1]")
	@CacheLookup
	WebElement txtRecordId;

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[2]/div[1]/form[1]/table[2]/tbody[1]/tr[1]/td[1]/div[1]/fieldset[1]/table[1]/tbody[1]/tr[7]/td[4]/select[1]")
	@CacheLookup
	WebElement selectRecruiterEmailId;

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[2]/div[1]/form[1]/table[2]/tbody[1]/tr[1]/td[1]/div[1]/fieldset[1]/table[1]/tbody[1]/tr[8]/td[4]/select[1]")
	@CacheLookup
	WebElement selectCeGoAheadRequired;

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[2]/div[1]/form[1]/table[2]/tbody[1]/tr[1]/td[1]/div[1]/fieldset[1]/table[1]/tbody[1]/tr[9]/td[4]/select[1]")
	@CacheLookup
	WebElement selectBgvSpocEmailId;

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[2]/div[1]/form[1]/table[2]/tbody[1]/tr[1]/td[1]/div[1]/fieldset[1]/table[1]/tbody[1]/tr[10]/td[4]/input[1]")
	@CacheLookup
	WebElement txtHrdpEmailId;

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[2]/div[1]/form[1]/table[2]/tbody[1]/tr[1]/td[1]/div[1]/fieldset[1]/table[1]/tbody[1]/tr[11]/td[4]/input[1]")
	@CacheLookup
	WebElement txtCandidateId;

	@FindBy(xpath = "//textarea[@id='case_comment']")
	@CacheLookup
	WebElement txtComments;

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[2]/div[1]/form[1]/fieldset[3]/table[1]/tbody[1]/tr[2]/td[1]/div[1]/div[1]/div[1]/span[1]/input[1]")
	@CacheLookup
	WebElement clickOnSignOffReceivedRadioYesBtn;

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[2]/div[1]/form[1]/table[3]/tbody[1]/tr[1]/td[1]/div[1]/input[1]")
	@CacheLookup
	WebElement clickAddCaseBtn;

	// Case detail has been saved successfully. 2325-007433
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[2]/div[1]")
	@CacheLookup
	WebElement verifyCaseDetailsSavedSuccessfullyMessage;

	// Highlighter Allocator
	@FindBy(xpath = "//select[@id='user_current_role']")
	@CacheLookup
	WebElement selectHighlighterAllocator;

	// List of processed Cases
	@FindBy(xpath = "//h4[contains(text(),'Cases')]")
	@CacheLookup
	WebElement verifyListOfProcessedCases;
	
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[2]/div[1]/div[2]/div[1]/h4[2]/a[1]")
	@CacheLookup
	WebElement clickOnLoadResultLink;

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[2]/div[1]/div[2]/div[2]/table[1]/tbody[1]/tr")
	@CacheLookup
	WebElement getTableRows;

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[2]/div[1]/div[2]/div[2]/table[1]/thead/tr/th")
	@CacheLookup
	WebElement getTableColumns;

	// British Telecom ( Normal Client )
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[2]/div[1]/div[2]/div[2]/table[1]/tbody[1]/tr[15]/td[2]")
	@CacheLookup
	WebElement getBritishTelecomNormalClient;

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[2]/div[1]/div[2]/div[2]/table[1]/tbody[1]/tr[15]/td[8]")
	@CacheLookup
	WebElement getSpecificRowsAndColsValue;

	// Allocate Cases Detail
	@FindBy(xpath = "//input[@id='selectall']")
	@CacheLookup
	WebElement checkAllCheckBoxButton;

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[2]/div[1]/form[1]/div[2]/table[1]/tbody[1]/tr[1]/td[1]/input[1]")
	@CacheLookup
	WebElement checkAllocateCaseOfCheckBox;

	@FindBy(xpath = "//h4[contains(text(),'Allocate Cases Detail')]")
	@CacheLookup
	WebElement verifyAllocateCasesDetail;

	@FindBy(xpath = "//select[@id='allocatorAllocateTo']")
	@CacheLookup
	WebElement selectAssignToHighlighterName;// Shariq Abbas

	@FindBy(xpath = "//button[contains(text(),'Submit')]")
	@CacheLookup
	WebElement clickOnSubmitBtn;

	// Case is successfully allocated to highlighter.
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[2]/div[1]")
	@CacheLookup
	WebElement verifySuccessfullyAllocatedMessage;

	// Highlighter-- List Of Assign Cases with Ageing
	@FindBy(xpath = "//select[@id='user_current_role']")
	@CacheLookup
	WebElement selectUserAdminRoleHighlighter;

	@FindBy(xpath = "//h4[contains(text(),'List Of Assign Cases with Ageing')]")
	@CacheLookup
	WebElement verifyListOfAssignCasesWithAgeing;
	
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[2]/div[1]/div[2]/div[1]/h4[2]/a[1]")
	@CacheLookup
	WebElement clickOnLoadResultHighliter;

	// Highlighter-- Details Listing
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[2]/div[2]/div[2]/table[1]/tbody[1]/tr[1]/td[9]/select[1]")
	@CacheLookup
	WebElement selectActionTopsheet;

	@FindBy(xpath = "//td[contains(text(),'British Telecom')]")
	@CacheLookup
	WebElement verifyCaseClientName;

	// Highlighter-- Add Details
	@FindBy(xpath = "//select[@id='location_id']")
	@CacheLookup
	WebElement selectClientLocation;

	@FindBy(xpath = "//select[@id='process_id']")
	@CacheLookup
	WebElement selectSelectProcess;

	// Check(s) -- Add Details
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[2]/div[2]/form[1]/table[1]/tbody[1]/tr[2]/td[1]/div[1]/fieldset[1]/table[1]/tbody[1]/tr[1]/td[1]/table[1]/tbody[1]/tr[2]/td[1]/div[1]/div[1]/span[1]/input[1]")
	@CacheLookup
	WebElement clickOnCurrentAddressVerificationCheck;

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[2]/div[2]/form[1]/table[1]/tbody[1]/tr[2]/td[1]/div[1]/fieldset[1]/table[1]/tbody[1]/tr[1]/td[1]/table[1]/tbody[1]/tr[2]/td[1]/div[1]/input[1]")
	@CacheLookup
	WebElement currentAddressComments;
	
	// Upload Documents
	@FindBy(xpath = "//input[@id='masterdocumentFile']")
	@CacheLookup
	WebElement uploadDocument;

	@FindBy(xpath = "//input[@id='CaseDocumentDocument']")
	@CacheLookup
	WebElement uploadClientEmailDoc;

	@FindBy(xpath = "//textarea[@id='clarificationTxtID']")
	@CacheLookup
	WebElement txtEscalationComment;

	@FindBy(xpath = "//textarea[@id='CommentsTxtID']")
	@CacheLookup
	WebElement txtCaseLevelComments;

	@FindBy(xpath = "//input[@id='caseAddId']")
	@CacheLookup
	WebElement clickOnAddCaseBtn;

	// Case is successfully created. You can now proceed with checks creation for
	// the given candidate.
	// Top sheet is successfully created. You can now proceed with checks creation
	// for the given candidate.
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[2]/div[2]")
	@CacheLookup
	WebElement verifyTopsheetSuccessfullyCreatedMesage;

	// Documentation Specialist
	@FindBy(xpath = "//select[@id='user_current_role']")
	@CacheLookup
	WebElement selectUserRoleDocumentationSpecialist;

	@FindBy(xpath = "//h4[contains(text(),'British Telecom - Specialist Pending Cases')]")
	@CacheLookup
	WebElement verifyBritishTelecomSpecialistPendingCasesText;

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]")
	@CacheLookup
	WebElement getCasesTotalRecords;

	// Pagination Count
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[2]/table[1]/tbody[1]/tr[51]/td[1]/div[1]/span[4]/a[1]")
	@CacheLookup
	WebElement clickOnPageCountNo;

	// Documentation Specialist-- Candidate Details
	@FindBy(xpath = "//input[@id='alias_fname']")
	@CacheLookup
	WebElement txtAliasFname;

	@FindBy(xpath = "//input[@id='alias_lname']")
	@CacheLookup
	WebElement txtAliasLname;

	@FindBy(xpath = "//input[@id='GenderMale']")
	@CacheLookup
	WebElement checkGenderMale;

	// Client Specific Fields
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[3]/div[1]/div[1]/form[1]/div[17]/input[1]")
	@CacheLookup
	WebElement txtClientSpecificEin;

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[3]/div[1]/div[1]/form[1]/div[18]/input[1]")
	@CacheLookup
	WebElement txtClientSpecificDateOfJoining;

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[3]/div[1]/div[1]/form[1]/div[19]/input[1]")
	@CacheLookup
	WebElement txtClientSpecificDob;

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[3]/div[1]/div[1]/form[1]/div[20]/input[1]")
	@CacheLookup
	WebElement txtClientSpecificBusinessUnit;

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[3]/div[1]/div[1]/form[1]/div[21]/select[1]")
	@CacheLookup
	WebElement selectClientSpecificOUC;

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[3]/div[1]/div[1]/form[1]/div[22]/input[1]")
	@CacheLookup
	WebElement txtClientSpecificDesination;

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[3]/div[1]/div[1]/form[1]/div[23]/input[1]")
	@CacheLookup
	WebElement txtClientSpecificLineManager;

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[3]/div[1]/div[1]/form[1]/div[24]/input[1]")
	@CacheLookup
	WebElement txtClientSpecificRoleCode;

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[3]/div[1]/div[1]/form[1]/div[25]/input[1]")
	@CacheLookup
	WebElement txtClientSpecificLegalEntity;

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[3]/div[1]/div[1]/form[1]/div[26]/input[1]")
	@CacheLookup
	WebElement txtClientSpecificBtClientEmailId;

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[3]/div[1]/div[1]/form[1]/div[27]/input[1]")
	@CacheLookup
	WebElement txtClientDateOfProvisional;

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[3]/div[1]/div[1]/form[1]/div[28]/input[1]")
	@CacheLookup
	WebElement txtClientSpecificRecordId;

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[3]/div[1]/div[1]/form[1]/div[29]/input[1]")
	@CacheLookup
	WebElement txtClientSpecificPanNumber;

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[3]/div[1]/div[1]/form[1]/div[30]/select[1]")
	@CacheLookup
	WebElement selectClientSpecificRecruiterEmailId;

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[3]/div[1]/div[1]/form[1]/div[31]/select[1]")
	@CacheLookup
	WebElement selectClientSpecificRecruiterName;

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[3]/div[1]/div[1]/form[1]/div[32]/select[1]")
	@CacheLookup
	WebElement selectClientSpecificCeoGoAhead;

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[3]/div[1]/div[1]/form[1]/div[33]/select[1]")
	@CacheLookup
	WebElement selectCleintSpecificBGVSpoc;

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[3]/div[1]/div[1]/form[1]/div[34]/select[1]")
	@CacheLookup
	WebElement selectBGVSpocEmailID;

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[3]/div[1]/div[1]/form[1]/div[35]/input[1]")
	@CacheLookup
	WebElement txtClientSpecificHrdpName;

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[3]/div[1]/div[1]/form[1]/div[36]/input[1]")
	@CacheLookup
	WebElement txtClientSpecificHrdpEmail;

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[3]/div[1]/div[1]/form[1]/div[37]/input[1]")
	@CacheLookup
	WebElement txtClientSpecifClientPoccessName;

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[3]/div[1]/div[1]/form[1]/div[38]/input[1]")
	@CacheLookup
	WebElement txtClientSpecificCandidateId;

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[3]/div[1]/div[1]/form[1]/div[39]/input[1]")
	@CacheLookup
	WebElement txtClientSpecificAddress;

	@FindBy(xpath = "//button[contains(text(),'Add Candidate')]")
	@CacheLookup
	WebElement ClickOnClientSpecificAddCondidateBtn;

	// Candidate details are successfully saved. Kindly enter the process and check
	// details.
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[2]/div[1]")
	@CacheLookup
	WebElement verifyCandidateDetailsSuccessfullySaved;

	// Case Details -- Confirm availability of Following Documents:
	@FindBy(xpath = "//input[@id='arn_doc']")
	@CacheLookup
	WebElement txtAuthorizationReleaseNote;

	@FindBy(xpath = "//input[@id='JAF_DOC']")
	@CacheLookup
	WebElement txtApplicationForm;

	@FindBy(xpath = "//textarea[@id='case_comment']")
	@CacheLookup
	WebElement txtCaseComments;

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[3]/div[1]/form[1]/div[5]/div[1]/input[1]")
	@CacheLookup
	WebElement clickOnCaseDetailsAddCaseBtn;

	// Documentation Specialist-- Add Check Details
	// Current Address Verification
	@FindBy(xpath = "//strong[contains(text(),'Current Address Verification')]")
	@CacheLookup
	WebElement clickOnCurrentAddressVerification;

	@FindBy(xpath = "//input[@id='unique_city']")
	@CacheLookup
	WebElement txtCityName;

	@FindBy(css = "#dynamic_5")
	@CacheLookup
	WebElement txtCurrentAddressContactNo;

	@FindBy(css = "#dynamic_6")
	@CacheLookup
	WebElement txtCurrentAddress;

	@FindBy(css = "#dynamic_7")
	@CacheLookup
	WebElement txtCurrentAddressPinCode;

	@FindBy(css = "#dynamic_15")
	@CacheLookup
	WebElement txtCurrentAddressPeriodOfStay;

	@FindBy(xpath = "//textarea[@id='check_comment']")
	@CacheLookup
	WebElement txtCurrentAddressChecksComment;

	@FindBy(css = "#ProcessCheckFieldForm > div:nth-child(16) > div:nth-child(2) > input")
	@CacheLookup
	WebElement clickOnCurrentAddressSaveCheckBtn;

	// Permanent Address Verification
	@FindBy(xpath = "//strong[contains(text(),'Permanent Address Verification')]")
	@CacheLookup
	WebElement clickOnPermanentAddressVerification;

	@FindBy(xpath = "//input[@id='unique_city']")
	@CacheLookup
	WebElement txtPermanentAddressCityName;

	@FindBy(css = "#dynamic_5")
	@CacheLookup
	WebElement txtPermanentAddressNewConatactNo;

	@FindBy(css = "#dynamic_6")
	@CacheLookup
	WebElement txtPermanentAddress;

	@FindBy(css = "#dynamic_7")
	@CacheLookup
	WebElement txtPermanentAddressPinCode;

	@FindBy(css = "#dynamic_15")
	@CacheLookup
	WebElement txtPermanentAddressPeriodOfStayDate;

	@FindBy(xpath = "//textarea[@id='check_comment']")
	@CacheLookup
	WebElement txtPermanentAddressCheckComments;

	@FindBy(css = "#ProcessCheckFieldForm > div:nth-child(16) > div:nth-child(2) > input")
	@CacheLookup
	WebElement clickOnPermanentAddressSaveCheckBtn;

	// Check details are successfully saved. Case is Completed.
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[2]/div[1]")
	@CacheLookup
	WebElement verifyCheckDetailsSuccessfullyMessage;

	// (Docs Qc Allocator)-- (Super Admin) Bridge --Insufficient
	@CacheLookup
	@FindBy(how = How.XPATH, using = "//select[@id='user_current_role']")
	WebElement selectDocsQcAllocator;

	@CacheLookup
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'British Telecom')]")
	WebElement verifyBritishTelecom;
	
	// Adding New Code started
	@CacheLookup
	@FindBy(how = How.XPATH, using = "//h4[contains(text(),'Notification Alerts')]")
	WebElement verifyNotificationAlerts;
	
	@CacheLookup
	@FindBy(how = How.XPATH, using = "/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[1]/h4[2]/a[1]")
	WebElement clickOnLoadResult;
	
	@CacheLookup
	@FindBy(how = How.XPATH, using = "/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[4]/a[1]")
	WebElement clickOniBridgeCountAll;

	@CacheLookup
	@FindBy(how = How.XPATH, using = "//textarea[@id='SearchCriteriaCASEARSNO']")
	WebElement txtEnterArsSearch;
	
	@CacheLookup
	@FindBy(how = How.XPATH, using = "//input[@id='btnSearch']")
	WebElement clickOnSearchBtn;
	// Adding New Code ended
	
	@CacheLookup
	@FindBy(how = How.XPATH, using = "//input[@id='case_all']")
	WebElement checkBoxCheckedClientCaseAll;

	@CacheLookup
	@FindBy(how = How.XPATH, using = "/html[1]/body[1]/div[1]/div[2]/div[1]/div[2]/div[1]/form[2]/table[1]/tbody[1]/tr[1]/td[1]/input[1]")
	WebElement checkBoxCheckedBritishTelecom;

	@CacheLookup
	@FindBy(how = How.XPATH, using = "//select[@id='CaseMasterBULKACTIONTAKEN']")
	WebElement selectCaseMasterBulkActionTaken;

	@CacheLookup
	@FindBy(how = How.XPATH, using = "//select[@id='ddlCasesAssignedTo']")
	WebElement selectDdlCasesAssignedTo;

	@CacheLookup
	@FindBy(how = How.XPATH, using = "//button[@id='btnGo']")
	WebElement clickOnGoBtn;

	// Are you sure you want to allocate selected Cases to "Shariq Abbas" ?
	@CacheLookup
	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Yes')]")
	WebElement clickOnActionConfAlertYesBtn;

	@CacheLookup
	@FindBy(how = How.XPATH, using = "//*[contains(text(),'All selected cases were successfully allocated to QC Team Member.')]")
	WebElement verifyCaseSuccessfullyAllocated;

	// (Docs Quality)--Bridge --Insufficient
	@CacheLookup
	@FindBy(how = How.XPATH, using = "//select[@id='user_current_role']")
	WebElement selectDocsQcQuality;

	@CacheLookup
	@FindBy(how = How.XPATH, using = "/html[1]/body[1]/div[1]/div[1]/div[1]/ul[1]/li[4]/a[1]")
	WebElement clickOnDocQualityCases;

	@CacheLookup
	@FindBy(how = How.XPATH, using = "//h4[contains(text(),'Cases for Quality Review')]")
	WebElement verifyCasesforQualityReview;

	@CacheLookup
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Search Case')]")
	WebElement clickOnSearchCase;

	@CacheLookup
	@FindBy(how = How.XPATH, using = "//input[@id='CaseMasterCASEARSNO']")
	WebElement txtArsNumber;

	@CacheLookup
	@FindBy(how = How.XPATH, using = "//button[contains(text(),'Search Case')]")
	WebElement clickOnSearchCaseBtn;

	// Case List - Search Result
	@CacheLookup
	@FindBy(how = How.XPATH, using = "/html[1]/body[1]/div[1]/div[2]/div[2]/div[2]/form[1]/table[1]/tbody[1]/tr[1]/td[13]/select[1]")
	WebElement selectActionReviewForQuality;

	@CacheLookup
	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Yes')]")
	WebElement clickOnActionConfirmationAlertYesBtn;

	@CacheLookup
	@FindBy(how = How.XPATH, using = "/html[1]/body[1]/div[1]/div[2]/div[1]/div[2]/form[1]/table[1]/thead[1]/tr[3]/th[2]")
	WebElement verifyCaseQCReviewArsNumber;

	// Current Address Verification-- Check Type (QC Done)Checks Summary
	@CacheLookup
	@FindBy(how = How.XPATH, using = "/html[1]/body[1]/div[1]/div[2]/div[1]/div[2]/form[1]/table[4]/tbody[1]/tr[1]/td[8]/a[1]/img[1]")
	WebElement clickOnCurrentAddressQcDoneImg;

	@CacheLookup
	@FindBy(how = How.XPATH, using = "//button[@id='btnAction']")
	WebElement clickOnCurrentAddressMarkAsDQCDone;

	// Permanent Address Verification --Checks Summary
	@CacheLookup
	@FindBy(how = How.XPATH, using = "/html[1]/body[1]/div[1]/div[2]/div[1]/div[2]/form[1]/table[5]/tbody[1]/tr[2]/td[3]/span[1]/button[1]")
	WebElement scrollViewReviewBtn;

	@CacheLookup
	@FindBy(how = How.XPATH, using = "/html/body/div[1]/div[2]/div/div[2]/form/table[4]/tbody/tr[12]/td[8]/a/img")
	WebElement clickOnPermanentAddressQcDoneImg;

	@CacheLookup
	@FindBy(how = How.XPATH, using = "//button[@id='btnAction']")
	WebElement clickOnPermanentAddressAsDQCDone;

	// QC Check list-- Correct Client & location selected
	@CacheLookup
	@FindBy(how = How.XPATH, using = "/html[1]/body[1]/div[1]/div[2]/div[1]/div[2]/form[2]/table[1]/tbody[1]/tr[1]/td[2]/select[1]")
	WebElement selectCorrectClient;

	@CacheLookup
	@FindBy(how = How.XPATH, using = "/html[1]/body[1]/div[1]/div[2]/div[1]/div[2]/form[2]/table[1]/tbody[1]/tr[2]/td[2]/select[1]")
	WebElement selectCorrectProcessMapped;

	@CacheLookup
	@FindBy(how = How.XPATH, using = "/html[1]/body[1]/div[1]/div[2]/div[1]/div[2]/form[2]/table[1]/tbody[1]/tr[3]/td[2]/select[1]")
	WebElement selectClientSpecificFields;

	@CacheLookup
	@FindBy(how = How.XPATH, using = "/html[1]/body[1]/div[1]/div[2]/div[1]/div[2]/form[2]/table[1]/tbody[1]/tr[4]/td[2]/select[1]")
	WebElement selectCandidateDetailsMapped;

	@CacheLookup
	@FindBy(how = How.XPATH, using = "/html[1]/body[1]/div[1]/div[2]/div[1]/div[2]/form[2]/table[1]/tbody[1]/tr[5]/td[2]/select[1]")
	WebElement selectChecksRaisedCorrectly;

	@CacheLookup
	@FindBy(how = How.XPATH, using = "/html[1]/body[1]/div[1]/div[2]/div[1]/div[2]/form[2]/table[1]/tbody[1]/tr[6]/td[2]/select[1]")
	WebElement selectReadCsisInstructions;

	@CacheLookup
	@FindBy(how = How.XPATH, using = "//input[@id='csis_count']")
	WebElement txtNoOfChecks;

	@CacheLookup
	@FindBy(how = How.XPATH, using = "//button[@id='qc_checklist_btn']")
	WebElement clickOnQcCheckListBtn;

	// Action Required --There is a difference in the no. of checks raised and no.
	// of checks given by you, Please select action
	@CacheLookup
	@FindBy(how = How.XPATH, using = "//select[@id='action_taken']")
	WebElement selectActionTaken;

	@CacheLookup
	@FindBy(how = How.XPATH, using = "//input[@id='btn-action']")
	WebElement clickOnActionSubmitBtn;

	@CacheLookup
	@FindBy(how = How.XPATH, using = "//textarea[@id='cases_comments']")
	WebElement txtCaseLevelComment;

	@CacheLookup
	@FindBy(how = How.XPATH, using = "//select[@id='case_action_taken']")
	WebElement selectReleseForVerification;

	// Action Confirmation Alert-- There are 1 overlapping tenures between
	// employment checks.
	@CacheLookup
	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Ok, I Understood')]")
	WebElement clickOnOkIUnderstoodBtn;

	@CacheLookup
	@FindBy(how = How.XPATH, using = "//select[@id='CaseCASELEVEL']")
	WebElement selectCaseLevelSenior;

	@CacheLookup
	@FindBy(how = How.XPATH, using = "//button[@id='btnSubmit']")
	WebElement clickOnReviewBtn;

	// Case QC - Review --Checks Summary-------Success Page
	@CacheLookup
	@FindBy(how = How.XPATH, using = "//textarea[@id='cases_comments']")
	WebElement txtCaseLevelCommentCheck;

	@CacheLookup
	@FindBy(how = How.XPATH, using = "//select[@id='case_action_taken']")
	WebElement selectReleseForVerificationCheck;

	// Action Confirmation Alert-- There are 1 overlapping tenures between
	// employment checks.
	@CacheLookup
	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Ok, I Understood')]")
	WebElement clickOnOkIUnderstoodBtnCheck;

	@CacheLookup
	@FindBy(how = How.XPATH, using = "//select[@id='CaseCASELEVEL']")
	WebElement selectCaseLevelSeniorCheck;

	@CacheLookup
	@FindBy(how = How.XPATH, using = "//button[@id='btnSubmit']")
	WebElement clickOnReviewBtnCheck;

	// The Case was successfully released for Verification.
	@CacheLookup
	@FindBy(how = How.XPATH, using = "//*[contains(text(),'The Case was successfully released for Verification.')]")
	WebElement verifyReleasedForVerificationMessage;

	// Allocator-- (Super Admin)
	@CacheLookup
	@FindBy(how = How.XPATH, using = "//select[@id='user_current_role']")
	WebElement selectSuperAdminAllocator;

	@CacheLookup
	@FindBy(how = How.XPATH, using = "//h4[contains(text(),'Employment UAN')]")
	WebElement verifyEmploymentUan;

	@CacheLookup
	@FindBy(how = How.XPATH, using = "//input[@id='complete_search_no']")
	WebElement txtArsNumberAllocator;

	@CacheLookup
	@FindBy(how = How.XPATH, using = "//button[@id='complete_search']")
	WebElement clickOnSearchAllocatorBtn;

	@CacheLookup
	@FindBy(how = How.XPATH, using = "/html/body/div[1]/div[2]/div[2]/div[2]/form/table/tbody/tr/td[10]/a")
	WebElement clickOnApplicableCountNumber;

	// Check List - Search Result - (14 records)
	@CacheLookup
	@FindBy(how = How.XPATH, using = "//input[@id='check_all']")
	WebElement checkAllCheckBoxCandidate;

	@CacheLookup
	@FindBy(how = How.XPATH, using = "//select[@id='CaseCheckBULKACTIONTAKEN']")
	WebElement selectAssignToVerifier;

	@CacheLookup
	@FindBy(how = How.XPATH, using = "//select[@id='ddlChecksAssignedTo']")
	WebElement selectTeamMemberName;

	@CacheLookup
	@FindBy(how = How.XPATH, using = "//textarea[@id='check_comments']")
	WebElement txtCheckComments;

	@CacheLookup
	@FindBy(how = How.XPATH, using = "//button[@id='btnGo']")
	WebElement clickOnGoAllocatorBtn;

	// Are you sure you want to "Release to Vendor" of selected checks?
	@CacheLookup
	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Yes')]")
	WebElement clickOnConfirmationYesBtn;

	// Check id=9601540 is Not Released, DueTo, Already released to vendor..
	@CacheLookup
	@FindBy(how = How.XPATH, using = "/html[1]/body[1]/div[1]/div[2]/div[1]")
	WebElement verifyAlreadyReleasedToVendorMsg;

	// Verify Ars Number in Allocator
	@CacheLookup
	@FindBy(how = How.XPATH, using = "/html[1]/body[1]/div[1]/div[2]/div[3]/div[2]/form[1]/table[1]/tbody[1]/tr[1]/td[3]/a[1]")
	WebElement verifyArsNumber;

	// Checks are successfully allocated to Shariq Abbas
	@CacheLookup
	@FindBy(how = How.XPATH, using = "/html/body/div[1]/div[2]/div[1]")
	WebElement verifyChecksAreSuccessfullyMsg;

	// Click On Dashboard Module
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[1]/ul[1]/li[3]/a[1]")
	@CacheLookup
	WebElement clickOnDashboardModule;

	public void selectUserAdminRoleDocumentProcessor() throws InterruptedException {
		JavaScriptManuplator.waitForElementPresent(ldriver, selectRoleDocumentProcessor, 120);
		JavaScriptManuplator.selectOptionFromDropDown(selectRoleDocumentProcessor, "Document Processor");
		Thread.sleep(3000);
		clickOnDashboardModule.click();
		JavaScriptManuplator.waitForElementPresent(ldriver, clickOnCasesMenu, 60);
		JavaScriptManuplator.javaScriptExecutor(clickOnCasesMenu, "arguments[0].click()", ldriver);
		JavaScriptManuplator.waitForElementPresent(ldriver, clickOnAddDetails, 60);
		JavaScriptManuplator.javaScriptExecutor(clickOnAddDetails, "arguments[0].click()", ldriver);
	}

	public void candidateFirstName(String firstName) {
		JavaScriptManuplator.waitForElementPresent(ldriver, txtFirstName, 60);
		txtFirstName.sendKeys(firstName);
	}

	public void candidateMiddleName(String middleName) {
		txtMiddleName.sendKeys(middleName);
	}

	public void candidateLastName(String lastName) {
		txtLastName.sendKeys(lastName);
	}

	public void candidateEmail(String email) throws InterruptedException {
		txtEmailAddress.sendKeys(email);
		Thread.sleep(1000);
	}
	
	public void candidateMobileNumber(String mobileNumber) throws InterruptedException {
		txtMobileNo.sendKeys(mobileNumber);
		Thread.sleep(1000);
	}

	// Candidate Details
	public void createNewBridgeCase(String caseReceivedDate, String caseAcceptanceDate, String documentRefNo,
			String panCard, String passportNo, String drivingLicenceNo, String voterId, String fathername,
			String dateOfBirth, String mobileNo, String ein, String dob, String lineManager, String legalEntity,
			String dateOfProvisional, String panNo, String hrdName, String clientProcessName, String address,
			String dateOfJoining, String businessUnit, String designation, String roleCode, String btEmailId,
			String recordId, String hrdpEmailId, String candidateId, String comments) throws InterruptedException {
		// Bridge Case Add Details
		JavaScriptManuplator.waitForElementPresent(ldriver, selectClientName, 120);
		JavaScriptManuplator.waitForElementPresent(ldriver, selectClientName, 60);
		JavaScriptManuplator.selectOptionFromDropDown(selectClientName, "British Telecom");
		JavaScriptManuplator.selectOptionFromDropDown(selectProcessName, "Check Wise");
		JavaScriptManuplator.selectOptionFromDropDown(selectCaseSourceName, "Mail");
		JavaScriptManuplator.javaScriptExecutor(txtCaseReceivedDate, "arguments[0].removeAttribute('readonly')",
				ldriver);
		txtCaseReceivedDate.sendKeys(caseReceivedDate);
		JavaScriptManuplator.javaScriptExecutor(txtCaseAcceptanceDate, "arguments[0].removeAttribute('readonly')",
				ldriver);
		txtCaseAcceptanceDate.sendKeys(caseAcceptanceDate);
		txtDocumentRefNo.sendKeys(documentRefNo);
		// txtPanCard.sendKeys(panCard);
		// NID Details
		/*
		 * txtPanCard.sendKeys(panCard); txtPassportNo.sendKeys(passportNo);
		 * txtDrivingLicenceNo.sendKeys(drivingLicenceNo); txtVoterId.sendKeys(voterId);
		 */
		// Candidate Details
		txtFatherName.sendKeys(fathername);
		JavaScriptManuplator.javaScriptExecutor(txtDateOfBirth, "arguments[0].removeAttribute('readonly')", ldriver);
		txtDateOfBirth.sendKeys(dateOfBirth);
		//txtMobileNo.sendKeys(mobileNo);
		// Client Specific Fields
		txtEIN.sendKeys(ein);
		JavaScriptManuplator.javaScriptExecutor(txtDob, "arguments[0].removeAttribute('readonly')", ldriver);
		txtDob.sendKeys(dob);
		JavaScriptManuplator.selectOptionFromDropDown(selectOuc, "BEA1");
		txtLineManager.sendKeys(lineManager);
		txtLegalEntity.sendKeys(legalEntity);
		JavaScriptManuplator.javaScriptExecutor(txtDateOfProvisional, "arguments[0].removeAttribute('readonly')",
				ldriver);
		txtDateOfProvisional.sendKeys(dateOfProvisional);
		txtPanNo.sendKeys(panNo);
		JavaScriptManuplator.selectOptionFromDropDown(selectRecruiterName, "Aditya Pandey");
		JavaScriptManuplator.selectOptionFromDropDown(selectBGVSpoc, "Aditya Chauhan");
		txtHRDPName.sendKeys(hrdName);
		txtClientProcessName.sendKeys(clientProcessName);
		txtAddress.sendKeys(address);
		JavaScriptManuplator.javaScriptExecutor(txtDateOfJoining, "arguments[0].removeAttribute('readonly')", ldriver);
		txtDateOfJoining.sendKeys(dateOfJoining);
		JavaScriptManuplator.javaScriptExecutor(txtBusinessUnit, "arguments[0].value='Unit20'", ldriver);
		JavaScriptManuplator.javaScriptExecutor(txtDesignation, "arguments[0].value='Senior QA'", ldriver);
		JavaScriptManuplator.javaScriptExecutor(txtRoleCode, "arguments[0].value='6098'", ldriver);
		JavaScriptManuplator.javaScriptExecutor(txtBtEmailId, "arguments[0].value='btemailid@gmail.com'", ldriver);
		JavaScriptManuplator.javaScriptExecutor(txtRecordId, "arguments[0].value='6098'", ldriver);
		JavaScriptManuplator.selectOptionFromDropDown(selectRecruiterEmailId, "Aditya.Pandey@Bt.Com");
		JavaScriptManuplator.selectOptionFromDropDown(selectCeGoAheadRequired, "Not Applicable");
		JavaScriptManuplator.selectOptionFromDropDown(selectBgvSpocEmailId, "aditya.chauhan@bt.com");
		txtHrdpEmailId.sendKeys(hrdpEmailId);
		txtCandidateId.sendKeys(candidateId);
		txtComments.sendKeys(comments);
		JavaScriptManuplator.javaScriptExecutor(clickOnSignOffReceivedRadioYesBtn, "arguments[0].click()", ldriver);
		JavaScriptManuplator.javaScriptExecutor(clickAddCaseBtn, "arguments[0].scrollIntoView(true);",
				ldriver);
		wait = new WebDriverWait(ldriver, 60);
		wait.until(ExpectedConditions.visibilityOf(clickAddCaseBtn));
		JavaScriptManuplator.javaScriptExecutor(clickAddCaseBtn, "arguments[0].click()", ldriver);
		Thread.sleep(2000);
	}

	// Case detail has been saved successfully. 2325-007433
	public String verifyCaseDetailsSavedSuccessfullyMsg() {
		wait = new WebDriverWait(ldriver, 120);
		wait.until(ExpectedConditions.visibilityOf(verifyCaseDetailsSavedSuccessfullyMessage));
		try {
			File output = new File("BridgeCaseArsNo.txt");
			FileWriter writer = new FileWriter(output);
			writer.write(verifyCaseDetailsSavedSuccessfullyMessage.getText());
			writer.flush();
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return verifyCaseDetailsSavedSuccessfullyMessage.getText();
	}

	// Highlighter Allocator-- User Admin Role
	public void selectAdminUserRoleHighlighterAllocator() throws InterruptedException {
		JavaScriptManuplator.waitForElementPresent(ldriver, selectHighlighterAllocator, 120);
		JavaScriptManuplator.selectOptionFromDropDown(selectHighlighterAllocator, "Highlighter Allocator");
		Thread.sleep(3000);
		clickOnDashboardModule.click();
		// List of processed Cases
		JavaScriptManuplator.waitForElementPresent(ldriver, verifyListOfProcessedCases, 60);
		Thread.sleep(2000);
		JavaScriptManuplator.javaScriptExecutor(clickOnLoadResultLink, "arguments[0].click()", ldriver);
		// How many rows in table
		int rows = ldriver
				.findElements(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[2]/table[1]/tbody[1]/tr"))
				.size();                
		// Get Client name, and clicked on British Telecom count number.
		for (int r = 1; r <= rows; r++) {
			String clientName = ldriver.findElement(By
					.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[2]/table[1]/tbody[1]/tr[" + r +"]/td[2]"))
					.getText();
			if (clientName.contains("British Telecom ( Normal Client )")) {

				WebElement element = ldriver.findElement(
						By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[2]/table[1]/tbody[1]/tr[" + r
								+ "]/td[13]/a[1]"));
				Thread.sleep(1000);
				element.click();
				break;
			}
		}

		// Allocate Cases Detail
		JavaScriptManuplator.waitForElementPresent(ldriver, verifyAllocateCasesDetail, 60);
		JavaScriptManuplator.javaScriptExecutor(checkAllocateCaseOfCheckBox, "arguments[0].click()", ldriver);
		JavaScriptManuplator.javaScriptExecutor(selectAssignToHighlighterName, "arguments[0].scrollIntoView(true);",
				ldriver);
		JavaScriptManuplator.waitForElementPresent(ldriver, selectAssignToHighlighterName, 60);
		JavaScriptManuplator.selectOptionFromDropDown(selectAssignToHighlighterName, "Shariq Abbas");
		clickOnSubmitBtn.click();
		Thread.sleep(1000);
	}

	// Case is successfully allocated to highlighter.
	public String verifySuccessfullyAllocatedMsg() {
		JavaScriptManuplator.waitForElementPresent(ldriver, verifySuccessfullyAllocatedMessage, 120);
		return verifySuccessfullyAllocatedMessage.getText();
	}

	// Highlighter-- User Admin Role
	public void selectUserAdminRoleHighlighter() throws InterruptedException {
		JavaScriptManuplator.waitForElementPresent(ldriver, selectUserAdminRoleHighlighter, 120);
		JavaScriptManuplator.selectOptionFromDropDown(selectUserAdminRoleHighlighter, "Highlighter");
		Thread.sleep(3000);
		clickOnDashboardModule.click();
		// List of processed Cases
		JavaScriptManuplator.waitForElementPresent(ldriver, verifyListOfAssignCasesWithAgeing, 60);
		Thread.sleep(2000);
		JavaScriptManuplator.javaScriptExecutor(clickOnLoadResultHighliter, "arguments[0].click()", ldriver);
		// How many rows in table
		int rows = ldriver
				.findElements(
						By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[2]/form[1]/table[1]/tbody[1]/tr"))
				.size();
		// Get Client name, and clicked on British Telecom count number.
		for (int r = 1; r <= rows; r++) {
			String clientName = ldriver.findElement(
					By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[2]/form[1]/table[1]/tbody[1]/tr[" + r
							+ "]/td[2]"))
					.getText();
			if (clientName.equals("British Telecom")) {

				WebElement element = ldriver.findElement(
						By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[2]/form[1]/table[1]/tbody[1]/tr[" + r
								+ "]//td[11]/a[1]"));
				Thread.sleep(2000);
				element.click();
				break;
			}
		}
		// Highlighter -- Details Listing
		JavaScriptManuplator.waitForElementPresent(ldriver, selectActionTopsheet, 60);
		JavaScriptManuplator.selectOptionFromDropDown(selectActionTopsheet, "Topsheet");
		Thread.sleep(1000);
	}

	// Highlighter-- Add Details
	public void highlighterAddDetails(String creditDefault, String indianDatabaseCheck, String previousEmpCheck,
			String criminalRecordsCheck, String educationWCheck, String indiaCourtCheck, String nationalCheck,
			String professionalCheck, String uploadDoc, String clientEmailDoc, String escalationComment,
			String caseLevelComments) throws InterruptedException {
		JavaScriptManuplator.waitForElementPresent(ldriver, verifyCaseClientName, 60);
		JavaScriptManuplator.selectOptionFromDropDown(selectClientLocation, "Gurgaon");
		JavaScriptManuplator.selectOptionFromDropDown(selectSelectProcess, "Check Wise");
		// Check(s) -- Add Details
		JavaScriptManuplator.javaScriptExecutor(clickOnCurrentAddressVerificationCheck, "arguments[0].click()",
				ldriver);
		//wait = new WebDriverWait(ldriver, 120);
		//wait.until(ExpectedConditions.visibilityOf(currentAddressComments));
		//JavaScriptManuplator.javaScriptExecutor(currentAddressComments, "arguments[0].value='Comments are good'", ldriver);
		// Upload Documents
		uploadDocument.sendKeys(uploadDoc);
		uploadClientEmailDoc.sendKeys(clientEmailDoc);
		JavaScriptManuplator.javaScriptExecutor(clickOnAddCaseBtn, "arguments[0].scrollIntoView(true);", ldriver);
		JavaScriptManuplator.waitForElementPresent(ldriver, clickOnAddCaseBtn, 60);
		txtEscalationComment.sendKeys(escalationComment);
		txtCaseLevelComments.sendKeys(caseLevelComments);
		clickOnAddCaseBtn.click();
		Thread.sleep(2000);
	}

	// Top sheet is successfully created. You can now proceed with checks creation
	// for the given candidate.
	public String verifyTopsheetSuccessfullyCreatedMsg() {
		wait = new WebDriverWait(ldriver, 120);
		wait.until(ExpectedConditions.visibilityOf(verifyTopsheetSuccessfullyCreatedMesage));
		return verifyTopsheetSuccessfullyCreatedMesage.getText();
	}

	// Documentation Specialist
	public void selectUserAdminRoleDocumentationSpecialist() throws IOException, InterruptedException {
		JavaScriptManuplator.waitForElementPresent(ldriver, selectUserRoleDocumentationSpecialist, 120);
		JavaScriptManuplator.selectOptionFromDropDown(selectUserRoleDocumentationSpecialist,
				"Documentation Specialist");
		Thread.sleep(3000);
		clickOnDashboardModule.click();
		JavaScriptManuplator.waitForElementPresent(ldriver, verifyListOfAssignCasesWithAgeing, 60);
		// How many rows in table
		int rows = ldriver
				.findElements(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[2]/div[2]/table[1]/tbody[1]/tr"))
				.size();
		// Get Client name, and clicked on British Telecom count number.
		for (int r = 1; r <= rows; r++) {
			String companyName = ldriver.findElement(By
					.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[2]/div[2]/table[1]/tbody[1]/tr[" + r + "]/td[2]"))
					.getText();
			if (companyName.equals("British Telecom")) {

				WebElement element = ldriver.findElement(
						By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[2]/div[2]/table[1]/tbody[1]/tr[" + r
								+ "]//td[3]/a[1]"));
				element.click();
				break;
			}
		}
	}

	// British Telecom - Specialist Pending Cases
	@SuppressWarnings("unlikely-arg-type")
	public void specialistPendingCases() throws IOException, InterruptedException {
		JavaScriptManuplator.waitForElementPresent(ldriver, verifyBritishTelecomSpecialistPendingCasesText, 120);
		String data = new String(Files.readAllBytes(Paths.get("BridgeCaseArsNo.txt")));
		String arsNumber[] = data.split(" ");
		// Find How many rows exists in each pages.
		String totalCaseRecords = getCasesTotalRecords.getText();
		totalCaseRecords = totalCaseRecords.split("-")[1];
		int noOfPage = Integer.parseInt(totalCaseRecords.trim()) / 50;
		if (Integer.parseInt(totalCaseRecords.trim()) % 50 > 0) {
			noOfPage = noOfPage + 1;
		}
		boolean isElementFound = false;
		for (int p = 1; p <= noOfPage; p++) {
			WebElement active_page = ldriver.findElement(By.xpath("//span[@class='current']"));
			active_page.click();
			int rows = ldriver
					.findElements(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[2]/table[1]/tbody[1]/tr"))
					.size();
			// Read all the rows from each page
			for (int r = 1; r <= (rows - 1); r++) {
				String arsNumbers = ldriver.findElement(By.xpath(
						"/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[2]/table[1]/tbody[1]/tr[" + r + "]/td[3]"))
						.getText();

				if (arsNumbers.equals(arsNumber[6])) {
					WebElement element = ldriver.findElement(
							By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[2]/table[1]/tbody[1]/tr[" + r
									+ "]/td[8]/a[1]"));
					Thread.sleep(2000);
					JavaScriptManuplator.javaScriptExecutor(element, "arguments[0].click()", ldriver);
					isElementFound = true;
					break;
				}
			}
			if (isElementFound) {
				break;
			}
			String pageNo = Integer.toString(p + 1);
			// ldriver.findElement(By.xpath("//tbody/tr[51]/td[1]/div[1]/span["+(p+2)+"]/a[1]")).click();
			ldriver.findElement(By.xpath("//div[@class='pagination']//span//a[text()='" + pageNo + "']")).click();
		}
	}

	// Documentation Specialist-- Candidate Details
	public void docSpecialistCandidateDetails() throws InterruptedException {
		JavaScriptManuplator.waitForElementPresent(ldriver, txtAliasFname, 60);
		JavaScriptManuplator.javaScriptExecutor(txtAliasFname, "arguments[0].value='Raju'", ldriver);
		JavaScriptManuplator.javaScriptExecutor(txtAliasLname, "arguments[0].value='Yadav'", ldriver);
		JavaScriptManuplator.javaScriptExecutor(checkGenderMale, "arguments[0].click()", ldriver);
		// Client Specific Fields
		JavaScriptManuplator.javaScriptExecutor(txtClientSpecificEin, "arguments[0].scrollIntoView(true);", ldriver);
		JavaScriptManuplator.waitForElementPresent(ldriver, txtClientSpecificEin, 60);
		JavaScriptManuplator.javaScriptExecutor(txtClientSpecificEin, "arguments[0].value='12345678'", ldriver);
		JavaScriptManuplator.javaScriptExecutor(txtClientSpecificDateOfJoining, "arguments[0].value='2-Mar-2021'",
				ldriver);
		JavaScriptManuplator.javaScriptExecutor(txtClientSpecificDob, "arguments[0].value='04-04-1991'", ldriver);
		JavaScriptManuplator.javaScriptExecutor(txtClientSpecificBusinessUnit, "arguments[0].value='Unit123'", ldriver);
		JavaScriptManuplator.selectOptionFromDropDown(selectClientSpecificOUC, "BEA1");
		JavaScriptManuplator.javaScriptExecutor(txtClientSpecificDesination, "arguments[0].value='Senior QA'", ldriver);
		JavaScriptManuplator.javaScriptExecutor(txtClientSpecificLineManager, "arguments[0].value='Sunil Kumar'",
				ldriver);
		JavaScriptManuplator.javaScriptExecutor(txtClientSpecificRoleCode, "arguments[0].value='6098'", ldriver);
		JavaScriptManuplator.javaScriptExecutor(txtClientSpecificLegalEntity, "arguments[0].value='Legal Entity'",
				ldriver);
		JavaScriptManuplator.javaScriptExecutor(txtClientSpecificBtClientEmailId,
				"arguments[0].value='bt123@gmail.com'", ldriver);
		JavaScriptManuplator.javaScriptExecutor(txtClientDateOfProvisional, "arguments[0].value='03-04-2020'", ldriver);
		JavaScriptManuplator.javaScriptExecutor(txtClientSpecificRecordId, "arguments[0].scrollIntoView(true);",
				ldriver);
		JavaScriptManuplator.waitForElementPresent(ldriver, txtClientSpecificRecordId, 60);
		JavaScriptManuplator.javaScriptExecutor(txtClientSpecificRecordId, "arguments[0].value='6098'", ldriver);
		JavaScriptManuplator.javaScriptExecutor(txtClientSpecificPanNumber, "arguments[0].value='AKSPY4173C'", ldriver);
		JavaScriptManuplator.selectOptionFromDropDown(selectClientSpecificRecruiterEmailId, "Aditya.Pandey@Bt.Com");
		JavaScriptManuplator.selectOptionFromDropDown(selectClientSpecificRecruiterName, "Aditya Pandey");
		JavaScriptManuplator.selectOptionFromDropDown(selectClientSpecificCeoGoAhead, "Not Applicable");
		JavaScriptManuplator.selectOptionFromDropDown(selectCleintSpecificBGVSpoc, "Aditya Chauhan");
		JavaScriptManuplator.selectOptionFromDropDown(selectBGVSpocEmailID, "aditya.chauhan@bt.com");
		JavaScriptManuplator.javaScriptExecutor(txtClientSpecificHrdpName, "arguments[0].value='Ashish Kumar'",
				ldriver);
		JavaScriptManuplator.javaScriptExecutor(txtClientSpecificHrdpEmail, "arguments[0].value='hrdp12@gmail.com'",
				ldriver);
		JavaScriptManuplator.javaScriptExecutor(txtClientSpecifClientPoccessName, "arguments[0].scrollIntoView(true);",
				ldriver);
		JavaScriptManuplator.waitForElementPresent(ldriver, txtClientSpecifClientPoccessName, 60);
		JavaScriptManuplator.javaScriptExecutor(txtClientSpecifClientPoccessName, "arguments[0].value='Amit Singh'",
				ldriver);
		JavaScriptManuplator.javaScriptExecutor(txtClientSpecificCandidateId, "arguments[0].value='6098'", ldriver);
		JavaScriptManuplator.javaScriptExecutor(txtClientSpecificAddress, "arguments[0].value='Gurgaow'", ldriver);
		JavaScriptManuplator.javaScriptExecutor(ClickOnClientSpecificAddCondidateBtn, "arguments[0].click()", ldriver);
		// Confirm availability of Following Documents:
		JavaScriptManuplator.javaScriptExecutor(txtAuthorizationReleaseNote, "arguments[0].scrollIntoView(true);",
				ldriver);
		JavaScriptManuplator.waitForElementPresent(ldriver, txtAuthorizationReleaseNote, 60);
		JavaScriptManuplator.javaScriptExecutor(txtAuthorizationReleaseNote, "arguments[0].value='1'", ldriver);
		JavaScriptManuplator.javaScriptExecutor(txtApplicationForm, "arguments[0].value='3'", ldriver);
		JavaScriptManuplator.javaScriptExecutor(txtCaseComments,
				"arguments[0].value='Case Details Comments added Successfully'", ldriver);
		JavaScriptManuplator.javaScriptExecutor(clickOnCaseDetailsAddCaseBtn, "arguments[0].click()", ldriver);
		Thread.sleep(1000);
		ldriver.navigate().refresh();
		Thread.sleep(2000);
	}

	// Documentation Specialist-- Add Check Details
	// Current Address Verification
	public void currentAddressVerification() throws InterruptedException {
		JavaScriptManuplator.waitForElementPresent(ldriver, clickOnCurrentAddressVerification, 60);
		JavaScriptManuplator.javaScriptExecutor(clickOnCurrentAddressVerification, "arguments[0].click()", ldriver);
		WebElement addressCityName = ldriver.findElement(By.xpath("//input[@id='unique_city']"));
		try {
			addressCityName.clear();
			Thread.sleep(2000);
		} catch (StaleElementReferenceException e) {
			Thread.sleep(2000);
			addressCityName.sendKeys("Luxembourg");
		}
		addressCityName.sendKeys("Luxembourg");
		Thread.sleep(2000);
		String addressCity;
		do {
			addressCityName.sendKeys(Keys.ARROW_DOWN);
			addressCity = addressCityName.getAttribute("value");
			if (addressCity.equals("Luxembourg (city), Luxembourg")) {
				addressCityName.sendKeys(Keys.ENTER);
				break;
			}
			Thread.sleep(2000);
		} while (!addressCity.isEmpty());
		Thread.sleep(2000);
		JavaScriptManuplator.javaScriptExecutor(txtCurrentAddressContactNo, "arguments[0].value='8989897878'", ldriver);
		JavaScriptManuplator.javaScriptExecutor(txtCurrentAddress, "arguments[0].value='Gurgaon'", ldriver);
		JavaScriptManuplator.javaScriptExecutor(txtCurrentAddressPinCode, "arguments[0].value='110091'", ldriver);
		JavaScriptManuplator.javaScriptExecutor(txtCurrentAddressPeriodOfStay, "arguments[0].value='02-02-2020'",
				ldriver);
		JavaScriptManuplator.javaScriptExecutor(txtCurrentAddressChecksComment, "arguments[0].scrollIntoView(true);",
				ldriver);
		JavaScriptManuplator.waitForElementPresent(ldriver, txtCurrentAddressChecksComment, 60);
		JavaScriptManuplator.javaScriptExecutor(txtCurrentAddressChecksComment, "arguments[0].value='Good Comments'",
				ldriver);
		JavaScriptManuplator.javaScriptExecutor(clickOnCurrentAddressSaveCheckBtn, "arguments[0].click()", ldriver);
		Thread.sleep(2000);
		ldriver.navigate().refresh();
		Thread.sleep(2000);
	}

	// Permanent Address Verification
	public void permanentAddressVerificationCheck() throws InterruptedException {
		JavaScriptManuplator.waitForElementPresent(ldriver, clickOnPermanentAddressVerification, 60);
		JavaScriptManuplator.javaScriptExecutor(clickOnPermanentAddressVerification, "arguments[0].click()", ldriver);
		WebElement permanentCityName = ldriver.findElement(By.xpath("//input[@id='unique_city']"));
		permanentCityName.clear();
		Thread.sleep(3000);
		permanentCityName.sendKeys("Dadri");
		String permanentCity;
		do {
			permanentCityName.sendKeys(Keys.ARROW_DOWN);
			permanentCity = permanentCityName.getAttribute("value");
			if (permanentCity.equals("Dadri, Uttar Pradesh, India")) {
				permanentCityName.sendKeys(Keys.ENTER);
				break;
			}
			Thread.sleep(2000);
		} while (!permanentCity.isEmpty());
		Thread.sleep(2000);
		JavaScriptManuplator.javaScriptExecutor(txtPermanentAddressNewConatactNo, "arguments[0].value='8989787878'",
				ldriver);
		JavaScriptManuplator.javaScriptExecutor(txtPermanentAddress, "arguments[0].value='Gurgaon'", ldriver);
		JavaScriptManuplator.javaScriptExecutor(txtPermanentAddressPinCode, "arguments[0].value='110091'", ldriver);
		Thread.sleep(1000);
		JavaScriptManuplator.javaScriptExecutor(txtPermanentAddressPeriodOfStayDate, "arguments[0].value='02-03-2000'",
				ldriver);
		JavaScriptManuplator.javaScriptExecutor(txtPermanentAddressCheckComments, "arguments[0].scrollIntoView(true);",
				ldriver);
		JavaScriptManuplator.waitForElementPresent(ldriver, txtPermanentAddressCheckComments, 60);
		JavaScriptManuplator.javaScriptExecutor(txtPermanentAddressCheckComments, "arguments[0].value='Good Comments'",
				ldriver);
		JavaScriptManuplator.javaScriptExecutor(clickOnPermanentAddressSaveCheckBtn, "arguments[0].click()", ldriver);
		Thread.sleep(2000);
		ldriver.navigate().refresh();
		Thread.sleep(2000);
	}

	// Check details are successfully saved. Case is Completed.
	public String verifyCheckDetailsSuccessfullyMsg() {
		JavaScriptManuplator.waitForElementPresent(ldriver, verifyCheckDetailsSuccessfullyMessage, 60);
		return verifyCheckDetailsSuccessfullyMessage.getText();
	}

	// Verify Docs Qc Allocator-- Bridge Portal
	public void superAdminDocsQcAllocator() throws InterruptedException, IOException {
		JavaScriptManuplator.waitForElementPresent(ldriver, selectDocsQcAllocator, 120);
		JavaScriptManuplator.selectOptionFromDropDown(selectDocsQcAllocator, "Docs QC Allocator");
		Thread.sleep(3000);
		clickOnDashboardModule.click();
		// Adding New Code started
		wait = new WebDriverWait(ldriver, 60);
		wait.until(ExpectedConditions.visibilityOf(verifyNotificationAlerts));
		JavaScriptManuplator.javaScriptExecutor(clickOnLoadResult, "arguments[0].click()", ldriver);
		
		wait = new WebDriverWait(ldriver, 60);
		wait.until(ExpectedConditions.visibilityOf(clickOniBridgeCountAll));
		JavaScriptManuplator.javaScriptExecutor(clickOniBridgeCountAll, "arguments[0].click()", ldriver);
		Thread.sleep(1000);
		String data = new String(Files.readAllBytes(Paths.get("BridgeCaseArsNo.txt")));
		String arsNumber[] = data.split(" ");
		JavaScriptManuplator.javaScriptExecutor(txtEnterArsSearch, "arguments[0].value='"+arsNumber[6]+"'",
				ldriver);
		JavaScriptManuplator.javaScriptExecutor(clickOnSearchBtn, "arguments[0].click()", ldriver);
		// Adding New Code ended
		
		//JavaScriptManuplator.waitForElementPresent(ldriver, verifyBritishTelecom, 60);

		/*// How many rows in table
		int rows = ldriver
				.findElements(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[2]/div[2]/table[1]/tbody[1]/tr"))
				.size();
		// Get Client name, and clicked on British Telecom count number.
		for (int r = 1; r <= rows; r++) {
			String companyName = ldriver.findElement(By
					.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[2]/div[2]/table[1]/tbody[1]/tr[" + r + "]/td[1]"))
					.getText();
			if (companyName.equals("British Telecom")) {

				WebElement element = ldriver.findElement(
						By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[2]/div[2]/table[1]/tbody[1]/tr[" + r
								+ "]//td[9]/a[1]"));
				element.click();
				break;
			}
		}*/

		JavaScriptManuplator.waitForElementPresent(ldriver, checkBoxCheckedClientCaseAll, 60);
		JavaScriptManuplator.javaScriptExecutor(checkBoxCheckedClientCaseAll, "arguments[0].click()", ldriver);
		// checkBoxCheckedBritishTelecom.click();
		JavaScriptManuplator.selectOptionFromDropDown(selectCaseMasterBulkActionTaken, "Assign to QC Team Member");
		JavaScriptManuplator.waitForElementPresent(ldriver, selectDdlCasesAssignedTo, 60);
		JavaScriptManuplator.selectOptionFromDropDown(selectDdlCasesAssignedTo, "Shariq Abbas");
		clickOnGoBtn.click();
		JavaScriptManuplator.waitForElementPresent(ldriver, clickOnActionConfAlertYesBtn, 60);
		clickOnActionConfAlertYesBtn.click();
		Thread.sleep(1000);
	}

	public String verifyCaseSuccessAllocatedMsg() {
		JavaScriptManuplator.waitForElementPresent(ldriver, verifyCaseSuccessfullyAllocated, 60);
		return verifyCaseSuccessfullyAllocated.getText();
	}

	// Verify Docs Quality-- Bridge Portal
	public void superAdminDocsQuality(String arsNumber) throws InterruptedException {
		JavaScriptManuplator.waitForElementPresent(ldriver, selectDocsQcQuality, 120);
		JavaScriptManuplator.selectOptionFromDropDown(selectDocsQcQuality, "Docs Quality");
		// Select docsQcQuality = new Select(selectDocsQcQuality);
		// docsQcQuality.selectByIndex(25);
		Thread.sleep(3000);
		clickOnDashboardModule.click();
		wait = new WebDriverWait(ldriver, 240);
		wait.until(ExpectedConditions.visibilityOf(verifyCasesforQualityReview));
		clickOnDocQualityCases.click();
		WebElement element = ldriver.findElement(By.xpath("//a[contains(text(),'Search Case')]"));
		Actions action = new Actions(ldriver);
		action.moveToElement(element).click().perform();
		wait = new WebDriverWait(ldriver, 60);
		wait.until(ExpectedConditions.visibilityOf(txtArsNumber));
		txtArsNumber.sendKeys(arsNumber);
		clickOnSearchCaseBtn.click();
		wait = new WebDriverWait(ldriver, 60);
		wait.until(ExpectedConditions.visibilityOf(selectActionReviewForQuality));
		Select actionReviewForQuality = new Select(selectActionReviewForQuality);
		actionReviewForQuality.selectByIndex(3);
		wait = new WebDriverWait(ldriver, 60);
		wait.until(ExpectedConditions.visibilityOf(clickOnActionConfirmationAlertYesBtn));
		clickOnActionConfirmationAlertYesBtn.click();
		Thread.sleep(1000);
	}

	public String verifyCaseQCReviewArsNumber() {
		JavaScriptManuplator.waitForElementPresent(ldriver, verifyCaseQCReviewArsNumber, 60);
		return verifyCaseQCReviewArsNumber.getText();
	}

	// Check Type -- (QC Done)--Checks Summary)
	public void verifyQcDoneChecksSummary(String caseComments, String noOfChecks, String caseComment)
			throws InterruptedException {
		// Current Address Verification-- Check Type (QC Done)Checks Summary
		js = (JavascriptExecutor) ldriver;
		js.executeScript("arguments[0].scrollIntoView(true);", clickOnCurrentAddressQcDoneImg);
		wait = new WebDriverWait(ldriver, 60);
		wait.until(ExpectedConditions.visibilityOf(clickOnCurrentAddressQcDoneImg));
		js = (JavascriptExecutor) ldriver;
		js.executeScript("arguments[0].click()", clickOnCurrentAddressQcDoneImg);

		js = (JavascriptExecutor) ldriver;
		js.executeScript("arguments[0].scrollIntoView(true);", clickOnCurrentAddressMarkAsDQCDone);
		wait = new WebDriverWait(ldriver, 60);
		wait.until(ExpectedConditions.visibilityOf(clickOnCurrentAddressMarkAsDQCDone));
		js = (JavascriptExecutor) ldriver;
		js.executeScript("arguments[0].click()", clickOnCurrentAddressMarkAsDQCDone);

		// QC Check list-- Correct Client & location selected
		Select correctClient = new Select(selectCorrectClient);
		correctClient.selectByIndex(2);

		Select correctProcessMapped = new Select(selectCorrectProcessMapped);
		correctProcessMapped.selectByIndex(2);

		Select clientSpecificFields = new Select(selectClientSpecificFields);
		clientSpecificFields.selectByIndex(2);

		Select candidateDetailsMapped = new Select(selectCandidateDetailsMapped);
		candidateDetailsMapped.selectByIndex(2);

		Select checksRaisedCorrectly = new Select(selectChecksRaisedCorrectly);
		checksRaisedCorrectly.selectByIndex(2);

		Select readCsisInstructions = new Select(selectReadCsisInstructions);
		readCsisInstructions.selectByIndex(2);
		txtNoOfChecks.sendKeys(noOfChecks);
		clickOnQcCheckListBtn.click();

		// Case QC - Review --Checks Summary-------Success Page
		js = (JavascriptExecutor) ldriver;
		js.executeScript("arguments[0].scrollIntoView(true);", clickOnReviewBtnCheck);
		Thread.sleep(1000);
		js = (JavascriptExecutor) ldriver;
		js.executeScript("arguments[0].value='Testuser'", txtCaseLevelCommentCheck);
		Select releseForVerificationCheck = new Select(selectReleseForVerificationCheck);
		releseForVerificationCheck.selectByIndex(2);
		clickOnReviewBtnCheck.click();
		Thread.sleep(1000);
	}

	// The Case was successfully released for Verification.
	public String verifyReleasedForVerificationMsg() {
		wait = new WebDriverWait(ldriver, 60);
		wait.until(ExpectedConditions.visibilityOf(verifyReleasedForVerificationMessage));
		return verifyReleasedForVerificationMessage.getText();
	}

	// Allocator-- (Super Admin)-- Bridge Portal
	public void superAdminAllocator(String arsNumberAllocator, String checkComments) throws InterruptedException {
		wait = new WebDriverWait(ldriver, 120);
		wait.until(ExpectedConditions.visibilityOf(selectSuperAdminAllocator));
		JavaScriptManuplator.selectOptionFromDropDown(selectSuperAdminAllocator, "Allocator");
		Thread.sleep(3000);
		clickOnDashboardModule.click();
		wait = new WebDriverWait(ldriver, 540);
		wait.until(ExpectedConditions.visibilityOf(verifyEmploymentUan));
		txtArsNumberAllocator.sendKeys(arsNumberAllocator);
		clickOnSearchAllocatorBtn.click();

		wait = new WebDriverWait(ldriver, 60);
		wait.until(ExpectedConditions.visibilityOf(clickOnApplicableCountNumber));
		clickOnApplicableCountNumber.click();

		// Check List - Search Result - (14 records)
		wait = new WebDriverWait(ldriver, 60);
		wait.until(ExpectedConditions.visibilityOf(checkAllCheckBoxCandidate));
		checkAllCheckBoxCandidate.click();

		js = (JavascriptExecutor) ldriver;
		js.executeScript("arguments[0].scrollIntoView(true);", selectAssignToVerifier);
		Select assignToVerifierName = new Select(selectAssignToVerifier);
		assignToVerifierName.selectByIndex(2);
		txtCheckComments.sendKeys(checkComments);
		Thread.sleep(1000);
		clickOnGoAllocatorBtn.click();
		Thread.sleep(1000);
		wait = new WebDriverWait(ldriver, 60);
		wait.until(ExpectedConditions.visibilityOf(clickOnConfirmationYesBtn));
		clickOnConfirmationYesBtn.click();
		Thread.sleep(1000);
	}

	// Check id=9601540 is Not Released, DueTo, Already released to vendor..
	public String verifyChecksSuccessfullyMsg() {
		wait = new WebDriverWait(ldriver, 60);
		wait.until(ExpectedConditions.visibilityOf(verifyAlreadyReleasedToVendorMsg));
		try {
			File output = new File("CaseCheckId.txt");
			FileWriter writer = new FileWriter(output);
			writer.write(verifyAlreadyReleasedToVendorMsg.getText());
			System.out.println("Raju=======" + verifyAlreadyReleasedToVendorMsg);
			writer.flush();
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return verifyAlreadyReleasedToVendorMsg.getText();
	}

	public String verifyAllocatorArsNumber() {
		wait = new WebDriverWait(ldriver, 60);
		wait.until(ExpectedConditions.visibilityOf(verifyArsNumber));
		try {
			File output = new File("CaseCheckId.txt");
			FileWriter writer = new FileWriter(output);
			writer.write(verifyAlreadyReleasedToVendorMsg.getText());
			writer.flush();
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return verifyArsNumber.getText();
	}
}
