package com.comcast.crm.contacttest;

import org.testng.annotations.Test;

import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.objectrepositoryutility.ContactInfoPage;
import com.comcast.crm.objectrepositoryutility.ContactPage;
import com.comcast.crm.objectrepositoryutility.CreateNewContactPage;
import com.comcast.crm.objectrepositoryutility.HomePage;

public class CreateContactTest extends BaseClass {

	@Test(groups = "smoke")

	public void createContactTest() throws Exception {

		String lastName = eu.readDataFromExcel("Contact", 1, 0) + ju.generateRandomNumber();
		// String industry = eu.readDataFromExcel("Organization", 1, 1);

		// Navigate to contact Module
		HomePage hp = new HomePage(driver);
		hp.getContactLink().click();

		// click on create organization button
		ContactPage cp = new ContactPage(driver);
		cp.getCreateNewContactBtn().click();

		// Enter all the details and create new Contact
		CreateNewContactPage cncp = new CreateNewContactPage(driver);
		cncp.createcontact(lastName);

		// verify header message expected result
		ContactInfoPage cip = new ContactInfoPage(driver);
		String contact = cip.getHeaderMsg().getText();

		if (contact.contains(lastName)) {
			System.out.println(lastName + " name is verified==pass");
		} else {
			System.out.println(lastName + " name is verified==Fail");

		}

	}

}
