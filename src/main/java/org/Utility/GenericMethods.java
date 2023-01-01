package org.Utility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import javax.imageio.ImageIO;

import org.Utility.BaseClass;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class GenericMethods extends BaseClass{
	public static JavascriptExecutor js;
	WebDriverWait wt;
	public String getTitle() {
		
		return driver.getTitle();

	}
	public void getCurrentPageUrl() {
		System.out.println("CurrentPageURL: "+ driver.getCurrentUrl());
	}
	public void implicitWait(long maxTime) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(maxTime));
	}
	public void waitForVisilibilityOfElement(long maxTime,WebElement element) {
		wt=new WebDriverWait(driver,Duration.ofSeconds(maxTime));
		wt.until(ExpectedConditions.visibilityOf(element));
	}
	public void clickByJS(WebElement element) {
		js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", element);
	}
	public void sendByJS(WebElement element,String value) {
		js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].value=arguments[1]", element,value);

	}
	public void scrollByJSTillParticularEle(WebElement element) {
		js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true)", element);
	}
	public void waitForAlert(long maxTime) {
		wt=new WebDriverWait(driver,Duration.ofSeconds(maxTime));
		wt.until(ExpectedConditions.alertIsPresent());
		

	}
	public void switchToFrame(WebElement frameElement) {
		driver.switchTo().frame( frameElement);
	}
	public void switchToParentFrame(WebElement parentFrameElement) {
		driver.switchTo().parentFrame();
	}
	public void moveOutOf_Frame_OR_Window() {
		driver.switchTo().defaultContent();
	}
	public void switchToWindow(String Id) {
		driver.switchTo().window(Id);
	}
	public void openNewWindow() {
		driver.switchTo().newWindow(WindowType.WINDOW);
	}
	public void openNewTab() {
		driver.switchTo().newWindow(WindowType.TAB);
	}
	public void takeScreenShot(String setImgName) throws IOException {
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(src, new File("./Screenshot/"+setImgName+""));
	}
	public void takeFullPageScreenshot(String setImgName) throws IOException {
		Screenshot ss=new AShot().shootingStrategy(ShootingStrategies.viewportPasting(2000))
				.takeScreenshot(driver);
		ImageIO.write(ss.getImage(), "PNG", new File("./Screenshot/"+setImgName+""));
	}
	



}
