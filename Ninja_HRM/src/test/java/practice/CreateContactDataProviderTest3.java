package practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreateContactDataProviderTest3 {
	
	@Test(dataProvider = "getData")
	public void createContactTest(String firstName,String lastName,long phoneNumber)
	{
		System.out.println("FirstName:"+firstName+" Lastname:"+lastName+" Phone No:-"+phoneNumber);
	}
	
	@DataProvider
	
	public Object[][] getData()
	{
		Object[][] objarr = new Object[3][3];
		
		objarr[0][0] = "Tom";
		objarr[0][1] = "HR";
		objarr[0][2] = 87545545555l;
		
		objarr[1][0] = "Deepak";
		objarr[1][1] = "PR";
		objarr[1][2] = 99545545555l;
		
		objarr[2][0] = "Harry";
		objarr[2][1] = "KR";
		objarr[2][2] = 87545557555l;
		
		return objarr;
		
	}

}
