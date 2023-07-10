package com.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.pages.HomePage;
import com.testbase.TestBase;

public class Testcase1 extends TestBase {
	HomePage homePage;

	public Testcase1() {
		super();
	}

	@BeforeClass
	public void setUp() {
		initialization();
		homePage = new HomePage();
	}

	@Test(priority = 1)
	public void VerifyTheTextLogin() {
		String pText = homePage.getLoginText();
		Assert.assertEquals(pText, "Login");
	}

	@Test(priority = 2)
	public void VerifyLogin() {
		homePage.LoginUsername();
		homePage.LoginPassword();
		homePage.Login();
		boolean pFlag = homePage.checkElementVisibileByDashBoard();
		Assert.assertEquals(pFlag, true);
	}

	@Test(priority = 3)
	public void AddNewEmp() throws InterruptedException {
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
		homePage.clickPIM();
		// homePage.clickEmployeeList();
		homePage.SearchWithEmpName();
		Thread.sleep(4000);
		homePage.clickSearch();
		Thread.sleep(4000);
		boolean pFlag = homePage.checkElementVisibileBySearchResult();
		Assert.assertEquals(pFlag, true);
	}

	@Test(priority = 5)
	public void EditEmp() throws InterruptedException {
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
		homePage.Logout();
		Thread.sleep(4000);
		boolean pFlag = homePage.checkElementVisibileByLogin();
		Assert.assertEquals(pFlag, true);
	}

}
