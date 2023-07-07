package com.wrapper;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.*;

import com.testbase.TestBase;

public class Wrapper extends TestBase {
	//1.Select By Value
	public void selectByValue(WebElement pElement, String pValue ) {
		Select selector = new Select(pElement); 
		selector.selectByValue(pValue);
	}
 
	//2.Select By VisibleText
	public void selectByVisibleText(WebElement pElement, String pValue) {
		Select selector = new Select(pElement);
		selector.selectByVisibleText(pValue);
	}
	
	//3.Select By Index
		public void selectByIndex(WebElement pElement, int pValue) {
			Select selector = new Select(pElement);
			selector.selectByIndex(pValue);
		}
		
	//4.Move To Element
		public void moveToElement(WebDriver driver,WebElement pElement) {
			Actions action = new Actions(driver);
			Action pAction = action.moveToElement(pElement).build();
			pAction.perform();
		}
		
	//5.Scroll To Element
		public void scrollToElement(WebDriver driver,WebElement pElement) {
			Actions action = new Actions(driver);
			Action pAction = action.scrollToElement(pElement).build();
			pAction.perform();
		}
		
	//6.Drag And Drop
		public void dragAndDrop(WebDriver driver,WebElement from, WebElement to) {
			Actions action = new Actions(driver);
			Action dragAndDrop = action.dragAndDrop(from, to).build();
			dragAndDrop.perform();
		}
		
	//7.Scroll To View-JS Executor
		public void scrollToView(WebDriver driver, WebElement pElement) {
			JavascriptExecutor js = (JavascriptExecutor)driver;	
			js.executeScript("arguments[0].scrollIntoView();",pElement);
		}
		
	//8.Alert Accept
		public void alertAccept(WebDriver driver) {
			Alert alert = driver.switchTo().alert();
			alert.accept();
		}
		
	//9.Alert Dismiss
		public void alertDismiss(WebDriver driver) {
			Alert alert = driver.switchTo().alert();
			alert.dismiss();
		}
		
	//10.Alert Text
		public String alertText(WebDriver driver) {
			Alert alert = driver.switchTo().alert();
			return alert.getText();
		}
		
	//11.Return List Of Elements From Dropdown
		public List<WebElement> returnElementList(WebDriver driver, String pXpath){
			return driver.findElements(By.xpath(pXpath));
		}
		
	//12.Window Handle
		public void windowHandle(WebDriver driver) throws InterruptedException {
			String currentWindow = driver.getWindowHandle();
			driver.switchTo().window(currentWindow);
			
			Set<String> allWindows = driver.getWindowHandles();
			for (String temp : allWindows) {
				driver.switchTo().window(temp);
				Thread.sleep(5000);
			}
		}
		
	//13.iFrame Handle
		public void iFrameHandle(WebDriver driver, WebElement frameElement) {
			driver.switchTo().frame(frameElement);
		}
		
	//14.Alert SendKey And Accept	
		public void alertSendKeyAndAccept(WebDriver driver, String sKey) {
			Alert alert = driver.switchTo().alert();
			alert.sendKeys(sKey);
			alert.accept();	
		}
		
	//15.Scroll By Amount
		public void scrollByAmount(WebDriver driver, int a, int b) {
			Actions action1 = new Actions(driver);
			Action scroll = action1.scrollByAmount(a,b).build();
			scroll.perform();
		}
		
	//16.Wait For Element To Be Clickable
		public void waitForElement(WebElement pElement, WebDriver driver) {
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(pElement));
		}
		
	//17.Wait For Alert Present
		public void waitForAlert(WebDriver driver, Object pElement) {
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
			wait.until(ExpectedConditions.alertIsPresent());		
		}
		
	//18.Select Element From List By Value
		public void selectFromElementListByValue(List<WebElement> pList, String pValue) {
			for (WebElement pTemp : pList) {
				if (pTemp.getText().equalsIgnoreCase(pValue)){
				pTemp.click();
			    }
		    }
		}
		
	//19.Check Element Visibility
		public boolean checkElementVisibility(WebElement pElement) {
			return pElement.isDisplayed();	
		}
		
	//20.List And Select Object
		public void listAndSelect(String pXpath, String pString) {
			List<WebElement>pList = returnElementList(driver, pXpath);
			for(WebElement e : pList) {
				if(e.getText().equalsIgnoreCase(pString)) {
					e.click();
					break;
				}
			}
		}
		
}
