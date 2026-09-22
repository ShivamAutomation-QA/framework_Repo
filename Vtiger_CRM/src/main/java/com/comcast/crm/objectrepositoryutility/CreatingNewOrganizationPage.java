package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreatingNewOrganizationPage {
	
WebDriver driver;
	
	public CreatingNewOrganizationPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
		
	}
	
	@FindBy(name="accountname")
	private WebElement orgNameEdt;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	@FindBy(name = "industry")
	private WebElement industrydd;
	
	@FindBy(id = "phone")
	private WebElement phoneNo;

	public WebElement getOrgNameEdt() {
		return orgNameEdt;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	public void createOrg(String OrgName)
	{
		orgNameEdt.sendKeys(OrgName);
		saveBtn.click();
	}
	
	public void createOrgPhone(String OrgName,String phone)
	{
		orgNameEdt.sendKeys(OrgName);
		phoneNo.sendKeys(phone);
		saveBtn.click();
	}
	
	public void createOrg(String OrgName,String industry)
	{
		orgNameEdt.sendKeys(OrgName);
		Select sel = new Select(industrydd);
		sel.selectByVisibleText(industry);
		saveBtn.click();
	}

}
