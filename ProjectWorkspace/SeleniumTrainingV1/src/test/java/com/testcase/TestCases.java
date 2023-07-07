package com.testcase;

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

public class TestCases extends TestBase{

	HomePage homepage;
	Wrapper objWrapperTest;
	Utilities objUtilities;
	public ExtentReports extent;
	public ExtentTest extentTest;
	
	public TestCases() {
		super();
	}
	@BeforeTest
	public void setExtent() {
	extent = new ExtentReports(System.getProperty("user.dir") + "/test-output/ExtentReport.html", true);
	extent.addSystemInfo("Host Name", "Aswathy Paul");
	extent.addSystemInfo("User Name", "Aswathy Paul");
	extent.addSystemInfo("Environment", "Learning");
	}
	
	@BeforeClass
	public void setUp() {
		initialization();
		homepage = new HomePage();	
		objWrapperTest = new Wrapper();
		objUtilities = new Utilities();
	}
	
	@Test(priority=1)
	public void verifyNavigation() {
		extentTest = extent.startTest("verifyNavigation");
		homepage.navigateToHomePage();
	}
	
	@Test (priority=2)
	public void verifyThePageTitle() {
	extentTest = extent.startTest("verifyThePageTitle");
    String actualTitle = driver.getTitle();
    Assert.assertEquals(actualTitle, "OrangeHRM");
	}
	
	@Test(priority=3)
	public void verifyLoginPageIsDisplayedCorrectly() {
		extentTest = extent.startTest("verifyLoginPageIsDisplayedCorrectly");
		Assert.assertTrue(homepage.isUsernameFieldDisplayed());
		Assert.assertTrue(homepage.isLoginPasswordFieldDisplayed());
	    Assert.assertTrue(homepage.isLoginButtonDisplayed());
		
	}

	@Test (priority=4)
	public void LoginWithValidUsernameAndPassword() throws InterruptedException {
		Thread.sleep(5000);
		extentTest = extent.startTest("LoginWithValidUsernameAndPassword");	
		homepage.enterUsername();
		homepage.enterLoginPassword();
		homepage.clickOnLoginButton();
	}
	
    @Test (priority = 5)
    public void verifyEmployeeAdd() throws InterruptedException {
    	extentTest = extent.startTest("verifyEmployeeAdd");	
    	homepage.ClickAddEmployee();
    	String pText = homepage.getEmployeeAddedPersonalDetailsText();
    	Assert.assertEquals(pText, "Personal Details");
    }
    @Test (priority = 6)
    public void verifyTheNationalitiesListDisplayed() {
    	extentTest = extent.startTest("verifyTheNationalitiesListDisplayed");
    	homepage.ClickNationalities();
    	String pText = homepage.getNationalitiesText();
    	Assert.assertEquals(pText, "Nationalities");
    }
    @Test (priority = 7)
    public void verifytheLeaveListDisplayed() {
    	extentTest = extent.startTest("verifytheLeaveListDisplayed");
    	homepage.clickOnLeave();
    	String pText = homepage.getLeaveListText();
    	Assert.assertEquals(pText, "Leave List");
    }
    @Test (priority = 8)
    public void verifyEmployeeSearchListDisplayed() {
    	extentTest = extent.startTest("verifyEmployeeSearchListDisplayed");	
    	homepage.clickOnEmployeeList();
    	String pText = homepage.getEmployeeInformationText();
    	Assert.assertEquals(pText, "Employee Information");
    }
    @Test (priority = 9)
    public void VerifyTheVacanciesDisplayed() {
    	extentTest = extent.startTest("VerifyTheVacanciesDisplayed");
    	homepage.clickVacancies();
    	String pText = homepage.getVacanciesText();
    	Assert.assertEquals(pText, "Vacancies");
    }
    @Test (priority = 10)
    public void verifyUserInformationDisplayed() {
    	extentTest = extent.startTest("verifyUserInformationDisplayed");
    	homepage.clickOnMyInfo();
    	String pText = homepage.getPersonalDetailsText();
    	Assert.assertEquals(pText, "Personal Details");
    }
    @Test (priority = 11)
    public void verifyEmployeeReportDisplayed() {
    	extentTest = extent.startTest("verifyEmployeeReportDisplayed");
    	homepage.clickOnEmployeeReport();
    	String pText = homepage.getEmployeeReportText();
    	Assert.assertEquals(pText, "Employee Reports");
    }
	@Test (priority=12)
	public void verifySuccessfulLogout() throws InterruptedException {
		Thread.sleep(2000);
		extentTest = extent.startTest("verifySuccessfulLogout");
		Thread.sleep(000);
		homepage.ClickOnUser();
		Thread.sleep(2000);
		Assert.assertTrue(homepage.isLoginButtonDisplayed());
	}

	@Test (priority=13)
	public void LoginWithInvalidUsernameAndValidPassword() {
		extentTest = extent.startTest("LoginWithInvalidUsernameAndValidPassword");
		homepage.enterInvalidUsername();
		homepage.enterLoginPassword();
		homepage.clickOnLoginButton();
		String pText = homepage.getInvalidUsernameText();
		Assert.assertEquals(pText, "Invalid credentials");
	}
	@Test (priority=14)
	public void LoginWithValidUsernameAndInvalidPassword() {
		extentTest = extent.startTest("LoginWithValidUsernameAndInvalidPassword");
		homepage.enterUsername();
		homepage.enterInvalidPassword();
		homepage.clickOnLoginButton();
		String pText = homepage.getInvalidUsernameText();
		Assert.assertEquals(pText, "Invalid credentials");
	}
	
	@Test (priority=15)
	public void LoginWithInvalidUsernameAndInvalidPassword() {
		extentTest = extent.startTest("LoginWithInvalidUsernameAndInvalidPassword");
		homepage.enterInvalidUsername();
		homepage.enterInvalidPassword();
		homepage.clickOnLoginButton();
		String pText = homepage.getInvalidUsernameText();
		Assert.assertEquals(pText, "Invalid credentials");
	}
	
	@Test (priority=16)
	public void LoginWithBlankUsernameAndValidPassword() {
		extentTest = extent.startTest("LoginWithBlankUsernameAndValidPassword");
		homepage.enterBlankUsername();
		homepage.enterLoginPassword();
		homepage.clickOnLoginButton();
		String pText = homepage.getInvalidUsernameText();
		Assert.assertEquals(pText, "Invalid credentials");
	}
	
	@Test (priority=17)
	public void LoginWithValidUsernameAndBlankPassword() {
		extentTest = extent.startTest("LoginWithValidUsernameAndBlankPassword");
		homepage.enterUsername();
		homepage.enterBlankPassword();
		homepage.clickOnLoginButton();
		String pText = homepage.getInvalidUsernameText();
		Assert.assertEquals(pText, "Invalid credentials");
	}
	
	@Test (priority=18)
	public void LoginWithBlankUsernameAndBlankPassword() {
		extentTest = extent.startTest("LoginWithBlankUsernameAndBlankPassword");
		homepage.enterBlankUsername();
		homepage.enterBlankPassword();
		homepage.clickOnLoginButton();
		String pText = homepage.getInvalidUsernameText();
		Assert.assertEquals(pText, "Invalid credentials");
	}
	@Test (priority = 19)
	public void verifyForgotPasswordWithoutUsername() {
		extentTest = extent.startTest("verifyForgotPasswordWithoutUsername");
		homepage.clickOnResetPasswordWithouUsername();
		String pText = homepage.getResetPasswordWithoutUsernameText();
		Assert.assertEquals(pText, "Reset Password");
	}
	@Test (priority = 20)
	public void verifyForgotPassword() {
		extentTest = extent.startTest("verifyForgotPassword");
		homepage.clickOnResetPassword();
		String pText = homepage.getResetPasswordText();
		Assert.assertEquals(pText, "Reset Password link sent successfully");
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
