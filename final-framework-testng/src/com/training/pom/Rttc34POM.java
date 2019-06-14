package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Rttc34POM {

private WebDriver driver; 
	
	public Rttc34POM(WebDriver driver) {
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
	
	public void writeIntoComment(String comment1) {
		
		this.commentt.clear();
		this.commentt.sendKeys(comment1);
	}
	
	@FindBy(xpath = "//div/p/textarea")
	private WebElement commentt2;
	
	public void writeIntoComment2(String comment2) {
		//driver.switchTo().defaultContent();
		this.commentt2.clear();
		this.commentt2.sendKeys(comment2);
	}
	
	@FindBy(xpath = "//div/input[@id='button-shipping-method']")
	private WebElement continueBtn;
	
	public void clickContinueButton() throws InterruptedException {
		
		
		this.continueBtn.click();
		Thread.sleep(4000);
		driver.switchTo().defaultContent();
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
    
    @FindBy(xpath ="//div/label/input[@value='guest']")
	private WebElement guestRadioButton; 
    public void clickGuestRadioButton() {
		this.guestRadioButton.click();
		
    }
    
    @FindBy(xpath = "//div/input[@id='button-account']")
	private WebElement guestContinueBtn;
	
	public void clickGuestContinueButton() {
		
		
		this.guestContinueBtn.click();
	}
	
	@FindBy(xpath = "//div/input[@id='input-payment-firstname']")
	private WebElement guestFirstName;
	
	public void sendGuestFirstName(String gfn) {
		
		this.guestFirstName.clear();
		this.guestFirstName.sendKeys(gfn);
	}
	
	@FindBy(xpath = "//div/input[@id='input-payment-lastname']")
	private WebElement guestLastName;
	
	public void sendGuestLastName(String gln) {
		
		this.guestLastName.clear();
		this.guestLastName.sendKeys(gln);
	}
	
	@FindBy(xpath = "//div/input[@id='input-payment-email']")
	private WebElement guestEmail;
	
	public void sendGuestEmail(String ge) {
		
		this.guestEmail.clear();
		this.guestEmail.sendKeys(ge);
	}
	
	@FindBy(xpath = "//div/input[@id='input-payment-telephone']")
	private WebElement guestTelephone;
	
	public void sendGuestTelephone(String gt) {
		
		this.guestTelephone.clear();
		this.guestTelephone.sendKeys(gt);
	}
	
	@FindBy(xpath = "//div/input[@id='input-payment-address-1']")
	private WebElement guestAddress1;
	
	public void sendGuestAddress1(String ga1) {
		
		this.guestAddress1.clear();
		this.guestAddress1.sendKeys(ga1);
	}
	
	@FindBy(xpath = "//div/input[@id='input-payment-city']")
	private WebElement guestCity;
	
	public void sendGuestCity(String gc) {
		
		this.guestCity.clear();
		this.guestCity.sendKeys(gc);
	}
	
	@FindBy(xpath = "//div/input[@id='input-payment-postcode']")
	private WebElement guestPostcode;
	
	public void sendGuestPostcode(String gp) {
		
		this.guestPostcode.clear();
		this.guestPostcode.sendKeys(gp);
	}
	
	@FindBy(id="input-payment-country")
	private WebElement guestCountry;
	
	public void selectGuestCountry() {
		
		Select sel = new Select(this.guestCountry);
		sel.selectByVisibleText("India");
	}
	
	@FindBy(id="input-payment-zone")
	private WebElement guestState;
	
	public void selectGuestState() {
		
		Select sel = new Select(this.guestState);
		sel.selectByVisibleText("Karnataka");
	}
	
    @FindBy(xpath = "//div/input[@id='button-guest']")
	private WebElement guestPersonalDetailsContinueBtn;
	
	public void clickGuestPersonalDetailsContinueButton() {
		
		
		this.guestPersonalDetailsContinueBtn.click();
	}
}
