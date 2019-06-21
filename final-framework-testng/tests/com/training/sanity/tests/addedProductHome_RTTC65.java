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
import com.training.pom.Rttc35POM;
import com.training.pom.addedProductHome_Rttc65POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

/* To Verify whether added product details get displayed in home screen  */

public class addedProductHome_RTTC65 {
	private WebDriver driver;
	private String baseUrl;
	
	private Rttc35POM rttc35POM;
	private addedProductHome_Rttc65POM rttc65POM;
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
		rttc65POM = new addedProductHome_Rttc65POM(driver);
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
	@Test (priority = 1)
	public void validAddProductTest() throws InterruptedException {
		// To add new product in admin
		rttc35POM.sendUserName("admin");
		rttc35POM.sendPassword("admin@123");
		rttc35POM.clickLoginBtn();
		rttc35POM.clickProductsBtn();
		rttc35POM.clickAddNewBtn();
		rttc35POM.sendProductName("praween1");
		rttc35POM.sendmetaTagTitle("Finger Ring for ladies");
		rttc35POM.clickDataTab();
		rttc35POM.sendModel("SKU-012");
		rttc35POM.sendPrice("50");
		rttc35POM.sendQuantity("1");
		rttc35POM.clickLinkTab();
		rttc35POM.clickOnCategories();
		
		rttc35POM.clickSaveButton();
		String expected = "Success: You have modified products!";
		String actual = rttc35POM.successMessageGetText();
		
		Assert.assertTrue(actual.contains(expected), "Test case passed");
		rttc35POM.clickOnLogout();
		//Assert.assertEquals(actual, expected, "Test case passed");

}
	
	@Test (priority = 2)
	public void validAddProductTest2() throws InterruptedException {
		
//To search for added product in Retails site
		
		
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
		
		rttc65POM.sendSearchText("praween1");
		boolean actual = rttc65POM.isResultAvailable("praween1");
		Assert.assertEquals(actual, true);
}
}
