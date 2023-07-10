package com.wrapper;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.testbase.TestBase;

public class Wrapper extends TestBase{
	 // select By Value
		public void selectByValue(WebElement pSelect,String pValue){
			Select selector=new Select(pSelect);
			selector.selectByValue(pValue);
		}
		       // select By Visible Text
		public void selectByVisibleText(WebElement pSelect,String pValue){
			Select selector=new Select(pSelect);
			selector.selectByVisibleText(pValue);
		}
		       // select By Index
		public void selectByIndex(WebElement pSelect,int pValue){
			Select selector=new Select(pSelect);
			selector.selectByIndex(pValue);
		}
		       // Move To Element
		public void moveToElement(WebElement Submit){
			Actions action =new Actions(driver);
			Action click = action.moveToElement(Submit).contextClick().build();
			click.perform();
		}
		       //Scroll To Element
		public void scrollToElement(WebElement pSubmit){
			Actions action = new Actions(driver);
			Action pAction = action.scrollToElement(pSubmit).build();
			pAction.perform();
		}
		       //Drag and Drop 
		public void DragAndDrop(WebElement psource,WebElement  ptarget){
			Actions builder = new Actions(driver);
			Action dragAndDrop = builder.dragAndDrop(psource, ptarget).build();
		    dragAndDrop.perform();
		}
		       //Scroll To View
		public void scrollTOView(WebElement pSubmit){
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", pSubmit);
		
		} 
		       //Wait for element to be Clickable    
		public void waitForElement(WebElement pElement){
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(pElement));
		}
		       //Wait for Alert Present         
	 public void waitForAlert(){
	 	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	 	wait.until(ExpectedConditions.alertIsPresent());
		}
		
		       //Alert Accept
		public void alertAccept(){
		
			 Alert alert = driver.switchTo().alert();
			 alert.accept();
		}
		       //Alert Dismiss
		public void alertDismiss(){
			 
			 Alert alertdismiss =driver.switchTo().alert();
			 alertdismiss.dismiss();
		}
		       //Alert Text
		public String alertText(){
			 
			 Alert alertGetText =driver.switchTo().alert();
			 return alertGetText.getText();
		}
		
		       //Return List of elements from Drop Down  

		public List<WebElement> returnListOfElementsFromDropDown(String pElement) {
			List<WebElement> pLangList= driver.findElements(By.xpath(pElement));
			return pLangList;
		}
		        
		       // select  element list by value
		public void selectFromElementListValue(String pElement,List<WebElement> pElementList ) {
			for(WebElement pTemp:pElementList) {
				  if(pTemp.getText().equalsIgnoreCase(pElement)){ 
				  pTemp.click();
				  }
				 }
			}
		
		       //Window Handle
		public void WindowHandle()throws InterruptedException {
			                     // To get the current window handle.
			String currentWindow = driver.getWindowHandle();
			                     // To get all window handles.
	      Set<String> allWindows = driver.getWindowHandles();
			for (String temp : allWindows) {
				driver.switchTo().window(temp);
				Thread.sleep(5000);
			}
			driver.switchTo().window(currentWindow);
		}
		
	        //iFrame Handle   
		public void iFrameHandle(WebElement  frameElement ){
				driver.switchTo().frame(frameElement);
				}
		public boolean checkElementVisibility(WebElement pElement) {
			return pElement.isDisplayed();
		}
}
