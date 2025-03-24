package PageClass;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import Utilities.DriverSetup;

import Utilities.PropertiesFile;

public class BeCognizantPage extends DriverSetup {
	
	//login
    static By username=By.id("i0116");
    static By password= By.id("i0118");
    static By next=By.xpath("//input[@type='submit']");
    static By signin=By.xpath("//input[@data-report-event=\"Signin_Submit\"]");
    static By yes=By.xpath("//input[@value='Yes']");
    //userInfo
    static By user=By.xpath("//*[@id='O365_UniversalMeContainer']");
    static By useracc=By.xpath("//*[@id='O365_MainLink_Me']");
    static By name=By.id("mectrl_currentAccount_primary");
    static By mailid=By.id("mectrl_currentAccount_secondary");
    //peopleTab
    static By countries=By.xpath("//span[contains(text(),'Markets and Countries')]");
    static By peopletab=By.xpath("//*[@name='People']");
    static By rewards=By.xpath("//*[@name='Rewards, Life and Work']");
    static By holidayschedules=By.name("Holiday Schedules");
    static By title=By.xpath("//div[@title='Holiday Schedules']");
    static By h4=By.xpath("//h4");
       
	public static void logIn(WebDriver driver) throws IOException, InterruptedException {
		// Enter Credentials
		try {
		String Name = PropertiesFile.readProperties("name");
		driver.findElement(username).sendKeys(Name);
		driver.findElement(next).click();
		}catch(Exception e) {
			System.out.print("Email not required");
		}
		String Pass = PropertiesFile.readProperties("pass");
		driver.findElement(password).sendKeys(Pass);
		Thread.sleep(4000);
		driver.findElement(next).click();
		Thread.sleep(4000);
		driver.findElement(yes).click();
		
	}

	public static void userInfo() throws InterruptedException {

		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(user)).build().perform();
		driver.findElement(useracc).click();
		Thread.sleep(1000);

		// User Account details
		System.out.println("*****User Account Details*****");
		WebElement primaryElement = driver.findElement(name);
		
		//Thread.sleep(3000);
		String Name = primaryElement.getText();
		System.out.println("        ");
		System.out.println(Name);
		WebElement secondaryElement = driver.findElement(mailid);
		String Id = secondaryElement.getText();
		System.out.println(Id);
//		Thread.sleep(3000);
//		driver.findElement(useracc).click();
		System.out.println("        ");
		System.out.println("---------********************-------------");
		System.out.println("        ");
	}

	public static void peopleTab() throws InterruptedException {
		// Click on people tab
		driver.findElement(countries).click();
		Thread.sleep(2000);
		driver.findElement(peopletab).click();
		Actions action = new Actions(driver);

		action.moveToElement(driver.findElement(rewards)).build().perform();
		// verify Holiday Schedules displayed or not

		WebElement holidaySchedule = driver.findElement(holidayschedules);
		if (holidaySchedule.isDisplayed()) {
			System.out.println("Holiday schedule is displayed.");
		} else {
			System.out.println("Holiday schedule is not displayed.");
		}
		System.out.println("        ");
		System.out.println("---------********************-------------");
		System.out.println("        ");

		// Click on Holiday Schedules and also verify you correctly navigate to Holiday
		// Schedules or not
	
		driver.findElement(By.name("Holiday Schedules")).click();
		Thread.sleep(2000);
		String currentTitle = driver.findElement(title).getText();
		String expectedTitle = "Holiday Schedules";
		if (currentTitle.equals(expectedTitle)) {
			System.out.println("Correctly navigate to Holiday schedules.");
		} else {
			System.out.println("You might be on the wrong application.");
		}
		System.out.println("        ");
		System.out.println("---------********************-------------");
		System.out.println("        ");

		WebElement element = driver.findElement( h4);
		String info = element.getText();
		System.out.println("Page Infomation: " + info);
		System.out.println("        ");
		System.out.println("---------********************-------------");
		System.out.println("        ");
		Thread.sleep(2000);

	}
}
