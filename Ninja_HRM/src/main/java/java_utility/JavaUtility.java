package java_utility;

import java.util.Random;

public class JavaUtility {
	
	public int generateRandomNumber()
	{
		Random r = new Random();
		return r.nextInt();
	}

}
