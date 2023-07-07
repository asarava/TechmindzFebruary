package com.pages;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.testbase.TestBase;
import com.wrapper.Wrapper;

public class HomePage extends TestBase {
	Wrapper wrapObj = new Wrapper();

	@FindBy(xpath = "//*[@name='username']")
	WebElement logUserName;

	@FindBy(xpath = "//*[@name='password']")
	WebElement logPassword;

	@FindBy(xpath = "//*[@type='submit']")
	WebElement loginButton;

	@FindBy(xpath = "//*[@class='oxd-main-menu-search']")
	WebElement searchIcon;

	@FindBy(xpath = "(//*[@class='oxd-main-menu-item-wrapper'])[1]")
	WebElement adminLink;

	@FindBy(xpath = "(//*[@class='oxd-main-menu-item-wrapper'])[2]")
	WebElement PIMLink;

	@FindBy(xpath = "(//*[@class='oxd-main-menu-item-wrapper'])[3]")
	WebElement leaveLink;

	@FindBy(xpath = "(//*[@class='oxd-main-menu-item-wrapper'])[4]")
	WebElement timeLink;

	@FindBy(xpath = "(//*[@class='oxd-main-menu-item-wrapper'])[5]")
	WebElement recruitmentLink;

	@FindBy(xpath = "//*[@class='oxd-table-filter-header-title']")
	WebElement headerTitleText;

	@FindBy(xpath = "//*[@class='oxd-topbar-body-nav-tab --parent --visited']")
	WebElement userManagementTab;

	@FindBy(xpath = "//*[@class='oxd-topbar-body-nav-tab --visited']")
	WebElement employeeListTab;

	@FindBy(xpath = "(//*[@class='oxd-topbar-body-nav-tab'])[2]")
	WebElement myLeaveTab;

	@FindBy(xpath = "//*[@class='oxd-topbar-body-nav-tab --parent --visited']")
	WebElement timeSheetsTab;

	@FindBy(xpath = "(//*[@class='oxd-text oxd-text--h6 orangehrm-main-title'])[1]")
	WebElement timePageTitle;

	@FindBy(xpath = "(//input[@class='oxd-input oxd-input--active'])[2]")
	WebElement userName;

	@FindBy(xpath = "(//*[@class='oxd-select-text oxd-select-text--active'])[1]")
	WebElement userRole;

	@FindBy(xpath = "(//*[@placeholder='Type for hints...'])")
	WebElement employeeName;

	@FindBy(xpath = "(//*[@class='oxd-select-text oxd-select-text--active'])[2]")
	WebElement userStatus;

	@FindBy(xpath = "(//*[@type='submit'])")
	WebElement adminSearchButton;

	@FindBy(xpath = "(//*[@class='card-center'])")
	WebElement adminSearchResult;

	@FindBy(xpath = "(//*[@type='button'])[5]")
	WebElement addUserButton;

	@FindBy(xpath = "(//*[@type='submit'])")
	WebElement saveButton;

	@FindBy(xpath = "(//*[@type='password'])[1]")
	WebElement addUserPassword;

	@FindBy(xpath = "(//*[@type='password'])[2]")
	WebElement confPassword;

	@FindBy(xpath = "(//*[@name='firstName'])")
	WebElement employeeFirstName;

	@FindBy(xpath = "(//*[@name='lastName'])")
	WebElement employeeLastName;

	@FindBy(xpath = "(//*[@type='button'])[4]")
	WebElement addEmployeeButton;

	@FindBy(xpath = "(//*[@class='orangehrm-edit-employee-name'])")
	WebElement employeeFullName;

	@FindBy(xpath = "//*[@class='orangehrm-horizontal-padding orangehrm-vertical-padding']")
	WebElement userSearchResult;

	@FindBy(xpath = "(//*[@type='submit'])")
	WebElement searchUserButton;

	@FindBy(xpath = "(//*[@class='oxd-topbar-body-nav-tab --parent'])")
	WebElement jobTab;

	@FindBy(xpath = "(//*[@class='oxd-button oxd-button--medium oxd-button--secondary'])")
	WebElement jobAddButton;

	@FindBy(xpath = "(//*[@class='oxd-dropdown-menu'])//li")
	WebElement jobTabList;

	@FindBy(xpath = "(//*[@class='oxd-input oxd-input--active'])[2]")
	WebElement inputJobTitleOrCatg;

	@FindBy(xpath = "(//*[@placeholder='Type description here'])")
	WebElement inputJobDescription;

	@FindBy(xpath = "(//*[@type='submit'])")
	WebElement saveJobTitle;

	@FindBy(xpath = "(//*[@class='oxd-text oxd-text--h6 orangehrm-main-title'])")
	WebElement jobTitlesOrCatgHeading;

	@FindBy(xpath = "(//*[@class='oxd-topbar-body-nav-tab --parent'])[1]")
	WebElement entitlementTab;

	@FindBy(xpath = "(//*[@class='oxd-select-text oxd-select-text--active'])[1]")
	WebElement leaveType;

	@FindBy(xpath = "(//*[@class='oxd-text oxd-text--span'])[1]")
	WebElement entitleResultText;

	@FindBy(xpath = "(//*[@class='oxd-topbar-body-nav-tab --parent'])[3]")
	WebElement qualificationTab;

	@FindBy(xpath = "(//*[@class='oxd-button oxd-button--medium oxd-button--secondary'])")
	WebElement qualificationAddButton;

	@FindBy(xpath = "(//*[@placeholder='Search'])")
	WebElement mainMenuSearch;

	@FindBy(xpath = "(//*[@class='oxd-topbar-body-nav-tab --visited'])")
	WebElement candidatesTab;

	@FindBy(xpath = "(//*[@class='oxd-select-text oxd-select-text--active'])")
	WebElement vacancyField;

	@FindBy(xpath = "(//*[@class='oxd-text oxd-text--p'])[1]")
	WebElement candidateResultName;

	  /*@FindBy (xpath = "") WebElement
	  
	  /*@FindBy (xpath = "") WebElement*/
	 

	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	public void loginWithoutUserName() {
		logPassword.sendKeys("admin123");
		loginButton.click();
	}

	public void loginWithoutPassword() {
		logUserName.sendKeys("Admin");
		logPassword.sendKeys(Keys.CONTROL + "a" + Keys.DELETE);
		loginButton.click();
	}

	public void loginWithInvalidUsername() {
		logUserName.sendKeys(Keys.CONTROL + "a" + Keys.DELETE);
		logUserName.sendKeys("adm");
		logPassword.sendKeys("admin123");
		loginButton.click();
	}

	public void loginWithInvalidPwd() {
		logUserName.sendKeys(Keys.CONTROL + "a" + Keys.DELETE);
		logPassword.sendKeys(Keys.CONTROL + "a" + Keys.DELETE);
		logUserName.sendKeys("Admin");
		logPassword.sendKeys("admin");
		loginButton.click();
	}

	public void loginWithUserNameAndPwd() {
		logUserName.sendKeys(Keys.CONTROL + "a" + Keys.DELETE);
		logPassword.sendKeys(Keys.CONTROL + "a" + Keys.DELETE);
		logUserName.sendKeys("Admin");
		logPassword.sendKeys("admin123");
		loginButton.click();
	}

	public boolean checkLoginButtonPresent() {
		return wrapObj.checkElementVisibility(loginButton);
	}

	public boolean checkSearchIconPresent() {
		return wrapObj.checkElementVisibility(searchIcon);
	}

	public String getInnerText() {
		return headerTitleText.getText();
	}

	public void clickOnAdminLink() {
		adminLink.click();
		wrapObj.waitForElement(userManagementTab, driver);
	}

	public void clickOnPIMLink() {
		PIMLink.click();
		wrapObj.waitForElement(employeeListTab, driver);
	}

	public void clickOnLeaveLink() {
		leaveLink.click();
		wrapObj.waitForElement(myLeaveTab, driver);
	}

	public void clickOnTimeLink() {
		timeLink.click();
		wrapObj.waitForElement(timeSheetsTab, driver);
	}

	public void clickOnRecruitmentLink() {
		recruitmentLink.click();
		wrapObj.waitForElement(candidatesTab, driver);
	}

	public String getTimePageText() {
		return timePageTitle.getText();
	}

	public void clickAddUserButton() {
		addUserButton.click();
		wrapObj.waitForElement(saveButton, driver);
	}

	public void enterUserNameOrEntitle(String pString) {
		userName.sendKeys(pString);
	}

	public void selectUserRole(String pString) throws InterruptedException {
		userRole.click();
		Thread.sleep(10000);
		wrapObj.listAndSelect("//*[@class='oxd-select-option']", pString);
	}

	public void enterEmployeeName(String pHint, String pEmplName) throws InterruptedException {
		employeeName.sendKeys(pHint);
		Thread.sleep(5000);
		wrapObj.listAndSelect("//*[@class='oxd-autocomplete-option']", pEmplName);
	}

	public void enterUserStatus() {
		userStatus.click();
		wrapObj.listAndSelect("//*[@class='oxd-select-option']", "enabled");
	}

	public void searchUser() {
		searchUserButton.click();
	}

	public void enterPassword() {
		addUserPassword.sendKeys("shehna123");
		confPassword.sendKeys("shehna123");
	}

	public void submitUser() {
		saveButton.click();
	}

	public void clickAddEmployee() {
		addEmployeeButton.click();
		wrapObj.waitForElement(employeeFirstName, driver);
	}

	public void fillEmployeeDetails(String pText1, String pText2, String IDNum) throws InterruptedException {
		userName.sendKeys(Keys.CONTROL + "a" + Keys.DELETE);
		employeeFirstName.sendKeys(pText1);
		employeeLastName.sendKeys(pText2);
		userName.sendKeys(IDNum);
		Thread.sleep(3000);
		saveButton.click();
	}

	public String getEmployeeNameText() {
		return employeeFullName.getText();
	}

	public String getSearchResultText() {
		return userSearchResult.getText();
	}

	public boolean searchButtonPresence() {
		return wrapObj.checkElementVisibility(adminSearchButton);
	}

	public void selectFromJobTab(String pString) {
		jobTab.click();
		wrapObj.listAndSelect("(//*[@class='oxd-dropdown-menu'])//li", pString);
	}

	public void clickAddButton() {
		jobAddButton.click();
	}

	public void fillAndSubmit(String pName, String pDescription) {
		inputJobTitleOrCatg.sendKeys(pName);
		inputJobDescription.sendKeys(pDescription);
		saveJobTitle.click();
	}

	public String getJobTitleHeadingText() {
		return jobTitlesOrCatgHeading.getText();
	}

	public void fillAndSubmitJobCatg() {
		inputJobTitleOrCatg.sendKeys("Human Resources");
		saveJobTitle.click();
	}

	public void enterID(String pNumber) {
		inputJobTitleOrCatg.sendKeys(pNumber);
	}

	public void selectFromEntitlementTab(String pString) {
		entitlementTab.click();
		wrapObj.listAndSelect("(//*[@class='oxd-dropdown-menu'])//li", pString);
	}

	public void selectLeaveType() {
		leaveType.click();
		wrapObj.listAndSelect("//*[@class='oxd-select-option']", "CAN - Vacation");
	}

	public void confirmEntitlement() {
		addUserButton.click();
	}

	public String getEntitleResultText() {
		return entitleResultText.getText();
	}

	public void selectQualification(String pString) {
		qualificationTab.click();
		wrapObj.listAndSelect("(//*[@class='oxd-dropdown-menu'])//li", pString);
	}

	public boolean checkAddButtonPresent() {
		return wrapObj.checkElementVisibility(jobAddButton);
	}

	public void inputTextToSearch() {
		mainMenuSearch.sendKeys("t");
		wrapObj.listAndSelect("(//*[@class='oxd-main-menu-item-wrapper'])", "time");
	}

	public void fillAndSubmitCandidateDetails() throws InterruptedException {
		employeeFirstName.sendKeys("Ram");
		employeeLastName.sendKeys("Kumar");
		vacancyField.click();
		wrapObj.listAndSelect("(//*[@class='oxd-select-option'])", "Junior Account Assistant");
		Thread.sleep(10000);
		inputJobTitleOrCatg.sendKeys("admin@example.com");
		saveButton.click();
	}
	
	public String getCandidateResultNameText() {
		return candidateResultName.getText();
	}
}
