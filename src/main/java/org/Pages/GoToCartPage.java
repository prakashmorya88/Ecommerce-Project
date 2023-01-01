package org.Pages;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoToCartPage {
	private WebDriver driver;
	@FindBy (className="a-dropdown-prompt")
	private List<WebElement>quantity;
	@FindBy (css="p[class='a-spacing-mini']>span")
	private List<WebElement> price;
	@FindBy (css="div[class='a-column a-span10']>div ul span[class='a-truncate-full']")
	private List<WebElement> productDetail;		//BestSeller is getting included here
	@FindBy (id="sc-subtotal-label-buybox")
	private WebElement subTotalQuantity;
	@FindBy (xpath="(//div[@data-name='Subtotals']/span/span)[1]")
	private WebElement totalAmount;
	@FindBy (id="sc-buy-box-gift-checkbox")
	private WebElement thisOrderContainAGiftCheckBox;
	@FindBy (name="proceedToRetailCheckout")
	private WebElement proceedToRetailCheckoutBtn;
	
	
	public GoToCartPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	
	List<Integer>list;
	public void quantity() {
		int counterQty=0;
		list=new ArrayList<Integer>();
		for(WebElement i:quantity) {
			String text=i.getText();
			System.out.println(text);
			//String text2=text.replaceAll("[^a-zA-Z]","");
			int qty=Integer.parseInt(text);
			list.add(qty);
			counterQty+=qty;
		}
		System.out.println("counterQty: "+counterQty);
		for(Integer i:list) {
			System.out.println(i);
		}
		
	}
	List<Double>list2;
	public void price() {
		double counterPrice=0;
		list2=new ArrayList<Double>();
		for(WebElement i:price) {
			//String text=i.getText();
			String text=i.getText().replaceAll("[₹,]","");
			System.out.println(text);
			
			double unitPrice=(Double.parseDouble(text));
			list2.add(unitPrice);
			counterPrice+=unitPrice;
		}
		System.out.println("counterPrice: "+counterPrice);
		for(Double i:list2) {
			System.out.println(i);
		}
	}
	public double grandTotal() {
		double grandTotal=0.0;
		for( int i=0;i<list.size();i++) {
			grandTotal+=list.get(i)*list2.get(i);
		}
		return grandTotal;
		
	}
	
	public int subTotalQuantity() {
		String text=subTotalQuantity.getText().replaceAll("[^0-9]", "");
		 System.out.println(text);
		 int totalQty=(Integer.parseInt(text));
		 System.out.println(totalQty);
		 return totalQty;
		
	}
	public double totalAmount() {
		String text=totalAmount.getText().replaceAll("[₹,]","");
		 double totalAmt=(Double.parseDouble(text));
		 System.out.println(totalAmt);
		 return totalAmt;
		
		
		
	}
	public boolean proceedToRetailCheckoutBtnIsDisplayed() {
		return proceedToRetailCheckoutBtn.isDisplayed();
		
	}
	public boolean thisOrderContainAGiftCheckBoxIsDisplayed() {
		return thisOrderContainAGiftCheckBox.isDisplayed();
		
	}
	public void thisOrderContainAGiftCheckBox() {
		thisOrderContainAGiftCheckBox.click();;
	}
	public CheckoutPage proceedToRetailCheckoutBtn() {
		proceedToRetailCheckoutBtn.click();
		return new CheckoutPage(driver);
	}
}
