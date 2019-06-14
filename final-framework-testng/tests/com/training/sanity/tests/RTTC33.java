package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.RTC002POM;
import com.training.pom.Rttc32POM;
import com.training.pom.Rttc33POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RTTC33 {
	private WebDriver driver;
	private String baseUrl;
	private RTC002POM rtc002POM;
	private Rttc32POM rttc32POM;
	private Rttc33POM rttc33POM;
	private static Properties properties;
	private ScreenShot screenShot;
	
	/*
	To verify whether application allows user to place an order with Pre Logging in
	*/

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		rtc002POM = new RTC002POM(driver);
		rttc32POM = new Rttc32POM(driver);
		rttc33POM = new Rttc33POM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
		Thread.sleep(7000);
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath("//i[@class='fa fa-user-o']"))).click().build().perform();
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	@Test 
	public void validLoginTest() throws InterruptedException {
		rtc002POM.sendEmail("praween2@gmail.com");
		rtc002POM.sendPassword("password1");
		rtc002POM.clickLoginBtn();
        rttc33POM.clickHomeButton();
        System.out.println("haha");
        Thread.sleep(5000);
		rttc32POM.clickIntegerMassa();
		System.out.println("hahah");
		rttc32POM.clickAddToCart();
		Thread.sleep(12000);
		rttc32POM.mouseOverCart();
		rttc32POM.clickCart();
		rttc32POM.clickCheckoutButton();
        rttc33POM.selectBillingDetails();
		rttc33POM.clickbillingAddressContinueButton();
		rttc33POM.selectDeliveryDetails();
		rttc33POM.clickdeliveryAddressContinueButton();
		rttc33POM.writeIntoComment("Nice Product");
		rttc33POM.clickContinueButton();
		rttc33POM.writeIntoComment("Nice product it is");
		rttc33POM.clickCheckbox();
		rttc33POM.clickPaymentContinueButton();
		rttc33POM.clickConfirmOrderButton();
		Thread.sleep(5000);
		System.out.println("yeye");
		String expected = "Your order has been placed!";
		String actual = driver.getTitle();
		Assert.assertEquals(actual, expected, "Test case passed");

}
}