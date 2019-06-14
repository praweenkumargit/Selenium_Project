package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.RTC002POM;
import com.training.pom.Rttc32POM;
import com.training.pom.Rttc33POM;
import com.training.pom.Rttc34POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

/*
To verify whether application allows user to place an order as guest user
*/ 

public class RTTC34 {
	private WebDriver driver;
	private String baseUrl;
	private RTC002POM rtc002POM;
	private Rttc32POM rttc32POM;
	private Rttc33POM rttc33POM;
	private Rttc34POM rttc34POM;
	private static Properties properties;
	private ScreenShot screenShot;

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
		rttc34POM = new Rttc34POM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
		
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	@Test 
	public void validLoginTest() throws InterruptedException {
		
		rttc32POM.clickIntegerMassa();
		System.out.println("hahah");
		rttc32POM.clickAddToCart();
		Thread.sleep(12000);
		rttc32POM.mouseOverCart();
		rttc32POM.clickCart();
		rttc32POM.clickCheckoutButton();
		rttc34POM.clickGuestRadioButton();
		rttc34POM.clickGuestContinueButton();
		rttc34POM.sendGuestFirstName("Praween11");
		rttc34POM.sendGuestLastName("Kumar");
		rttc34POM.sendGuestEmail("praweenpappu4@gmail.com");
		rttc34POM.sendGuestTelephone("9903305762");
		rttc34POM.sendGuestAddress1("yeswantpur");
		rttc34POM.sendGuestCity("bengaluru");
		rttc34POM.sendGuestPostcode("560022");
		rttc34POM.selectGuestCountry();
		rttc34POM.selectGuestState();
		rttc34POM.clickGuestPersonalDetailsContinueButton();
		Thread.sleep(5000);
		rttc34POM.writeIntoComment("The product is nice");
		rttc34POM.clickContinueButton();
		Thread.sleep(5000);
		rttc34POM.writeIntoComment2("Thanks again2");
		rttc34POM.clickCheckbox();
		rttc34POM.clickPaymentContinueButton();
		rttc33POM.clickConfirmOrderButton();
		Thread.sleep(5000);
		System.out.println("yeye");
		String expected = "Your order has been placed!";
		String actual = driver.getTitle();
		Assert.assertEquals(actual, expected, "Test case passed");

}
}
