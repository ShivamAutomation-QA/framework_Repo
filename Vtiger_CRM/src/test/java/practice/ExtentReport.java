package practice;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReport {
	ExtentReports report;
	@BeforeSuite
	public void configBS()
	{
		ExtentSparkReporter spark = new ExtentSparkReporter("./AdvanceReport/report.html");
		spark.config().setDocumentTitle("CRM Test Suite Result");
		spark.config().setReportName("CRM Report");
		spark.config().setTheme(Theme.DARK);
		
		//Add environment information and create test
		report= new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", "Windows-11");
		report.setSystemInfo("BROWSER", "CHROME");
	}
	@AfterSuite
	public void configAS()
	{
		report.flush();
	}
	@Test
	public void createContactTest()
	{
		//spark report configuration
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.com/");
		TakesScreenshot ts = (TakesScreenshot) driver;
		String filePath = ts.getScreenshotAs(OutputType.BASE64);
		
		ExtentTest test = report.createTest("createContactTest");
		test.log(Status.INFO,"login to APP");
		test.log(Status.INFO,"Navigate to Contact Page");
		test.log(Status.INFO,"create contact");
		
		if("HDFC".equals("HFDC"))
		{
			test.log(Status.PASS,"contact is craeted");
		}
		else
		{
			test.addScreenCaptureFromBase64String(filePath,"ErrorFile");
			test.log(Status.FAIL,"contact is not craeted");

		}
	
	}
	
	@Test
	public void createContactWithOrg()
	{
		//spark report configuration
		
		ExtentTest test = report.createTest("createContactWithOrg");
		test.log(Status.INFO,"login to APP");
		test.log(Status.INFO,"Navigate to Contact Page");
		test.log(Status.INFO,"create contact");
		
		if("HDFC".equals("HDFC"))
		{
			test.log(Status.PASS,"contact is craeted");
		}
		else
		{
			test.log(Status.FAIL,"contact is not craeted");

		}
	
	}

}
