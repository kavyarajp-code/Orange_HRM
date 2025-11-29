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
import utitlities.reportGenerator;

public class tc2_login_invalid {
	WebDriver driver;
	@Given("the user in the login page for logging in with invalid credentials")
	public void the_user_in_the_login_page_for_logging_in_with_invalid_credentials() {
		reportGenerator.test = reportGenerator.extent.startTest("Invalid Login Test");
		WebDriverManager.chromedriver().setup(); 
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}
	@When("he enteres invalid details and submits")
	public void he_enteres_invalid_details_and_submits() {
		driver.findElement(By.name("username")).sendKeys("Adm");
		driver.findElement(By.name("password")).sendKeys("admin");
		driver.findElement(By.className("orangehrm-login-button")).click();
	    reportGenerator.test.log(LogStatus.INFO, "Entered invalid credentials and attempted login");
	}
	@Then("the system displays the error message")
	public void the_system_displays_the_error_message() {
		driver.quit();
	}

}
