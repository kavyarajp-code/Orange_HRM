package stepdefinition;

import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.loginPage;
import pageObjects.myInfoPage;
import utitlities.reportGenerator;
import utitlities.screenshots;

public class tc9_myinfo_contact_phinvalid {
	
	WebDriver driver;
	loginPage loginpage;
	myInfoPage info;
	
@Given("the user is logged into OrangeHRM and navigates to the My Info module for inv phone")
public void loginAndNavigateToMyInfoforinvph() {
	reportGenerator.test = reportGenerator.extent.startTest("Myinfo add invalid phone number");
		WebDriverManager.chromedriver().setup(); 
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		loginpage=new loginPage(driver);
		loginpage.enterUsername("Admin");
		loginpage.enterPassword("admin123");
		loginpage.clickLogin();
		
		driver.findElement(By.xpath("//span[text()='My Info']")).click();
		info=new myInfoPage(driver);
		
}
	
	@When("the user navigates to the Contact Details section for inv")
    public void openContactDetailsInvalid() {
		info.clickcontactdetails();
		reportGenerator.test.log(LogStatus.INFO,"clicked the contact details button");
	}
	@And("the user updates their {string},{string} and {string}")
    public void updateInvalidContactDetails(String address, String invalidphone, String email) {
		info.enterContactdetails(address,invalidphone,email);
        reportGenerator.test.log(LogStatus.INFO, "Entered contact details: " + address + " " + invalidphone + " " + email);

	}
	 @And("the user clicks Save button for contact details for invalid")
	    public void clickSaveInvalidContactDetails() {
		 info.clicksavebutton2();
	        reportGenerator.test.log(LogStatus.INFO, "clicked on save button");
	 }
	 @Then("system shows error message for invalid phone")
	 public void phonenumberinv() {
		 try {
			 boolean validationWorked=info.verifySave();
			 if (validationWorked) {
		            reportGenerator.test.log(LogStatus.PASS, "Error message displayed, invalid phone not saved");
		        } else {
		            screenshots.takeScreenshot(driver);
		            reportGenerator.test.log(LogStatus.FAIL, "Invalid phone number was saved (Success toast appeared)");
		            Assert.fail("Invalid phone number was saved");
		        }
		    } catch (Exception e) {
		        screenshots.takeScreenshot(driver);
		        reportGenerator.test.log(LogStatus.FAIL, "Scenario failed due to exception: " + e);
		        Assert.fail("Scenario failed due to exception: " + e);
		    } finally {
		        driver.quit();
		    }
		 
	 }

}
