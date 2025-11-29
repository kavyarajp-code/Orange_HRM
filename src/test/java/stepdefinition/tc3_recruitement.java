package stepdefinition;

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

public class tc3_recruitement {
	WebDriver driver;
	loginPage loginpage;
	recruitement_candidatePage candidatepage;
	
	@Given("the user navigates to the candidate section in Recruitement module")
	public void the_user_navigates_to_the_candidate_section_in_Recruitement_module() {
		reportGenerator.test = reportGenerator.extent.startTest("Recruitment add valid candidate");
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
	
	@When("user click on Add")
	public void user_click_on() {
		candidatepage.clickAdd();
	    reportGenerator.test.log(LogStatus.INFO, "Clicked on Add button in Recruitment module");
	}
	
	@And("user enter candidate details")
    public void enterCandidateDetails() {
        candidatepage.enterCandidateDetails("Kavya", "Raj", "P", "kavya@gmail.com");
        reportGenerator.test.log(LogStatus.INFO, "Entered candidate details: Kavya Raj P, kavya@gmail.com");
    }

    @And("user click on save")
    public void clickOnSave() {
        candidatepage.clickSave();
        reportGenerator.test.log(LogStatus.INFO, "Clicked on Save button after entering candidate details");
    }
    
    @Then("user navigates to home page")
    public void CandidateHomepage() {
        driver.quit();
    }


}
