package com.comcast.crm.orgtest;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.objectrepositoryutility.CreatingNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.OrganizationInfoPage;
import com.comcast.crm.objectrepositoryutility.OrganizationPage;

import generic_utility.UtilityClassObject;

public class CreateOrganizationTest extends BaseClass {

	@Test(groups = "smoke")

	public void CreateOrganization() throws Exception {
		UtilityClassObject.getTest().log(Status.INFO, "read data from excel");
		String orgName = eu.readDataFromExcel("Organization", 1, 0) + ju.generateRandomNumber();
		//String industry = eu.readDataFromExcel("Organization", 1, 1) + ju.generateRandomNumber();

		// Navigate to Organization Module
		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();

		// click on create organization button
		OrganizationPage cop = new OrganizationPage(driver);
		cop.getCreateNewOrgBtn().click();

		// Enter all the details and create new organization
		CreatingNewOrganizationPage cnop = new CreatingNewOrganizationPage(driver);
		cnop.createOrg(orgName);

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
