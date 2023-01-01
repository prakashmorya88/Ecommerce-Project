package org.Utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver driver;
	public static Properties prop;

	
	public Properties getCredential(String filePath) throws IOException {
		try{FileInputStream fis=new FileInputStream(filePath);
		prop=new Properties();
		prop.load(fis);
		return prop;
		}catch(Exception e) {
			e.printStackTrace();
			return prop;
		}
		
	}
	public Sheet createCustDeatils() throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream("./ExcelData/createCustDetail.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		Sheet s=wb.getSheet("NewCustDetails");
		return s;
		
	}
	
	public WebDriver launchURL(String browser) throws IOException {
		
		
		if(browser.equalsIgnoreCase("ch")||browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			
		}else if(browser.equalsIgnoreCase("IE")||browser.equalsIgnoreCase("Internet Explorer")) {
			WebDriverManager.iedriver().setup();
			driver=new InternetExplorerDriver();
		}else if(browser.equalsIgnoreCase("FF") ||browser.equalsIgnoreCase("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}else if(browser.equalsIgnoreCase("O") ||browser.equalsIgnoreCase("Opera")) {
			WebDriverManager.operadriver().setup();
			driver=new OperaDriver();
			WebDriverManager.edgedriver().setup();
			driver=new ChromeDriver();
		}
		driver.manage().window().maximize();	
		return driver;
		
		
		
	}

}
