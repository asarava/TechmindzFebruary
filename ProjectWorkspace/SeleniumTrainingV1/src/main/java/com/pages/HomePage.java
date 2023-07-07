package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.testbase.TestBase;
import com.wrapper.Wrapper;

public class HomePage extends TestBase {

	Wrapper wrapObj = new Wrapper();
	
	@FindBy (xpath = "//input[@placeholder='Username']")
	WebElement pUsername;
	@FindBy (xpath = "//input[@placeholder='Password']")
	WebElement pPassword;
	@FindBy (xpath = "//button[text()=' Login ']")	
	WebElement pLoginButton;
	@FindBy (xpath = "//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[2]/a")
	WebElement pPIM;
	@FindBy (xpath = "//a[text()='Add Employee']")
	WebElement pAddEmployee;
	@FindBy (xpath = "(//button[@type='button'])[4]")
	WebElement pAdd;
	@FindBy (xpath = "//input[@placeholder='First Name']")
	WebElement pEmployeeFirstName;
	@FindBy (xpath = "//input[@placeholder='Last Name']")
	WebElement pEmployeeLastName;
	@FindBy (xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/button[2]")
	WebElement pSave;
	@FindBy (xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/h6")
	WebElement pEmployeeAddedPersonalDetails;
	@FindBy (xpath = "//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[1]/a/span")
	WebElement pAdmin;
	@FindBy (xpath = "//a[text()='Nationalities']")
	WebElement pNationalities;
	@FindBy (xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div[1]/h6")
	WebElement pNationalitiesText;
	@FindBy (xpath = "//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[3]/a")
	WebElement pLeave;
	@FindBy(xpath = "//a[text()='Leave List']")
	WebElement pLeaveList;
	@FindBy (xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[1]/div[1]/h5")
	WebElement pLeaveListText;
	@FindBy (xpath = "//a[text()='Employee List']")
	WebElement pEmployeeList;
	@FindBy (xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[1]/div[1]/h5")
	WebElement pEmployeeInformationText;
	@FindBy (xpath = "//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[5]/a")
	WebElement pRecruitment;
	@FindBy (xpath = "//a[text()='Vacancies']")
	WebElement pVacancies;
	@FindBy (xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[1]/div[1]/h5")
	WebElement pVacanciesText;
	@FindBy (xpath = "//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[6]/a")
	WebElement pMyInfo;
	@FindBy (xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/h6")
	WebElement pPersonalDetailsText;
	@FindBy (xpath = "//a[text()='Reports']")
	WebElement pPIMReport;
	@FindBy (xpath = "//button[@type='submit']")
	WebElement pPIMReportSearch;
	@FindBy (xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[1]/div[1]/h5")
	WebElement pEmployeeReportText;
	@FindBy (xpath = "//p[@class='oxd-text oxd-text--p orangehrm-login-forgot-header']")
	WebElement pForgotPassword;
	@FindBy (xpath = "//h5[@class='oxd-text oxd-text--h5 orangehrm-login-title']")
	WebElement pLoginText;
	@FindBy (xpath = "//p[text()='Invalid credentials']")
	WebElement pInvalidUsernameText;
	@FindBy (xpath = "//*[@id='app']/div[1]/div[1]/header/div[1]/div[2]/ul/li/span/i")
	WebElement pDropdown;
	@FindBy (xpath = "//p[text()='Paul Collings']")
	WebElement pUser;
	@FindBy (xpath = "//a[text()='Logout']")
	WebElement pLogOut;
	@FindBy (xpath = "//button[@type='submit']")
	WebElement pResetPassword;
	@FindBy (xpath = "//*[@id=\"app\"]/div[1]/div[1]/div/h6")
	WebElement pResetPasswordText;
	@FindBy (xpath = "//*[@id=\"app\"]/div[1]/div[1]/div/form/div[2]/button[1]")
	WebElement pCancel;
	@FindBy (xpath = "//*[@id=\"app\"]/div[1]/div[1]/div/form/h6")
	WebElement pResetWithoutUsernameText;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	public void navigateToHomePage() {
		 driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}
	public boolean isUsernameFieldDisplayed() {
		wrapObj.waitForElementVisible(pLoginButton);
		return pUsername.isDisplayed();
	}
	public boolean isLoginPasswordFieldDisplayed() {
		wrapObj.waitForElementVisible(pLoginButton);
		return pPassword.isDisplayed();
	}
	public boolean isLoginButtonDisplayed() {
		wrapObj.waitForElementVisible(pLoginButton);
		return pLoginButton.isDisplayed();
	}
	public void enterUsername() {		
		wrapObj.enterOrangeLoginDetails(pUsername, "Admin");
    }
    public void enterLoginPassword() {		
	wrapObj.enterOrangeLoginDetails(pPassword, "admin123");
    }

    public void clickOnLoginButton() {
	wrapObj.waitForElement(pLoginButton);
	pLoginButton.click();
    }
    public void ClickAddEmployee() throws InterruptedException {
 	   pPIM.click();
 	   pAddEmployee.click();
 	   wrapObj.waitForElement(pSave);
 	   pEmployeeFirstName.sendKeys("Anna");
 	   pEmployeeLastName.sendKeys("Jacob");
 	   Thread.sleep(2000);
 	   pSave.click();
 	   wrapObj.waitForElement(pEmployeeAddedPersonalDetails);
    }
    public String getEmployeeAddedPersonalDetailsText() {
 	   String pText = pEmployeeAddedPersonalDetails.getText();
 	   return pText;
    }
    public void ClickNationalities() {
 	   pAdmin.click();
 	   pNationalities.click();
 	   wrapObj.waitForElement(pNationalitiesText);
    }
    public String getNationalitiesText() {
 	   String pText = pNationalitiesText.getText();
 	return pText;
 	   
    }
    public void clickOnLeave() {
 	   pLeave.click();
 	   pLeaveList.click();
 	   wrapObj.waitForElement(pLeaveListText);
    }
    public String getLeaveListText() {
 	   String pText = pLeaveListText.getText();
 	return pText;
 	   
    }
    public void clickOnEmployeeList() {
 	   pPIM.click();
 	   pEmployeeList.click();
 	   wrapObj.waitForElement(pEmployeeInformationText);
    }
    public String getEmployeeInformationText() {
 	   String pText = pEmployeeInformationText.getText();
 	return pText;  
    }
    public void clickVacancies() {
 	   pRecruitment.click();
 	   pVacancies.click();
 	   wrapObj.waitForElement(pVacanciesText);
    }
    public String getVacanciesText() {
 	   String pText = pVacanciesText.getText();
 	   return pText;
    }
    public void clickOnMyInfo() {
 	   pMyInfo.click();
 	   wrapObj.waitForElement(pPersonalDetailsText);
    }
    public String getPersonalDetailsText() {
 	   String pText = pPersonalDetailsText.getText();
 	   return pText;
    }
    public void clickOnEmployeeReport() {
 	   pPIM.click();
 	   pPIMReport.click();
 	   pPIMReportSearch.click();
 	   wrapObj.waitForElement(pEmployeeReportText);;
    }
    public String getEmployeeReportText() {
 	   String pText = pEmployeeReportText.getText();
 	   return pText;
    }
    public void ClickOnUser() throws InterruptedException {
    	wrapObj.waitForElement(pDropdown);
    	pDropdown.click();
    	Thread.sleep(1000);
    	pLogOut.click();
    }
    public void enterInvalidUsername() {
    	wrapObj.enterOrangeLoginDetails(pUsername, "adminat");
    }
    public void enterInvalidPassword() {
    	wrapObj.enterOrangeLoginDetails(pPassword, "admin234");
    }
    public void enterBlankUsername() {
    	wrapObj.enterOrangeLoginDetails(pUsername, "      ");
    }
    public void enterBlankPassword() {
    	wrapObj.enterOrangeLoginDetails(pPassword, "      ");
    }
       public String getInvalidUsernameText() {
    	String pText = pInvalidUsernameText.getText();
    	return pText;
    }
 
   public void clickOnResetPassword() {
	   pCancel.click();
	   pForgotPassword.click();
	   pUsername.click();
	   pUsername.sendKeys("Admin");
	   pResetPassword.click();
   }
   public void clickOnResetPasswordWithouUsername() {
	   pForgotPassword.click();
	   pUsername.click();
	   pResetPassword.click();
   }
   public String getResetPasswordText() {
	   String pText = pResetPasswordText.getText();
	   return pText;
   }
   public String getResetPasswordWithoutUsernameText() {
	   String pText = pResetWithoutUsernameText.getText();
	   return pText;
   }
      
   
}
