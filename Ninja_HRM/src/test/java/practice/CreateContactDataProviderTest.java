package practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreateContactDataProviderTest {
	
	@Test(dataProvider = "getData")
	public void createContactTest(String firstName,String lastName)
	{
		System.out.println("FirstName: "+firstName+" Lastname: "+lastName);
	}
	
	@DataProvider
	
	public Object[][] getData()
	{
		Object[][] objarr = new Object[3][2];
		
		objarr[0][0] = "Tom";
		objarr[0][1] = "HR";
		
		objarr[1][0] = "Deepak";
		objarr[1][1] = "PR";
		
		objarr[2][0] = "Harry";
		objarr[2][1] = "KR";
		
		return objarr;
		
	}

}
