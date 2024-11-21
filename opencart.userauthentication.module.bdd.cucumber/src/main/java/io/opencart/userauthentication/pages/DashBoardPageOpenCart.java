

package io.opencart.userauthentication.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class DashBoardPageOpenCart {
	
	public  WebDriver driver = null;

	public DashBoardPageOpenCart(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	}

