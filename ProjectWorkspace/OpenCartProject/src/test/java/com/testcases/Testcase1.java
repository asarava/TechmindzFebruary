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
	public void AddFirstName() throws InterruptedException {
		homePage.clickPIM();
		Thread.sleep(4000);
		homePage.clickAdd();
		homePage.FirstName();
		boolean pFlag = homePage.checkElementVisibileByFirstname();
		Assert.assertEquals(pFlag, true);
	}

	@Test(priority = 4)
	public void AddMiddleName() throws InterruptedException {
		homePage.MiddleName();
		boolean pFlag = homePage.checkElementVisibileByMiddlename();
		Assert.assertEquals(pFlag, true);
	}
	@Test(priority = 5)
	public void AddLastName() throws InterruptedException {
		homePage.LastName();
		Thread.sleep(4000);
		boolean pFlag = homePage.checkElementVisibileByLastname();
		Assert.assertEquals(pFlag, true);
	}
	@Test(priority = 6)
	public void SaveTheDetails() throws InterruptedException {
		homePage.clickSave();
		Thread.sleep(4000);
		boolean pFlag = homePage.checkElementVisibileBySaveDetails();
		Assert.assertEquals(pFlag, true);
	}
	@Test(priority = 7)
	public void Clickjob() throws InterruptedException {
		homePage.clickJob();
		boolean pFlag = homePage.checkElementVisibileByJob();
		Assert.assertEquals(pFlag, true);
	}
	@Test(priority = 8)
	public void Selectjob() throws InterruptedException {
		homePage.selectJob();
		Thread.sleep(4000);
		homePage.clickSave();
		Thread.sleep(4000);
		boolean pFlag = homePage.checkElementVisibileByPersonalDetails();
		Assert.assertEquals(pFlag, true);
	}

	@Test(priority = 9)
	public void SearchwithEmpName() throws InterruptedException {
		homePage.clickPIM(); 
		homePage.SearchWithEmpName();
		Thread.sleep(4000);
		boolean pFlag = homePage.checkElementVisibileBySearchEmp();
		Assert.assertEquals(pFlag, true);
	}
	@Test(priority = 10)
	public void clickSearch() throws InterruptedException {
		homePage.clickSearch();
		Thread.sleep(4000);
		boolean pFlag = homePage.checkElementVisibileBySearchResult();
		Assert.assertEquals(pFlag, true);
	}

	@Test(priority = 11)
	public void clikEdit() throws InterruptedException {
		homePage.clickEdit();
		Thread.sleep(5000);
		boolean pFlag = homePage.checkElementVisibileByEdit();
		Assert.assertEquals(pFlag, true);
	}
	@Test(priority = 12)
	public void EditLastName() throws InterruptedException {
		homePage.EditLastName();
		Thread.sleep(4000);
		boolean pFlag = homePage.checkElementVisibileByEditLastName();
		Assert.assertEquals(pFlag, true);
	}

	@Test(priority = 13)
	public void SaveEditLastName() throws InterruptedException {
		homePage.clickEditSave();
		Thread.sleep(4000);
		homePage.clickEmployeeList();
		String pText = homePage.getLastName();
		Assert.assertEquals(pText, "Kumar");
	}

	@Test(priority = 14)
	public void clickdelete() throws InterruptedException {
		homePage.SearchWithEmpName();
		Thread.sleep(4000);
		homePage.clickSearch();
		homePage.clickdelete();
		Thread.sleep(4000);
		boolean pFlag = homePage.checkElementVisibileByDelete();
		Assert.assertEquals(pFlag, true);
	}
	@Test(priority = 15)
	public void deleteEmp() throws InterruptedException {
		homePage.deleteAlertok();
		Thread.sleep(5000);
		boolean pFlag = homePage.checkElementVisibileAdd();
		Assert.assertEquals(pFlag, true);
	}

	@Test(priority = 16)
	public void LogOut() throws InterruptedException {
		homePage.Logout();
		Thread.sleep(4000);
		boolean pFlag = homePage.checkElementVisibileByLogin();
		Assert.assertEquals(pFlag, true);
	}

}
