package org.TestCases;

import java.io.IOException;

import org.Pages.IndexPage;
import org.Utility.BaseClass;
import org.Utility.GenericMethods;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class C_IndexPageTestCase {
	WebDriver driver;
	BaseClass b=new BaseClass();
	IndexPage ip;
	GenericMethods gm;
	
	@BeforeMethod
	public void setUp() throws IOException {
		
		driver=b.launchURL("Firefox");
		driver.get(b.getCredential("./Configuration file/Properties.txt").getProperty("url"));
		
		
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	@Test(groups="smoke")
	public void verifyLogo() {
		ip=new IndexPage(driver);
		Assert.assertTrue(ip.islogoDispplayed());
		
	}
	@Test(groups= {"somke"})
	public void verifyTitle() {
		gm=new GenericMethods();
		String actualTitle=gm.getTitle();
		String expectedTitle="Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
		Assert.assertEquals(actualTitle, expectedTitle);
	}
}
