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
import com.testBase.TestBase;
import com.utilities.Utilities;
import com.wrapper.Wrapper;

public class AddScreenshotsToReport extends TestBase {
	HomePage homePage;
	Wrapper wrapobj;
	Utilities objUtilities;
	public ExtentReports extent;
	public ExtentTest extentTest;
	
	public AddScreenshotsToReport() {
		super();
	}
	@BeforeTest
	public void setExtent() {
	extent = new ExtentReports(System.getProperty("user.dir") + "/test-output/ExtentReport.html", true);
	extent.addSystemInfo("Host Name", "Ranjima PV");
	extent.addSystemInfo("User Name", "Ranjima PV");
	extent.addSystemInfo("Environment", "Project");
	}

	@BeforeClass
	public void setUp() {
		initialization();
		homePage = new HomePage();
		wrapobj = new Wrapper();
		objUtilities = new Utilities();
	}


@Test(priority=1)
public void ViewLoginButton()  {
extentTest = extent.startTest("ViewLoginButton");
homePage.checkLogin();
String pText=homePage.getLoginText();
Assert.assertEquals(pText,"Login");
boolean pFlag=homePage.checkLoginVisible();
Assert.assertEquals(pFlag,true);
}

@Test(priority=2)
public void ViewTitle() {
  extentTest = extent.startTest("ViewTitle");
  homePage.checkTitle();
  boolean pFlag=homePage.checkTitleVisible();
  Assert.assertEquals(pFlag,true);
	}

@Test(priority=3)
public void ViewUserPW() {
	extentTest = extent.startTest("ViewUserPW");
	homePage.checkUsername();
	homePage.checkPassword();
	String pText=homePage.getViewUsernameText();
	Assert.assertEquals(pText,"Username : Admin");
	boolean pFlag=homePage.checkViewUsernameVisible();
	Assert.assertEquals(pFlag,true);
	String pText1=homePage.getViewPasswordText();
	Assert.assertEquals(pText1,"Password : admin123");
	boolean pFlag1=homePage.checkViewPasswordVisible();
	Assert.assertEquals(pFlag1,true);
			
}

@Test(priority=4)
public void ClickOnFPassword() {
	extentTest = extent.startTest("ClickOnFPassword");
	homePage.clickFPassword();
	homePage.clickCancel();
	String pText=homePage.getFPasswordText();
	Assert.assertEquals(pText,"Forgot your password?");
	boolean pFlag=homePage.checkFPasswordVisible();
	Assert.assertEquals(pFlag,true);
	
}

@Test(priority=5)
public void ClickOnUsername() {
	extentTest = extent.startTest("ClickOnUsername");
	homePage.enterUsername();
	//String pText=homePage.getUsernameText();
	//Assert.assertEquals(pText,"Admin");
	boolean pFlag=homePage.checkUsernameVisible();
	Assert.assertEquals(pFlag,true);
	
}

@Test(priority=6)
public void ClickOnPassword() {
	extentTest = extent.startTest("ClickOnPassword");
	homePage.enterPassword();
	boolean pFlag=homePage.checkPasswordVisible();
	Assert.assertEquals(pFlag,true);
}

@Test(priority=7)
public void ClickOnLogin() {
	extentTest = extent.startTest("ClickOnLogin");
	homePage.clickLogin();
	boolean pFlag=homePage.checkHomePageVisible();
	Assert.assertEquals(pFlag,true);
}

@Test(priority=8)
public void ViewDashBoard() {
	extentTest = extent.startTest("ViewDashBoard");
	homePage.clickDashBoard();
	String pText=homePage.getDashBoardText();
	Assert.assertEquals(pText,"Dashboard");
	boolean pFlag=homePage.checkDashBoardVisible();
	Assert.assertEquals(pFlag,true);
}


@Test(priority=9)
public void ClickOnSearch() {
	extentTest = extent.startTest("ClickOnSearch");
	homePage.clickSearch();
	String pText=homePage.getMyInfoText();
	Assert.assertEquals(pText,"My Info");
	boolean pFlag=homePage.checkMyInfoVisible();
	Assert.assertEquals(pFlag,true);
}

@Test(priority=10)
public void ClickOnFirst() throws InterruptedException {
	extentTest = extent.startTest("ClickOnFirst");
	homePage.clickPIM();
	homePage.clickAddButton();
	homePage.enterFName();
	Thread.sleep(1000);
	boolean pFlag=homePage.checkFirstVisible();
	Assert.assertEquals(pFlag,true);
}

@Test(priority=11)
public void ClickOnAdd() throws InterruptedException {
	extentTest = extent.startTest("ClickOnAdd");
	homePage.clickPIM();
	homePage.clickAddButton();
	homePage.enterFName();
	homePage.enterMName();
	homePage.enterLName();
	homePage.clickSave();
	boolean pFlag=homePage.checkMyInfoVisible();
	Assert.assertEquals(pFlag,true);
}

@Test(priority=12)
public void ClickOnESearch() throws InterruptedException {
	extentTest = extent.startTest("ClickOnESearch");
	homePage.clickPIM();
	homePage.enterEName();
	homePage.clickESearch();
	Thread.sleep(1000);
	boolean pFlag=homePage.checkRecordVisible();
	Assert.assertEquals(pFlag,true);
}

@Test(priority=13)
public void ClickOnTime() {
	extentTest = extent.startTest("ClickOnTime");
	homePage.clickTime();
	homePage.clickView();
	String pText=homePage.getTimeText();
	Assert.assertEquals(pText,"Time");
	boolean pFlag=homePage.checkTimeVisible();
	Assert.assertEquals(pFlag,true);
}

@Test(priority=14)
public void ClickOnImage() throws InterruptedException {
	extentTest = extent.startTest("ClickOnImage");
	homePage.checkImageView();
	Thread.sleep(1000);
	boolean pFlag=homePage.checkImageVisible();
	Assert.assertEquals(pFlag,true);
}

@Test(priority=15)
public void ClickOnLogout() {
	extentTest = extent.startTest("ClickOnLogout");
	homePage.clickLogout();
	boolean pFlag=homePage.checkLoginVisible();
	Assert.assertEquals(pFlag,true);
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
