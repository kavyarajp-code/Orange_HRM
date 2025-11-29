package stepdefinition;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.loginPage;
import pageObjects.recruitement_candidatePage;
import utitlities.reportGenerator;

public class tc7_reset {
	
	WebDriver driver;
	loginPage loginpage;
	recruitement_candidatePage candidatepage;
	
	@Given("the user navigates to the candidate section in Recruitement module for resetting")
	public void navigatetoCandidatesectionforVacancy() {
		reportGenerator.test=reportGenerator.extent.startTest("Resetting Search");
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
	@When("user click on Reset")
	public void clickonReset() {
		candidatepage.clickReset();
		reportGenerator.test.log(LogStatus.INFO,"Successfully clicked on reset button");
	}
	@Then("all search filters should be cleared")
	public void clearingSearch() {
		driver.quit();
	}

}
