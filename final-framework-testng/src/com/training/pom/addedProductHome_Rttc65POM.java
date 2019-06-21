package com.training.pom;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class addedProductHome_Rttc65POM {
private WebDriver driver; 
	
	public addedProductHome_Rttc65POM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div/a[@id='search_button']")
	private WebElement searchIcon; 
	
	
	
	
	@FindBy(xpath="//*[@id=\"filter_keyword\"]")
	private WebElement searchTextbox;
	
	public void sendSearchText(String stringg) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click(); ", searchIcon);
		js.executeScript("arguments[0].value='praween' ", searchTextbox);
		js.executeScript("arguments[0].click(); ", searchIcon);
	}
	
	@FindBy(tagName="a")
	private List <WebElement> resultLinks; 
	
	public  boolean isResultAvailable(String stringg) {
		
		resultLinks.contains(stringg);
		return true;
		
			
		}
	
	
	

}
