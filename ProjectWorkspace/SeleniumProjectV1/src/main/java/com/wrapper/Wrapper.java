package com.wrapper;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.testbase.TestBase;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Wrapper extends TestBase {

	public void waitForElement(WebElement pMessageButton) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(pMessageButton));
		
	}
	
	public void waitForAlert()
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.alertIsPresent());
		
	}
	
	public String getAlertText()
	{
		Alert alert = driver.switchTo().alert();
		return alert.getText();
	}
	
	public void alertAccept()
	{
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}
	
	public boolean checkElementVisibility (WebElement pElement)
	{
		return pElement.isDisplayed();
	}
	 
	

}

