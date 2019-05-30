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
import com.training.pom.Rtc003POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RTC003 {
private WebDriver driver;
private String baseUrl;
private Rtc003POM rtc003POM;
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
	rtc003POM = new Rtc003POM(driver); 
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
	rtc003POM.sendEmail("praweenpappu@gmail.com");
	rtc003POM.sendPassword("password2");
	rtc003POM.clickLoginBtn();
	String expected = "Warning: No match for E-Mail Address and/or Password.";
	String actual = rtc003POM.assertion();
	Assert.assertEquals(actual, expected);
	rtc003POM.clickfgtpwdBtn();
	rtc003POM.sendEmail("praweenpappu@gmail.com");
	rtc003POM.clickContinueBtn();
	String expected2 = "An email with a confirmation link has been sent your email address.";
	
	String actual2 = rtc003POM.assertion2();
	Assert.assertEquals(actual2, expected2);
	screenShot.captureScreenShot("First");
}
}
