package io.opencart.userauthentication.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class HomePageOpenCart {
	
	public  WebDriver driver = null;
	public HomePageOpenCart (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath = "//span[text()='My Account']")
	WebElement myAccountElement;
	
	@FindBy(xpath = "//a[text()='Login']")
    WebElement loginLink;
	
	@FindBy(xpath = "//a[text()='Register']")
    WebElement registerLink;
	
	public LoginPageOpenCart navigateTologinPage()throws Exception {
		myAccountElement.click();
		loginLink.click();
		 return new LoginPageOpenCart(driver);
	}
		
		public RegisterPageOpenCart navigateToRegisterPage() {
			
			myAccountElement.click();
			registerLink.click();
			return new RegisterPageOpenCart(driver);
		}
	
}
	
	
	
	
	
	



