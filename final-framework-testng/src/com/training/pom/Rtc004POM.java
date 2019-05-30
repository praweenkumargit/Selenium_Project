package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class Rtc004POM {
	
private WebDriver driver; 
	
	public Rtc004POM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//td/a[@class='btn btn-default tb_no_text']")
	private WebElement view; 
	
	@FindBy(xpath="//tr/td[@class='text-left']")
	private WebElement orderDetails; 
	
	public void clickView() {
		this.view.click();
	}
	
	public String oderDetails() {
		//String str = "Order Details";
		String actual = this.orderDetails.getText();
		//return oderDetails();
		//Assert.assertEquals(actual, str, "Order details displayed");
		return actual;
	}

}
