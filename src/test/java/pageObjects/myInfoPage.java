package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class myInfoPage {
	WebDriver driver;
	public myInfoPage(WebDriver driver){
		this.driver=driver;
	}
	
	//personal details 
	By personaldetails=By.xpath("//a[text()='Personal Details']");
	By firstname= By.name("firstName");
	By middlename=By.name("middleName");
	By lastname=By.name("lastName");
	By saveButton=By.xpath("//button[@type='submit']");
	
	//contact details
	By contactdetails=By.linkText("Contact Details");
	By street1 =By.xpath("//form/div[1]/div[1]/div[1]/div[1]/div[2]//input");
	By mobile=By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[2]/div/div[2]/div/div[2]/input");
	By email=By.xpath("//form/div[3]/div[1]/div[1]/div[1]/div[2]/input");
	By saveButton2=By.xpath("//button[@type='submit']");
	By toastcontainer =By.id("oxd-toaster_1");
	
	public void clickPersonaldetails() {
		driver.findElement(personaldetails).click();
	}
	
	public void clicksavebutton1() {
		driver.findElement(saveButton).click();
	}
	public void clickcontactdetails() {
		driver.findElement(contactdetails).click();;
	}
	public void clicksavebutton2() {
		driver.findElement(saveButton2).click();
	}
	
	
	public void enterPersonaldetails(String first,String middle, String last ) {
		driver.findElement(firstname).clear();
		driver.findElement(firstname).sendKeys(first);
		driver.findElement(middlename).clear();
		driver.findElement(middlename).sendKeys(middle);
		driver.findElement(lastname).clear();
		driver.findElement(lastname).sendKeys(last);
		
	}
	public void enterContactdetails(String addr,String mob,String emailid) {
		driver.findElement(street1).clear();
		driver.findElement(street1).sendKeys(addr);
		driver.findElement(mobile).clear();
		driver.findElement(mobile).sendKeys(mob);
		driver.findElement(email).clear();
		driver.findElement(email).sendKeys(emailid);
	}
	public boolean verifySave() {
		 WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		 WebElement toastelement=wait.until(ExpectedConditions.visibilityOfElementLocated(toastcontainer));
		 String toastText=toastelement.getText().toLowerCase();
		 if (toastText.contains("success")) {
		        return false;
		    }
		 return true;
	}
	
	


}
