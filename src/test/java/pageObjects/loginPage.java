package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class loginPage {
	WebDriver driver;
	By username=By.name("username");
	By password=By.name("password");
	By loginbutton=By.className("orangehrm-login-button");
	
	public loginPage(WebDriver driver) {
		this.driver=driver;
	}
	public void enterUsername(String s) {
		driver.findElement(username).sendKeys(s);
	}
	public void enterPassword(String s) {
		driver.findElement(password).sendKeys(s);
	}
	public void clickLogin() {
		driver.findElement(loginbutton).click();
	}

}
