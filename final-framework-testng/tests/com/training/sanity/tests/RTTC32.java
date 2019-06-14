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
import com.training.pom.Rttc31_invalidLoginPOM;
import com.training.pom.Rttc32POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RTTC32 {
	private WebDriver driver;
	private String baseUrl;
	private Rttc32POM rttc32POM;
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
		rttc32POM = new Rttc32POM(driver); 
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
		rttc32POM.clickAddToCart();
		Thread.sleep(12000);
		rttc32POM.mouseOverCart();
		rttc32POM.clickCart();
		rttc32POM.clickCheckoutButton();
		Thread.sleep(5000);
		String expected = "Returning Customer";
		String s1 = rttc32POM.getLoginPageText();
		
		Assert.assertEquals(s1, expected);
		
		//screenShot.captureScreenShot("First");
	}
}
