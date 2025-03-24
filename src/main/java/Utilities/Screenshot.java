package Utilities;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import org.openqa.selenium.WebDriver;

public class Screenshot {
	public static void takeScreenshot(WebDriver driver) throws IOException {
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
			TakesScreenshot scrShot = ((TakesScreenshot) driver);//Convert web driver object to TakeScreenshot

			File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);//Call getScreenshot method to create image file

			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss");
	        String timestamp = dateFormat.format(new Date());
			File DestFile = new File("./Screenshot/" + timestamp + ".png");//move image file to new designation

			FileUtils.copyFile(SrcFile, DestFile);//Copy file to desired location
			System.out.println("------Screenshot is taken successfully-------\n");
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
