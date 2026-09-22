package ddt;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import generic_utility.ExcelUtility;
import generic_utility.PropertyUtility;
import generic_utility.WebDriverUtility;
import java_utility.JavaUtility;

public class AddEmployee {

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
		driver.findElement(By.id("username")).sendKeys(un);
		driver.findElement(By.id("inputPassword")).sendKeys(pwd);

		driver.findElement(By.xpath("//button[text()='Sign in']")).click();
		Thread.sleep(2000);
		//click on add employee
		driver.findElement(By.linkText("Employees")).click();
		driver.findElement(By.xpath("//span[text()='Add New Employee']")).click();
		
		// 2 random number generating for new project name
				JavaUtility ju = new JavaUtility();
				int num = ju.generateRandomNumber();
		
		// 2.3 Reading required data to create project from excel
		ExcelUtility eu = new ExcelUtility();
		String name = eu.readDataFromExcel("Employees", 2, 0)+num;
		String email = eu.readDataFromExcel("Employees", 2, 1);
		String phone = eu.readDataFromExcel("Employees", 2, 2);
		String username = eu.readDataFromExcel("Employees", 2, 3)+num;
		String designation = eu.readDataFromExcel("Employees", 2, 4);
		String experience = eu.readDataFromExcel("Employees", 2, 5);
		String project = eu.readDataFromExcel("Employees", 2, 6);
		
		driver.findElement(By.xpath("//label[text()='Name*']/following-sibling::input")).sendKeys(name);
		driver.findElement(By.xpath("//label[text()='Email*']/following-sibling::input")).sendKeys(email);
		driver.findElement(By.xpath("//label[text()='Phone*']/following-sibling::input")).sendKeys(phone);
		driver.findElement(By.xpath("//label[text()='Username*']/following-sibling::input")).sendKeys(username);
		driver.findElement(By.xpath("//label[text()='Designation*']/following-sibling::input")).sendKeys(designation);
		driver.findElement(By.xpath("//label[text()='Experience*']/following-sibling::input")).sendKeys(experience);
		
		WebElement drop = driver.findElement(By.name("project"));
		wu.selectFromDropDown(drop, project);
		
		driver.findElement(By.xpath("//input[@class='btn btn-success']")).click();
		
		Thread.sleep(3000);
		driver.quit();
	}

}
