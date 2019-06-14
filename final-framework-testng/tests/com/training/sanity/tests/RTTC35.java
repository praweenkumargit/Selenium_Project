package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
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
import com.training.pom.Rttc35POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;


/*
To verify whether application allows admin to add product with the rewards point
*/ 

public class RTTC35 {
	private WebDriver driver;
	private String baseUrl;
	
	private Rttc35POM rttc35POM;
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
		
		rttc35POM = new Rttc35POM(driver);
		baseUrl = properties.getProperty("baseURL2");
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
	public void validAddProductTest() throws InterruptedException {
		
		rttc35POM.sendUserName("admin");
		rttc35POM.sendPassword("admin@123");
		rttc35POM.clickLoginBtn();
		rttc35POM.clickProductsBtn();
		rttc35POM.clickAddNewBtn();
		rttc35POM.sendProductName("Finger Ring");
		rttc35POM.sendmetaTagTitle("Finger Ring for ladies");
		rttc35POM.clickDataTab();
		rttc35POM.sendModel("SKU-012");
		rttc35POM.sendPrice("50");
		rttc35POM.sendQuantity("1");
		rttc35POM.clickLinkTab();
		rttc35POM.clickOnCategories();
		rttc35POM.clickDiscountTab();
		rttc35POM.clickDiscountBtn();
		rttc35POM.sendDiscountQuantity("1");
		rttc35POM.sendDiscountPrice("30");
		rttc35POM.clickStartDateIcon();
		rttc35POM.selectCurrentDate();
		rttc35POM.clickEndDateIcon();
		rttc35POM.selectnextDate();
		rttc35POM.clickSaveButton();
		String expected = "Success: You have modified products!";
		String actual = rttc35POM.successMessageGetText();
		
		Assert.assertTrue(actual.contains(expected), "Test case passed");
		//Assert.assertEquals(actual, expected, "Test case passed");

}
}
