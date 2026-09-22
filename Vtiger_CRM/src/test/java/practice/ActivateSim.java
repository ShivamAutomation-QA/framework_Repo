package practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ActivateSim {

	@Test(retryAnalyzer = com.comcast.crm.listenerutility.RetryListenerImplementation.class)
	public void activateSim() {
		Assert.assertEquals("", "Login");
		System.out.println("step-1");
		System.out.println("step-2");
		System.out.println("step-3");
	}

}
