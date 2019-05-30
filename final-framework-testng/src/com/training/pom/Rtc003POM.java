package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class Rtc003POM {
private WebDriver driver; 
	
	public Rtc003POM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="input-email")
	private WebElement email; 
	
	@FindBy(id="input-password")
	private WebElement password;
	
	@FindBy(xpath="//*[@id=\"System_nyHsmShk\"]/div/div[2]/div/form/div/div[2]/input")
	private WebElement loginBtn; 
	
	@FindBy(xpath="//div[contains(text(),'Warning: No match for E-Mail Address and/or Password.')]")
	private WebElement warningMessage; 
	
	@FindBy(linkText="Forgotten Password")
	private WebElement forgotPwdBtn;
	
	@FindBy(xpath="//div/input[@class='btn btn-primary']")
	private WebElement continueBtn;
	
	@FindBy(xpath="//div[contains(text(),'An email with a confirmation link has been sent your email address.')]")
	private WebElement confirmationMessage;
	
	public void sendEmail(String email) {
		this.email.clear();
		this.email.sendKeys(email);
	}
	
	public void sendPassword(String password) {
		this.password.clear(); 
		this.password.sendKeys(password); 
	}
	
	public void clickLoginBtn() {
		this.loginBtn.click(); 
	}
	public void clickfgtpwdBtn() {
		this.forgotPwdBtn.click(); 
	}
	
	public void clickContinueBtn() {
		this.continueBtn.click(); 
	}
	public  String assertion() {
		
       String actual = this.warningMessage.getText();
       return actual;
      
	}
	
	public String assertion2() {

		String actual2 = this.confirmationMessage.getText();
		return actual2;
		
	}

}
