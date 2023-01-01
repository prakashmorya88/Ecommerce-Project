package org.Pages;

import java.io.IOException;
import java.util.Properties;

import org.Utility.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	private WebDriver driver;
	private Properties prop;
	@FindBy(id="ap_email")
	private WebElement emailIdField;
	@FindBy(id="continue")
	private WebElement countinueBtn;
	@FindBy(className="a-expander-prompt")
	private WebElement NeedHelpBtn;
	@FindBy(id="auth-fpp-link-bottom")
	private WebElement ForgetPasswordlink;
	@FindBy(id="ap-other-signin-issues-link")
	private WebElement issueWithSignInLink;
	@FindBy(id="createAccountSubmit")
	private WebElement createAccountBtn;
	@FindBy(id="ap_password")
	private WebElement passwordField;
	@FindBy(name="rememberMe")
	private WebElement KeepMeSigninCheckbox;
	@FindBy(id="signInSubmit")
	private WebElement signInBtn;
	

	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}

	public boolean emailIdFieldIsDisplayed() {
		return emailIdField.isDisplayed();
	}
	public boolean countinueBtnIsDisplayed() {
		return countinueBtn.isDisplayed();
	}
	public boolean NeedHelpBtnIsDisplayed() {
		return NeedHelpBtn.isDisplayed();
	}
	public boolean ForgetPasswordlinkIsDisplayed() {
		return ForgetPasswordlink.isDisplayed();
	}
	public boolean issueWithSignInLinkIsDisplayed() {
		return issueWithSignInLink.isDisplayed();
	}
	public boolean createAccountBtnIsDisplayed() {
		return createAccountBtn.isDisplayed();
	}
	public boolean passwordFieldIsDisplayed() {
		return passwordField.isDisplayed();
	}
	public boolean KeepMeSigninCheckboxIsDisplayed() {
		return KeepMeSigninCheckbox.isDisplayed();
	}
	public boolean signInBtnIsDisplayed() {
		return signInBtn.isDisplayed();
	}
	BaseClass b=new BaseClass();


	public void enterEmailId() throws IOException {
		prop=b.getCredential("./Configuration file/Properties.txt");
		emailIdField.sendKeys(prop.getProperty("emailId"));
	}
	public void countinueBtn() throws IOException {

		countinueBtn.click();
	}

	public void enterpassword() throws IOException {

		passwordField.sendKeys(prop.getProperty("password"));
	}
	public void KeepMeSigninCheckbox() throws IOException {

		KeepMeSigninCheckbox.click();
	}
	public HomePage signInBtn() throws IOException {

		signInBtn.click();
		return new HomePage(driver);
	}
	public void NeedHelpBtn() throws IOException {

		NeedHelpBtn.click();
	}
	public CreateAccountPage createAccountBtn() {
		 createAccountBtn.click();
		 return new CreateAccountPage(driver);
	}

//	
}
