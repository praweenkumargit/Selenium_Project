package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Rttc33POM {
private WebDriver driver; 
	
	public Rttc33POM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="address_id")
	private WebElement billingDetails;
	private Object sel; 
	public void selectBillingDetails() {
		
		Select sel = new Select(billingDetails);
		sel.selectByValue("126");
	}
	
	@FindBy(name="address_id")
	private WebElement deliveryDetails;
	private Object sel2; 
	public void selectDeliveryDetails() {
		
		Select sel2 = new Select(deliveryDetails);
		sel2.selectByValue("126");
	}
	
	
	@FindBy(name="comment")
	private WebElement commentt;
	
	public void writeIntoComment(String comment) {
		
		this.commentt.clear();
		this.commentt.sendKeys(comment);
	}
	
	@FindBy(xpath = "//div/input[@id='button-shipping-method']")
	private WebElement continueBtn;
	
	public void clickContinueButton() {
		
		
		this.continueBtn.click();
	}
	
	@FindBy(xpath = "//div/input[@id='button-payment-method']")
	private WebElement paymentContinueBtn;
	
	public void clickPaymentContinueButton() {
		
		
		this.paymentContinueBtn.click();
	}
	
	@FindBy(xpath = "//div/input[@id='button-payment-address']")
	private WebElement billingAddressContinueBtn;
	
	public void clickbillingAddressContinueButton() {
		
		
		this.billingAddressContinueBtn.click();
	}
	
	@FindBy(xpath = "//div/input[@id='button-shipping-address']")
	private WebElement deliveryAddressContinueBtn;
	
	public void clickdeliveryAddressContinueButton() {
		
		
		this.deliveryAddressContinueBtn.click();
	}
	
	@FindBy(xpath = "//div/input[@id='button-confirm']")
	private WebElement confirmOrderBtn;
	
	public void clickConfirmOrderButton() {
		
		
		this.confirmOrderBtn.click();
	}
	
	@FindBy(xpath = "//div/div[2]/div[1]/label/input[@name='agree']")
	private WebElement checkbox;
	
	public void clickCheckbox() {
		if (this.checkbox.isSelected())
		{
			
		}
		
		else {
			
			this.checkbox.click();
		}
	}
		
	@FindBy(xpath ="//ul/li[@id='menu_url_F5fG9']")
	private WebElement homeButton; 
    public void clickHomeButton() {
		this.homeButton.click();
		
    }
}
