package stepdefinition;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.loginPage;
import utitlities.reportGenerator;

public class tc1_login_valid {
	WebDriver driver;
	loginPage loginpage;
	
	@Given("the user in the login page for logging in with valid credentials")
	public void the_user_in_the_login_page_for_logging_in_with_valid_credentials() {
		reportGenerator.test = reportGenerator.extent.startTest("Valid Login Test");
		WebDriverManager.chromedriver().setup(); 
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		loginpage=new loginPage(driver);
	}
	@When("he enteres valid details and submits")
	public void he_enteres_valid_details_and_submits() {
		loginpage.enterUsername("Admin");
		loginpage.enterPassword("admin123");
		loginpage.clickLogin();
		reportGenerator.test.log(LogStatus.INFO, "Entered valid credentials and clicked login");
	}
	@Then("the system navigates to home page")
	public void the_system_navigates_to_home_page() {
		driver.quit();
	}
	
	

}


