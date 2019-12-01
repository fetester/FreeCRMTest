package com.crm.qa.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.basic.TestBase;

public class LoginPage extends TestBase {
	Actions actions;
	//Page factory - Object Repository
	
	@FindBy(name ="username")
	WebElement username;
	
	@FindBy(name ="password")
	WebElement password;
	
	/*
	 * @FindBy(xpath="//input[@type='submit']") WebElement loginBtn;
	 */
	
	@FindBy(xpath="//*[@id=\'loginForm\']/div/div/input")
	WebElement loginBtn;
	
	@FindBy(xpath="//a[contains(text(),'Sign Up')]")
	WebElement signUp;
	
	@FindBy(xpath="//img[contains(@class, 'img-responsive')]")
	WebElement crmLogo;
	
	
	//Initializing the page objects
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
		
	}
	
	public String validateLoginPageTitle() {
		return driver.getTitle();
		
	}
	
	public Boolean validateLoginPageLogo() {
		return crmLogo.isDisplayed();
		 
	}
	
	public HomePage login(String un, String pwd) {
		username.sendKeys(un);
		password.sendKeys(pwd);
		actions = new Actions(driver);
		actions.moveToElement(loginBtn).click().build().perform();
		//loginBtn.click();		
		return new HomePage();
	}
}
