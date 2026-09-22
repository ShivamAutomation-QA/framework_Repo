package ddt;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.mysql.jdbc.Driver;

import generic_utility.DataBaseUtility;
import generic_utility.ExcelUtility;
import generic_utility.PropertyUtility;
import generic_utility.WebDriverUtility;
import java_utility.JavaUtility;
import object_repository.Login_page;

public class CreateProject {

	public static void main(String[] args) throws Exception {

		WebDriver driver;
		// 1.Login
		// 1.1 read data from property file
		PropertyUtility p = new PropertyUtility();
		String browser = p.readDataFromProperty("browser");
		String un = p.readDataFromProperty("userName");
		String pwd = p.readDataFromProperty("password");
		String url = p.readDataFromProperty("url");

		// 1.2 Launch browser

		WebDriverUtility wu = new WebDriverUtility();
		driver = wu.launchBrowser(browser);

		// maximize and ImplicitlyWait
		wu.maximizeBrowser(driver);
		wu.implicitWait(driver);

		// 1.3 Navigation to application
		driver.get(url);
		// 1.4 login
		
		Login_page lp = new Login_page(driver);
		lp.userLogin(un, pwd);
		//driver.findElement(By.id("username")).sendKeys(un);
		//driver.findElement(By.id("inputPassword")).sendKeys(pwd);

		//driver.findElement(By.xpath("//button[text()='Sign in']")).click();
		Thread.sleep(2000);

		// 2. create project
		// 2.1 go to project feature
		driver.findElement(By.linkText("Projects")).click();

		// 2.2 click on create project
		driver.findElement(By.xpath("//button[contains(.,'Create Project')]")).click();

		// 2.3 Reading required data to create project from excel
		ExcelUtility eu = new ExcelUtility();

		// 2.3.1 random number generating for new project name
		JavaUtility ju = new JavaUtility();
		int num = ju.generateRandomNumber();

		String pName = eu.readDataFromExcel("Project", 2, 0) + num;
		String pManager = eu.readDataFromExcel("Project", 2, 1);
		String pStatus = eu.readDataFromExcel("Project", 2, 2);

		// 2.4 creating project
		driver.findElement(By.name("projectName")).sendKeys(pName);
		driver.findElement(By.name("createdBy")).sendKeys(pManager);

		WebElement drop = driver.findElement(By.xpath("//label[text()='Project Status* ']/following-sibling::select"));
		wu.selectFromDropDown(drop, pStatus); 

		driver.findElement(By.xpath("//input[@value='Add Project']")).click();
		Thread.sleep(2000);

		// 2.5 getting project id
		String projectID = driver.findElement(By.xpath("//td[text()='" + pName + "']/preceding-sibling::td")).getText();
		eu.writeDataInNewCell("Project", 1, 3, projectID);
		eu.writeDataInExistingCell("Project", 1, 0, pName);
		
		//DB validation
		
		DataBaseUtility du = new DataBaseUtility();
		boolean b = du.validateDataEntry("project","project_name",pName,"jdbc:mysql://49.249.29.4:3307/ninza_hrm","root@%","root");
//		Driver d = new Driver();
//		DriverManager.registerDriver(d);
//		Connection con = DriverManager.getConnection("jdbc:mysql://49.249.29.4:3307/ninza_hrm", "root@%", "root");
//		Statement st = con.createStatement();
//		boolean b = st.execute("select * from project where project_name='"+pName+"';");
		if(b==true)
			System.out.println("Project with "+pName+" got created in frontend and available in backend");
		else
			System.out.println("Project with "+pName+" did not got created in frontend and available in backend");
		
		Thread.sleep(5000);
		driver.quit();
	}
}
