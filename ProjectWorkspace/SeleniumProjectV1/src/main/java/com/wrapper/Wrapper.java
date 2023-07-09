package com.wrapper;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.testbase.TestBase;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
//import org.openqa.selenium.support.ui.Select;

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
	
//	public void selectByValue (WebElement pSelect, String pValue)
//	{
//		Select SelectElement = new Select(pSelect);
//		SelectElement.selectByValue(pValue);
//	}
	
	public List<WebElement> pSearchListDropDown(WebDriver driver,String pSearchList)
	{
		List <WebElement> pSearchListList = driver.findElements(By.xpath(pSearchList));
		return pSearchListList;
	}
	
	public void pSelectDropdown(String pXpath, String pValue)
	{
		 List<WebElement> pList = pSearchListDropDown(driver,pXpath);
		 for (WebElement pElement : pList) {
				if (pElement.getText().equalsIgnoreCase(pValue)) {
					pElement.click();
					break;
				}
			}
	}
	 
	

}
