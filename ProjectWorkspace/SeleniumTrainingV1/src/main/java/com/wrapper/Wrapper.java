package com.wrapper;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.testbase.TestBase;

public class Wrapper extends TestBase{

	//select by value
			public void selectByValue(WebElement pElement, String pValue) {
				
				Select selector = new Select(pElement);
				selector.selectByValue(pValue);
			}

			//select by visible text
			public void selectByVisibleText(WebElement pElement, String pValue) {
				Select selector = new Select(pElement);
				selector.selectByVisibleText(pValue);
			}
			

			//select by index
		public void selectByIndex(WebElement pElement, int pValue) {
				
				Select selector = new Select(pElement);
				selector.selectByIndex(pValue);
				}
			
			
			//move to element
			
			
		public void moveToElement(WebDriver driver, WebElement pElement) {
			Actions action = new Actions(driver);
			//action.moveToElement(pSwitchTo).build().perform();
			
			Action pAction = action.moveToElement(pElement).build();
			pAction.perform();
		  
		}
			
			
			//scroll to element
			
		public void scrollToElement(WebDriver driver, WebElement pElement) {
			Actions action = new Actions(driver);
			Action pAction = action.scrollToElement(pElement).build();
			pAction.perform();
			//action.moveToElement(pSubmit).build().perform();	
		}

			
		    //drag and drop
			
		public void DragAndDrop(WebDriver driver, WebElement pDragBoxFrom, WebElement pDragBoxTo) {
		    Actions action = new Actions(driver);
		    Action dragAndDrop = action.dragAndDrop(pDragBoxFrom, pDragBoxTo).build();
		    dragAndDrop.perform();
		    //action.dragAndDrop(pDragBoxFrom, pDragBoxTo).build().perform();		
		    //action.moveToElement(pDragBoxTo).build().perform();
		}
			
			//scroll to view

		public void scrollIntoView(WebDriver driver,WebElement pElement) {
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("arguments[0].scrollIntoView();",pElement);
		}
			
			//Wait for Alert Present – Wait Class
			//Wait for element to be Clickable – Wait Class
			
			public void explicitWait(WebDriver driver,Duration drtn,WebElement smallAlert) {
			WebDriverWait wait = new WebDriverWait(driver, drtn);
			wait.until(ExpectedConditions.alertIsPresent());
			wait.until(ExpectedConditions.elementToBeClickable(smallAlert));
			}
			
			//Alert Accept – Alert Class
			
			public void AlertAccept(WebDriver driver,WebElement AlertAcce) throws InterruptedException {
				  AlertAcce.click(); 
				  Thread.sleep(5000);
				  Alert alert = driver.switchTo().alert();
				  alert.accept();
				}
			
			//Alert Text – Alert Class
			
			public String AlertGetText(WebDriver driver,WebElement smallAlert) throws InterruptedException {
				  smallAlert.click(); 
				  Thread.sleep(2000);
				  Alert alert = driver.switchTo().alert();
				   return alert.getText();
				  
				}
			
			//Alert Dismiss – Alert Class
			
			public void AlertDismiss(WebDriver driver,WebElement smlAlert) throws InterruptedException {
				  smlAlert.click(); 
				  Thread.sleep(5000);
				  Alert alert = driver.switchTo().alert();
				  alert.dismiss();
				}
			
			//Return List of elements from Drop Down
			
			public void ReturnList(WebDriver driver,WebElement pSelectCountry) {
				pSelectCountry.click();
				List<WebElement> ReturnList = driver.findElements(By.xpath("//ul[@class='select2-results__options']//li"));
				ReturnList.get(5).click();
			}
			
			//Return List of elements from Drop Down language
			
			public List<WebElement> returnListOfElementsFromDropDown(WebDriver driver, String PLang){
				List<WebElement> pLangList = driver.findElements(By.xpath(PLang));
				return pLangList;
			}
			
			/*public void selectFromElementListByValue(String pValue,List<WebElement> pLanguageList){
				for(WebElement pTemp : pLanguageList) {
					if(pTemp.getText().equalsIgnoreCase(pValue)) {
						pTemp.click();
					}
				}
			}*/
			
			//Window Handle
			
			public void WindowHandle(WebDriver driver,WebElement pOpenNew ) {
				pOpenNew.click();
				pOpenNew.click();
				pOpenNew.click();
				pOpenNew.click();
				}
			
			//iFrame Handle Switch To
			
			public void SwitchToElement(WebDriver driver,WebElement pSwitchTo) {
		        Actions action = new Actions(driver);
		        Action pAction = action.moveToElement(pSwitchTo).build();
		        pAction.perform();
		    }
			
			//iFrameHandle Switch To Frame
			
			 public void switchToFrame(WebDriver driver,WebElement frameElement) {
			        driver.switchTo().frame(frameElement);
			    }
			
			//iFrameHandle EnterText
			
			public void enterText(WebElement textInFrame, String text) {
				textInFrame.sendKeys("Test");;
		    }
			
			//wait for element
			
			public void waitForElement(WebElement pElement) {
				WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(60));
				wait.until(ExpectedConditions.elementToBeClickable(pElement));
			}
			
			//wait for element to be visible
			
					public void waitForElementVisible(WebElement pElement) {
						WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
						wait.until(ExpectedConditions.visibilityOf(pElement));
					}
			
			/*public void iFrameHandle(WebDriver driver,WebElement pSwitchTo,WebElement frameElement,WebElement textInFrame) {
				Actions action = new Actions(driver);
				action.moveToElement(pSwitchTo).build().perform();
				
				
				driver.switchTo().frame(frameElement);
				textInFrame.sendKeys("Test");

			}*/
			
			public void enterTextContact(WebElement pElement, String pValue) {
				pElement.sendKeys(pValue);
			}
			
			public void waitForAlert() {
				WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
				wait.until(ExpectedConditions.alertIsPresent());
			}
			
			public String getAlertText() {
				Alert alert = driver.switchTo().alert();
				return alert.getText();
			}
			
			public boolean checkElementVisibility(WebElement pElement) {
				return pElement.isDisplayed();
			}
			
			public boolean checkAlertPresent(WebElement pElement) {
				return pElement.isDisplayed();
			}
			public void enterSignUpDetails(WebElement pElement,String pValue) {
				pElement.sendKeys(pValue);
			}
			public void enterLoginDeatails(WebElement pElement, String pValue) {
				pElement.sendKeys(pValue);
				
			}
			public void enterTravellerDetails(WebElement pElement, String pValue) {
				pElement.sendKeys(pValue);
			}
			public void ReturnListState(WebDriver driver,WebElement pElement) {
				pElement.click();
				List<WebElement> ReturnListState = driver.findElements(By.xpath("//*[@id=\\\"liFrom\\\"]/div/h6"));
				ReturnListState.get(3).click();
			}
			public void selectDate(WebElement datePicker,String date) {
				datePicker.clear();
				datePicker.sendKeys(date);
			}
			public void enterOrangeLoginDetails(WebElement pElement,String pValue) {
				pElement.sendKeys(pValue);
			}
}
