package stepdefinition;

import static org.testng.Assert.assertNull;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
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

public class tc4_recruitement_invalid {
	
	WebDriver driver;
	loginPage loginpage;
	recruitement_candidatePage candidatepage;
	
	@Given("the user navigates to the candidate section in Recruitement module for inv")
	public void the_user_navigates_to_the_candidate_section_in_Recruitement_module() {
		reportGenerator.test = reportGenerator.extent.startTest("Recruitment add invalid candidate");

			WebDriverManager.chromedriver().setup(); 
			driver=new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
			
			loginpage=new loginPage(driver);
			loginpage.enterUsername("Admin");
			loginpage.enterPassword("admin123");
			loginpage.clickLogin();
			
			driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[5]/a/span")).click();
			}
	
	@When("user click on Add for inv")
	public void user_click_on() {
		candidatepage = new recruitement_candidatePage(driver);
		candidatepage.clickAdd();
	    reportGenerator.test.log(LogStatus.INFO, "Clicked on Add button for invalid candidate test");
	}
	
	@And("user enter invalid candidate details")
    public void enterInvCandidateDetails() {
        candidatepage.enterCandidateDetails("Kavya", "Raj", "P", "kavya@gm.co");
        reportGenerator.test.log(LogStatus.INFO, "Entered invalid candidate details: Kavya Raj P, kavya@gm.co");
    }

    @And("user click on save for inv")
    public void clickOnSave() {
        candidatepage.clickSave();
        reportGenerator.test.log(LogStatus.INFO, "Clicked on Save button with invalid candidate details");
    }
    
    @Then("system shows an error message")
    public void CandidateInvHomepage() {
    	try {
    	assertNull(driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div[1]/form/h6")));
    	reportGenerator.test.log(LogStatus.PASS, "Passed");
    	}
    	catch(AssertionError e) {
    		screenshots.takeScreenshot(driver);
    		reportGenerator.test.log(LogStatus.FAIL, "Failed: "+e);
    		throw e;
    	}
    	finally {
    		 driver.quit();
    	}
       
    }


}



