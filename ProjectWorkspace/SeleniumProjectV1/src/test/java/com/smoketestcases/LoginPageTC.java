package com.smoketestcases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.pages.LoginPage;
import com.testbase.TestBase;

public class LoginPageTC extends TestBase {
	
	LoginPage loginpage;
	
	public LoginPageTC() {
		super();
	}
	
	@BeforeClass

	public void SetUp() {
		initialization();
		loginpage = new LoginPage();
	}
	
	@Test(priority = 1)

	public void ClickOnForgotPassword() {
		loginpage.clickForgotPassword();
		String pText = loginpage.getResetPassText();
		Assert.assertEquals(pText, "Reset Password", "Validated Click on ForgotPassword");
	}
	
	@Test(priority = 2)

	public void ClickOnCancelPassword() {
		loginpage.clickCancelPassword();
		String pText = loginpage.getLoginText();
		Assert.assertEquals(pText, "Login", "Validated Click on CancelPassword");
	}
	
	@Test(priority = 3)

	public void ClickOnReqLogin() {
		loginpage.emptyUsername();
		loginpage.emptyPassword();
		loginpage.clickEmptyLogin();
		String pText = loginpage.getLoginText();
		Assert.assertEquals(pText, "Login", "Validated Click on Login Text");
	}
	
	@Test(priority = 4)

	public void ClickOnInvalidLogin() {
		loginpage.clear();
		loginpage.InvalidUsername();
		loginpage.InvalidPassword();
		loginpage.clickInvalidLogin();
		String pText = loginpage.getLoginText();
		Assert.assertEquals(pText, "Login", "Validated Click on Login Text");
	}
	
	@Test(priority = 5)

	public void ClickOnLogin() {
		loginpage.clear();
		loginpage.enterUsername();
		loginpage.enterPassword();
		loginpage.clickLogin();
		String pText = loginpage.getAdminText();
		Assert.assertEquals(pText, "Admin", "Validated Click on Login");	
	}
	
	@Test(priority = 6)

	public void ClickOnSearch() {
		loginpage.clickSearch("Admin");
		Assert.assertEquals(loginpage.getSearchText(), "Admin");
	}
	
	@Test(priority = 10)

	public void ClickOnAdminAdd() {
		loginpage.clickAdminAdd();
		String pText = loginpage.getSaveText();
		Assert.assertEquals(pText, "Save", "Validated Click on Add button");
	}
	@Test(priority = 8)

	public void ClickOnAdminEdit() {
		loginpage.clickEditUser();
		String pText = loginpage.getSaveText();
		Assert.assertEquals(pText, "Save", "Validated Click on Add button");
	}
	
	@Test(priority = 9)

	public void ClickOnAdminUserEdit() {
		loginpage.clickEditUserAdmin();
		String pText = loginpage.getSearchuserText();
		Assert.assertEquals(pText, "Save", "Validated Click on edit button");
	}
	
	@Test(priority = 7)

	public void ClickOnSearchUser() throws InterruptedException {
		loginpage.SearchUserRole();
		loginpage.clickSearchUser();
		String pText = loginpage.getRecordlistText();
		Assert.assertEquals(pText, "Username", "Validated Click on Search button");
	}
	
	@Test(priority = 12)

	public void ClickOnPIM() {
		loginpage.clickPIM();
		String pText = loginpage.getSearchText();
		Assert.assertEquals(pText, "PIM", "Validated Click on PIM Link");
	}
	
	@Test(priority = 11)

	public void ClickOnAddUserSave() throws InterruptedException {
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
		loginpage.clickAddEmployee();
		String pText = loginpage.getSaveText();
		Assert.assertEquals(pText, "Save", "Validated Click on Add button");
	}
	
	@Test(priority = 14)

	public void ClickOnAddEmployeeSave() {
		loginpage.clickEmployeeSave();
		String pText = loginpage.getAddEmployeeText();
		Assert.assertEquals(pText, "Add Employee", "Validated Click on Save button");

	}
	
	@Test(priority = 15)

	public void ClickOnEmployeeReports() {
		loginpage.clickReports();
		String pText = loginpage.getEmployeeReportsText();
		Assert.assertEquals(pText, "Employee Reports", "Validated Click on Report Link");
	}
	
	@Test(priority = 16)

	public void ClickOnViewReports() {
		loginpage.clickViewReports();
		String pText = loginpage.getViewReportsText();
		Assert.assertEquals(pText, "All Employee Sub Unit Hierarchy Report", "Validated Click on Report Link");
	}
	
	@Test(priority = 17)

	public void ClickOnLeave() {
		loginpage.clickLeave();
		String pText = loginpage.getSearchText();
		Assert.assertEquals(pText, "Leave", "Validated Click on leave Link");
	}
	
	@Test(priority = 18)

	public void ClickOnTime() {
		loginpage.clickTime();
		String pText = loginpage.getSearchText();
		Assert.assertEquals(pText, "Time", "Validated Click on Time Link");
	}
	
	@Test(priority = 19)

	public void ClickOnRecruitment() {
		loginpage.clickRecruitment();
		String pText = loginpage.getSearchText();
		Assert.assertEquals(pText, "Recruitment", "Validated Click on Recruitment Link");
	}
	
	@Test(priority = 20)

	public void ClickOnDashboard() {
		loginpage.clickDashboard();
		String pText = loginpage.getSearchText();
		Assert.assertEquals(pText, "Dashboard", "Validated Click on Recruitment Link");
	}
	
	@Test(priority = 21)

	public void ClickOnLogout() {
		loginpage.clickLogout();
		String pText = loginpage.getLoginText();
		Assert.assertEquals(pText, "Login", "Validated Click on Logout Link");
	}


}
