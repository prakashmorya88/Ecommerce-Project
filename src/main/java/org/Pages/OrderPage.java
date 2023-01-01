package org.Pages;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderPage {
	WebDriver driver;	
	@FindBy(css="[for='time-filter']>span")
	private WebElement totalOrderPlaced;
	@FindBy(css="div[class='item-view-left-col-inner']>a")
	private List<WebElement> productName;

	public OrderPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}

	public boolean totalOrderPlacedIsDisplayed() {
		return totalOrderPlaced.isDisplayed();
	}
	public void totalOrderPlaced() {
		System.out.println(totalOrderPlaced.getText());
	}
	public void productName() {
		
		for(int i=0;i<productName.size();i++) {
			System.out.println(productName.get(i).getText());
		}
		
	}

}
