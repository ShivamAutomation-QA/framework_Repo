package practice;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertionPractice {
	@Test
	public void homePageTest()
	{
		SoftAssert soft = new SoftAssert();
		System.out.println("step-1");
		System.out.println("step-2");
		//Assert.assertEquals("Home", "Home");
		//Assert.assertEquals("Home", "Home-Page");
		soft.assertEquals("Home", "Home-Page");
		System.out.println("step-3");
		Assert.assertEquals("Home-CRM", "Home-CRM");
		System.out.println("step-4");
		soft.assertAll();
	}
	@Test
	public void verifyLogohHomePageTest()
	{
		
		System.out.println("step-1");
		System.out.println("step-2");
		Assert.assertTrue(true);
		System.out.println("step-3");
		Assert.assertEquals("Home", "Home");
		System.out.println("step-4");
		Reporter.log("step-5",true);
	}

}
