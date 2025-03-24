package PageClass;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import Utilities.DriverSetup;
import Utilities.ExcelWrite;

public class HolidaySchedules extends DriverSetup {
	public static WebElement element = null;
	public static String fname = "";

	// holidayCalendars
	static By peoplename = By.xpath("//*[@name='People']");
	static By rewards = By.xpath("//*[@name='Rewards, Life and Work']");
	static By benifits = By.linkText("Benefits & Wellbeing");
	static By holidaycalendar = By.xpath("//div[@title='Holiday Calendars']");
	// verifyYear
	static By year = By.xpath("//*[@id='2023​​​​​​​']/span[1]");
	// clickOnCalendars
	static By calendars = By.xpath("//*[@id=\"d589ce2f-0fd1-4ea1-8706-433e6c41297e\"]/div/div/div");
	// verifyPDF
	static By filter = By.xpath("//*[@aria-label='Open the filters pane']");
	static By PDF = By.xpath("//*[@id='FiltersPane-id']/div[3]/div[2]/div/div[1]/div[1]/div[1]/label/div");
	static By pdfdata = By.xpath(
			"//*[@class='ms-Link root_c37e4642 nameField_dd1019e7 clickable_dd1019e7 overflow_7939f24e pre_7939f24e']");
	// verifyWord
	static By word = By.xpath("//*[@id=\"FiltersPane-id\"]/div[3]/div[2]/div/div[2]/div[1]/div[1]/label/div");
	static By worddata = By.xpath(
			"//*[@class='ms-Link root_c37e4642 nameField_dd1019e7 clickable_dd1019e7 overflow_7939f24e pre_7939f24e']");
	// verifySelectFile
	static By file = By.xpath(
			"//div[@aria-label='Toggle selection for all items']//div//i[@data-icon-name='StatusCircleCheckmark']");
	static By fileselection = By
			.xpath("//button[@title='Clear selection']/span[@data-automationid='splitbuttonprimary']/span[1]/span[1]");
	static By namefield = By.xpath(
			"//*[@class=\"ms-Link root_4af3cd9e nameField_91b2ee42 clickable_91b2ee42 overflow_7939f24e pre_7939f24e\"]");
	// verifyDeselectFile
	static By clearselection = By.xpath("//button[@title='Clear selection']");
	static By toggleselection = By.xpath(
			"//div[@aria-label='Toggle selection for all items']//div//i[@data-icon-name='StatusCircleCheckmark']");
	static By indiacalender = By.xpath(
			"/html/body/div[1]/div/div[2]/div[1]/div[2]/div[3]/div/div[3]/div[2]/div[2]/div[2]/div[1]/div/div/div/div/div/div[3]/div/div/div/div/div[2]/div/div/div/div/div/div[6]/div/div/div/div[2]/div[2]/div/div[1]/div[1]/span/span[1]/button");
	// verifyName
	static By titleindiacalendar = By.xpath(
			"//button[@title='india-holiday-calendar-2023 (1).pdf']//span[@data-automationid='splitbuttonprimary']//span//span");
	// clickOnVersionHistory
	static By buttonversion = By.xpath("//button[@title='Other things you can do with the selected items']");
	static By versionhistory = By.xpath("//button[@title='Version history']");
	// getData
	static By iframe = By.xpath("//iframe[@title='Version history']");
	static By headingclass = By.xpath("//*[@class='ms-vh2-nofilter']/a");
	static By information = By
			.xpath("//body[1]/form[1]/div[12]/div[1]/div[2]/div[2]/div[3]/table[1]/tbody[1]/tr[2]/td");

	public static void holidayCalendars(WebDriver driver) throws InterruptedException {

		// Click on people
		driver.findElement(peoplename).click();
		// Click on Rewards,Life and Work
		driver.findElement(rewards).click();
		Thread.sleep(5000);

		// Click on Holiday Calendars
		Actions action = new Actions(driver);
		WebElement ele = driver.findElement(benifits);
		action.moveToElement(ele).build().perform();

		WebElement elementToClick = driver.findElement(holidaycalendar);
		action.moveToElement(elementToClick).click().build().perform();
	}

	public static void verifyYear(WebDriver driver) {
		// Verify current year
		element = driver.findElement(year);
		String year = element.getText();
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		String currentYear = jsExecutor.executeScript("return new Date().getFullYear().toString();").toString();
		if (year.equals(currentYear)) {
			System.out.println("Current year Displayed");
		}
		System.out.println("     ");
		System.out.println("---------********************-------------");
		System.out.println("     ");
	}

	public static void clickOnCalendars(WebDriver driver) throws InterruptedException {
		// Click on India, America and UKI calendars button
		driver.findElement(calendars).click();
		Thread.sleep(5000);
	}

	public static void verifyPDF(WebDriver driver) throws InterruptedException {
		// Click on filter
		driver.findElement(filter).click();

		// Click on PDF checkbox
		driver.findElement(PDF).click();

		// verify PDF related data is displayed or not
		List<WebElement> pdf = driver.findElements(pdfdata);
		String[] name = new String[pdf.size()];

		String temp = "";
		for (int i = 0; i < pdf.size(); i++) {
			temp = pdf.get(i).getText();
			if (temp.contains(".pdf")) {
				name[i] = temp;

			} else
				System.out.println("This is not a pdf file");
		}
		System.out.println("Only pdf files are displayed");
		System.out.println("     ");
		System.out.println("---------********************-------------");
		System.out.println("     ");
	}

	public static void verifyWord(WebDriver driver) throws InterruptedException {
		// Unselect pdf checkbox
		driver.findElement(PDF).click();

		// Click on word checkbox
		driver.findElement(word).click();

		// verify word related data is displayed or not
		List<WebElement> doc = driver.findElements(worddata);
		String[] name = new String[doc.size()];
		String temp = "";
		for (int i = 0; i < doc.size(); i++) {
			temp = doc.get(i).getText();
			if (temp.contains(".docx")) {
				name[i] = temp;
			} else
				System.out.println("This is not a word file");
		}
		System.out.println("Only word files are displayed");
		System.out.println("     ");
		System.out.println("---------********************-------------");
		System.out.println("     ");
	}

	public static void verifySelectFile(WebDriver driver) throws InterruptedException {
		// Click on PDF checkbox
		driver.findElement(PDF).click();
		// Select all file
		driver.findElement(file).click();
		element = driver.findElement(fileselection);
		String Actual_Selected_file = element.getText();
		Actual_Selected_file = Actual_Selected_file.replaceAll("[^0-9]", "");
		System.out.println("Total files: " + Actual_Selected_file);
		List<WebElement> files = driver.findElements(namefield);
		String Expected_selected_file = Integer.toString(files.size());
		if (Actual_Selected_file.equals(Expected_selected_file)) {
			System.out.println("All files are selected successfully");
		} else {
			System.out.println("All files not  selected successfully");
		}
		System.out.println("     ");
		System.out.println("---------********************-------------");
		System.out.println("     ");
	}

	public static void verifyDeselectFile(WebDriver driver) throws InterruptedException {
		// Clear all selected file
		driver.findElement(clearselection).click();
		Thread.sleep(2000);
		element = driver.findElement(toggleselection);
		if (!element.isSelected())
			System.out.println("file deselected");
		else {
			System.out.println("file is selected");
		}
		System.out.println("     ");
		System.out.println("---------********************-------------");
		System.out.println("     ");
		Thread.sleep(2000);
	}

	public static void clickOnIndia(WebDriver driver) throws InterruptedException {
		// Click on India holiday calendar
		driver.findElement(indiacalender).click();
		
		Thread.sleep(2000);
	}

	public static void verifyName(WebDriver driver) throws InterruptedException {
		// Verify whether navigate India holiday calender or not
		Set<String> windowHandles = driver.getWindowHandles();
		String mainWindowHandle = driver.getWindowHandle();
		for (String handle : windowHandles) {
			if (!handle.equals(mainWindowHandle)) {
				driver.switchTo().window(handle);
				break;
			}
		}
		element = driver.findElement(titleindiacalendar);
		fname = element.getText();
		Thread.sleep(2000);
		if (fname.contains("india-holiday")) {
			System.out.println("Successfully open the India Holiday Calendar file");
		} else
			System.out.println("different file will open");
		System.out.println("     ");
		System.out.println("---------********************-------------");
		System.out.println("     ");

	}

	public static void clickOnVersionHistory(WebDriver driver) throws InterruptedException {
		driver.findElement(buttonversion).click();
		Thread.sleep(1000);
		driver.findElement(versionhistory).click();
		Thread.sleep(2000);
	}

	public static void getData(WebDriver driver) throws InterruptedException {
		System.out.println("*******Version History*******");
		driver.switchTo().frame(driver.findElement(iframe));
		List<WebElement> heading = driver.findElements(headingclass);
		String[] headingData = new String[heading.size()];
		for (int i = 0; i < heading.size(); i++) {
			headingData[i] = heading.get(i).getText();
			System.out.println(headingData[i]);
		}
		List<WebElement> info = driver.findElements(information);
		String[] infoData = new String[heading.size()];
		for (int i = 0; i < info.size(); i++) {
			infoData[i] = info.get(i).getText();
			System.out.println(infoData[i]);
			
		}
		ExcelWrite.storeData(headingData, infoData);
	}
}
