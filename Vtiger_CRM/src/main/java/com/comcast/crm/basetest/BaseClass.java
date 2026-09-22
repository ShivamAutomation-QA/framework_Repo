package com.comcast.crm.basetest;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;

import generic_utility.ExcelUtility;
import generic_utility.PropertyUtility;
import generic_utility.UtilityClassObject;
import generic_utility.WebDriverUtility;
import java_utility.JavaUtility;

public class BaseClass {

	public WebDriver driver;
	//public static WebDriver sdriver;
	public PropertyUtility pu = new PropertyUtility();
	public ExcelUtility eu = new ExcelUtility();
	public JavaUtility ju = new JavaUtility();
	public WebDriverUtility wu = new WebDriverUtility();
	public ExtentSparkReporter spark;
	public ExtentReports report;

	@BeforeSuite(groups = "smoke")
	public void configBS() {
		System.out.println("===Connect to DB , Report Config==");
		
	}
	//@Parameters("BROWSER")
	@BeforeClass(groups = "smoke")
	public void configBC() throws Exception {
		System.out.println("==Launch the Browser");
		String browser = pu.readDataFromProperty("browser");
		//String browsers = browser;
		driver = wu.launchBrowser(browser);
		UtilityClassObject.setDriver(driver);
		wu.maximizeBrowser(driver);
		wu.implicitWait(driver);
		//sdriver=driver;
	}

	@BeforeMethod(groups = "smoke")
	public void configBM() throws Exception {
		System.out.println("==Login==");
		String un = pu.readDataFromProperty("userName");
		String pwd = pu.readDataFromProperty("password");
		String url = pu.readDataFromProperty("url");

		driver.get(url);
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(un, pwd);

	}

	@AfterMethod(groups = "smoke")
	public void configAM() throws Exception {
		System.out.println("==Logout==");
		HomePage hp = new HomePage(driver);
		hp.logout();
	}

	@AfterClass(groups = "smoke")
	public void configAC() throws Exception {
		System.out.println("==Close the Browser");
		driver.quit();
	}

	@AfterSuite(groups = "smoke")
	public void configAS() throws Exception {
		System.out.println("==Close DB,Report backUP");
		
	}

}
