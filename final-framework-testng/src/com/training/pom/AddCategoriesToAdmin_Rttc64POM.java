package com.training.pom;

import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddCategoriesToAdmin_Rttc64POM {
private WebDriver driver; 
	
	public AddCategoriesToAdmin_Rttc64POM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="input-username")
	private WebElement userName;
	public void sendUserName(String userName) {
		this.userName.clear();
		this.userName.sendKeys(userName);
	}
	
	@FindBy(id="input-password")
	private WebElement password;
	public void sendPassword(String password) {
		this.password.clear(); 
		this.password.sendKeys(password); 
	}
	
	@FindBy(xpath="//div/button[@class='btn btn-primary']")
	private WebElement loginBtn; 
	public void clickLoginBtn() {
		this.loginBtn.click(); 
	}
	
	@FindBy(xpath="//li/a/i[@class='fa fa-tags fw']")
	private WebElement catalogBtn; 
	@FindBy(xpath="//ul/li/a[contains(text(),'Categories')]")
	private WebElement categoriesBtn; 
	public void clickCategoriesBtn() {
		Actions act  = new Actions(driver);
		act.moveToElement(catalogBtn).build().perform();
		act.moveToElement(categoriesBtn).click().build().perform();
	}
	
	@FindBy(xpath="//div/a/i[@class='fa fa-plus']")
	private WebElement addNewBtn; 
	public void clickAddNewBtn() {
		this.addNewBtn.click(); 
	}
	
	@FindBy(name="category_description[1][name]")
	private WebElement categoryName;
	public void sendCategoryName(String categoryName) {
		this.categoryName.clear();
		this.categoryName.sendKeys(categoryName);
	}
	public String getCategoryName() {
		return this.categoryName.getAttribute("value");
	}
	
	@FindBy(id="input-meta-title1")
	private WebElement metaTagTitle;
	public void sendmetaTagTitle(String metaTagTitle) {
		this.metaTagTitle.clear();
		this.metaTagTitle.sendKeys(metaTagTitle);
	}
	
	public String getmetaTagTitle() {
		return this.metaTagTitle.getAttribute("value");
	}
	
	@FindBy(xpath="//div[@class='note-editable panel-body']")
	private WebElement description;
	public void sendDescription(String description) {
		
		this.description.clear();
		this.description.sendKeys(description);
	}
	
	public String getdescription() {
		return this.description.getAttribute("value");
	}
	
	
	@FindBy(xpath="//div[@class='note-editable panel-body']")
	private WebElement metaTagDescription;
	public void sendmetaDescription(String metadescription) {
		
		this.metaTagDescription.clear();
		this.metaTagDescription.sendKeys(metadescription);
	}
	
	public String getmetaTagDescription() {
		return this.metaTagDescription.getAttribute("value");
	}
	
	
	@FindBy(xpath = "//div/button/i[@class='fa fa-save']")
	private WebElement saveBtn;
	
	public void clickSaveButton() throws InterruptedException {
		
		
		this.saveBtn.click();
		Thread.sleep(9000);
	}
	
	@FindBy(xpath = "//div[@class='alert alert-success']")
	private WebElement successMessage;
	
	public String successMessageGetText() {
		
		
		String actual = this.successMessage.getText();
		return actual;
	}
	

}
