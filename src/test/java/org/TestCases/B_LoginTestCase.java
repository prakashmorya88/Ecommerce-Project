package org.TestCases;

import java.io.IOException;

import org.Pages.HomePage;
import org.Pages.IndexPage;
import org.Pages.LoginPage;
import org.Utility.BaseClass;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class B_LoginTestCase {
	WebDriver driver;
	BaseClass b;
	IndexPage ip;
	@BeforeClass
	public void launch() throws IOException {
		b=new BaseClass();
		String url=b.getCredential("./Configuration file/Properties.txt").getProperty("url");
		driver=b.launchURL("Chrome");
		driver.get(url);
		
	}
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	@Test(groups= {"smoke","sanity","regression"})
	public void verifyLoginfield() throws IOException, InterruptedException {
		 ip=new IndexPage(driver);
		 Assert.assertTrue(ip.isaccountListDropdownDispplayed());
		LoginPage lp= ip.accountListDropdown();
		Assert.assertTrue(lp.emailIdFieldIsDisplayed(),"emailField is Not Displayed");
		Assert.assertTrue(lp.NeedHelpBtnIsDisplayed(),"NeedHelpBtn is not displayed");
		lp.NeedHelpBtn();
		Assert.assertTrue(lp.ForgetPasswordlinkIsDisplayed(),"Forgetpasswordlink is not displayed");
		Assert.assertTrue(lp.issueWithSignInLinkIsDisplayed(),"issueWithSignInLink is not displayed");
		Assert.assertTrue(lp.countinueBtnIsDisplayed(),"countinueBtn is not displayed");
		lp.enterEmailId();
		lp.countinueBtn();
		Assert.assertTrue(lp.passwordFieldIsDisplayed(),"passwordField is not displayed");
		Assert.assertTrue(lp.KeepMeSigninCheckboxIsDisplayed(),"KeepMeSigninCheckbox is not displayed");
		Assert.assertTrue(lp.signInBtnIsDisplayed(),"signInBtn is not displayed");
		Thread.sleep(2000);
		lp.enterpassword();
		lp.KeepMeSigninCheckbox();
		HomePage hp=lp.signInBtn();
		
		
		
	}
	@Test(groups= {"smoke"})
	public void verifyDashboard() throws InterruptedException {
		String expectedTitle="Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
		Thread.sleep(2000);
		String actualTitle=driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle);
	}
	
}
