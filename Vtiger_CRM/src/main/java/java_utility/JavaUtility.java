package java_utility;

import java.time.LocalDate;
import java.util.Random;

public class JavaUtility {

	public int generateRandomNumber() {
		Random r = new Random();
		return r.nextInt();
	}

//	public String currentDate() {
//		Date dateobj = new Date();
//		SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd");
//		String startdate = sim.format(dateobj);
//		return startdate;
//
//	}
//	
//	public String reqDate(int day)
//	{
//		Date dateobj = new Date();
//		SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd");
//		Calendar cal = sim.getCalendar();
//		cal.add(Calendar.DAY_OF_MONTH, day);
//		String endDate = sim.format(cal.getTime());
//		return endDate;
//		
//	}

	// Returns today's date
	    public String currentDate() {
		LocalDate date = LocalDate.now();
		return date.toString();
	}

	// Returns date after/before specified number of days
	    public String reqDate(int day) {
		LocalDate date = LocalDate.now();
		LocalDate requiredDate = date.plusDays(day);
		return requiredDate.toString();
	}
}
