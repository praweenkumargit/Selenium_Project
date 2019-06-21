package com.training.regression.tests;

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

import com.training.dataproviders.CategoryNameDataProviders;
import com.training.dataproviders.RegisterDataProviders;
import com.training.generics.GenericMethods;
import com.training.generics.ScreenShot;
import com.training.pom.AddCategoriesToAdmin_Rttc64POM;
import com.training.pom.RegisterPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class AddCategoriesTest_RTTC64 {
	private WebDriver driver;
	private String baseUrl;
	private AddCategoriesToAdmin_Rttc64POM rttc64POM;
	private static Properties properties;
	private ScreenShot screenShot;
	private GenericMethods genericMethods; 
	
	/* To verify whether application allows admin to add multiple category in categories page  */
	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		rttc64POM = new AddCategoriesToAdmin_Rttc64POM(driver);
		baseUrl = properties.getProperty("baseURL2");
		screenShot = new ScreenShot(driver);
		genericMethods = new GenericMethods(driver); 
		// open the browser
		driver.get(baseUrl);
	
	}

	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	

	@Test(dataProvider = "excel-inputs2", dataProviderClass = CategoryNameDataProviders.class)
	public void addCategoriesTest(String categoryName, String description, String metaTagTitle, String metaTagDescription) throws InterruptedException {
		// for demonstration 
//		genericMethods.getElement("login", "id"); 
		
		// Login to application
		rttc64POM.sendUserName("admin");
		rttc64POM.sendPassword("admin@123");
		rttc64POM.clickLoginBtn();
		Thread.sleep(2000);
		
		// Add Different categories
		rttc64POM.clickCategoriesBtn();
		rttc64POM.clickAddNewBtn();
		//Fill form using excel
		rttc64POM.sendCategoryName(categoryName);
		
		rttc64POM.sendDescription(description);
		
		rttc64POM.sendmetaTagTitle(metaTagTitle);
		
		rttc64POM.sendmetaDescription(metaTagDescription);
		
		
		rttc64POM.clickSaveButton();
	}
	
	
}
