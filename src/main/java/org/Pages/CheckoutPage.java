package org.Pages;

import java.time.Duration;

import org.Utility.GenericMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutPage {
	WebDriver driver;	
	GenericMethods gm;
	@FindBy(css="[data-testid='Address_selectShipToThisAddress']")
	private WebElement shipToThisAddressBtn;
	@FindBy(id="orderSummaryPrimaryActionBtn-announce")
	 WebElement saveGiftOptionAndContinueBtn;
	@FindBy(xpath="//input[@value='SelectableAddCreditCard']")
	 WebElement addCardDetailRadioBtn;
	@FindBy(css="a[id*='104']")
	 WebElement cardDetailLink;
	@FindBy(css="input[id*='16']")
	private WebElement cardNo;
	@FindBy(css="input[id*='18']")
	private WebElement nameOnCard;
	@FindBy(css="span[id*='22']")
	private WebElement expiryMonth;
	@FindBy(css="span[id*='23']")
	private WebElement expiryYear;
	@FindBy(css="button[id*='25-announce']")
	private WebElement cancelBtn;
	@FindBy(css="[id*='26-announce']")
	private WebElement enterCardDetailBtn;
	
	
	
	public CheckoutPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}

	public boolean shipToThisAddressBtnIsDisplayed() {
		
		return shipToThisAddressBtn.isDisplayed();
	}
	public boolean saveGiftOptionAndContinueBtnIsDisplayed() {
		return saveGiftOptionAndContinueBtn.isDisplayed();
	}
	
	public void shipToThisAddressBtn() {
		gm=new GenericMethods();
		gm.scrollByJSTillParticularEle(shipToThisAddressBtn);
		shipToThisAddressBtn.click();
	}
	public void saveGiftOptionAndContinueBtn() {
//		gm.scrollByJSTillParticularEle(saveGiftOptionAndContinueBtn);
		//gm.clickByJS(saveGiftOptionAndContinueBtn);
		Actions act=new Actions(driver);
		WebDriverWait wt=new WebDriverWait(driver,Duration.ofSeconds(30));
		wt.until(ExpectedConditions.elementToBeClickable(saveGiftOptionAndContinueBtn));
		
		act.click(saveGiftOptionAndContinueBtn).perform();
	
	}
	public void addCardDetailRadioBtn() {
		//gm.scrollByJSTillParticularEle(addCardDetailRadioBtn);
		gm.waitForVisilibilityOfElement(30, addCardDetailRadioBtn);
		addCardDetailRadioBtn.click();;
	}
	public void cardDetailLink() {
		cardDetailLink.click();;
	}
	public void enterCardNo() {
		cardNo.sendKeys("123456789012");
	}
	public void enterNameOnCard() {
		nameOnCard.sendKeys("Laxmi Maurya");
	}
	public void expiryMonth() {
		cardNo.sendKeys("12");
	}
	public void cancelBtn() {
		cancelBtn.click();
	}
	public void expiryYear() {
		expiryYear.sendKeys("2029");
	}
	public void submitBtn() {
		enterCardDetailBtn.sendKeys();
	}
	

}
