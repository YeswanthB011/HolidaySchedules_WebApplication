package TestCases;


import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import PageClass.BeCognizantPage;
import PageClass.HolidaySchedules;
import Utilities.DriverSetup;
import Utilities.ExtendReport;
import Utilities.PropertiesFile;
import Utilities.Screenshot;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class TestCases extends DriverSetup {
	public ExtentReports report = ExtendReport.getReportInstance();
	public ExtentTest logger;

	@Given("Browser is opened and our url is loaded")
	public void Login_Page() throws IOException {
		// Write code here that turns the phrase above into concrete actions
			String browserName = PropertiesFile.readProperties("browser");
			String url = PropertiesFile.readProperties("url");
			driver = DriverSetup.driverSetup(browserName);
			driver.get(url);
			// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		
	}

	@When("User account is verified")
	public void User_Account_Verification() {
		// Write code here that turns the phrase above into concrete actions
		logger = report.createTest("Test User Information");
		try {
			String title=driver.getTitle();
			if(title.equals("Home")|| title.equals("Be.Cognizant - Home")) {
				logger.log(Status.INFO, "Navigate to Be Cognizant url successfully...");
			}else {
			BeCognizantPage.logIn(driver);
			logger.log(Status.INFO, "Navigate to Be Cognizant url successfully...");
			}
			
			BeCognizantPage.userInfo();
			logger.log(Status.INFO, "User account info capture successfully...");

			logger.log(Status.PASS, "Test Executed Successfully");
			
		} catch (Exception e) {

			System.out.println(e.getMessage());
			logger.log(Status.FAIL, "Test Failed");
		}
	}

	@Then("Navigated to holiday Schedule succesfully")
	public void Holiday_schedule() {
		// Write code here that turns the phrase above into concrete actions
		logger = report.createTest("Test HolidaySchedules");
		try {
			BeCognizantPage.peopleTab();
			logger.log(Status.INFO, "Holiday Schedules verify sucessfully..");
			logger.log(Status.INFO, "Holiday Schedules click sucessfully..");
			logger.log(Status.INFO, "Correctly navigate to Holiday Schedules sucessfully..");
			logger.log(Status.PASS, "Test Executed Successfully");
		} catch (Exception e) {

			System.out.println(e.getMessage());
			logger.log(Status.FAIL, "Test Failed");
		}
	}

	@Then("Verify the Holiday Schedule Application")
	public void Holiday_schedule_application() {
		// Write code here that turns the phrase above into concrete actions
		logger = report.createTest("Test HolidayCalendars");
		try {
			HolidaySchedules.holidayCalendars(driver);
			logger.log(Status.INFO, "Holiday Calendars click successfully...");
			Thread.sleep(2000);

			HolidaySchedules.verifyYear(driver);
			logger.log(Status.INFO, "Current year verify successfully...");

			HolidaySchedules.clickOnCalendars(driver);
			logger.log(Status.INFO, "Click India, Americas & UKI calendars button successfully...");

			HolidaySchedules.verifyPDF(driver);
			logger.log(Status.INFO, "Only PDF related file verify successfully...");

			HolidaySchedules.verifyWord(driver);
			logger.log(Status.INFO, "Only Word related file verify successfully...");

			HolidaySchedules.verifySelectFile(driver);
			logger.log(Status.INFO, "All file selected successfully...");

			HolidaySchedules.verifyDeselectFile(driver);
			logger.log(Status.INFO, "All file deselected successfully...");
			
			logger.log(Status.INFO,"Test case Passes");

		} catch (Exception e) {

			System.out.println(e.getMessage());
			logger.log(Status.FAIL, "Test Failed");
		}
	}

	@Then("verify India Holiday schedules and took Screenshot")
	public void verify_india_holiday_schedules_and_took_screenshot() {
		// Write code here that turns the phrase above into concrete actions
		logger = report.createTest("Test India Holiday schedules");
		try {
			HolidaySchedules.clickOnIndia(driver);
			logger.log(Status.INFO, "Click India holiday calendar file successfully...");

			HolidaySchedules.verifyName(driver);
			logger.log(Status.INFO, "Navigate to India holiday calendar successfully...");
			Screenshot.takeScreenshot(driver);
			logger.log(Status.INFO, "Screenshot is taken successfully");
			logger.log(Status.PASS, "Test Executed Successfully");
		} catch (Exception e) {

			System.out.println(e.getMessage());
			logger.log(Status.FAIL, "Test Failed");
		}
		 
	}

	@When("Version history printed in consle and get Screenshot")
	public void version_history_and_screenshot() {
		// Write code here that turns the phrase above into concrete actions
		logger = report.createTest("Test VersionHistory");
		try {
			HolidaySchedules.clickOnVersionHistory(driver);
			logger.log(Status.INFO, "Click on Version History successfully");

			HolidaySchedules.getData(driver);
			logger.log(Status.INFO, "Data is taken successfully");

			Screenshot.takeScreenshot(driver);
			logger.log(Status.INFO, "Screenshot is taken successfully");

			logger.log(Status.PASS, "Test Executed Successfully");
		} catch (Exception e) {

			System.out.println(e.getMessage());
			logger.log(Status.FAIL, "Test Failed");
		}
		 
	}

	@Then("Quit the Browser")
	public void quit_browser() {
		// Write code here that turns the phrase above into concrete actions
		System.out.println("-----Browser Closed Successfully----");
		report.flush();
		driver.quit();
	}
}




