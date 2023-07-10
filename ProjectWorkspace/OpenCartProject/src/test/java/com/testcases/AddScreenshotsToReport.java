package com.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.pages.HomePage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.testbase.TestBase;
import com.utilities.Utilities;
import com.wrapper.Wrapper;

public class AddScreenshotsToReport extends TestBase {
	HomePage homePage;
	Wrapper wrrobj;
	Utilities objUtilities;
	public ExtentReports extent;
	public ExtentTest extentTest;
	public AddScreenshotsToReport() {
		super();
	}
	@BeforeTest
	public void setExtent() {
	extent = new ExtentReports(System.getProperty("user.dir") + "/test-output/ExtentReport.html", true);
	extent.addSystemInfo("Host Name", "Gana mc");
	extent.addSystemInfo("User Name", "Gana mc");
	extent.addSystemInfo("Environment", "Project");
	}

	@BeforeClass
	public void setUp() {
		initialization();
		homePage = new HomePage();
		wrrobj = new Wrapper();
		objUtilities = new Utilities();
	}

	@Test(priority = 1)
	public void VerifyTheTextLogin() {
		extentTest = extent.startTest("VerifyTheTextLogin");
		String pText = homePage.getLoginText();
		Assert.assertEquals(pText, "Login");
	}
	@Test(priority = 2)
	public void VerifyLogin() {
		extentTest = extent.startTest("VerifyLogin");
		homePage.LoginUsername();
		homePage.LoginPassword();
		homePage.Login();
		boolean pFlag = homePage.checkElementVisibileByDashBoard();
		Assert.assertEquals(pFlag, true);
	}

	
	@Test(priority = 3)
	public void AddNewEmp() throws InterruptedException {
		extentTest = extent.startTest("AddNewEmp");
		homePage.clickPIM();
		Thread.sleep(4000);
		homePage.clickAdd();
		homePage.FirstName();
		homePage.MiddleName();
		homePage.LastName();
		Thread.sleep(4000);
		homePage.clickSave();
		Thread.sleep(4000);
		homePage.clickJob();
		homePage.selectJob();
		Thread.sleep(4000);
		homePage.clickSave();
		Thread.sleep(4000);
		boolean pFlag = homePage.checkElementVisibileByPersonalDetails();
		Assert.assertEquals(pFlag, true);
	}

	@Test(priority = 4)
	public void SearchEmp() throws InterruptedException {
		extentTest = extent.startTest("SearchEmp");
		homePage.clickPIM();
		homePage.SearchWithEmpName();
		Thread.sleep(4000);
		homePage.clickSearch();
		Thread.sleep(4000);
		boolean pFlag = homePage.checkElementVisibileBySearchResult();
		Assert.assertEquals(pFlag, true);
	}

	@Test(priority = 5)
	public void EditEmp() throws InterruptedException {
		extentTest = extent.startTest("EditEmp");
		homePage.clickEdit();
		// homePage.EditLastNameclear();
		Thread.sleep(4000);
		homePage.EditLastName();
		Thread.sleep(4000);
		homePage.clickEditSave();
		Thread.sleep(4000);
		homePage.clickEmployeeList();
		String pText = homePage.getLastName();
		Assert.assertEquals(pText, "Kumar");

	}

	@Test(priority = 6)
	public void deleteEmp() throws InterruptedException {
		extentTest = extent.startTest("deleteEmp");
		homePage.SearchWithEmpName();
		Thread.sleep(4000);
		homePage.clickSearch();
		homePage.clickdelete();
		Thread.sleep(4000);
		homePage.deleteAlertok();
		Thread.sleep(5000);
		boolean pFlag = homePage.checkElementVisibileAdd();
		Assert.assertEquals(pFlag, true);
	}

	@Test(priority = 7)
	public void LogOut() throws InterruptedException {
		extentTest = extent.startTest("LogOut");
		homePage.Logout();
		Thread.sleep(4000);
		boolean pFlag = homePage.checkElementVisibileByLogin();
		Assert.assertEquals(pFlag, true);
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
