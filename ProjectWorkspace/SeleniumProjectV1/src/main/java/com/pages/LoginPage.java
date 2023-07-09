package com.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.wrapper.Wrapper;
import com.testbase.TestBase;

public class LoginPage extends TestBase {

	Wrapper wrrObj = new Wrapper();

	@FindBy(xpath = "//*[@name='username']")
	WebElement pUsername;

	@FindBy(xpath = "//*[@name='password']")
	WebElement pPassword;

	@FindBy(xpath = "//*[@type='submit']")
	WebElement pSubmit;

	@FindBy(xpath = "//*[text()='Admin']")
	WebElement pAdmin;

	@FindBy(xpath = "(//*[text()='Required'])[1]")
	WebElement pUserRequired;
	@FindBy(xpath = "(//*[text()='Required'])[2]")
	WebElement pPassRequired;

	@FindBy(xpath = "//*[text()='Login']")
	WebElement pLoginText;

	@FindBy(xpath = "//*[@role='alert']//div//p")
	WebElement pInvalid;

	@FindBy(xpath = "//*[@class='orangehrm-login-forgot']//p")
	WebElement pForgotPaswword;

	@FindBy(xpath = "//*[@type='submit']")
	WebElement pResetPaswword;

	@FindBy(xpath = "//*[@type='button']")
	WebElement pCancelPaswword;

	@FindBy(xpath = "//*[@placeholder='Search']")
	WebElement pSearch;

	@FindBy(xpath = "//*[@class='oxd-topbar-header-title']//span//h6")
	WebElement pHeading;

	@FindBy(xpath = "//*[@class='orangehrm-header-container']//button//i")
	WebElement pAdminAdd;

	@FindBy(xpath = "//*[@type='submit']")
	WebElement pAdminSave;
	@FindBy(xpath = "(//*[@class='oxd-form-actions']//button)[2]")
	WebElement pAdminSaveButton;
	

	@FindBy(xpath = "(//*[@class='oxd-select-text oxd-select-text--active'])[1]")
	WebElement pUserRole;

	@FindBy(xpath = "(//*[@class='oxd-select-text-input'])[1]")
	WebElement pSelectUserRole;
	
	@FindBy(xpath = "(//*[@class='oxd-select-wrapper']//div)[4]")
	WebElement pStatus;
	
	@FindBy(xpath = "(//*[@class='oxd-select-text-input'])[2]")
	WebElement pSelectStatus;
	
	@FindBy(xpath = "//*[@placeholder='Type for hints...']")
	WebElement pEmployeeName;
	
	@FindBy(xpath = "//*[@class='oxd-autocomplete-wrapper']//input")
	WebElement pEmployeeNameList;
	
	@FindBy(xpath = "(//*[@class='oxd-input-group oxd-input-field-bottom-space'])[4]//input")
	WebElement pAddUser;
	
	@FindBy(xpath = "(//*[@class='oxd-input-group oxd-input-field-bottom-space'])[5]//input")
	WebElement pAddPass;
	
	@FindBy(xpath = "(//*[@class='oxd-input-group oxd-input-field-bottom-space'])[6]//input")
	WebElement pAddConPass;
	
	@FindBy(xpath = "(//*[@class='oxd-input oxd-input--active'])[2]")
	WebElement pUserNameSearch;
	
	@FindBy(xpath = "//*[@type='submit']")
	WebElement pSearchUser;
	
	@FindBy(xpath = "(//*[@class='oxd-table-header-cell oxd-padding-cell oxd-table-th'])[2]")
	WebElement pUsernameText;
	
	@FindBy(xpath = "//*[@class='oxd-icon bi-trash']")
	WebElement pDeleteAdmin;
	
	@FindBy(xpath = "//*[@class='oxd-icon bi-pencil-fill']")
	WebElement pEditAdmin;
	
	@FindBy(xpath = "(//*[@class='oxd-main-menu']//li)[2]")
	WebElement pPIM;
	
	@FindBy(xpath = "(//*[@class='oxd-topbar-body']//ul//li//a)[2]")
	WebElement pAddEmployee;
	
	@FindBy(xpath = "//*[@name='firstName']")
	WebElement pFirstName;
	
	@FindBy(xpath = "//*[@name='middleName']")
	WebElement pMiddleName;
	
	@FindBy(xpath = "//*[@name='lastName']")
	WebElement pLastName;
	
	@FindBy(xpath = "(//*[@class='oxd-text oxd-text--h6 orangehrm-main-title'])[1]")
	WebElement pPersonalDetails;
	
	@FindBy(xpath = "(//*[@class='oxd-topbar-body-nav']//ul//li//a)[3]")
	WebElement pReports;
	
	@FindBy(xpath = "//*[@class='oxd-table-filter-header-title']//h5")
	WebElement pEmployeeReportsText;
	
	@FindBy(xpath = "(//*[@class='oxd-icon-button oxd-table-cell-action-space'])[3]//i")
	WebElement pViewReport;
	
	@FindBy(xpath = "//*[@class='orangehrm-card-container']//h6")
	WebElement pViewReportText;
	
	@FindBy(xpath = "(//*[@class='oxd-main-menu']//li)[3]")
	WebElement pLeave;
	
	@FindBy(xpath = "(//*[@class='oxd-main-menu']//li)[4]")
	WebElement pTime;
	
	@FindBy(xpath = "(//*[@class='oxd-main-menu']//li)[5]")
	WebElement pRecruitment;
	
	@FindBy(xpath = "(//*[@class='oxd-main-menu']//li)[8]")
	WebElement pDashboard;
	
	@FindBy(xpath = "//*[@class='oxd-topbar-header-userarea']//ul//li//p")
	WebElement pAccount;
	
	@FindBy(xpath = "(//*[@class='oxd-dropdown-menu']//li//a)[4]")
	WebElement pLogout;
	
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	public void enterUsername() {
		pUsername.sendKeys("Admin");
	}

	public void emptyUsername() {
		pUsername.sendKeys("");
	}

	public void InvalidUsername() {
		pUsername.sendKeys("abcd");
	}

	public void enterPassword() {
		pPassword.sendKeys("admin123");
	}

	public void InvalidPassword() {
		pPassword.sendKeys("abcd123");
	}

	public void emptyPassword() {
		pPassword.sendKeys("");
	}

	public void clickLogin() {
		pSubmit.click();
		wrrObj.waitForElement(pAdmin);
	}

	public void clickEmptyLogin() {
		pSubmit.click();
		wrrObj.waitForElement(pLoginText);
	}

	public void clickInvalidLogin() {
		pSubmit.click();
		wrrObj.waitForElement(pLoginText);
	}

	public void clear() {
		pUsername.clear();
		pPassword.clear();
	}

	public String getAdminText() {
		String pText = pAdmin.getText();
		return pText;
	}

	public String getLoginText() {
		String pText = pLoginText.getText();
		return pText;
	}

	public void clickForgotPassword() {
		pForgotPaswword.click();
		wrrObj.waitForElement(pResetPaswword);
	}

	public String getResetPassText() {
		String pText = pResetPaswword.getText();
		return pText;
	}

	public void clickCancelPassword() {
		pCancelPaswword.click();
		wrrObj.waitForElement(pLoginText);
	}

	public void clickSearch(String pValue) {
		pSearch.click();
		pSearch.sendKeys("Ad");
		List<WebElement> pSearchList = driver
				.findElements(By.xpath("//*[@class='oxd-main-menu-item-wrapper']//a//span"));

		for (WebElement pElement : pSearchList) {
			if (pElement.getText().equalsIgnoreCase(pValue)) {
				pElement.click();
				break;
			}
		}
	}

	public String getSearchText() {
		String pSearchlist = pHeading.getText();
		return pSearchlist;
	}

	public void clickAdminAdd() {
		pAdminAdd.click();
		wrrObj.waitForElement(pAdminSave);
	}

	public String getSaveText() {
		String pText = pAdminSave.getText();
		return pText;
	}

	public void ClickUserRole(String pValue) throws InterruptedException {
		pUserRole.click();
		Thread.sleep(3000);
		wrrObj.pSelectDropdown("//*[@class='oxd-select-option']", pValue);
			}
	
	public String getUserRole()
	{
		String pUserList=pSelectUserRole.getText();
		return pUserList;
	}
	
	public void enterEmployeeName(String pValue) throws InterruptedException {
		pEmployeeName.click();
		pEmployeeName.sendKeys("od");
		Thread.sleep(5000);
		List<WebElement> pEmployeeList = driver.findElements(By.xpath("//*[@class='oxd-autocomplete-option']"));

		for (WebElement pElement : pEmployeeList) {
			if (pElement.getText().equalsIgnoreCase(pValue)) {
				pElement.click();
				break;
			}
		}
	}
	public String getEmployeeName()
	{
		String pEmployeList=pEmployeeNameList.getText();
		return pEmployeList;
	}
	
	public void ClickStatus(String pValue) throws InterruptedException {
		pStatus.click();
		Thread.sleep(5000);
		wrrObj.pSelectDropdown("//*[@class='oxd-select-option']", pValue);
	}
	
	public String getStatusText()
	{
		String pEmployeList=pSelectStatus.getText();
		return pEmployeList;
	}
	
	public void enterAddUsername() {
		pAddUser.sendKeys("employee1");
	}
	public void enterAddPassword() {
		pAddPass.sendKeys("employee123");
	}
	public void enterAddConPassword() {
		pAddConPass.sendKeys("employee123");
	}
	public void clickAdminSave()
	{
		pAdminSaveButton.click();
		wrrObj.waitForElement(pSearchUser);
	}
	
	
	public void SearchUserRole() throws InterruptedException {
		this.ClickUserRole("ESS");
	}
	
	public void clickSearchUser() {
		pSearchUser.click();
		wrrObj.waitForElement(pUsernameText);
	}
	
	public String getRecordlistText() {
		String pSearchlist = pUsernameText.getText();
		return pSearchlist;
	}
	
	public void clickEditUser() {
		pEditAdmin.click();
		//pUserNameSearch.sendKeys("David.Morris1");
		wrrObj.waitForElement(pAdminSave);
	}
	public void clickEditUserAdmin() {
		
		pUserNameSearch.sendKeys("new");
		pAdminSave.click();
		wrrObj.waitForElement(pSearchUser);
	}
	public String getSearchuserText() {
		String pText = pSearchUser.getText();
		return pText;
	}
	
	public void clickPIM() {
		pPIM.click();
		wrrObj.waitForElement(pHeading);
	}
	
	public void clickAddEmployee() {
		pAddEmployee.click();
		wrrObj.waitForElement(pAdminSave);
	}
	
	
	
	public void clickEmployeeSave()
	{
		pFirstName.sendKeys("sinu");
		pMiddleName.sendKeys("P");
		pLastName.sendKeys("Babu");
		pAdminSaveButton.click();
		wrrObj.waitForElement(pPersonalDetails);
	}
	
	public String getAddEmployeeText() {
		String pSearchlist = pAddEmployee.getText();
		return pSearchlist;
	}
	
	public void clickReports() {
		pReports.click();
		wrrObj.waitForElement(pEmployeeReportsText);
	}
	
	public String getEmployeeReportsText() {
		String pSearchlist = pEmployeeReportsText.getText();
		return pSearchlist;
	}
	
	public void clickViewReports() {
		pViewReport.click();
		wrrObj.waitForElement(pViewReportText);
	}
	public String getViewReportsText() {
		String pSearchlist = pViewReportText.getText();
		return pSearchlist;
	}
	public void clickLeave() {
		pLeave.click();
		wrrObj.waitForElement(pHeading);
	}
	
	public void clickTime() {
		pTime.click();
		wrrObj.waitForElement(pHeading);
	}
	
	public void clickRecruitment() {
		pRecruitment.click();
		wrrObj.waitForElement(pHeading);
	}
	public void clickDashboard() {
		pDashboard.click();
		wrrObj.waitForElement(pHeading);
	}
	public void clickLogout() {
		pAccount.click();
		pLogout.click();
		wrrObj.waitForElement(pLoginText);
	}
	
}
