package org.TestCases;

import java.io.IOException;

import org.Pages.CreateAccountPage;
import org.Pages.IndexPage;
import org.Pages.LoginPage;
import org.Utility.BaseClass;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class A_CreateAccountTestCase extends BaseClass {
	WebDriver driver;
	IndexPage ip;
	LoginPage lp;
	CreateAccountPage cap;
	@BeforeClass
	public void setUp() throws IOException {
		String url=getCredential("./Configuration file/Properties.txt").getProperty("url");
		createCustDeatils();
		driver=launchURL("Chrome");
		driver.get(url);
		
	}
	@AfterClass
	public void tearDown() {
//		driver.quit();
		
	}
	@Test(groups="smoke")
	public void verifyVisilibilityOfField() {
		ip=new IndexPage(driver);
		ip.accountListDropdown();
		 lp=new LoginPage(driver);
		 cap=lp.createAccountBtn();
		 Assert.assertTrue(cap.yourNameFieldIsDisplayed(), "yourNameField is not displayed");
		 Assert.assertTrue(cap.mobileNoFieldIsDisplayed(), "mobileNoField is not displayed");
		 Assert.assertTrue(cap.emailIdFieldIsDisplayed(), "emailIdField is not displayed");
		 Assert.assertTrue(cap.passwordFieldIsDisplayed(), "passwordField is not displayed");
		 Assert.assertTrue(cap.countinueBtnIsDisplayed(), "countinueBtn is not displayed");
		 Assert.assertTrue(cap.signInLinkIsDisplayed(), "signInLink is not displayed");
		 Assert.assertTrue(cap.createBusinessAccountIsDisplayed(), "createBusinessAccount is not displayed");
		 
		 
		
	}
	@Test(dependsOnMethods= {"verifyVisilibilityOfField"},groups= {"regression"})
	public void validateCreateNewAccoun() throws IOException {
		cap.enterYourName();
		cap.enterYourPassword();
		cap.enterYourEmailId();
		cap.enterYourMobileNo();
		cap.countinueBtn();
		Assert.assertTrue(cap.errorMessageIsDisplayed());
		cap.getErrorMessage();
		//Reporter.log("");
		
	}
	
	

}
