package TestRunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
   features = "C:\\Users\\2282605\\OneDrive - Cognizant\\Desktop\\INTQEA23QE011_Team8_HolidaySchedules\\src\\main\\java\\Feature",
   glue = "TestCases",
  // tags = "@Login", // Run scenarios with the @Login tag
   plugin = {"pretty", "html:target/cucumber-reports.html"}, // Generate HTML reports
   monochrome = true // Produce more readable console output
)
public class TestRunner {
	
	
	
}


