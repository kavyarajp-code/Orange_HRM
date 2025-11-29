package utitlities;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class reportGenerator {
	public static ExtentReports extent; 
	public static ExtentTest test;  
	  
	
	

//	  @AfterMethod
//	  public void getResult(ITestResult result)
//	  {
//	      if(result.getStatus() == ITestResult.FAILURE)
//	      {
//	          test.log(LogStatus.FAIL, "Test is failed");
//	          
//	      }
//	      else if(result.getStatus() == ITestResult.SUCCESS)
//	      {
//	          test.log(LogStatus.PASS, "Test is pass");
//	      }
//	      reportGenerator.extent.endTest(test);
//	      
//	  }


	  @BeforeSuite
	  public void beforeSuite() 
	  {
		  extent = new ExtentReports ("C:\\Users\\Administrator\\Desktop\\Maven test\\capstone_orangeHRM\\TestReport\\report.html", true);
	  }

	  @AfterSuite
	  public void afterSuite() 
	  {
		  extent.flush();
	  }

}