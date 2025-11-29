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
import utitlities.screenshots;

public class tc6_search_vacancy {
	
	WebDriver driver;
	loginPage loginpage;
	recruitement_candidatePage candidatepage;

	@Given("the user navigates to the candidate section in Recruitement module for search using vacancy")
	public void navigatetoCandidatesectionforVacancy() {
		reportGenerator.test=reportGenerator.extent.startTest("Search candidate by vacancy");
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
	@When("user select vacancy {string}")
	public void selectVacancy(String string) {
		candidatepage.selectVacancy(string);
		reportGenerator.test.log(LogStatus.INFO,"Selectes vacancy: " +string);
	}
	@And("user click on Search using vacancy")
	public void clickonSearch() {
		candidatepage.clickSearch();
		reportGenerator.test.log(LogStatus.INFO,"Clicked on search button");
	}
	
	@Then("user should see candidates under vacancy {string}")
	public void seeingCandidates(String string) {
		List<WebElement> candidate=driver.findElements(By.xpath("//p[contains(normalize-space(), '\" + vacancy + \"')]"));
		if(!candidate.isEmpty()) {
			reportGenerator.test.log(LogStatus.PASS,"Verified candidate with vacancy: "+string);
		}
		else {
			screenshots.takeScreenshot(driver);
			reportGenerator.test.log(LogStatus.FAIL,"No candidates found with vacancy: " +string);
			
		}
		driver.quit();
	}

}
