package org.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IndexPage {
	private WebDriver driver;
	@FindBy(id="nav-logo-sprites")
	private WebElement logo;
	@FindBy(id="nav-global-location-popover-link")
	private WebElement selectYourAddressBtn;
	@FindBy (id="nav-search-dropdown-card")
	private WebElement searchDropdownBoxBtn;
	@FindBy (id="twotabsearchtextbox")
	private WebElement searchTextBox;
	@FindBy (css="[type='submit']")
	private WebElement searchBtn;
	@FindBy(partialLinkText="Choose a language.")
	private WebElement chooseLanguageDropDown;
	@FindBy(id="nav-link-accountList")
	private WebElement accountListDropdown;
	
	
	public IndexPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	public boolean islogoDispplayed() {
		return logo.isDisplayed();
	}

	public boolean isselectYourAddressBtnDispplayed() {
		return selectYourAddressBtn.isDisplayed();
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
	public boolean ischooseLanguageDropDownDispplayed() {
		return chooseLanguageDropDown.isDisplayed();
	}
	public boolean isaccountListDropdownDispplayed() {
		return accountListDropdown.isDisplayed();
	}
	public void searchTextBox() {
		searchTextBox.sendKeys("Guitar");
	}
	public SearchPage searchBtn() {
		searchBtn.click();
		return new SearchPage(driver);
	}
	public LoginPage accountListDropdown() {
		 accountListDropdown.click();
		 return new LoginPage(driver);
	}
	
}
