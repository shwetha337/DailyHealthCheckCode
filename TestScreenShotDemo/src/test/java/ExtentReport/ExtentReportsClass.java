package ExtentReport;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;
import java.util.IllegalFormatException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.dhc.qa.pages.HomePage;
import com.hcc.qa.util.ExcelDataReading;
import com.hcc.qa.util.WebEventListener;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ExtentReportsClass {
	ExtentReports extent;
	ExtentTest logger;
	HomePage homePage;

	WebDriver driver;
	ExcelDataReading excel = new ExcelDataReading();
	WebEventListener eventListener;
	EventFiringWebDriver e_driver;
	
	 public ExtentReportsClass() {
		super();
	}

	@BeforeTest
	public void startReport() {

		extent = new ExtentReports(System.getProperty("user.dir") + "./Report/STMExtentReport.html", true);
		// extent.addSystemInfo("Environment","Environment Name")
		extent.addSystemInfo("Host Name", "Paladion").addSystemInfo("Environment", "Automation Testing")
				.addSystemInfo("User Name", "Shwetha S");

		extent.loadConfig(new File(System.getProperty("user.dir") + "\\extent-config.xml"));
	}

	@DataProvider
	public Object[][] paladionNetworksWithO365Data() {

		Object data[][] = excel.getTestData("Paladion Networks With O365");
		return data;
	}

	@Test(dataProvider = "paladionNetworksWithO365Data", priority = 1)
	public void PaladionNetworksWithAzureAndOffice365(String url, String name)
			throws IOException, InterruptedException {

		logger = extent.startTest("PaladionNetworksWithAzureAndOffice365");

		basicsetup(url, name);

	}

	@DataProvider
	public Object[][] paladionNetworksAzure() {

		Object data[][] = excel.getTestData("Paladion Networks with Azure");
		return data;
	}

	@Test(dataProvider = "paladionNetworksAzure", priority = 2)
	public void paladionNetworksWithAzure(String url, String name) throws IOException, InterruptedException {
		logger = extent.startTest("paladionNetworksWithAzure");
		basicsetup(url, name);

	}

	@DataProvider
	public Object[][] paladionNetworkswithAws() {

		Object data[][] = excel.getTestData("Paladion Networks with AWS");
		return data;
	}

	@Test(dataProvider = "paladionNetworkswithAws", priority = 2)
	public void paladionNetworksWithAws(String url, String name) throws IOException, InterruptedException {

		logger = extent.startTest("paladionNetworksWithAzure");
		basicsetup(url, name);

	}

	/*@DataProvider
	public Object[][] ASMData() {

		Object data[][] = excel.getTestData("ASM");
		return data;
	}

	@Test(dataProvider = "ASMData", priority = 2)
	public void ASMShippingPvtLtdwithazureAndoffice365(String url, String name)
			throws IOException, InterruptedException {

		logger = extent.startTest("ASMData");
		basicsetup(url, name);

	}*/

	@DataProvider
	public Object[][] uplData() {
		Object data[][] = excel.getTestData("UPL");
		return data;
	}

	@Test(dataProvider = "uplData", priority = 3)
	public void UPL(String url, String name) throws IOException, InterruptedException {
		logger = extent.startTest("UPL");
		basicsetup(url, name);

	}

	@DataProvider
	public Object[][] AlMuhaidib() {
		Object data[][] = excel.getTestData("Al Muhaidib");
		return data;
	}

	@Test(dataProvider = "AlMuhaidib", priority = 4)
	public void AlMuhaidib(String url, String name) throws IOException, InterruptedException {
		logger = extent.startTest("AlMuhaidib");
		basicsetup(url, name);

	}

	@DataProvider
	public Object[][] goDigitData() {
		Object data[][] = excel.getTestData("GoDigit");
		return data;
	}

	@Test(dataProvider = "goDigitData", priority = 5)
	public void goDigitWithAWS(String url, String name) throws IOException, InterruptedException {
		logger = extent.startTest("goDigitAWS");
		basicsetup(url, name);

	}

	@DataProvider
	public Object[][] ASGData() {
		Object data[][] = excel.getTestData("ASG");
		return data;
	}

	@Test(dataProvider = "ASGData", priority = 6)
	public void ASG(String url, String name) throws IOException, InterruptedException {
		logger = extent.startTest("ASG");
		basicsetup(url, name);

	}

	@DataProvider
	public Object[][] SPIGlobal() {
		Object data[][] = excel.getTestData("SPI global");
		return data;
	}

	@Test(dataProvider = "SPIGlobal", priority = 7)
	public void spiGlobalAzureAndOffice365(String url, String name) throws IOException, InterruptedException {
		logger = extent.startTest("spiGlobalAzureAndOffice365");
		basicsetup(url, name);

	}

	@DataProvider
	public Object[][] Trainz() {
		Object data[][] = excel.getTestData("Trainz");
		return data;
	}

	@Test(dataProvider = "Trainz", priority = 8)
	public void TrainzWithAzure(String url, String name) throws IOException, InterruptedException {
		logger = extent.startTest("TrainzWithAzure");
		basicsetup(url, name);

	}

	@DataProvider
	public Object[][] SPIGlobalWithAWS() {
		Object data[][] = excel.getTestData("SPI global1");
		return data;
	}

	@Test(dataProvider = "SPIGlobalWithAWS", priority = 9)
	public void SPIGlobalWithAWS(String url, String name) throws IOException, InterruptedException {
		logger = extent.startTest("SPIGlobalWithAWS");
		basicsetup(url, name);

	}

	@DataProvider
	public Object[][] UNICOIL() {
		Object data[][] = excel.getTestData("UNICOIL");
		return data;
	}

	@Test(dataProvider = "UNICOIL", priority = 11)
	public void UNICOIL(String url, String name) throws IOException, InterruptedException {
		logger = extent.startTest("UNICOIL");
		basicsetup(url, name);

	}

	@DataProvider
	public Object[][] UtkarshBank() {
		Object data[][] = excel.getTestData("Utkarsh Bank");
		return data;
	}

	@Test(dataProvider = "UtkarshBank", priority = 13)
	public void UtkarshBank(String url, String name) throws IOException, InterruptedException {
		logger = extent.startTest("UtkarshBank");
		basicsetup(url, name);

	}

	@DataProvider
	public Object[][] commonsaaslecind() {
		Object data[][] = excel.getTestData("commonsaaslecind");
		return data;
	}

	@Test(dataProvider = "commonsaaslecind", priority = 14)
	public void commonsaaslecind(String url, String name) throws IOException, InterruptedException {
		logger = extent.startTest("commonsaaslecind");
		basicsetup(url, name);

	}

	@DataProvider
	public Object[][] ThomasCookData() {
		Object data[][] = excel.getTestData("ThomasCook");
		return data;
	}

	@Test(dataProvider = "ThomasCookData", priority = 15)
	public void ThomasCook(String url, String name) throws IOException, InterruptedException {
		logger = extent.startTest("ThomasCook");
		basicsetup(url, name);

	}

	@DataProvider
	public Object[][] GoDigitAzureAndOffice365() {
		Object data[][] = excel.getTestData("GoDigit1");
		return data;
	}

	@Test(dataProvider = "GoDigitAzureAndOffice365", priority = 16)
	public void GoDigitAzureAndOffice365(String url, String name) throws IOException, InterruptedException {
		logger = extent.startTest("GoDigitAzureAndOffice365");
		basicsetup(url, name);

	}

	@DataProvider
	public Object[][] commonsaaslecwipfli() {
		Object data[][] = excel.getTestData("commonsaaslecwipfli");
		return data;
	}

	@Test(dataProvider = "commonsaaslecwipfli", priority = 17)
	public void commonsaaslecwipfli(String url, String name) throws IOException, InterruptedException {
		logger = extent.startTest("commonsaaslecwipfli");
		basicsetup(url, name);

	}

	@DataProvider
	public Object[][] MCGUIREData() {
		Object data[][] = excel.getTestData("MCGUIRE");
		return data;
	}

	@Test(dataProvider = "MCGUIREData", priority = 18)
	public void MCGUIRE(String url, String name) throws IOException, InterruptedException {
		logger = extent.startTest("MCGUIRE");
		basicsetup(url, name);

	}

	@DataProvider
	public Object[][] WipfliLLPData() {
		Object data[][] = excel.getTestData("Wipfli LLP");
		return data;
	}

	@Test(dataProvider = "WipfliLLPData", priority = 19)
	public void WipfliLLPWithAzureAndO365(String url, String name) throws IOException, InterruptedException {
		logger = extent.startTest("WipfliLLPWithAzureAndO365");
		basicsetup(url, name);

	}

	@DataProvider
	public Object[][] HPGData() {
		Object data[][] = excel.getTestData("HPG");
		return data;
	}

	@Test(dataProvider = "HPGData", priority = 20)
	public void HPG(String url, String name) throws IOException, InterruptedException {
		logger = extent.startTest("HPG");
		basicsetup(url, name);

	}

	@DataProvider
	public Object[][] commonsaaslecusa() {
		Object data[][] = excel.getTestData("commonsaaslecusa");
		return data;
	}

	@Test(dataProvider = "commonsaaslecusa", priority = 21)
	public void commonsaaslecusa(String url, String name) throws IOException, InterruptedException {
		logger = extent.startTest("commonsaaslecusa");
		basicsetup(url, name);

	}

	@DataProvider
	public Object[][] commonsaaslecpocusa() {
		Object data[][] = excel.getTestData("commonsaaslecpocusa");
		return data;
	}

	@Test(dataProvider = "commonsaaslecpocusa", priority = 22)
	public void commonsaaslecpocusa(String url, String name) throws IOException, InterruptedException {
		logger = extent.startTest("commonsaaslecpocusa");
		basicsetup(url, name);

	}

	@DataProvider
	public Object[][] mdrazcentrallec() {
		Object data[][] = excel.getTestData("mdrazcentrallec");
		return data;
	}

	@Test(dataProvider = "mdrazcentrallec", priority = 22)
	public void mdrazcentrallec(String url, String name) throws IOException, InterruptedException {
		logger = extent.startTest("mdrazcentrallec");
		basicsetup(url, name);

	}

	@AfterMethod
	public void getResult(ITestResult result) throws Exception {
		if (result.getStatus() == ITestResult.FAILURE) {
			logger.log(LogStatus.FAIL, "Test Case Failed is " + result.getName());
			logger.log(LogStatus.FAIL, "Test Case Failed is " + result.getThrowable());
		} else if (result.getStatus() == ITestResult.SKIP) {
			logger.log(LogStatus.SKIP, "Test Case Skipped is " + result.getName());
		}

		extent.endTest(logger);
	}

	@AfterTest
	public void endReport() {

		extent.flush();
		extent.close();
		driver.quit();
	}

	public void LOGWithScreenshot(ExtentTest logger, String status, String TestDescription)
			throws IOException, IllegalFormatException {
		String Base64StringofScreenshot = "";
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		byte[] fileContent = FileUtils.readFileToByteArray(src);
		Base64StringofScreenshot = "data:image/png;base64," + Base64.getEncoder().encodeToString(fileContent);
		if (status.equalsIgnoreCase("fail")) {
			// logger.log(LogStatus.PASS,
			// TestDescription+"\n"+logger.addBase64ScreenShot(Base64StringofScreenshot));
			// else
			logger.log(LogStatus.FAIL, TestDescription + "\n" + logger.addBase64ScreenShot(Base64StringofScreenshot));
		}
	}

	public void checkigTheTotalQueueddata(String name) throws IOException, InterruptedException {
		/*homePage=new HomePage();
		String value =homePage.getQueuedData();
		logger.log(LogStatus.INFO, "The Total queued data found is :" + value);
		
		String[] sval = value.split("/");

		String secHalf = sval[1];
		String[] splitStr = secHalf.split("\\s+");

		String num = splitStr[1];
		String string = splitStr[2];
		float i = Float.parseFloat(num);

		if (i >= 25 && string.equals("MB") || string.equals("GB")) {

			LOGWithScreenshot(logger, "fail", "The Total Queued Data is More than 25MB");
		}

		else {
			logger.log(LogStatus.PASS, "Checked for Total Queued data, Queued data is not more than 25MB");

		}

		logger.log(LogStatus.INFO, "Checking for error messages");
		checkingForErrorMessages(name);*/
		
		Thread.sleep(4000);
		WebElement totalQueuedData = driver.findElement(By.xpath("//span[@id='total-queued']"));

		Thread.sleep(4000);
		String value = totalQueuedData.getText();
		logger.log(LogStatus.INFO, "The Total queued data found is :" + value);

		String[] sval = value.split("/");

		String secHalf = sval[1];
		String[] splitStr = secHalf.split("\\s+");

		String num = splitStr[1];
		String string = splitStr[2];
		float i = Float.parseFloat(num);

		if (i >= 25 && string.equals("MB") || string.equals("GB")) {

			// logger.log(LogStatus.FAIL,"The Total Queued Data is More than
			// 25MB ,taking the screenshot");
			LOGWithScreenshot(logger, "fail", "The Total Queued Data is More than 25MB");
		}

		else {
			logger.log(LogStatus.PASS, "Checked for Total Queued data, Queued data is not more than 25MB");

		}

		logger.log(LogStatus.INFO, "Checking for error messages");
		checkingForErrorMessages(name);

	}

	public void checkingForErrorMessages(String name) throws InterruptedException, IOException {

/*	   homePage=new HomePage();
	   homePage.clickOnzoomBtn();
	   homePage.clickOnglobalButton();
	   homePage.clickOnbulletinBoard();
	   driver.switchTo().frame("shell-iframe");
	   int xpathCount=homePage.listOfValues();
	   if (xpathCount >= 1) {

			LOGWithScreenshot(logger, "fail", "Error exist in the Nifi Parser,Taking the screenshot");
		} else {
			logger.log(LogStatus.PASS, "No errors found!!! in Nifi Parser");

		}
	   driver.quit();*/
		WebElement zoomBtn = driver.findElement(By.xpath("//div[@id='naviagte-zoom-actual-size']//button"));
		zoomBtn.click();

	

		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement globalButton = driver.findElement(By.xpath("//button[@id='global-menu-button']"));
		wait.until(ExpectedConditions.elementToBeClickable(globalButton));
		globalButton.click();

		WebElement bulletinBoard = driver.findElement(By.xpath("//a[@id='bulletin-board-link']"));
		wait.until(ExpectedConditions.elementToBeClickable(bulletinBoard));
		bulletinBoard.click();

		driver.switchTo().frame("shell-iframe");
		Thread.sleep(3000);

		List<WebElement> myElements = driver
				.findElements(By.xpath("//div[@id='bulletin-board-container']//div[@class='bulletin']"));
		int xpathCount = myElements.size();

		if (xpathCount >= 1) {

			LOGWithScreenshot(logger, "fail", "Error exist in the Nifi Parser,Taking the screenshot");
		} else {
			logger.log(LogStatus.PASS, "No errors found!!! in Nifi Parser");

		}

		driver.quit();
	}

	public void basicsetup(String url, String name) {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Pal\\workspace1\\TestScreenShotDemo\\drivers\\chromedriver.exe");
		// Initialize browser
		driver = new ChromeDriver();
		// Maximize browser

		driver.manage().window().maximize();
		e_driver = new EventFiringWebDriver(driver);

		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;

		driver.manage().timeouts().pageLoadTimeout(2, TimeUnit.MINUTES);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// Open nifi
		try {
			driver.get(url);

		} catch (Exception e) {

			System.out.println("NullPointerException thrown!,Not found the Element");
			logger.log(LogStatus.FAIL, "Nifi LEC is not Loading");
			driver.close();
		}

		logger.log(LogStatus.INFO, "Client is : " + name + " " + "URL is : " + url);
		logger.log(LogStatus.INFO, "Checking forTotal Queued data");

		try {
			logger.log(LogStatus.INFO, "Checking for error messages");

			checkigTheTotalQueueddata(name);
		} catch (Exception e) {

			System.out.println("NullPointerException thrown!,Not found the Element");

		}
		// test.log(Status.INFO,"Checking for error messages");
		// QueuedDataAndExceptions.checkingForErrorMessages(name);
	}

}
