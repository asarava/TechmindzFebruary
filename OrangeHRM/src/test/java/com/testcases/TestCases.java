package com.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.beust.jcommander.WrappedParameter;
import com.pages.HomePage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.testbase.TestBase;
import com.utilities.Utility;

public class TestCases extends TestBase {

	HomePage homepage;
	Utility utilObj;
	ExtentReports extent;
	ExtentTest extentTest;

	public TestCases() {
		super();
	}

	@BeforeClass
	public void setUp() {
		initialization();
		homepage = new HomePage();
		utilObj = new Utility();
	}

	@BeforeTest
	public void setExtent() {
		extent = new ExtentReports(System.getProperty("user.dir") + "/Test-Output/ExtentReports.html", true);
		extent.addSystemInfo("Host Name", "Saravanan A");
		extent.addSystemInfo("User Name", "Shehna Abby");
		extent.addSystemInfo("Environment", "Learning");
	}

	@Test(priority = 1)
	public void loginWithBlankUserName() {
		extentTest = extent.startTest("loginWithBlankUserName");
		homepage.loginWithoutUserName();
		boolean pFlag = homepage.checkLoginButtonPresent();
		Assert.assertEquals(pFlag, true);
	}

	@Test(priority = 2)
	public void loginWithBlankPassword() {
		extentTest = extent.startTest("loginWithBlankPassword");
		homepage.loginWithoutPassword();
		boolean pFlag = homepage.checkLoginButtonPresent();
		Assert.assertEquals(pFlag, true);
	}

	@Test(priority = 3)
	public void loginWithInvalidUsername() {
		extentTest = extent.startTest("loginFailureWithInvalidUsername");
		homepage.loginWithInvalidUsername();
		boolean pFlag = homepage.checkLoginButtonPresent();
		Assert.assertEquals(pFlag, true);
	}

	@Test(priority = 4)
	public void loginWithInvalidPassword() {
		extentTest = extent.startTest("loginWithInvalidPassword");
		homepage.loginWithInvalidPwd();
		boolean pFlag = homepage.checkLoginButtonPresent();
		Assert.assertEquals(pFlag, true);
	}

	@Test(priority = 5)
	public void loginWithValidUsernameAndPassword() {
		extentTest = extent.startTest("loginWithValidUsernameAndPassword");
		homepage.loginWithUserNameAndPwd();
		boolean pFlag = homepage.checkSearchIconPresent();
		Assert.assertEquals(pFlag, true);
	}

	@Test(priority = 6)
	public void clickOnAdminLink() {
		extentTest = extent.startTest("clickOnAdminLink");
		//homepage.loginWithUserNameAndPwd();
		homepage.clickOnAdminLink();
		String pText = homepage.getInnerText();
		Assert.assertEquals(pText, "System Users");
	}

	@Test(priority = 7)
	public void clickOnPIMLink() {
		extentTest = extent.startTest("clickOnPIMLink");
		//homepage.loginWithUserNameAndPwd();
		homepage.clickOnPIMLink();
		String pText = homepage.getInnerText();
		Assert.assertEquals(pText, "Employee Information");
	}

	@Test(priority = 8)
	public void clickOnLeaveLink() {
		extentTest = extent.startTest("clickOnLeaveLink");
		//homepage.loginWithUserNameAndPwd();
		homepage.clickOnLeaveLink();
		String pText = homepage.getInnerText();
		Assert.assertEquals(pText, "Leave List");
	}

	@Test(priority = 9)
	public void clickOnTimeLink() {
		extentTest = extent.startTest("clickOnTimeLink");
		//homepage.loginWithUserNameAndPwd();
		homepage.clickOnTimeLink();
		String pText = homepage.getTimePageText();
		Assert.assertEquals(pText, "Select Employee");
	}

	@Test(priority = 10)
	public void addEmployee() throws InterruptedException {
		extentTest = extent.startTest("addEmployee");
		//homepage.loginWithUserNameAndPwd();
		homepage.clickOnPIMLink();
		homepage.clickAddEmployee();
		homepage.fillEmployeeDetails("Shehna", "Abby", "1234");
		Thread.sleep(5000);
		String pText = homepage.getEmployeeNameText();
		Assert.assertEquals(pText, "Shehna Abby");
	}

	@Test(priority = 11)
	public void searchWithEmployeeName() throws InterruptedException {
		extentTest = extent.startTest("searchWithEmployeeName");
		//homepage.loginWithUserNameAndPwd();
		homepage.clickOnPIMLink();
		homepage.enterEmployeeName("sh", "Shehna Abby");
		homepage.submitUser();
		String pText = homepage.getSearchResultText();
		Assert.assertEquals(pText, "(1) Record Found");
	}

	@Test(priority = 12)
	public void searchWithEmployeeID() {
		extentTest = extent.startTest("searchWithEmployeeID");
		//homepage.loginWithUserNameAndPwd();
		homepage.clickOnPIMLink();
		homepage.enterID("1234");
		homepage.submitUser();
		String pText = homepage.getSearchResultText();
		Assert.assertEquals(pText, "(1) Record Found");
	}

	@Test(priority = 13)
	public void addUserInAdmin() throws InterruptedException {
		extentTest = extent.startTest("addUserInAdmin");
		//homepage.loginWithUserNameAndPwd();
		homepage.clickOnAdminLink();
		homepage.clickAddUserButton();
		homepage.selectUserRole("admin");
		homepage.enterEmployeeName("sh", "Shehna Abby");
		homepage.enterUserStatus();
		homepage.enterUserNameOrEntitle("Shehna");
		homepage.enterPassword();
		homepage.submitUser();
		boolean pFlag = homepage.searchButtonPresence();
		Assert.assertEquals(pFlag, true);
	}

	@Test(priority = 14)
	public void searchUser() throws InterruptedException {
		extentTest = extent.startTest("searchUser");
		homepage.clickOnAdminLink();
		homepage.enterUserNameOrEntitle("Shehna");
		homepage.selectUserRole("admin");
		homepage.enterEmployeeName("sh", "Shehna Abby");
		homepage.enterUserStatus();
		homepage.searchUser();
		String pText = homepage.getSearchResultText();
		Assert.assertEquals(pText, "(1) Record Found");
	}

	@Test(priority = 15)
	public void addJobTitle() throws InterruptedException {
		extentTest = extent.startTest("addJobTitle");
		// homepage.loginWithUserNameAndPwd();
		homepage.clickOnAdminLink();
		homepage.selectFromJobTab("Job Titles");
		homepage.clickAddButton();
		homepage.fillAndSubmit("Administrator", "Data Administrator");
		;
		Thread.sleep(6000);
		String pText = homepage.getJobTitleHeadingText();
		Assert.assertEquals(pText, "Job Titles");
	}

	@Test(priority = 16)
	public void addJobCategories() throws InterruptedException {
		extentTest = extent.startTest("addJobCategories");
		//homepage.loginWithUserNameAndPwd();
		homepage.clickOnAdminLink();
		homepage.selectFromJobTab("Job Categories");
		homepage.clickAddButton();
		homepage.fillAndSubmitJobCatg();
		Thread.sleep(6000);
		String pText = homepage.getJobTitleHeadingText();
		Assert.assertEquals(pText, "Job Categories");
	}

	@Test(priority = 17)
	public void addSkillQualification() throws InterruptedException {
		extentTest = extent.startTest("addSkillQualification");
		//homepage.loginWithUserNameAndPwd();
		homepage.clickOnAdminLink();
		homepage.selectQualification("skills");
		Thread.sleep(2000);
		homepage.clickAddButton();
		homepage.fillAndSubmit("Communication", "Soft Skill");
		boolean pFlag = homepage.checkAddButtonPresent();
		Assert.assertEquals(pFlag, true);
	}

	@Test(priority = 18)
	public void addLeaveEntitlement() throws InterruptedException {
		extentTest = extent.startTest("addLeaveEntitlement");
		//homepage.loginWithUserNameAndPwd();
		homepage.clickOnLeaveLink();
		homepage.selectFromEntitlementTab("Add Entitlements");
		homepage.enterEmployeeName("sh", "Shehna Abby");
		homepage.selectLeaveType();
		homepage.enterUserNameOrEntitle("3.00");
		homepage.submitUser();
		Thread.sleep(2000);
		homepage.confirmEntitlement();
		Thread.sleep(6000);
		String pText = homepage.getEntitleResultText();
		Assert.assertEquals(pText, "Total 3.00 Day(s)");
	}

	@Test(priority = 19)
	public void addCandidateForRecruitment() throws InterruptedException {
		extentTest = extent.startTest("addCandidateForRecruitment");
		//homepage.loginWithUserNameAndPwd();
		homepage.clickOnRecruitmentLink();
		homepage.clickAddButton();
		homepage.fillAndSubmitCandidateDetails();
		String pText = homepage.getCandidateResultNameText();
		Assert.assertEquals(pText, "Ram Kumar");
	}

	@Test(priority = 20)
	public void searchAndSelectFromMainMenu() {
		extentTest = extent.startTest("searchAndSelectFromMainMenu");
		//homepage.loginWithUserNameAndPwd();
		homepage.inputTextToSearch();
		String pText = homepage.getTimePageText();
		Assert.assertEquals(pText, "Select Employee");
	}

	@AfterMethod
	public void tearDown(ITestResult result) throws IOException {
		if (result.getStatus() == ITestResult.FAILURE) {

			extentTest.log(LogStatus.FAIL, "TEST CASE FAILED IS " + result.getName());
			extentTest.log(LogStatus.FAIL, "TEST CASE FAILED IS " + result.getThrowable());
			String screenshotPath = utilObj.getScreenshot(driver, result.getName());
			extentTest.log(LogStatus.FAIL, extentTest.addScreenCapture(screenshotPath));
		}

		else if (result.getStatus() == ITestResult.SKIP) {
			extentTest.log(LogStatus.SKIP, "TEST CASE SKIPPED IS " + result.getName());
		}

		else if (result.getStatus() == ITestResult.SUCCESS) {
			extentTest.log(LogStatus.PASS, "TEST CASE PASSED IS " + result.getName());
			String screenshotPath = utilObj.getScreenshot(driver, result.getName());
			extentTest.log(LogStatus.PASS, extentTest.addScreenCapture(screenshotPath));
		}

		extent.endTest(extentTest);
	}

	@AfterTest
	public void endReport() {
		extent.flush();
		extent.close();
		driver.quit();
	}

}
