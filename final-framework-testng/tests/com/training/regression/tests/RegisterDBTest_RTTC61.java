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

import com.training.dataproviders.LoginDataProviders;
import com.training.dataproviders.RegisterDataProviders;
import com.training.generics.GenericMethods;
import com.training.generics.ScreenShot;
import com.training.pom.LoginPOM;
import com.training.pom.RegisterPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RegisterDBTest_RTTC61 {
	private WebDriver driver;
	private String baseUrl;
	private RegisterPOM registerPOM;
	private static Properties properties;
	private ScreenShot screenShot;
	private GenericMethods genericMethods; 
	
	/*  To verify whether registered user details stored in database */
	
	
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
		genericMethods = new GenericMethods(driver); 
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
	

	@Test(dataProvider = "db-inputs", dataProviderClass = RegisterDataProviders.class)
	public void loginDBTest(String firstName, String lastName, String email, String telePhone, String address1, String  city, String password, String confirmPassword) {
		// for demonstration 
//		genericMethods.getElement("login", "id"); 
		
		//Fill and Submit the registration form as well get values into local variable strings 
				
		registerPOM.sendFirstName("praween9");
		String FIRSTNAME = registerPOM.getfirstName();
		registerPOM.sendLastName("praween9");
		String LASTNAME = registerPOM.getlastName();
		
		registerPOM.sendEmail("praween9@gmail.com");
		String EMAIL = registerPOM.getemail();
		
		registerPOM.sendTelephone("9903305762");
		String TELEPHONE = registerPOM.gettelePhone();
		
		registerPOM.sendAddress1("Salt Lake");
		String ADDRESS1 = registerPOM.getaddress1();
		
		registerPOM.sendCity("Kolkata");
		String CITY1         = registerPOM.getcity();
		registerPOM.selectCountry();
		registerPOM.selectZone();
		registerPOM.sendPassword("password1");
		String PASSWORD = registerPOM.getpassword();
		registerPOM.sendConfirmPassword("password1");
		String confirmpassword = registerPOM.getconfirmPassword();
		registerPOM.checkAgree();
		registerPOM.clickContinue();
		
		//Assert that values in database matches with strings entered
		
		Assert.assertEquals(FIRSTNAME, firstName);
		Assert.assertEquals(ADDRESS1, address1);
		Assert.assertEquals(LASTNAME, lastName);
		Assert.assertEquals(EMAIL, email);
		Assert.assertEquals(TELEPHONE, telePhone);
		Assert.assertEquals(CITY1, city);
		Assert.assertEquals(PASSWORD, password);
		Assert.assertEquals(confirmpassword, confirmPassword);

	}

}
