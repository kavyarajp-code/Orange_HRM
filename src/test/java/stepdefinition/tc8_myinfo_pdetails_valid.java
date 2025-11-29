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
import pageObjects.myInfoPage;
import utitlities.reportGenerator;

public class tc8_myinfo_pdetails_valid {
	WebDriver driver;
	loginPage loginpage;
	myInfoPage info;
	
	
	@Given("the user is logged into OrangeHRM and navigates to the My Info module")
    public void loginAndNavigateToMyInfo() {
			reportGenerator.test = reportGenerator.extent.startTest("Myinfo add personal details");
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
	 @When("the user opens the Personal Details section for valid")
	    public void openPersonalDetailsValid() {
	        info.clickPersonaldetails();
	        reportGenerator.test.log(LogStatus.INFO,"clicked the personal details button");
	 }
	 @And("the user enters {string} {string} {string}")
	    public void enterPersonalDetails(String firstName, String middleName, String lastName) {
	        info.enterPersonaldetails(firstName, middleName, lastName); 
	        reportGenerator.test.log(LogStatus.INFO, "Entered personal details: " + firstName + " " + middleName + " " + lastName);
	 }
	 
	 @Then("the user clicks save button for personal details")
	 public void clickonSave() {
		 info.clicksavebutton1();
		 reportGenerator.test.log(LogStatus.PASS,"clicked on save button");
		 
		 driver.quit();
		 
	 }
	 

}
