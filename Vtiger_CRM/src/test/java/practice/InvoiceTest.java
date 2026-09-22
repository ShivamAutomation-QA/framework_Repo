package practice;

import org.jspecify.annotations.Nullable;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.comcast.crm.basetest.BaseClass;
//@Listeners(com.comcast.crm.listenerutility.ListenerImplementation.class)
public class InvoiceTest extends BaseClass {
	
	@Test
	public void createInvoiceTest()
	{
		System.out.println("execute createInvoiceTest");
		@Nullable
		String actTitle = driver.getTitle();
		Assert.assertEquals(actTitle, "Login");
		System.out.println("step-1");
		System.out.println("step-2");
		System.out.println("step-3");
		
	}

}
