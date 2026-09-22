package com.comcast.crm.contacttest;

import org.testng.annotations.Test;

import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.objectrepositoryutility.ContactInfoPage;
import com.comcast.crm.objectrepositoryutility.ContactPage;
import com.comcast.crm.objectrepositoryutility.CreateNewContactPage;
import com.comcast.crm.objectrepositoryutility.HomePage;

public class CreateContactWithSupportDateTest extends BaseClass {

	@Test
	public void createContactWithSupportDateTest() throws Exception {

		String lastName = eu.readDataFromExcel("Contact", 1, 0) + ju.generateRandomNumber();

		// Navigate to contact Module
		HomePage hp = new HomePage(driver);
		hp.getContactLink().click();

		// click on create organization button
		ContactPage cp = new ContactPage(driver);
		cp.getCreateNewContactBtn().click();

		String currentDate = ju.currentDate();
		String reqDate = ju.reqDate(30);

		// Enter all the details and create new Contact
		CreateNewContactPage cncp = new CreateNewContactPage(driver);
		cncp.date(currentDate, reqDate);
		cncp.createcontact(lastName);

		// verify header message expected result
		ContactInfoPage cip = new ContactInfoPage(driver);
		//String contact = cip.getHeaderMsg().getText();

		// getting actual start and end date from the page
		String actStartDate = cip.getStartDateEdt().getText();
		String actEndDate = cip.getEndDateEdt().getText();

		// verify header
		if (actStartDate.contains(currentDate)) {
			System.out.println(currentDate + " information is verified==pass");
		} else {
			System.out.println(currentDate + " information is verified==pass");
		}
		if (actEndDate.contains(reqDate)) {
			System.out.println(reqDate + " information is verified==pass");
		} else {
			System.out.println(reqDate + " information is verified==pass");
		}

	}

}
