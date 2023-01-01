package org.Pages;

import java.io.IOException;
import java.util.Properties;

import org.Utility.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ForgetPasswordPage {
	private WebDriver driver;
	private Properties prop;
	@FindBy(id="ap_email")
	private WebElement emailIdField;
	@FindBy(id="continue")
	private WebElement countinueBtn;
	@FindBy(css="[type='text']")
	private WebElement EnterOTPField;
	@FindBy(css="[type='submit']")
	private WebElement countinueBtn2;





	public ForgetPasswordPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}

	public boolean emailIdFieldIsDisplayed() {
		return emailIdField.isDisplayed();
	}
	public boolean countinueBtnIsDisplayed() {
		return countinueBtn.isDisplayed();
	}
	public boolean EnterOTPFieldIsDisplayed() {
		return EnterOTPField.isDisplayed();
	}
	public boolean countinueBtn2IsDisplayed() {
		return countinueBtn2.isDisplayed();
	}

	BaseClass b=new BaseClass();


	public void enterEmailId() throws IOException {
		prop=b.getCredential("./Configuration file/Properties.txt");
		emailIdField.sendKeys(prop.getProperty("emailId"));
	}
	public void countinueBtn() throws IOException {

		countinueBtn.click();
	}

	public void EnterOTPField() throws IOException {

		EnterOTPField.sendKeys();
	}
	public void countinueBtn2() throws IOException {

		countinueBtn2.click();
	}
}
