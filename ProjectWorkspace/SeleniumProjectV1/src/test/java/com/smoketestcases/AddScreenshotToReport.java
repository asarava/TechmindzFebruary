package com.smoketestcases;

import java.io.IOException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.testbase.TestBase;
import com.pages.LoginPage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.utilities.Utility;
import com.wrapper.Wrapper;


public class AddScreenshotToReport extends TestBase {
	
	LoginPage loginpage;
	Wrapper objWrapperTest;
	Utility objUtilities;
	public ExtentReports extent;
	public ExtentTest extentTest;
	
	
	public AddScreenshotToReport() {
	super();
	}
	
	@BeforeTest
	public void setExtent() {
	extent = new ExtentReports(System.getProperty("user.dir") + "/test-output/ExtentReport.html", true);
	extent.addSystemInfo("Host Name", "Jintu");
	extent.addSystemInfo("User Name", "Jintu");
	extent.addSystemInfo("Environment", "Learning");
	}
	@BeforeClass
	public void setUp() {
	initialization();
	loginpage = new LoginPage();
	objWrapperTest = new Wrapper();
	objUtilities = new Utility();
	}
	
	@Test(priority = 1)

	public void ClickOnForgotPassword() {
		extentTest = extent.startTest("ClickOnForgotPassword");
		loginpage.clickForgotPassword();
		String pText = loginpage.getResetPassText();
		Assert.assertEquals(pText, "Reset Password", "Validated Click on ForgotPassword");
	}
	
	@Test(priority = 2)

	public void ClickOnCancelPassword() {
		extentTest = extent.startTest("ClickOnCancelPassword");
		loginpage.clickCancelPassword();
		String pText = loginpage.getLoginText();
		Assert.assertEquals(pText, "Login", "Validated Click on CancelPassword");
	}
	
	@Test(priority = 3)

	public void ClickOnReqLogin() {
		extentTest = extent.startTest("ClickOnReqLogin");
		loginpage.emptyUsername();
		loginpage.emptyPassword();
		loginpage.clickEmptyLogin();
		String pText = loginpage.getLoginText();
		Assert.assertEquals(pText, "Login", "Validated Click on Login Text");
	}
	
	@Test(priority = 4)

	public void ClickOnInvalidLogin() {
		extentTest = extent.startTest("ClickOnInvalidLogin");
		loginpage.clear();
		loginpage.InvalidUsername();
		loginpage.InvalidPassword();
		loginpage.clickInvalidLogin();
		String pText = loginpage.getLoginText();
		Assert.assertEquals(pText, "Login", "Validated Click on Login Text");
	}
	
	@Test(priority = 5)

	public void ClickOnLogin() {
		extentTest = extent.startTest("ClickOnLogin");
		loginpage.clear();
		loginpage.enterUsername();
		loginpage.enterPassword();
		loginpage.clickLogin();
		String pText = loginpage.getAdminText();
		Assert.assertEquals(pText, "Admin", "Validated Click on Login");	
	}
	
	@Test(priority = 6)

	public void ClickOnSearch() {
		extentTest = extent.startTest("ClickOnSearch");
		loginpage.clickSearch("Admin");
		Assert.assertEquals(loginpage.getSearchText(), "Admin");
	}
	
	@Test(priority = 10)

	public void ClickOnAdminAdd() {
		extentTest = extent.startTest("ClickOnAdminAdd");
		loginpage.clickAdminAdd();
		String pText = loginpage.getSaveText();
		Assert.assertEquals(pText, "Save", "Validated Click on Add button");
	}
	@Test(priority = 8)

	public void ClickOnAdminEdit() {
		extentTest = extent.startTest("ClickOnAdminEdit");
		loginpage.clickEditUser();
		String pText = loginpage.getSaveText();
		Assert.assertEquals(pText, "Save", "Validated Click on Add button");
	}
	
	@Test(priority = 9)

	public void ClickOnAdminUserEdit() {
		extentTest = extent.startTest("ClickOnAdminUserEdit");
		loginpage.clickEditUserAdmin();
		String pText = loginpage.getSearchuserText();
		Assert.assertEquals(pText, "Save", "Validated Click on edit button");
	}
	
	@Test(priority = 7)

	public void ClickOnSearchUser() throws InterruptedException {
		extentTest = extent.startTest("ClickOnSearchUser");
		loginpage.SearchUserRole();
		loginpage.clickSearchUser();
		String pText = loginpage.getRecordlistText();
		Assert.assertEquals(pText, "Username", "Validated Click on Search button");
	}
	
	@Test(priority = 12)

	public void ClickOnPIM() {
		extentTest = extent.startTest("ClickOnPIM");
		loginpage.clickPIM();
		String pText = loginpage.getSearchText();
		Assert.assertEquals(pText, "PIM", "Validated Click on PIM Link");
	}
	
	@Test(priority = 11)

	public void ClickOnAddUserSave() throws InterruptedException {
		extentTest = extent.startTest("ClickOnAddUserSave");
		loginpage.ClickUserRole("ESS");
		Assert.assertEquals(loginpage.getUserRole(),"ESS");
		loginpage.enterEmployeeName("Odis Adalwin");
		//Assert.assertEquals(loginpage.getEmployeeName(),"Odis Adalwin");
		loginpage.ClickStatus("Enabled");
		Assert.assertEquals(loginpage.getStatusText(),"Enabled");
		loginpage.enterAddUsername();
		loginpage.enterAddPassword();
		loginpage.enterAddConPassword();
		//loginpage.clickAdminSave();
		String pText = loginpage.getSearchuserText();
		Assert.assertEquals(pText, "Save", "Validated Click on Save button");
	}
	
	@Test(priority = 13)

	public void ClickOnAddEmployee() {
		extentTest = extent.startTest("ClickOnAddEmployee");
		loginpage.clickAddEmployee();
		String pText = loginpage.getSaveText();
		Assert.assertEquals(pText, "Save", "Validated Click on Add button");
	}
	
	@Test(priority = 14)

	public void ClickOnAddEmployeeSave() {
		extentTest = extent.startTest("ClickOnAddEmployeeSave");
		loginpage.clickEmployeeSave();
		String pText = loginpage.getAddEmployeeText();
		Assert.assertEquals(pText, "Add Employee", "Validated Click on Save button");

	}
	
	@Test(priority = 15)

	public void ClickOnEmployeeReports() {
		extentTest = extent.startTest("ClickOnEmployeeReports");
		loginpage.clickReports();
		String pText = loginpage.getEmployeeReportsText();
		Assert.assertEquals(pText, "Employee Reports", "Validated Click on Report Link");
	}
	
	@Test(priority = 16)

	public void ClickOnViewReports() {
		extentTest = extent.startTest("ClickOnViewReports");
		loginpage.clickViewReports();
		String pText = loginpage.getViewReportsText();
		Assert.assertEquals(pText, "All Employee Sub Unit Hierarchy Report", "Validated Click on Report Link");
	}
	
	@Test(priority = 17)

	public void ClickOnLeave() {
		extentTest = extent.startTest("ClickOnLeave");
		loginpage.clickLeave();
		String pText = loginpage.getSearchText();
		Assert.assertEquals(pText, "Leave", "Validated Click on leave Link");
	}
	
	@Test(priority = 18)

	public void ClickOnTime() {
		extentTest = extent.startTest("ClickOnTime");
		loginpage.clickTime();
		String pText = loginpage.getSearchText();
		Assert.assertEquals(pText, "Time", "Validated Click on Time Link");
	}
	
	@Test(priority = 19)

	public void ClickOnRecruitment() {
		extentTest = extent.startTest("ClickOnRecruitment");
		loginpage.clickRecruitment();
		String pText = loginpage.getSearchText();
		Assert.assertEquals(pText, "Recruitment", "Validated Click on Recruitment Link");
	}
	
	@Test(priority = 20)

	public void ClickOnDashboard() {
		extentTest = extent.startTest("ClickOnDashboard");
		loginpage.clickDashboard();
		String pText = loginpage.getSearchText();
		Assert.assertEquals(pText, "Dashboard", "Validated Click on Recruitment Link");
	}
	
	@Test(priority = 21)

	public void ClickOnLogout() {
		extentTest = extent.startTest("ClickOnLogout");
		loginpage.clickLogout();
		String pText = loginpage.getLoginText();
		Assert.assertEquals(pText, "Login", "Validated Click on Logout Link");
	}

	
	@AfterMethod
	public void tearDown(ITestResult result) throws IOException {
	if (result.getStatus() == ITestResult.FAILURE) {
	extentTest.log(LogStatus.FAIL, "TEST CASE FAILED IS " + result.getName());
	extentTest.log(LogStatus.FAIL, "TEST CASE FAILED IS " + result.getThrowable());
	String screenshotPath = objUtilities.getScreenshot(driver, result.getName());
	extentTest.log(LogStatus.FAIL, extentTest.addScreenCapture(screenshotPath));
	} else if (result.getStatus() == ITestResult.SKIP) {
	extentTest.log(LogStatus.SKIP, "Test Case SKIPPED IS " + result.getName());
	} else if (result.getStatus() == ITestResult.SUCCESS) {
	extentTest.log(LogStatus.PASS, "Test Case PASSED IS " + result.getName());
	String screenshotPath = objUtilities.getScreenshot(driver, result.getName());
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
