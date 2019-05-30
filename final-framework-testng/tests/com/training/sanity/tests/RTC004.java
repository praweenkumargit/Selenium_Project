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
import com.training.pom.Rtc004POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RTC004 {
	private WebDriver driver;
	private String baseUrl;
	private RTC002POM rtc002POM;
	private Rtc004POM rtc004POM;
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
		rtc004POM = new Rtc004POM(driver); 
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
	public void validViewOrderTest() throws InterruptedException {
		rtc002POM.sendEmail("praween2@gmail.com");
		rtc002POM.sendPassword("password1");
		rtc002POM.clickLoginBtn();
		//rtc002POM.assertion();
		
		rtc002POM.clickMyOrdersLink();
		System.out.println("kkk");
		Thread.sleep(7000);
		rtc004POM.clickView();
		String str = "Order Details";
		String actual = rtc004POM.oderDetails();
		Assert.assertEquals(actual, str, "Order details displayed");
		System.out.println("kkk");
		//rtc004POM.assertion();
		//screenShot.captureScreenShot("First");
	}
	
	//@Test (priority = 2)
	//public void validMyOrdersTest() {
	 //rtc004POM.clickView();
	 //rtc004POM.assertion();
	//}
}
