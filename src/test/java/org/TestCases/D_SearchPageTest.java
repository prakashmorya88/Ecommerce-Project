package org.TestCases;

import java.io.IOException;
import java.util.Set;

import org.Pages.GoToCartPage;
import org.Pages.HomePage;
import org.Pages.IndexPage;
import org.Pages.LoginPage;
import org.Pages.SearchPage;
import org.Utility.BaseClass;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class D_SearchPageTest extends BaseClass {
	WebDriver driver;
	IndexPage ip;
	SearchPage sp;
	@BeforeClass
	public void setup() throws IOException {
		String url=getCredential("./Configuration file/Properties.txt").getProperty("url");
		createCustDeatils();
		driver=launchURL("Chrome");
		driver.get(url);
	}
	@AfterClass
	public void teardown() {
		driver.quit();
	}
	@Test(groups="smoke",priority=1)
	public void searchProduct() throws IOException, InterruptedException {
		ip=new IndexPage(driver);
		Assert.assertTrue(ip.issearchTextBoxDispplayed(), "Searchbar is not displayed");
		Assert.assertTrue(ip.issearchBtnDispplayed(), "Searchbutton is not displayed");
		ip.searchTextBox();
		 sp=ip.searchBtn();
		String winID=driver.getWindowHandle();
		System.out.println(winID);
		Assert.assertTrue(sp.productIsDisplayed(),"product is not displayed");
		sp.product();
		beforeSignIn (winID);
		
		}
		
	
	public  void beforeSignIn(String winID) throws InterruptedException{
		Set<String> winId_s=driver.getWindowHandles();
		for(String i:winId_s) {
			if(!i.equals(winID)) {
				winID=i;
				System.out.println(winID);
				driver.switchTo().window(winID);
				break;
			}
		
	}
}
	@Ignore
	@Test(groups="sanity",priority=2)
	public void signIn() throws IOException {
		LoginPage lp=sp.addToCartBtn();
		lp.enterEmailId();
		lp.countinueBtn();
		lp.enterpassword();
		HomePage hp=lp.signInBtn();
	}
	@Test(groups= {"sanity","regression"},priority=3)
	public void afterSignInMoveToCart() throws InterruptedException {
		Assert.assertTrue(sp.addToCartBtnIsDisplayed(),"addTocart button is not displayed");
		sp.addToCartBtn();
		Thread.sleep(2000);
		Assert.assertTrue(sp.goToCartBtnIsDisplayed(), "goToCartBtn Is not Displayed");
		GoToCartPage cart=sp.goToCartBtn();
		cart.proceedToRetailCheckoutBtn();
	}

}
