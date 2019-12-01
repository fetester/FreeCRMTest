package com.crm.qa.basic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.crm.qa.util.TestUtil;

public class TestBase {
	
	public static WebDriver driver = null;
	public static Properties prop = null;
	
	public TestBase(){
		prop = new Properties();
		try {
			FileInputStream ip = new FileInputStream("E:\\Lingappa\\workspace\\FreeCRMTest\\src\\main\\java\\com\\crm\\qa\\config\\config.properties");
			prop.load(ip);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	public static void initialization(){
		String browserName = prop.getProperty("browser");
		
		if (browserName.equalsIgnoreCase("chrome")){
			
			System.setProperty("webdriver.chrome.driver", "E:\\Lingappa\\workspace\\FreeCRMTest\\chromedriver\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
			
			driver.get(prop.getProperty("url"));
		}else if(browserName.equalsIgnoreCase("firefox")){
			System.setProperty("webdriver.gecko.driver", "");
			driver = new FirefoxDriver();
			
		}
		
		
	}

}
