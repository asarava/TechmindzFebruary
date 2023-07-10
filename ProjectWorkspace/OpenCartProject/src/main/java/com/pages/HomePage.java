package com.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.testbase.TestBase;
import com.wrapper.Wrapper;

public class HomePage extends TestBase {
	Wrapper wrrobj = new Wrapper();

	// Login

	@FindBy(xpath = "//*[text()='Login']")
	WebElement pLoginText;

	@FindBy(xpath = "//*[@name='username']")
	WebElement pUserName;

	@FindBy(xpath = "//*[@name='password']")
	WebElement pPswd;

	@FindBy(xpath = "(//*[text()=' Login '])")
	WebElement pLogin;

	@FindBy(xpath = "(//*[text()='Dashboard'])[1]")
	WebElement pDashBoard;
	
	@FindBy(xpath = "//*[text()='PIM']")
	WebElement pPIM;
	   //Add emp
	@FindBy(xpath = "//*[text()=' Add ']")
	WebElement pAdd;

	@FindBy(xpath = "//*[@name='firstName']")
	WebElement pFirstName;

	@FindBy(xpath = "//*[@name='middleName']")
	WebElement pMiddleName;
	
	@FindBy(xpath = "//*[@name='lastName']")
	WebElement pLastName;

	@FindBy(xpath = "//*[@type='submit']")
	WebElement pSave;
		
	@FindBy(xpath = "//*[text()='Job']")
	WebElement pJob;
	
	@FindBy(xpath = "(//*[@type='submit'])[1]")
	WebElement pJobSave;
	
	@FindBy(xpath = "(//*[@class='oxd-select-text-input'])[1]")
	WebElement pJobTitle;
	
	@FindBy(xpath = "//*[@class='oxd-text oxd-text--h6 --strong']")
	WebElement pname;
	
       //search emp
	@FindBy(xpath = "(//*[@placeholder='Type for hints...'])[1]")
	WebElement pEmpName;

	@FindBy(xpath = "//*[@type='submit']")
	WebElement pSearch;

	@FindBy(xpath = "//*[text()='Hari M']")
	WebElement pResultEmpName;
       //edit emp
	@FindBy(xpath = "(//*[@class='oxd-icon-button oxd-table-cell-action-space'])[2]")
	WebElement pEdit;
	
	@FindBy(xpath = "//*[@name='lastName']")
	WebElement pEditLastName;
	
	@FindBy(xpath = "(//*[@type='submit'])[1]")
	WebElement pEditSave;
	
	@FindBy(xpath = "(//*[text()='Employee List'])[1]")
	WebElement pEmployeeList;
	
	@FindBy(xpath = "//*[text()='Kumar']")
	WebElement pEditText;
	//-------------------
	
	   //delete emp
	@FindBy(xpath = "(//*[@class='oxd-icon-button oxd-table-cell-action-space'])[1]")
	WebElement pdelete;
	
	@FindBy(xpath = "//*[text()=' Yes, Delete ']")
	WebElement pAlertDelete;
	  //LogOut
	@FindBy(xpath = "//*[@class='oxd-userdropdown-tab']")
	WebElement pLogout;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	
	// Login
	public void LoginUsername() {
		pUserName.sendKeys("Admin");
	}

	public void LoginPassword() {
		pPswd.sendKeys("admin123");
	}

	public void Login() {
		pLogin.click();

	}

	public String getLoginText() {
		String pText = pLoginText.getText();
		return pText;
	}

	public boolean checkElementVisibileByDashBoard() {
		return wrrobj.checkElementVisibility(pDashBoard);
	}

	// AddNewEmployee
	public void clickPIM() {
	pPIM.click();
	wrrobj.waitForElement(pAdd);
	}
	public void clickAdd() {
		pAdd.click();
		wrrobj.waitForElement(pSave);	
	}
	public void FirstName() {
		pFirstName.sendKeys("Hari");
	}

	public void MiddleName() {
		pMiddleName.sendKeys("M");
	}
	public void LastName() {
		pLastName.sendKeys("K");
	}
	public void clickSave() {
		pSave.click();
		//wrrobj.waitForElement(pPersonalDetails);	
	}
	public void clickJob() {
		pJob.click();
		wrrobj.waitForElement(pJobSave);
	}
	public void selectJob() {
	
	//pJobTitle.click();
	//String pLanguageList="(//*[@class='oxd-select-text oxd-select-text--active'])[1]";
	//List<WebElement> plangList=wrrobj.returnListOfElementsFromDropDown(pLanguageList);
	//wrrobj.selectFromElementListValue("Account Assistant",plangList);
	pJobTitle.sendKeys("a");
	//List<WebElement> pToCity=driver.findElements(By.xpath("(//*[@class='oxd-select-text-input'])[1]"));
	 //for(WebElement pElement:pToCity)
	 //{ 
     //   if(pElement.getText().split("\\n")[1].equalsIgnoreCase("Account Assistant")) {
	 // pElement.click();
	 // break;
	 // }}	
	}
	
	public boolean checkElementVisibileByPersonalDetails() {
		return wrrobj.checkElementVisibility(pJob);
	}
	public void SearchWithEmpName(){
		pEmpName.sendKeys("Hari M");
		wrrobj.waitForElement(pEdit);
	}
	public void clickSearch() {
		pSearch.click();
		wrrobj.waitForElement(pResultEmpName);
	}
	public boolean checkElementVisibileBySearchResult() {
		return wrrobj.checkElementVisibility(pResultEmpName);
	}
	public void clickEdit(){
		pEdit.click();
		wrrobj.scrollToElement(pEditLastName);
		//wrrobj.waitForElement(pEditLastName);
		}
	public void EditLastNameclear(){
		pEditLastName.clear();
	}
	public void EditLastName(){	
		pEditLastName.sendKeys("umar");
		}
	public void clickEditSave(){
		pEditSave.click();
	}
	public void clickEmployeeList(){
		pEmployeeList.click();
		wrrobj.waitForElement(pAdd);	
	}
	
	public String getLastName() {
		String pText = pEditText.getText();
		return pText;
	}

	public void clickdelete(){
		pdelete.click();
		//wrrobj.waitForAlert();
		}
	public void deleteAlertok() {
		pAlertDelete.click();
		//wrrobj.alertAccept();
	}
	public boolean checkElementVisibileAdd() {
		return wrrobj.checkElementVisibility(pAdd);
	}
	
	//Logout
		public void Logout() {
			pLogout.click();
		    String pLanguageList="//*[@class='oxd-dropdown-menu']//following-sibling::li//a";
			List<WebElement> plangList=wrrobj.returnListOfElementsFromDropDown(pLanguageList);
			wrrobj.selectFromElementListValue("Logout",plangList);
		}
		public boolean checkElementVisibileByLogin() {
			return wrrobj.checkElementVisibility(pLogin);
		}
}
