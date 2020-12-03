package com.dhc.qa.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class HomePage  {
	
	WebDriver driver;
	ExtentReports extent;
	ExtentTest logger;
	WebDriverWait wait = new WebDriverWait(driver, 30);
	
	@FindBy(xpath = "//span[@id='total-queued']")
	WebElement totalQueuedData;
	
	@FindBy(xpath = "//div[@id='naviagte-zoom-actual-size']//button")
	WebElement zoomBtn;
	
	@FindBy(xpath = "//button[@id='global-menu-button']")
	WebElement globalButton;
	
	@FindBy(xpath = "//a[@id='bulletin-board-link']")
	WebElement bulletinBoard;

	@FindBy(xpath = "//a[@id='bulletin-board-link']")
	List<WebElement> myElements;
	
	public HomePage() {
		
		
		
		PageFactory.initElements(driver, this);
	}
	
   public void clickOnzoomBtn(){
		zoomBtn.click();
	}
	
	public void clickOnglobalButton(){
		
		wait.until(ExpectedConditions.elementToBeClickable(globalButton));
		globalButton.click();
	}
	
	public void clickOnbulletinBoard(){
		wait.until(ExpectedConditions.elementToBeClickable(bulletinBoard));
		bulletinBoard.click();
	}

	public String getQueuedData() {
		String value = totalQueuedData.getText();
		return value;
	}
	
	public int listOfValues(){
		int xpathcount=myElements.size();
		return xpathcount;
	}
 }
