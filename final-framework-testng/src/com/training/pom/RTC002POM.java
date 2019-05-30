package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class RTC002POM {
private WebDriver driver; 
	
	public RTC002POM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="input-email")
	private WebElement email; 
	
	@FindBy(id="input-password")
	private WebElement password;
	
	@FindBy(xpath="//div/input[@class='btn btn-primary']")
	private WebElement loginBtn; 
	
	@FindBy(xpath="//*[@id=\"System_nyHsmShk\"]/align/h2")
	private WebElement myAccount;
	
	@FindBy(linkText="View your order history")
	private WebElement myOrders;
	
	
	
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
	public void assertion() {
		String str = "My Account";
		String actual = myAccount.getText();
		Assert.assertEquals(actual, str);
	}
	
	
	public void clickMyOrdersLink() {
		myOrders.click();
		 
	}
	
}
