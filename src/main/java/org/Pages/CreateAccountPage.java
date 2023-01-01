package org.Pages;

import java.io.IOException;

import org.Utility.BaseClass;
import org.apache.poi.ss.usermodel.Sheet;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateAccountPage {
	private WebDriver driver;
	private BaseClass b=new BaseClass();
	private Sheet s;
	@FindBy(id="ap_customer_name")
	private WebElement yourNameField;
	@FindBy(id="ap_phone_number")
	private WebElement mobileNoField;
	@FindBy(id="ap_email")
	private WebElement emailIdField;
	@FindBy(id="ap_password")
	private WebElement passwordField;
	@FindBy(id="continue")
	private WebElement countinueBtn;
	@FindBy(xpath="(//a[@class='a-link-emphasis'])[1]")
	private WebElement signInLink;
	@FindBy(xpath="(//a[@class='a-link-emphasis'])[2]")
	private WebElement createBusinessAccount;
	@FindBy(className="a-list-item")
	private WebElement errorMessage;
	
	
	public CreateAccountPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	
	public boolean yourNameFieldIsDisplayed() {
		return yourNameField.isDisplayed();
	}
	public boolean mobileNoFieldIsDisplayed() {
		return mobileNoField.isDisplayed();
	}
	public boolean emailIdFieldIsDisplayed() {
		return emailIdField.isDisplayed();
	}
	public boolean passwordFieldIsDisplayed() {
		return passwordField.isDisplayed();
	}
	public boolean countinueBtnIsDisplayed() {
		return countinueBtn.isDisplayed();
	}
	public boolean signInLinkIsDisplayed() {
		return signInLink.isDisplayed();
	}
	public boolean createBusinessAccountIsDisplayed() {
		return createBusinessAccount.isDisplayed();
	}
	public boolean errorMessageIsDisplayed() {
		return errorMessage.isDisplayed();
	}
	
	public void enterYourName() throws IOException {
		s=b.createCustDeatils();
		 yourNameField.sendKeys(s.getRow(1).getCell(0).getStringCellValue());
	}
	public void enterYourMobileNo() {
		String mobNo=String.valueOf((long)s.getRow(1).getCell(1).getNumericCellValue());
		mobileNoField.sendKeys(mobNo);
	}
	public void enterYourEmailId() {
		emailIdField.sendKeys(s.getRow(1).getCell(2).getStringCellValue());
	}
	public void enterYourPassword() {
		 passwordField.sendKeys(s.getRow(1).getCell(3).getStringCellValue());
	}
	public void countinueBtn() {
		 countinueBtn.click();
	}
	public LoginPage signInLink() {
		 signInLink.click();
		 return new LoginPage(driver);
	}
	public void getErrorMessage() {
		System.out.println( errorMessage.getText());
	}
	
	
	
}
