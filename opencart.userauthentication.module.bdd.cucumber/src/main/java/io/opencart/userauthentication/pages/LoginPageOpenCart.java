package io.opencart.userauthentication.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.opencart.userauthentication.utils.PropertyUtils;

public class LoginPageOpenCart {
	
	
	WebDriver driver = null;
	//HomePageOpenCart homePage = null;
	
	public LoginPageOpenCart(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
		
	
	
	@FindBy (id = "input-email")
	WebElement emailElement;
	
	@FindBy(id = "input-password")
	WebElement passwordElement;
	
	@FindBy(xpath="//input[@value='Login']")
	WebElement loginButton;
	
	@FindBy(xpath="//a[text()='Continue']")
	WebElement registerPageLink;
	
	@FindBy(linkText = "Logout")
    WebElement logoutLink;
	
	@FindBy(xpath = "//div[text()='Warning: No match for E-Mail Address and/or Password.']")
    WebElement errorMessageElement;
	
	@FindBy(xpath = "//div[text()='Warning: Your account has exceeded allowed number of login attempts. Please try again in 1 hour.']")
    WebElement warningMessageElement;
	
	
	
	
	public  DashBoardPageOpenCart validLogin() throws Exception {
		String email = PropertyUtils.readProperty("validEmail");
		String password = PropertyUtils.readProperty("validPassword");
        loginToApplication(email, password);
        return new DashBoardPageOpenCart(driver);
    }
	
	
	public void loginToApplication(String email, String password) throws Exception {
		
		emailElement.sendKeys(email);
		passwordElement.sendKeys(password);
        loginButton.click();
    }
	
	public boolean isUserOnDashboard() {
        return logoutLink.isDisplayed();
    }
	
	public boolean isErrorMessageDisplayedForInvalidCredentials() {
        return errorMessageElement.isDisplayed();
    }
	
	

	
	
}
