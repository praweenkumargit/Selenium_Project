package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Rttc32POM {
private WebDriver driver; 
	
	public Rttc32POM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText="Nullam sodales in purus vel auctor")
	private WebElement integerMassa; 
	public void clickIntegerMassa() {
		
		this.integerMassa.click();
	}
	
	@FindBy(id="button-cart")
	private WebElement addToCart;
    public void clickAddToCart() {
		
		this.addToCart.click();
	}
	
	@FindBy(xpath="//ul/li/h3/a/i[@class='tb_icon ico-linea-ecommerce-bag']")
	private WebElement cartButton; 
    public void mouseOverCart() {
		Actions builder = new Actions(this.driver);
		builder.moveToElement(this.cartButton).build().perform();
		
    }
	
    @FindBy(linkText="View Cart")
	private WebElement viewCartButton; 
    public void clickCart() {
		Actions builder = new Actions(this.driver);
		builder.moveToElement(this.viewCartButton).click().build().perform();
		
    }
	
    @FindBy(linkText="Checkout")
	private WebElement checkoutButton; 
	public void clickCheckoutButton() {
		
		this.checkoutButton.click();
	}
	
	@FindBy(xpath="//div/fieldset/legend")
	private WebElement loginPage; 
	public String getLoginPageText() {
		
		String s1 = this.loginPage.getText();
		return s1;
	}
	
}
