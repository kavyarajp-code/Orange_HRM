package stepdefinition;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.loginPage;
import pageObjects.recruitement_candidatePage;
import utitlities.reportGenerator;

public class tc5_search_jobtitle {
	WebDriver driver;
	loginPage loginpage;
	recruitement_candidatePage candidatepage;
	
	@Given("the user navigates to the candidate section in Recruitement module for search using jobtitle")
		public void navigateToCandidateSectionForJobTitle() {
			reportGenerator.test=reportGenerator.extent.startTest("Search candidate by Job title");
			WebDriverManager.chromedriver().setup(); 
			driver=new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
			loginpage=new loginPage(driver);
			
			loginpage.enterUsername("Admin");
			loginpage.enterPassword("admin123");
			loginpage.clickLogin();
			
			driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[5]/a/span")).click();
			candidatepage = new recruitement_candidatePage(driver);
	}
	@When("user select job title {string}")
	public void selectjobtitle(String jobTitle) {
		candidatepage.selectJobTitle(jobTitle);
		reportGenerator.test.log(LogStatus.INFO, "Selected job title: " + jobTitle);
	}
	@And("user click on Search using jobTitle")
	public void clickonSearch() {
		candidatepage.clickSearch();
        reportGenerator.test.log(LogStatus.INFO, "Clicked on Search button");
	}
	@Then("user should see candidates with job title {string}")
	public void seeingcandidates(String string) {
		
		List<WebElement> candidates = driver.findElements(By.xpath("//p[normalize-space()='" + string + "']"));

			if (!candidates.isEmpty()) {
			    reportGenerator.test.log(LogStatus.PASS, "Verified candidates with job title: " + string);
			} else {
			    reportGenerator.test.log(LogStatus.FAIL, "No candidates found with job title: " + string);
			}
			driver.quit();

		
		
	}
	

}
