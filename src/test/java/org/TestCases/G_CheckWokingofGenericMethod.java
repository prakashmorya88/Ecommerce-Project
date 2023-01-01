package org.TestCases;

import java.io.IOException;

import org.Pages.IndexPage;
import org.Pages.LoginPage;
import org.Utility.BaseClass;
import org.Utility.GenericMethods;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class G_CheckWokingofGenericMethod {

	public static void main(String[] args) throws IOException, InterruptedException {
		BaseClass b=new BaseClass();
		WebDriver driver=b.launchURL("chrome");
		
		GenericMethods gm=new GenericMethods();
		gm.getTitle();
		gm.getCurrentPageUrl();
		Thread.sleep(3000);
//		WebElement signinBtn=driver.findElement(By.partialLinkText("//div[@class='rhf-sign-in-button']"));
//		gm.waitForVisilibilityOfElement(30,signinBtn );
//		gm.scrollByJSTillParticularEle(signinBtn);
//		gm.takeScreenShot("visibileSS");
//		gm.takeFullPageScreenshot("fullSS");
//		LoginPage lp=new LoginPage(driver);
//		System.out.println(lp.signInBtnIsDisplayed());
		IndexPage ip=new IndexPage(driver);
		System.out.println(ip.islogoDispplayed());
		System.out.println(ip.issearchBtnDispplayed());
		System.out.println(ip.issearchDropdownBoxBtnDispplayed());
		System.out.println(ip.issearchTextBoxDispplayed());
		System.out.println(ip.isselectYourAddressBtnDispplayed());
		System.out.println(ip.isaccountListDropdownDispplayed());
		System.out.println(ip.ischooseLanguageDropDownDispplayed());
		ip.accountListDropdown();
		
		LoginPage lp=new LoginPage(driver);
		Assert.assertTrue(lp.emailIdFieldIsDisplayed());
		Assert.assertTrue(lp.countinueBtnIsDisplayed());
		Assert.assertTrue(lp.createAccountBtnIsDisplayed());
		Assert.assertTrue(lp.NeedHelpBtnIsDisplayed());
		Assert.assertTrue(lp.ForgetPasswordlinkIsDisplayed());
		Assert.assertTrue(lp.issueWithSignInLinkIsDisplayed());
		lp.enterEmailId();
		lp.countinueBtn();
		Assert.assertTrue(lp.passwordFieldIsDisplayed());
		Assert.assertTrue(lp.signInBtnIsDisplayed());
		Assert.assertTrue(lp.KeepMeSigninCheckboxIsDisplayed());
		lp.enterpassword();
		lp.KeepMeSigninCheckbox();
		lp.signInBtn();
		
		
		

	}

}
