package Utilities;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.edge.EdgeDriver;

public class DriverSetup {
public static WebDriver driver;
	
public static WebDriver driverSetup(String browserName) {
	try {
		if (browserName.equalsIgnoreCase("Chrome")) {

			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		} else if (browserName.equalsIgnoreCase("Edge")) {

			driver = new EdgeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		}
	}

	catch (Exception e) {
		System.out.println(e.getMessage());
	}
	return driver;
}
}
