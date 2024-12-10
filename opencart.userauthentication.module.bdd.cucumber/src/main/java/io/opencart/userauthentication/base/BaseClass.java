package io.opencart.userauthentication.base;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
//import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


import io.opencart.userauthentication.utils.PropertyUtils;

public class BaseClass {
	
	public static WebDriver driver = null;
	Logger log = Logger.getLogger(BaseClass.class);
	
	public void initialization() throws Exception {
		
		log.info("Reading property file for browser");
		String browserName = PropertyUtils.readProperty("browser"); //reading browser name 
		
		if(browserName.equalsIgnoreCase("chrome")) {
			if (driver == null) {
				System.setProperty("webdriver.chrome.driver", "driver/chromedriver");
		driver = new ChromeDriver();
		}
		}
		if(browserName.equalsIgnoreCase("FireFox")) {
			System.setProperty("webdriver.gecko.driver", "/Users/ameyaathale/Documents/Selenium_Automation_Workspace/geckodriver-mac-x64/chromedriver");
		driver = new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(PropertyUtils.readProperty("url"));
	}

	
}
	
	

