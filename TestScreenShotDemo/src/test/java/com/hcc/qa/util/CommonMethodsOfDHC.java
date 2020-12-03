package com.hcc.qa.util;

import java.io.File;
import java.io.IOException;
import java.util.Base64;
import java.util.IllegalFormatException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;



public class CommonMethodsOfDHC{
	WebDriver driver;
	ExtentTest logger;
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

}
