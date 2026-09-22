package ddt;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class PropertyFile {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		//Open the file in the read mode
		FileInputStream fis = new FileInputStream("./src/test/resources/CommonData.properties");
		
		//create object of Properties Class to read data based on key
		
		Properties p = new Properties();
		p.load(fis);
		
		System.out.println("URL:"+p.getProperty("url"));
		System.out.println("username:"+p.getProperty("useName"));
		System.out.println("Password:"+p.getProperty("password"));
		
		WebDriver driver;
		
		if(p.getProperty("browser").equalsIgnoreCase("chrome"))
			driver = new ChromeDriver();
		else if(p.getProperty("browser").equalsIgnoreCase("firefox"))
			driver = new FirefoxDriver();
		else if(p.getProperty("browser").equalsIgnoreCase("edge"))
			driver = new EdgeDriver();
		else
			driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get(p.getProperty("url"));
		driver.findElement(By.id("username")).sendKeys(p.getProperty("userName"));
		driver.findElement(By.id("inputPassword")).sendKeys(p.getProperty("password"));
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text()='Sign in']")).click();		
	}

}
