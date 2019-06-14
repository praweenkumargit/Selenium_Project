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
import com.training.pom.Rtc003POM;
import com.training.pom.Rttc31_invalidLoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RTC31 {
	private WebDriver driver;
	private String baseUrl;
	private Rttc31_invalidLoginPOM rttc31POM;
	private static Properties properties;
	private ScreenShot screenShot;
	
	/*
	To verify whether application denies user getting logged in upon entering invalid credentials in required field
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
		rttc31POM = new Rttc31_invalidLoginPOM(driver); 
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
	public void validLoginTest() {
		rttc31POM.sendEmail("praweenpappu@gmail.com");
		rttc31POM.sendPassword("password11");
		rttc31POM.clickLoginBtn();
		String expected = "Warning: No match for E-Mail Address and/or Password.";
		String actual = rttc31POM.assertion();
		Assert.assertEquals(actual, expected);
		
		screenShot.captureScreenShot("First");
	}
}
