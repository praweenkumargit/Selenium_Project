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
import com.training.pom.Rtc004POM;
import com.training.pom.Rtc005POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RTC005 {

	private WebDriver driver;
	private String baseUrl;
	private RTC002POM rtc002POM;
	private Rtc005POM rtc005POM;
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
		rtc005POM = new Rtc005POM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
		Thread.sleep(7000);
		Actions act = new Actions(driver);
		//act.moveToElement(driver.findElement(By.xpath("//*[@id=\"Menu_Wmt3OMY3\"]/nav/ul/li[2]/a/span/span/i"))).click().build().perform();
		act.moveToElement(driver.findElement(By.xpath("//i[@class='fa fa-user-o']"))).click().build().perform();
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	@Test 
	public void validAccountEditTest() throws InterruptedException {
		rtc002POM.sendEmail("praween2@gmail.com");
		rtc002POM.sendPassword("password1");
		rtc002POM.clickLoginBtn();
		//rtc002POM.assertion();
		Thread.sleep(7000);
		rtc005POM.clickEditAccountInfo();
		rtc005POM.sendFirstName("praween1");
		rtc005POM.sendLastName("Kumar1");
		rtc005POM.sendEmail("prawkuma3@in.ibm.com");
		rtc005POM.sendTelephone("9903305763");
		rtc005POM.clickContinueButton();
		Thread.sleep(7000);
		String actual = rtc005POM.editAccountInfoSuccess();
		String expected = "Success: Your account has been successfully updated.";
		
		Assert.assertEquals(actual, expected);
		System.out.println("Test Case Passed");
			
		
	}
}
