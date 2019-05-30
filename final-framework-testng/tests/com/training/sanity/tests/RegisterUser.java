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
import com.training.pom.LoginPOM;
import com.training.pom.RegisterPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RegisterUser {
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
	@Test
	public void validRegisterTest() {
		
		registerPOM.sendFirstName("Praween4");
		registerPOM.sendLastName("Praween4");
		registerPOM.sendEmail("praween4@gmail.com");
		registerPOM.sendTelephone("9903305762");
		registerPOM.sendAddress1("Salt Lake");
		registerPOM.sendCity("Kolkata");
		registerPOM.selectCountry();
		registerPOM.selectZone();
		registerPOM.sendPassword("password1");
		registerPOM.sendConfirmPassword("password1");
		registerPOM.checkAgree();
		registerPOM.clickContinue();
		String expected = "Congratulations! Your new account has been successfully created!";
		String actual = registerPOM.assertRegistration();
	    Assert.assertEquals(actual, expected);
		
		
		
		
		
	}
}


