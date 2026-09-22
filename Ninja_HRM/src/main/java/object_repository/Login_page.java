package object_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login_page {
	
	public Login_page(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="username")
	private WebElement username;
	
	@FindBy(id="inputPassword")
	private WebElement password;
	
	@FindBy(xpath = "//button[text()='Sign in']")
	private WebElement login;

	public WebElement getUsername() {
		return username;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getLogin() {
		return login;
	}

	public void userLogin(String un,String pwd)
	{
		username.clear();
		username.sendKeys(un);
		password.clear();
		password.sendKeys(pwd);
		login.click();
	}
	
	
	
	
	

}
