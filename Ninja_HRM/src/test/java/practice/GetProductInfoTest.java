package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class GetProductInfoTest {
	@Test(dataProvider = "getData")
	public void getProductInfoTest(String brandName,String productName)
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://amazon.in");
		
		//search product
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys(brandName,Keys.ENTER);
		
		//capture product info
		
		String x = "//span[text()='"+productName+"']/../../../../div[3]/div[1]/div/div[1]/div[1]/div[1]/a/span/span[2]/span[2]";
		String price =driver.findElement(By.xpath(x)).getText();
		System.out.println(price);
		
		driver.quit();
	}
	

	@DataProvider
	
	public Object[][] getData()
	{
		Object[][] objarr = new Object[3][2];
		
		objarr[0][0] = "iphone";
		objarr[0][1] = "iPhone 17 Pro Max 256 GB with Protect+ with AppleCare Services";
		
		objarr[1][0] = "iphone";
		objarr[1][1] = "iPhone 16 128 GB: 5G Mobile Phone with Camera Control, A18 Chip and a Big Boost in Battery Life. Works with AirPods; Ultramarine";
		
		objarr[2][0] = "iphone";
		objarr[2][1] = "iPhone 16 512 GB: 5G Mobile Phone with Camera Control, A18 Chip and a Big Boost in Battery Life. Works with AirPods; Teal";
		
		return objarr;
		
	}

}

//span[text()='iPhone 17 Pro Max 256 GB with Protect+ with AppleCare Services']/../../../../div[3]/div[1]/div/div[1]/div[1]/div[1]/a/span/span[2]/span[2]
