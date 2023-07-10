package com.wrapper;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.testBase.TestBase;

public class Wrapper extends TestBase {
	
	public void waitForElement(WebElement pElement) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(pElement));
		
	}
	
	/*public void enterEmail(WebElement pEmail,String pValue) {
		pEmail.sendKeys(pValue);
	}
	
	public void enterName(WebElement pName,String pValue) {
		pName.sendKeys(pValue);
	}
	
	public void enterMessage(WebElement pmsg,String pValue) {
		pmsg.sendKeys(pValue);
	}*/
	
	public void waitForAlert() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.alertIsPresent());
	}
	
	public void waitForElement2(WebElement pElement) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(pElement));
	}
	
	public void  alertAccept() {
		Alert alert = driver.switchTo().alert(); 
		alert.accept();	
	}
	
	public String  alertText() {
		Alert GetText = driver.switchTo().alert(); 
		return GetText.getText();	
	}
	
	public boolean checkElementVisibility(WebElement pElement) {
		return pElement.isDisplayed();
		}
	
	public void selectByVisibleText(WebElement pElement,String pValue) {
		Select selectorCountry =new Select(pElement);
		 selectorCountry.selectByVisibleText(pValue);
	}
	
	
}
