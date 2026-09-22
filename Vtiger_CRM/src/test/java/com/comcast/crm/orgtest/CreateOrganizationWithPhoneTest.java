package com.comcast.crm.orgtest;

import org.testng.annotations.Test;

import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.objectrepositoryutility.CreatingNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.OrganizationInfoPage;
import com.comcast.crm.objectrepositoryutility.OrganizationPage;

public class CreateOrganizationWithPhoneTest extends BaseClass {
	@Test

	public void organizationWithPhone() throws Exception {

		String orgName = eu.readDataFromExcel("Organization", 1, 0) + ju.generateRandomNumber();
		String phone = eu.readDataFromExcel("Organization", 1, 2);

		// Navigate to Organization Module
		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();

		// click on create organization button
		OrganizationPage cop = new OrganizationPage(driver);
		cop.getCreateNewOrgBtn().click();

		// Enter all the details and create new organization
		CreatingNewOrganizationPage cnop = new CreatingNewOrganizationPage(driver);
		cnop.createOrgPhone(orgName, phone);

		// verify header message expected result
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String actOrgName = oip.getHeaderMsg().getText();

		if (actOrgName.contains(orgName)) {
			System.out.println(orgName + " name is verified==pass");
		} else {
			System.out.println(orgName + " name is verified==Fail");

		}

	}

}