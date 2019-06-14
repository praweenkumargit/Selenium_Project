package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Rttc31_invalidLoginPOM {
private WebDriver driver; 
	
	public Rttc31_invalidLoginPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="input-email")
	private WebElement email; 
	
	@FindBy(id="input-password")
	private WebElement password;
	
	@FindBy(xpath="//div/input[@class='btn btn-primary']")
	private WebElement loginBtn; 
	
	@FindBy(xpath="//div[contains(text(),'Warning: No match for E-Mail Address and/or Password.')]")
	private WebElement warningMessage; 
	
	
	
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
	
	public  String assertion() {
		
       String actual = this.warningMessage.getText();
       return actual;
      
	}
	
	
}
