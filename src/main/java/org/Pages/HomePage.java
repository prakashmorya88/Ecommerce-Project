package org.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;
	@FindBy (id="nav-search-dropdown-card")
	private WebElement searchDropdownBoxBtn;
	@FindBy (id="twotabsearchtextbox")
	private WebElement searchTextBox;
	@FindBy (css="[type='submit']")
	private WebElement searchBtn;
	@FindBy (id="nav-cart")
	private WebElement cart;
	@FindBy (id="nav-orders")
	private WebElement ReturnAndOrderBtn;

	
	
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	
	public boolean issearchTextBoxDispplayed() {
		return searchTextBox.isDisplayed();
	}
	public boolean issearchBtnDispplayed() {
		return searchBtn.isDisplayed();
	}
	public boolean issearchDropdownBoxBtnDispplayed() {
		return searchDropdownBoxBtn.isDisplayed();
	}
	public boolean iscartDispplayed() {
		return cart.isDisplayed();
	}
	public boolean isReturnAndOrderBtnDispplayed() {
		return ReturnAndOrderBtn.isDisplayed();
	}
	public void enterProductName() {
		 searchTextBox.sendKeys("Macbook");
	}
	public GoToCartPage cart() {
		cart.click();
		return new GoToCartPage(driver);
	}
	public void searchBtn() {
		 searchBtn.click();
	}
	
}
