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
import org.openqa.selenium.support.ui.Select;

public class Rttc35POM {
private WebDriver driver; 
	
	public Rttc35POM(WebDriver driver) {
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
	@FindBy(linkText="Products")
	private WebElement productsBtn; 
	public void clickProductsBtn() {
		Actions act  = new Actions(driver);
		act.moveToElement(catalogBtn).build().perform();
		act.moveToElement(productsBtn).click().build().perform();
	}
	
	@FindBy(xpath="//div/a/i[@class='fa fa-plus']")
	private WebElement addNewBtn; 
	public void clickAddNewBtn() {
		this.addNewBtn.click(); 
	}
	
	@FindBy(id="input-name1")
	private WebElement productName;
	public void sendProductName(String productName) {
		this.productName.clear();
		this.productName.sendKeys(productName);
	}
	
	@FindBy(id="input-meta-title1")
	private WebElement metaTagTitle;
	public void sendmetaTagTitle(String metaTagTitle) {
		this.metaTagTitle.clear();
		this.metaTagTitle.sendKeys(metaTagTitle);
	}
	
	@FindBy(linkText="Data")
	private WebElement dataTab;
	public void clickDataTab() {
		
		this.dataTab.click();
	}
	
	@FindBy(id="input-model")
	private WebElement model;
	public void sendModel(String model) {
		this.model.clear();
		this.model.sendKeys(model);
	}
	
	@FindBy(id="input-quantity")
	private WebElement quantity;
	public void sendQuantity(String quantity) {
		this.quantity.clear();
		this.quantity.sendKeys(quantity);
	}
	
	@FindBy(id="input-price")
	private WebElement price;
	public void sendPrice(String price) {
		this.price.clear();
		this.price.sendKeys(price);
	}
	
	@FindBy(linkText="Links")
	private WebElement linkTab;
	public void clickLinkTab() {
		
		this.linkTab.click();
	}
	
	@FindBy(id="input-category")
	private WebElement categories;
	public void clickOnCategories() throws InterruptedException {
		
		this.categories.click();
		Thread.sleep(2000);
		List<WebElement> options = categories.findElements(By.tagName("li"));
		for (WebElement option : options)
		{
		    if (option.getText().equals("Ladies Ornaments"))
		    {
		        option.click(); 
		        
		    }
		}
		Thread.sleep(2000);
	}
		
	
	@FindBy(linkText="Discount")
	private WebElement discountTab;
	public void clickDiscountTab() {
		
		this.discountTab.click();
	}
	
	@FindBy(xpath="//tfoot/tr/td/button[@data-original-title='Add Discount']")
	private WebElement addDiscountBtn;
	public void clickDiscountBtn() {
		
		this.addDiscountBtn.click();
	}
	
	@FindBy(xpath="//td/input[@name='product_discount[0][price]']")
	private WebElement discountPrice;
	public void sendDiscountPrice(String discountPrice) {
		this.discountPrice.clear();
		this.discountPrice.sendKeys(discountPrice);
	}
	
	@FindBy(xpath="//td/input[@name='product_discount[0][quantity]']")
	private WebElement discountQuantity;
	public void sendDiscountQuantity(String discountQuantity) {
		this.discountQuantity.clear();
		this.discountQuantity.sendKeys(discountQuantity);
	}
	
	
	//@FindBy(xpath="//div/input[@name='product_discount[0][date_start]']")
	//private WebElement startDate;
	//@FindBy(xpath="//td[@class='day active today']")
	//private WebElement currentDate;
	//public String getCurrentDate() {
		
		
		//String dateToday = this.currentDate.getText();
		//String dateToday1 = dateToday.format(dateToday, 2)
		//return dateToday;
		
	//}
	//public void sendDiscountcurrentDate() {
		//this.startDate.clear();
		//String dateToday2 = getCurrentDate();
		//System.out.println(dateToday2);
		//this.startDate.sendKeys(dateToday2);
	//}
	
	
	@FindBy(xpath="//*[@id=\"discount-row0\"]/td[5]/div/span/button/i")
	private WebElement startDateicon;
	public void clickStartDateIcon() {
		this.startDateicon.click();
		}
	
	private String getCurrentDay() {
		
		Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
		int todayInt = calendar.get(Calendar.DAY_OF_MONTH);
		String todayStr = Integer.toString(todayInt);
		return todayStr;
	}
	
	@FindBy(xpath=" //div[5]/div/div[1]/table/tbody")
	private WebElement startDateCalendar;
	
	public void selectCurrentDate() {
		
		List<WebElement> columns = this.startDateCalendar.findElements(By.tagName("td"));
		
		for (WebElement cell: columns) {
			if (cell.getText().equals(getCurrentDay())) {
				cell.click();
				break;
			}
		}
	}
	
	@FindBy(xpath="//*[@id=\"discount-row0\"]/td[6]/div/span/button/i")
	private WebElement endDateicon;
	public void clickEndDateIcon() {
		this.endDateicon.click();
		}
	
	private String getNextDay() {
		
		Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
		int todayInt = calendar.get(Calendar.DAY_OF_MONTH);
		int nextInt = todayInt + 1;
		String nextStr = Integer.toString(nextInt);
		return nextStr;
	}
	
	@FindBy(xpath="//div[6]/div/div[1]/table/tbody")
	private WebElement endDateCalendar;
	
	public void selectnextDate() {
		
		List<WebElement> columns = this.endDateCalendar.findElements(By.tagName("td"));
		
		for (WebElement cell: columns) {
			if (cell.getText().equals(getNextDay())) {
				cell.click();
				break;
			}
		}
	}
	
	

	
	@FindBy(linkText="Reward Points")
	private WebElement rewardPointsTab;
	public void clickRewardPointsTab() {
		
		this.rewardPointsTab.click();
	}
	
	@FindBy(id="input-points")
	private WebElement points;
	public void sendPoints(String points) {
		this.points.clear();
		this.points.sendKeys(points);
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
