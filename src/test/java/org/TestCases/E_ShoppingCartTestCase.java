package org.TestCases;

import java.io.IOException;

import org.Pages.CheckoutPage;
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
import org.testng.annotations.Test;

public class E_ShoppingCartTestCase extends BaseClass {
	
	WebDriver driver;
	IndexPage ip;
	SearchPage sp;
	HomePage hp;
	GoToCartPage cart;
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
	
	@Test(groups= {"smoke","regression","sanity"})
	public void indexPage_SignIn() throws IOException, InterruptedException {
		ip=new IndexPage(driver);
		LoginPage lp=ip.accountListDropdown();
		lp.enterEmailId();
		lp.countinueBtn();
		lp.enterpassword();
		hp=lp.signInBtn();
		

}
	@Test(dependsOnMethods="indexPage_SignIn",groups="sanity")
	public void HomePage_MoveToCart() {
		cart=hp.cart();
		Assert.assertTrue(cart.thisOrderContainAGiftCheckBoxIsDisplayed(), "OrderContainAGiftCheckBox Is not Displayed");
		Assert.assertTrue(cart.proceedToRetailCheckoutBtnIsDisplayed(), "proceedToRetailCheckoutBtn Is not Displayed");
		//cart.thisOrderContainAGiftCheckBox();
		cart.quantity();
		cart.price();
		System.out.println("totalQuantity: "+cart.subTotalQuantity());
		System.out.println("grandTotal: "+ cart.grandTotal());
		System.out.println("totalAmount: "+cart.totalAmount());
		
		
		CheckoutPage cp=cart.proceedToRetailCheckoutBtn();
		
	}
}
