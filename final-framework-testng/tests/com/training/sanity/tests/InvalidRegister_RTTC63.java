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

import com.training.dataproviders.InvalidRegisterDataProviders;
import com.training.dataproviders.RegisterDataProviders;
import com.training.generics.ScreenShot;
import com.training.pom.RegisterPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

/*  To verify whether application denies the user to get registered on the application by entering invalid credentials   */

public class InvalidRegister_RTTC63 {
	private WebDriver driver;
	private String baseUrl;
	private RegisterPOM registerPOM;
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
		registerPOM = new RegisterPOM(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
		Thread.sleep(7000);
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath("//i[@class='fa fa-user-o']"))).click().build().perform();
		System.out.println("hhh");
		//act.moveToElement(driver.findElement(By.xpath("//*[@id=\"Menu_Wmt3OMY3\"]/nav/ul/li[2]/ul/li[1]/a/span"))).click().build().perform();
		Thread.sleep(5000);
		driver.findElement(By.linkText("Register")).click();
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	@Test (dataProvider = "excel-inputs2", dataProviderClass = InvalidRegisterDataProviders.class)
	public void validRegisterTest(String firstName, String lastName, String email, String telePhone, String address1, String city, String password, String confirmPassword) {
		
		// SUBMIT FORM USING INVALID DATA FROM EXCEL SHEET
		registerPOM.sendFirstName(firstName);
		registerPOM.sendLastName(lastName);
		registerPOM.sendEmail(email);
		registerPOM.sendTelephone(telePhone);
		registerPOM.sendAddress1(address1);
		registerPOM.sendCity(city);
		registerPOM.selectCountry();
		registerPOM.selectZone();
		registerPOM.sendPassword(password);
		registerPOM.sendConfirmPassword(confirmPassword);
		registerPOM.checkAgree();
		registerPOM.clickContinue();
		
		//WARNING MESSAGE ASSERTION
		String expected = "Warning: E-Mail Address is already registered!";
		String actual = registerPOM.assertRegistrationWarning();
	    Assert.assertEquals(actual, expected);
		
		
		
		
		
	}
}
