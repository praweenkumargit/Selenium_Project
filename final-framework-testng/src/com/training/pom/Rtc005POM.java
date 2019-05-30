package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Rtc005POM {
	
private WebDriver driver; 
	
	public Rtc005POM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText="Edit your account information")
	private WebElement editAccountInfo; 
	
	@FindBy(id="input-firstname")
	private WebElement firstName; 
	
	@FindBy(id="input-lastname")
	private WebElement lastName;
	
	@FindBy(id="input-email")
	private WebElement email;
	
	@FindBy(id="input-telephone")
	private WebElement telePhone;
	
	
	@FindBy(xpath="//div/input[@class='btn btn-primary']")
	private WebElement continueBtn;
	
	@FindBy(xpath="//div[@class='alert alert-success']")
	private WebElement alertSuccessMsg;
	
	public void clickEditAccountInfo() {
		this.editAccountInfo.click();
	}
		
	public void clickContinueButton() {
			this.continueBtn.click();
			
	}
	
	public void sendFirstName(String firstName) {
		this.firstName.clear();
		this.firstName.sendKeys(firstName);
	}
	
	public void sendLastName(String lastName) {
		this.lastName.clear();
		this.lastName.sendKeys(lastName);
	}
	
	public void sendEmail(String email) {
		this.email.clear();
		this.email.sendKeys(email);
	}
	
	public void sendTelephone(String telePhone) {
		this.telePhone.clear();
		this.telePhone.sendKeys(telePhone);
	}
	public String editAccountInfoSuccess() {
		//String str = "Order Details";
		String actual = this.alertSuccessMsg.getText();
		//return oderDetails();
		//Assert.assertEquals(actual, str, "Order details displayed");
		return actual;
	}


}
