package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class recruitement_candidatePage {
	WebDriver driver;
	
	public recruitement_candidatePage(WebDriver driver){
		this.driver=driver;
	}
	
	By addButton = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[1]/button");
	By firstName  = By.name("firstName");
	By middleName = By.name("middleName");
	By lastName   = By.name("lastName");
	By email    = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[3]/div/div[1]/div/div[2]/input");
	By saveButton      = By.xpath("//button[@type='submit']");
	
	 By jobTitle = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[1]/div/div[2]/div/div");
	 By vacancy  = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[2]/div/div[2]/div/div/div[1]");
	 By searchButton     = By.xpath("//button[normalize-space()='Search']");
	 
	 By resetButton      = By.xpath("//button[normalize-space()='Reset']");
	 
	 public void clickAdd() {
		 driver.findElement(addButton).click();
	 }
	 public void clickSave() {
		 driver.findElement(saveButton).click();
	 }
	 public void clickSearch() {
		 driver.findElement(searchButton).click();
	 }
	 public void clickReset() {
		 driver.findElement(resetButton).click();
	 }
	 
	 
	 
	 public void enterCandidateDetails(String firstNames, String middleNames, String lastNames, String emails) {
		 driver.findElement(firstName).sendKeys(firstNames);
	     driver.findElement(middleName).sendKeys(middleNames);
	     driver.findElement(lastName).sendKeys(lastNames);
	     driver.findElement(email).sendKeys(emails);
	 }
	 
	 
	 
	 public void selectJobTitle(String jobTitles) {
	        driver.findElement(jobTitle).click();
	        driver.findElement(By.xpath("//span[text()='" + jobTitles + "']")).click();
	    }

	    public void selectVacancy(String vacancies) {
	        driver.findElement(vacancy).click();
	        driver.findElement(By.xpath("//span[text()='" + vacancies + "']")).click();
	    }

}
