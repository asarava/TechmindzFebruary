package com.pages;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.testBase.TestBase;
import com.wrapper.Wrapper;

public class HomePage extends TestBase {

Wrapper wrapobj=new Wrapper();
	
//Login
 @FindBy (xpath = "//input[@placeholder='Username']")
 WebElement pUsername;
	
 @FindBy (xpath = "//input[@placeholder='Password']")
 WebElement pPassword;
 
 @FindBy (xpath = "//img[@src='/web/images/ohrm_logo.png']")
 WebElement pImage;
 
 @FindBy (xpath = "//img[@src='/web/images/ohrm_branding.png?v=1683010990518']")
 WebElement pTitle;
 
 @FindBy (xpath = "//*[text()='Login']")
 WebElement pTitleLogin;
 
 @FindBy (xpath = "//*[text()='Username : Admin']")
 WebElement pViewUsername;
 
 @FindBy (xpath = "//*[text()='Password : admin123']")
 WebElement pViewPassword;
 
 @FindBy (xpath = "//*[text()=' Login ']")
 WebElement pLogin;
 
 @FindBy (xpath = "//*[text()='Forgot your password? ']")
 WebElement pFPassword;
 
 @FindBy (xpath = "//*[text()='Reset Password']")
 WebElement pReset;
 
 @FindBy (xpath = "//input[@placeholder='Search']")
 WebElement pSearch;
 
 @FindBy (xpath = "//input[@name='username']")
 WebElement pUsername1;
 
 @FindBy (xpath = "//*[text()=' Reset Password ']")
 WebElement pResetPW;
 
 @FindBy (xpath = "//*[text()='Reset Password link sent successfully']")
 WebElement pResetAlert;
 
 @FindBy (xpath = "//*[text()=' Cancel ']")
 WebElement pCancel;
 
 @FindBy (xpath = "//*[text()='My Info']")
 WebElement pMyInfo;
 
 @FindBy (xpath = "(//*[text()='Personal Details'])[2]")
 WebElement pPersonalDetails;
 
 @FindBy (xpath = "(//*[text()='PIM'])[1]")
 WebElement pPIM;
 
 @FindBy (xpath = "//*[text()=' Add ']")
 WebElement pAdd;
 
 @FindBy (xpath = "//input[@placeholder='First Name']")
 WebElement pFName;
 
 @FindBy (xpath = "//input[@placeholder='Middle Name']")
 WebElement pMName;
 
 @FindBy (xpath = "//input[@placeholder='Last Name']")
 WebElement pLName;
 
 @FindBy (xpath = "//*[text()=' Save ']")
 WebElement pSave;
 
 @FindBy (xpath = "//img[@class='oxd-userdropdown-img']")
 WebElement pimage;
 
  @FindBy (xpath = "(//*[text()='Dashboard'])[2]")
 WebElement pDashBoard;
 
 @FindBy (xpath = "(//*[text()='Time'])[1]")
 WebElement pTime;
 
 @FindBy (xpath = "//*[text()='Timesheets ']")
 WebElement pTimeSheets;
 
 @FindBy (xpath = "(//*[text()=' View '])[2]")
 WebElement pView;
 
 @FindBy (xpath = "//div[@class='orangehrm-timesheet-header--title']//h6")
 WebElement pTimeTitle;
 
 @FindBy (xpath = "(//i[@class='oxd-icon bi-pencil-fill'])[5]")
 WebElement pEdit;
 
 @FindBy (xpath = "//button[@type='submit']")
 WebElement pSave1;		
 
 @FindBy (xpath = "(//input[@class='oxd-input oxd-input--active'])[2]")
 WebElement pNname;
 
 @FindBy (xpath = "(//input[@placeholder='Type for hints...'])[1]")
 WebElement pEName;
 
 @FindBy (xpath = "//*[text()=' Search ']")
 WebElement pESearch;	
 
 @FindBy (xpath = "//*[text()='Employee Information']")
 WebElement pInfo;	
 
 @FindBy (xpath = "//*[text()='Logout']")
 WebElement pLogout;	
 
 public HomePage(){
	PageFactory.initElements(driver, this);
}
 
 //LoginView
 public void checkLogin()  {
	 pTitleLogin.click();
  }
 
 public String getLoginText(){
	String Text=pTitleLogin.getText();
	 return Text;
	}
 
 public boolean checkLoginVisible() {
	return wrapobj.checkElementVisibility(pTitleLogin);
}
 
 //Title
 public void checkTitle() {
	 pTitle.click();
 }
 
 public String getTitleText(){
		String Text=pTitle.getText();
		 return Text;
		}
 
 public boolean checkTitleVisible() {
		return wrapobj.checkElementVisibility(pTitle);
	}
 
 //User$pwView
 public void checkUsername() {
	 pViewUsername.click();
 }
 
 public String getViewUsernameText(){
		String Text=pViewUsername.getText();
		 return Text;
		}

public boolean checkViewUsernameVisible() {
		return wrapobj.checkElementVisibility(pViewUsername);
	}
 
public void checkPassword() {
	 pViewPassword.click();
}

public String getViewPasswordText(){
		String Text=pViewPassword.getText();
		 return Text;
		}

public boolean checkViewPasswordVisible() {
		return wrapobj.checkElementVisibility(pViewPassword);
	}

 //ForgotPassword
 public void clickFPassword() {
	 pFPassword.click();
	 wrapobj.waitForElement(pReset);
 }
 
 public boolean checkFPasswordVisible() {
		return wrapobj.checkElementVisibility(pFPassword);
 }
 
 public String getFPasswordText(){
	String Text=pFPassword.getText();
	return Text;
   }
 public void clickCancel() {
	 pCancel.click();
	 wrapobj.waitForElement(pFPassword);
 }
 
 //Login
 public void enterUsername() {
	 pUsername.sendKeys("Admin");
}
 
 public boolean checkUsernameVisible() {
		return wrapobj.checkElementVisibility(pUsername);
}
 
 
 public void enterPassword() {
	 pPassword.sendKeys("admin123");
}
 
 public boolean checkPasswordVisible() {
		return wrapobj.checkElementVisibility(pPassword);
}

 
 public void clickLogin() {
	 pLogin.click();
	 wrapobj.waitForElement(pSearch);
}
 
 public boolean checkHomePageVisible() {
		return wrapobj.checkElementVisibility(pSearch);
}

 //ResetPW
 public void clickResetPassword() throws InterruptedException  {
	pUsername1.sendKeys("Admin");
	pResetPW.click(); 
	Thread.sleep(5000);
}
 public boolean checkResetVisible() {
		return wrapobj.checkElementVisibility(pUsername1);
}
 
 public String getFPAlertText(){
		String Text=pResetAlert.getText();
		return Text;
	   }
 //DashBoard
 public void clickDashBoard() {
	 pDashBoard.click();
}
 
 public String getDashBoardText(){
		String Text=pDashBoard.getText();
		return Text;
	   }
 
 public boolean checkDashBoardVisible() {
		return wrapobj.checkElementVisibility(pDashBoard);
}

 //Search
 public void clickSearch() {
	pMyInfo.click();
	wrapobj.waitForElement(pPersonalDetails);
}
 
 public String getMyInfoText(){
		String Text=pMyInfo.getText();
		return Text;
	   }

 public boolean checkMyInfoVisible() {
		return wrapobj.checkElementVisibility(pPersonalDetails);
}
 
 public boolean checkFirstVisible() {
		return wrapobj.checkElementVisibility(pFName);
}
 //PIM Add
 public void clickPIM() {
	 pPIM.click();
	 wrapobj.waitForElement(pAdd);
}
 
 public void clickAddButton() {
	 pAdd.click();
	 wrapobj.waitForElement(pFName);
}
 
 public void enterFName() throws InterruptedException {
	 pFName.sendKeys("abcd");
	 Thread.sleep(1000);
}
 
 public void enterLName() {
	 pLName.sendKeys("123");
} 
 
 public void clickSave() {
	 pSave.click(); 
	 wrapobj.waitForElement(pPersonalDetails);
 }
 
  public String getAlertText() {
	 Alert alert = driver.switchTo().alert();
	  return alert.getText(); 	
	}
 
  public boolean alertPresent() {
		 wrapobj.waitForAlert();
		 return true;
  }
  
  //Time
  public void clickTime() {
		 pTime.click(); 
		 wrapobj.waitForElement(pTimeSheets);
	 }
 
 public boolean checkTimeVisible() {
		return wrapobj.checkElementVisibility(pTimeSheets);
	}
 
 public String getTimeText(){
		String Text=pTime.getText();
		return Text;
	   }
 
 public void clickView()  {
	 pView.click();
	 wrapobj.waitForElement(pTimeTitle);
 }
 
 public void clickEdit()  {
	 pEdit.click();
	 wrapobj.waitForElement(pPersonalDetails);
 }
 
 public void enterMName() throws InterruptedException {
	 pMName.sendKeys("@");
	 Thread.sleep(1000);
}
 
 public void clickSave1()  {
	 pSave1.click();
	 wrapobj.waitForElement(pPersonalDetails);
 }
 
 public void enterEName() throws InterruptedException   {
	 pEName.sendKeys("abcd@123");
	 Thread.sleep(1000);
 }
 
 public void clickESearch() throws InterruptedException {
	 pESearch.click(); 
	 wrapobj.waitForElement(pInfo);
	 Thread.sleep(1000);
 }
 
 public boolean checkRecordVisible() {
		return wrapobj.checkElementVisibility(pInfo);
		}
	 
 
public void checkImageView() {
	 pimage.click(); 
 }
 
public boolean checkImageVisible() {
	return wrapobj.checkElementVisibility(pimage);
	}
 
public void clickLogout() {
	pLogout.click();
	 wrapobj.waitForElement(pTitleLogin);
}


}