package utitlities;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.google.common.io.Files;

public class screenshots {
	static int i =1;
	public static void takeScreenshot(WebDriver driver) {
	try {
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File des = new File("C:\\Users\\Administrator\\Desktop\\Maven test\\capstone_orangeHRM\\screenshots\\screenshot"+(i++)+".jpeg");
		Files.copy(src, des);
	}catch(Exception e) {
		e.printStackTrace();
	}
	
	}
}
