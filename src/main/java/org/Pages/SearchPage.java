package org.Pages;

import org.Utility.GenericMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {
	WebDriver driver;
	@FindBy(xpath="(//a[@class='a-link-normal s-no-outline'])[2]")
	private WebElement product;
	@FindBy(css="[title='Add to Cart']")
	private WebElement addToCartBtn;
	@FindBy(css="[title='Go to Cart']")
	private WebElement goToCartBtn;
	
	
	public SearchPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}

	public boolean productIsDisplayed() {
		return product.isDisplayed();
	}
	public void product() {
		 product.click();
	}
	public boolean addToCartBtnIsDisplayed() {
		return addToCartBtn.isDisplayed();
	}
	public LoginPage addToCartBtn() {
		addToCartBtn.click();
		return new LoginPage(driver);
	}
	public boolean goToCartBtnIsDisplayed() {
		return goToCartBtn.isDisplayed();
	}
	public GoToCartPage goToCartBtn() {
		GenericMethods gm=new GenericMethods();
		gm.clickByJS(goToCartBtn);
		//goToCartBtn.click();
		return new GoToCartPage(driver);
	}
}
