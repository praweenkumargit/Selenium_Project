package com.training.pom;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class RegisterPOM {
private WebDriver driver; 
	
	public RegisterPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="input-firstname")
	private WebElement firstName; 
	
	@FindBy(id="input-lastname")
	private WebElement lastName;
	
	@FindBy(id="input-email")
	private WebElement email;
	
	@FindBy(id="input-telephone")
	private WebElement telePhone;
	
	@FindBy(id="input-address-1")
	private WebElement address1;
	
	@FindBy(id="input-city")
	private WebElement city;
	
	@FindBy(id="input-country")
	private WebElement country;
	
	@FindBy(id="input-zone")
	private WebElement regionState;
	
	@FindBy(id="input-password")
	private WebElement password;
	
	@FindBy(id="input-confirm")
	private WebElement confirmPassword;
	
	@FindBy(name="agree")
	private WebElement agree;
	
	@FindBy(xpath="//div/input[@class='btn btn-primary']")
	private WebElement clickContinue;
	
	@FindBy(xpath="//div/p[contains(text(),'Congratulations! Your new account has been successfully created!')]")
	private WebElement registerSuccess;

	
	
	public void sendFirstName(String firstName) {
		this.firstName.clear();
		this.firstName.sendKeys(firstName);
	}
	
	public String getfirstName() {
		return this.firstName.getAttribute("value");
	}
	
	public void sendLastName(String lastName) {
		this.lastName.clear();
		this.lastName.sendKeys(lastName);
	}
	public String getlastName() {
		return this.lastName.getAttribute("value");
	}
	
	public void sendEmail(String email) {
		this.email.clear();
		this.email.sendKeys(email);
	}
	
	public String getemail() {
		return this.email.getAttribute("value");
	}
	
	public void sendTelephone(String telePhone) {
		this.telePhone.clear();
		this.telePhone.sendKeys(telePhone);
	}
	
	public String gettelePhone() {
		return this.telePhone.getAttribute("value");
	}
	
	public void sendAddress1(String address1) {
		this.address1.clear();
		this.address1.sendKeys(address1);
	}
	
	public String getaddress1() {
		return this.address1.getAttribute("value");
	}
	
	public void sendCity(String city) {
		this.city.clear();
		this.city.sendKeys(city);
		
		}
	
	public String getcity() {
		return this.city.getAttribute("value");
	}
	
	public void selectCountry() {
		Select ctry = new Select(country);
		ctry.selectByVisibleText("India");
		
		}
	
	public void selectZone() {
		Select zone = new Select(regionState);
		zone.selectByVisibleText("Goa");
		
		}
	
	public void sendPassword(String password) {
		this.password.clear();
		this.password.sendKeys(password);
	}
	
	public String getpassword() {
		return this.password.getAttribute("value");
	}
	
	public void sendConfirmPassword(String confirmPassword) {
		this.confirmPassword.clear();
		this.confirmPassword.sendKeys(confirmPassword);
	}
	
	public String getconfirmPassword() {
		return this.confirmPassword.getAttribute("value");
	}
	
	public void checkAgree() {
		if(agree.isSelected()) {
			
			
		}
		else {
			
			agree.click();
		}
			
	}
	
	public void clickContinue() {
		this.clickContinue.click(); 
		
	}
	
	public String assertRegistration() {
	
		String actual = registerSuccess.getText();
		return actual;
			
	}
	
	@FindBy(xpath="//div/div[@class='alert alert-danger']")
	private WebElement registerAlert;
	public String assertRegistrationWarning() {
		
		String actual = this.registerAlert.getText();
		return actual;
			
	}
	

}
